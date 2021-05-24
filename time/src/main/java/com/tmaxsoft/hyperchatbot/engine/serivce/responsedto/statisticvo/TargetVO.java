package com.tmaxsoft.hyperchatbot.engine.serivce.responsedto.statisticvo;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
public class TargetVO {
    private String targetId;
    private String targetName;
    private Long total;
    private List<Long> typeCount = new ArrayList<>();
}
