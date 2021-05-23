package com.tmaxsoft.hyperchatbot.engine.statistic.resultdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@ToString
@Getter
@AllArgsConstructor
public class BotDialogCountDto {

    private String botId;
    private String botName;
    private Long count;
    private Integer timeIdx;

}
