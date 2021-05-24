package com.tmaxsoft.hyperchatbot.engine.statistic.resultdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public class DialogCountDto {

    private String projectName;
    private Integer timeIndex;
    private Long count;
}
