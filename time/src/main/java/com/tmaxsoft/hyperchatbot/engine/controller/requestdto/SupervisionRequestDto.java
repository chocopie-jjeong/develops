package com.tmaxsoft.hyperchatbot.engine.controller.requestdto;

import lombok.*;
import org.springframework.lang.Nullable;
import java.time.LocalDateTime;


@Getter
@ToString
@AllArgsConstructor
public class SupervisionRequestDto {

    private ModelDataDto modelData;
    private LocalDateTime startDateTime;
    private @Nullable LocalDateTime endDateTime;
}

