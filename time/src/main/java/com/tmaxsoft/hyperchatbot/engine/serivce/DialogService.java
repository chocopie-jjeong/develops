package com.tmaxsoft.hyperchatbot.engine.serivce;

import com.tmaxsoft.hyperchatbot.engine.controller.requestdto.ModelDataDto;
import com.tmaxsoft.hyperchatbot.engine.controller.requestdto.SupervisionRequestDto;
import com.tmaxsoft.hyperchatbot.engine.serivce.responsedto.StatisticResponseDto;
import com.tmaxsoft.hyperchatbot.engine.statistic.domain.dialog.Dialog;
import com.tmaxsoft.hyperchatbot.engine.statistic.domain.dialog.DialogRepository;
import com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.BotDialogCountDto;
import com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.DialogCountDto;
import com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.DialogDto;
import com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.ScenarioDialogCountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
//@Transactional
//@RequiredArgsConstructor
public class DialogService {

    @Autowired
    private DialogRepository dialogRepository;

    public List<DialogDto> records(SupervisionRequestDto request, boolean isTotal){

        String project = isTotal? getProjectAllVersion(request.getModelData())
                :getProjectVersionId(request.getModelData());
        LocalDate start = request.getStartDateTime().toLocalDate();
        LocalDate end = request.getEndDateTime().toLocalDate();
        System.out.println("request = " + request + ", isTotal = " + isTotal);
        System.out.println("project = " + project + ", start = " + start + ", end = " + end);
        List<Dialog> totalDialogs = isTotal? dialogRepository.findTotalDialogs(project, start, end)
                :dialogRepository.findDialogs(project, start, end);

        List<DialogDto> dialogDtoList = totalDialogs.stream()
                                                    .map(Dialog::toDialogDto)
                                                    .collect(Collectors.toList());
        return dialogDtoList;
    }

    public StatisticResponseDto statistics(SupervisionRequestDto request, boolean isTotal){
        String project = isTotal? getProjectAllVersion(request.getModelData())
                :getProjectVersionId(request.getModelData());
        LocalDate date = request.getStartDateTime().toLocalDate();

        return StatisticResponseDto.builder()
                .projectDialogs(dialogCount(project, date, isTotal))
                .botTotalDialogs(botDialogCount(project, date, isTotal))
                .scenarioTotalUsage(scenarioUsageCount(project, date, isTotal))
                .build();
    }

    private long[] dialogCount(String project, LocalDate date, boolean isTotal){
        List<DialogCountDto> dialogCount =
                isTotal? dialogRepository.findTotalDialogCount(project, date)
                :dialogRepository.findDialogCount(project, date);
        long[] result = new long[25];
        for(DialogCountDto count: dialogCount){
            result[count.getTimeIdx()] = count.getCount();
        }
        return result;
    }

    private HashMap<String, long[]> botDialogCount(String project, LocalDate date, boolean isTotal){

        List<BotDialogCountDto> botDialogCount =
                isTotal? dialogRepository.findTotalBotDialogCount(project, date)
                :dialogRepository.findBotDialogCount(project, date);
        HashMap<String, long[]> result = new HashMap<>();
        for(BotDialogCountDto count: botDialogCount){
            long[] lst = result.getOrDefault(count.getBotId(), new long[25]);
            lst[count.getTimeIdx()] = count.getCount();
            result.put(count.getBotId(), lst);
        }
        return result;
    }

    private HashMap<String, HashMap<Long, long[]>> scenarioUsageCount(String project,
                                                                      LocalDate date,
                                                                      boolean isTotal){

        List<ScenarioDialogCountDto> scenarioDialogCount =
                isTotal? dialogRepository.findTotalScenarioDialogCount(project, date)
                :dialogRepository.findScenarioDialogCount(project, date);
        HashMap<String, HashMap<Long, long[]>> result = new HashMap<>();
        for(ScenarioDialogCountDto count: scenarioDialogCount){
            HashMap<Long, long[]> innerMap = result.getOrDefault(count.getBotId(), new HashMap<>());
            long[] lst = innerMap.getOrDefault(count.getScenarioId(), new long[25]);
            lst[count.getTimeIndex()] = count.getCount();
            innerMap.put(count.getScenarioId(), lst);
            result.put(count.getBotId(), innerMap);
        }
        return result;
    }

    private String getProjectVersionId(ModelDataDto modelData){
        return String.format("%s_%s", modelData.getProject_id(), modelData.getVersion());
    }

    private String getProjectAllVersion(ModelDataDto modelData){
        return String.format("%s_%%", modelData.getProject_id());
    }

}
