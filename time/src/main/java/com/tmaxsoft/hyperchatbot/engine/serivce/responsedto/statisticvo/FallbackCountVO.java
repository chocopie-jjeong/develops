package com.tmaxsoft.hyperchatbot.engine.serivce.responsedto.statisticvo;


import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Getter
@ToString
public class FallbackCountVO {
    private String id;
    private String name;
    private List<TargetVO> values = new ArrayList<>();

    public FallbackCountVO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setValues(ArrayList<TargetVO> values) {
        this.values = values;
    }
}
