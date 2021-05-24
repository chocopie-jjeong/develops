package com.tmaxsoft.hyperchatbot.engine.serivce.responsedto.statisticvo;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@ToString
@Getter @Setter
public class CountValue {
    private String id;
    private String name;
    private long[] counts = new long[25];

    public CountValue(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addCount(int idx, long val){
        counts[idx] = val;
    }
}
