package com.tmaxsoft.hyperchatbot.engine.statistic.resultdto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class ScenarioDialogCountDto {

    private String botId;
    private String botName;
    private Long scenarioId;
    private String scenarioName;
    private Integer timeIndex;
    private Long count;

}
