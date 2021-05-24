package com.tmaxsoft.hyperchatbot.engine.statistic.resultdto;

import com.tmaxsoft.hyperchatbot.engine.statistic.domain.dialog.Dialog;
import com.tmaxsoft.hyperchatbot.engine.statistic.domain.extractedentity.ExtractedEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ToString
@Getter
public class DialogDto {

    private String projectId;
    private String projectName;
    private String botId;
    private String botName;
    private String scenarioId;
    private String scenarioName;
    private String intentId;
    private String intentName;
    private @Nullable List<EntityDto> entities;
    private LocalDateTime createdDateTime;
    private Integer statusCode;


    @Builder
    public DialogDto(Dialog dialog){
        this.projectId = dialog.getProjectId();
        this.projectName = dialog.getProjectName();
        this.botId = dialog.getBotId();
        this.botName = dialog.getBotName();
        this.scenarioId = dialog.getScenarioId();
        this.scenarioName = dialog.getScenarioName();
        this.intentId = dialog.getIntentId();
        this.intentName = dialog.getIntentName();
        this.entities = setEntities(dialog.getExtractedEntities());
        this.createdDateTime = dialog.getCreatedDateTime();
        this.statusCode = dialog.getStatusCode();
    }

    private List<EntityDto> setEntities(List<ExtractedEntity> entities){
        Stream<EntityDto> entityDtoStream = entities.stream()
                .map(EntityDto::new);
        return entityDtoStream.collect(Collectors.toList());
    }
}
