package com.tmaxsoft.hyperchatbot.engine.statistic.domain.dialog;

import com.tmaxsoft.hyperchatbot.engine.statistic.domain.extractedentity.ExtractedEntity;
import com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.DialogDto;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Validated
@ToString //(exclude = {"extractedEntities"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
        name = "DIALOG_SEQ_GEN",
        sequenceName = "DIALOG_SEQ",
        initialValue = 1,
        allocationSize = 1
)
@Entity
public class Dialog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "DIALOG_SEQ_GEN")
    @Column(unique = true, name="dialog_id")
    private Long id;

    private LocalDateTime createdDateTime;
    private LocalDate createdDate;
    private Integer timeIndex;

//    @OneToMany(mappedBy = "dialog", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<ExtractedEntity> extractedEntities = new ArrayList<>();

//    @Column(nullable = false, columnDefinition = "NVARCHAR(20)")
//    private String userId;
//
//    @Column(nullable = false, columnDefinition = "NVARCHAR(255)")
//    private String userMessage;

    private String projectId;

    private String projectName;

    private String botId;

    private String botName;

    private Long scenarioId;

    private String scenarioName;

//    private Long intentId;
//
//    private String intentName;
//
//    private Long actionId;
//
//    private Boolean isTerminated;
//
//    private Boolean isError;
//
//    private Integer statusCode;

    @Builder
    public Dialog(
//            List<ExtractedEntity> extractedEntities,
//                  String userId,
//                  String userMessage,
                  String projectId,
                  String projectName,
                  String botId,
                  String botName,
                  Long scenarioId,
                  String scenarioName
//                  Long intentId,
//                  String intentName,
//                  Long actionId,
//                  Boolean isTerminated,
//                  Boolean isError,
//                  Integer statusCode
    ) {
//        if(extractedEntities != null) {
//            this.extractedEntities = extractedEntities;
//        }
//        this.userId = userId;
//        this.userMessage = userMessage;
        this.projectId = projectId;
        this.projectName = projectName;
        this.botId = botId;
        this.botName = botName;
        this.scenarioId = scenarioId;
        this.scenarioName = scenarioName;
//        this.intentId = intentId;
//        this.intentName = intentName;
//        this.actionId = actionId;
//        this.isTerminated = isTerminated;
//        this.isError = isError;
//        this.statusCode = statusCode;

        setCreatedTime();
    }

//    public void addExtractedEntity(ExtractedEntity extractedEntity){
//        this.extractedEntities.add(extractedEntity);
//        extractedEntity.updateDialog(this);
//    }

    private void setCreatedTime(){
        this.createdDateTime = LocalDateTime.now();
        this.createdDate = this.createdDateTime.toLocalDate();
        this.timeIndex = this.createdDateTime.getHour();
    }

    public static DialogDto toDialogDto(Dialog dialog){
        return DialogDto.builder()
                .projectId(dialog.getProjectId())
                .projectName(dialog.getProjectName())
                .botId(dialog.getBotId())
                .botName(dialog.getBotName())
                .scenarioId(dialog.getScenarioId())
                .scenarioName(dialog.getScenarioName())
                .createdDateTime(dialog.getCreatedDateTime())
                .build();
    }
}
