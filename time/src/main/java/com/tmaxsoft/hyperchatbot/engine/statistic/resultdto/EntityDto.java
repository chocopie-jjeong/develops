package com.tmaxsoft.hyperchatbot.engine.statistic.resultdto;


import com.tmaxsoft.hyperchatbot.engine.statistic.domain.extractedentity.ExtractedEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class EntityDto {

    private Long entityRoleId;
    private String entityRoleName;
    private String value;

    public EntityDto(ExtractedEntity extractedEntity){
        this.entityRoleId = extractedEntity.getEntityRoleId();
        this.entityRoleName = extractedEntity.getEntityRoleName();
        this.value = extractedEntity.getValue();
    }
}
