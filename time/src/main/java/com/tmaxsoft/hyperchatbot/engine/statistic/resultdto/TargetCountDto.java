package com.tmaxsoft.hyperchatbot.engine.statistic.resultdto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class TargetCountDto {

    private String Id;
    private String Name;
    private String targetId;
    private String targetName;
    private Integer timeIndex;
    private Long count;
}
