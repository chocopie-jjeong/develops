package com.tmaxsoft.hyperchatbot.engine.controller.handler;

import com.tmaxsoft.hyperchatbot.engine.controller.requestdto.SupervisionRequestDto;
import com.tmaxsoft.hyperchatbot.engine.serivce.DialogService;
import com.tmaxsoft.hyperchatbot.engine.serivce.responsedto.RecordResponseDto;
import com.tmaxsoft.hyperchatbot.engine.serivce.responsedto.StatisticResponseDto;
import com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.DialogDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class StatisticServiceHandler {

    private final DialogService dialogService;

    public RecordResponseDto getRecords(SupervisionRequestDto request, boolean isTotal){
        List<DialogDto> dialogDtos = dialogService.records(request, isTotal);
        return new RecordResponseDto(dialogDtos);
    }

    public StatisticResponseDto getStatistics(SupervisionRequestDto request, boolean isTotal){
        return dialogService.statistics(request, isTotal);
    }
}
