package com.tmaxsoft.hyperchatbot.engine.serivce;

import com.tmaxsoft.hyperchatbot.engine.controller.requestdto.ModelDataDto;
import com.tmaxsoft.hyperchatbot.engine.controller.requestdto.SupervisionRequestDto;
import com.tmaxsoft.hyperchatbot.engine.serivce.responsedto.StatisticResponseDto;
import com.tmaxsoft.hyperchatbot.engine.serivce.responsedto.statisticvo.CountValue;
import com.tmaxsoft.hyperchatbot.engine.serivce.responsedto.statisticvo.StatisticVo;
import com.tmaxsoft.hyperchatbot.engine.statistic.domain.dialog.Dialog;
import com.tmaxsoft.hyperchatbot.engine.statistic.domain.dialog.DialogRepository;
import com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
//@Transactional
//@RequiredArgsConstructor
public class DialogService {

    @Autowired
    private DialogRepository dialogRepository;

    public Page<DialogDto> dialogs(SupervisionRequestDto request, Pageable pageable, boolean isTotal){

        String project = isTotal? getProjectAllVersion(request.getModelData())
                :getProjectVersionId(request.getModelData());
        LocalDate start = request.getStartDateTime().toLocalDate();
        LocalDate end = request.getEndDateTime().toLocalDate();

        Page<Dialog> totalDialogs = isTotal? dialogRepository.findTotalDialogs(project, start, end, pageable)
                :dialogRepository.findDialogs(project, start, end, pageable);
        Page<DialogDto> map = totalDialogs.map(DialogDto::new);

        return map;
    }

    public StatisticResponseDto statistics(SupervisionRequestDto request, boolean isTotal){
        String project = isTotal? getProjectAllVersion(request.getModelData())
                :getProjectVersionId(request.getModelData());
        LocalDate date = request.getStartDateTime().toLocalDate();

        return StatisticResponseDto.builder()
                .projectDialogs(dialogCount(project, date, isTotal))
                .botTotalDialogs(botDialogCount(project, date, isTotal))
                .scenarioTotalUsage(scenarioUsageCount(project, date, isTotal))
                .intentTotalUsage(intentUsageCount(project, date, isTotal))
                .build();
    }

    private CountValue dialogCount(String project, LocalDate date, boolean isTotal){
        List<DialogCountDto> dialogCount =
                isTotal? dialogRepository.findTotalDialogCount(project, date)
                :dialogRepository.findDialogCount(project, date);
        CountValue countValue = new CountValue();
        if(isTotal){
            countValue.setId(project.split("_")[0]);
        } else{
            countValue.setId(project);
        }
        for(DialogCountDto count: dialogCount){
            if(countValue.getName()==null)
                countValue.setName(count.getProjectName());
            countValue.addCount(count.getTimeIndex(), count.getCount());
        }
        return countValue;
    }

    private List<CountValue> botDialogCount(String project, LocalDate date, boolean isTotal){

        List<BotDialogCountDto> botDialogCount =
                isTotal? dialogRepository.findTotalBotDialogCount(project, date)
                :dialogRepository.findBotDialogCount(project, date);
        HashMap<String, CountValue> tmpResult = new HashMap<>();
        CountValue countValue;
        for(BotDialogCountDto count: botDialogCount){
            if(!tmpResult.containsKey(count.getBotId())){
                countValue = new CountValue(count.getBotId(), count.getBotName());
            } else{
                countValue = tmpResult.get(count.getBotId());
            }
            countValue.addCount(count.getTimeIndex(), count.getCount());
            tmpResult.put(count.getBotId(), countValue);
        }

        return new ArrayList(tmpResult.values());
    }

    private List<StatisticVo> scenarioUsageCount(String project,
                                                 LocalDate date,
                                                 boolean isTotal){

        List<TargetCountDto> scenarioDialogCount =
                isTotal? dialogRepository.findTotalScenarioDialogCount(project, date)
                :dialogRepository.findScenarioDialogCount(project, date);

        return getStatisticValues(scenarioDialogCount);
    }

    private List<StatisticVo> intentUsageCount(String projectId, LocalDate date, boolean isTotal){
        List<TargetCountDto> intentUsageCount =
                isTotal? dialogRepository.findTotalIntentUsageCount(projectId, date)
                :dialogRepository.findIntentUsageCount(projectId, date);

        return getStatisticValues(intentUsageCount);
    }

    private List<StatisticVo> getStatisticValues(List<TargetCountDto> countDtos){
        HashMap<String, StatisticVo> tmpResult = new HashMap<>();
        HashMap<String, HashMap<String, CountValue>> innerMap = new HashMap<>();
        HashMap<String, CountValue> tmpMap;
        StatisticVo statisticVo;
        CountValue countValue;
        for(TargetCountDto count: countDtos){
            if(!tmpResult.containsKey(count.getId())){
                tmpResult.put(count.getId(), new StatisticVo(count.getId(), count.getName()));
            }
            tmpMap = innerMap.getOrDefault(count.getId(), new HashMap<>());
            if(!tmpMap.containsKey(count.getTargetId()))
                countValue = new CountValue(count.getTargetId(), count.getTargetName());
            else {
                countValue = tmpMap.get(count.getTargetId());
            }
            countValue.addCount(count.getTimeIndex(), count.getCount());
            tmpMap.put(count.getTargetId(), countValue);
            innerMap.put(count.getId(), tmpMap);
        }

        for(String id: innerMap.keySet()){
            statisticVo = tmpResult.get(id);
            tmpMap = innerMap.get(id);
            statisticVo.setValues(new ArrayList(tmpMap.values()));
            tmpResult.put(id, statisticVo);
        }
        return new ArrayList(tmpResult.values());
    }

    private String getProjectVersionId(ModelDataDto modelData){
        return String.format("%s_%s", modelData.getProject_id(), modelData.getVersion());
    }

    private String getProjectAllVersion(ModelDataDto modelData){
        return String.format("%s_%%", modelData.getProject_id());
    }

}
