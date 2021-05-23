package com.tmaxsoft.hyperchatbot.engine.serivce.responsedto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;

@ToString
@Getter
public class StatisticResponseDto {


    private long[] projectDialogs;
    private HashMap<String, long[]> botTotalDialogs;
    private HashMap<String, HashMap<Long, long[]>> scenarioTotalUsage;
//    private HashMap<String, HashMap<Long, Long[]>> IntentTotalUsage;
//    private HashMap<String, HashMap<Long, Long[]>> scenarioFallbackTotal;

    @Builder
    public StatisticResponseDto(long[] projectDialogs,
                                HashMap<String, long[]> botTotalDialogs,
                                HashMap<String, HashMap<Long, long[]>> scenarioTotalUsage){
        this.projectDialogs = projectDialogs;
        this.botTotalDialogs = botTotalDialogs;
        this.scenarioTotalUsage = scenarioTotalUsage;
    }

    public void print(){
        System.out.println("projectDialogs: "+this.projectDialogs.toString());

        for(String key: botTotalDialogs.keySet()){
            System.out.print("key "+ key +" = [ " );
            long[] longs = botTotalDialogs.get(key);
            for(long a: longs){
                System.out.print(a+", ");
            }
            System.out.println("]");
        }


        for(String key: scenarioTotalUsage.keySet()){
            System.out.println("bot key = " + key);
            HashMap<Long, long[]> map = scenarioTotalUsage.get(key);
            for(Long sKey: map.keySet()){
                System.out.print("scenario Key = [ ");
                long[] longs = map.get(sKey);
                for(long a: longs){
                    System.out.print(a+", ");
                }
                System.out.println("]");
            }

        }


        System.out.println("scenarioTotalUsage = " + scenarioTotalUsage.toString());


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
