package com.tmaxsoft.hyperchatbot.engine.statistic.resultdto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class FallbackCountDto {

    private String botId;
    private String botName;
    private String scenarioId;
    private String scenarioName;
    private Integer statusCode;
    private Long count;
}
