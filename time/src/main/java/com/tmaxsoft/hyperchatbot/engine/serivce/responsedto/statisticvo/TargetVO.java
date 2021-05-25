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
    private Long total = 0L;
    private long[] typeCount = new long[4];

    public TargetVO(String targetId, String targetName) {
        this.targetId = targetId;
        this.targetName = targetName;
    }

    public void addCount(int statusCode, long count){
        this.total += count;
        typeCount[statusCode] = count;
    }
}
