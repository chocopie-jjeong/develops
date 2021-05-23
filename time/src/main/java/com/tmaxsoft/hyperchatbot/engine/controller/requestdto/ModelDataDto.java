package com.tmaxsoft.hyperchatbot.engine.controller.requestdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class ModelDataDto {
    private Long project_id;
    private Integer version;
    private boolean deploy_status;
    private boolean test_status;
}
