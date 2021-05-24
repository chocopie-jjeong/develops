package com.tmaxsoft.hyperchatbot.engine.statistic.domain.extractedentity;

import com.tmaxsoft.hyperchatbot.engine.statistic.domain.dialog.Dialog;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Getter
@Validated
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
        name = "VALUE_SEQ_GEN",
        sequenceName = "VALUE_SEQ",
        initialValue = 1,
        allocationSize = 1
)
@Entity
public class ExtractedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VALUE_SEQ_GEN")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "dialog_id",
            nullable = false
    )
    private Dialog dialog;

    @Column(nullable = false)
    private Long entityRoleId;

    @Column(nullable = false)
    private String entityRoleName;

    @Column(nullable = false, columnDefinition = "NVARCHAR(20)")
    private String value;

    @Builder
    public ExtractedEntity(Long entityRoleId,
                           String entityRoleName,
                           String value) {
        this.entityRoleId = entityRoleId;
        this.entityRoleName = entityRoleName;
        this.value = value;
    }

    public void updateDialog(Dialog dialog) {
        this.dialog = dialog;
    }
}