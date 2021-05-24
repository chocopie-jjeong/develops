package com.tmaxsoft.hyperchatbot.engine.serivce.responsedto.statisticvo;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Getter
@ToString
public class StatisticVo {
    private String id;
    private String name;
    private List<CountValue> values = new ArrayList<>();

    public StatisticVo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setValues(List<CountValue> values){
        this.values = values;
    }
}


