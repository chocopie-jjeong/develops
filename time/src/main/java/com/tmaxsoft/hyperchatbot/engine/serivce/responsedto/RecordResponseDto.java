package com.tmaxsoft.hyperchatbot.engine.serivce.responsedto;


import com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.DialogDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor
public class RecordResponseDto {
    private List<DialogDto> data;
}

//class Record {
//    private String projectId;
//    private String getProjectName;
//    private String botId;
//    private String botName;
//    private Long scenarioId;
//    private String scenarioName;
//    private LocalDateTime createdDateTime;
//}
