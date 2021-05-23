package com.tmaxsoft.hyperchatbot.engine.serivce.responsedto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;

@ToString
@Getter
public class StatisticResponseDto {

    private Long[] projectDialogs;
    private HashMap<String, Long[]> botTotalDialogs;
    private HashMap<String, HashMap<Long, Long[]>> scenarioTotalUsage;
//    private HashMap<String, HashMap<Long, Long[]>> IntentTotalUsage;
//    private HashMap<String, HashMap<Long, Long[]>> scenarioFallbackTotal;

    @Builder
    public StatisticResponseDto(Long[] projectDialogs,
                                HashMap<String, Long[]> botTotalDialogs,
                                HashMap<String, HashMap<Long, Long[]>> scenarioTotalUsage){
        this.projectDialogs = projectDialogs;
        this.botTotalDialogs = botTotalDialogs;
        this.scenarioTotalUsage = scenarioTotalUsage;
    }

}

//
//@ToString
//@Getter
//@AllArgsConstructor
//class StatisticInnerDto {
//    private String name;
//    private int[] value;
//
//    public StatisticInnerDto(String name){
//        value = new int[25];
//    }
//}
