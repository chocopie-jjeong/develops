package com.tmaxsoft.hyperchatbot.engine.statistic.resultdto;

import com.tmaxsoft.hyperchatbot.engine.statistic.domain.dialog.Dialog;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
public class DialogDto {

    private String projectId;
    private String projectName;
    private String botId;
    private String botName;
    private Long scenarioId;
    private String scenarioName;
    private LocalDateTime createdDateTime;

    @Builder
    public DialogDto(String projectId,
                     String projectName,
                     String botId,
                     String botName,
                     Long scenarioId,
                     String scenarioName,
                     LocalDateTime createdDateTime){

        this.projectId = projectId;
        this.projectName = projectName;
        this.botId = botId;
        this.botName = botName;
        this.scenarioId = scenarioId;
        this.scenarioName = scenarioName;
        this.createdDateTime = createdDateTime;
    }
}
