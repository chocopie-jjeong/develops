package com.tmaxsoft.hyperchatbot.engine.serivce.responsedto;

import com.tmaxsoft.hyperchatbot.engine.serivce.responsedto.statisticvo.CountValue;
import com.tmaxsoft.hyperchatbot.engine.serivce.responsedto.statisticvo.StatisticVo;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class StatisticResponseDto {

    private CountValue projectDialogs;
    private List<CountValue> botTotalDialogs;
    private List<StatisticVo> scenarioTotalUsage;
    private List<StatisticVo> intentTotalUsage;
//    private List<FallbackCountVO> scenarioFallbackTotal;

    @Builder
    public StatisticResponseDto(CountValue projectDialogs,
                                List<CountValue> botTotalDialogs,
                                List<StatisticVo> scenarioTotalUsage,
                                List<StatisticVo> intentTotalUsage
//                                List<FallbackCountVO> scenarioFallbackTotal
    ){
        this.projectDialogs = projectDialogs;
        this.botTotalDialogs = botTotalDialogs;
        this.scenarioTotalUsage = scenarioTotalUsage;
        this.intentTotalUsage = intentTotalUsage;
//        this.scenarioFallbackTotal = scenarioFallbackTotal;
    }
}