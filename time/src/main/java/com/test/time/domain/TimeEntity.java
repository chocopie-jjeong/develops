package com.test.time.domain;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;
import java.time.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class TimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    LocalDateTime time;
//    Time time;

    Integer timeIndex;

    LocalDate date;

    String name;


    @Builder
    public TimeEntity(String name, int timeIndex){
        this.name = name;
        this.timeIndex = timeIndex;
        this.time = LocalDateTime.now();
        this.date = LocalDate.now();

    }
}
