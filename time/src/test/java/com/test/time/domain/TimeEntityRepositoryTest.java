package com.test.time.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TimeEntityRepositoryTest {

    @Autowired
    TimeEntityRepository timeEntityRepository;


    @BeforeEach
    void clear(){
        timeEntityRepository.deleteAll();
    }

    @Test
    void 시간저장_테스트(){
        //given
        TimeEntity timeEntity = TimeEntity.builder().name("테스트").build();
        timeEntityRepository.save(timeEntity);

        //when
        TimeEntity entity = timeEntityRepository.findAll().get(0);
        LocalDateTime time = entity.getTime();

        //then
        System.out.println(time);
        System.out.println(entity.getTimeIndex());

    }

    @Test
    void 그룹화_테스트(){

        //given
        TimeEntity timeEntity = TimeEntity.builder().name("테스트").timeIndex(1).build();
        TimeEntity timeEntity1 = TimeEntity.builder().name("테스트").timeIndex(1).build();
        TimeEntity timeEntity2 = TimeEntity.builder().name("테스트").timeIndex(1).build();
        TimeEntity timeEntity3 = TimeEntity.builder().name("테스트2").timeIndex(2).build();
        TimeEntity timeEntity4 = TimeEntity.builder().name("테스트2").timeIndex(2).build();
        TimeEntity timeEntity5 = TimeEntity.builder().name("테스트2").timeIndex(2).build();
        TimeEntity timeEntity6 = TimeEntity.builder().name("테스트2").timeIndex(4).build();
        TimeEntity timeEntity7 = TimeEntity.builder().name("테스트3").timeIndex(4).build();
        TimeEntity timeEntity8 = TimeEntity.builder().name("테스트3").timeIndex(4).build();
        TimeEntity timeEntity9 = TimeEntity.builder().name("테스트3").timeIndex(10).build();
        TimeEntity timeEntity10 = TimeEntity.builder().name("테스트4").timeIndex(10).build();
        TimeEntity timeEntity11 = TimeEntity.builder().name("테스트4").timeIndex(11).build();
        TimeEntity timeEntity12 = TimeEntity.builder().name("테스트4").timeIndex(24).build();

        timeEntityRepository.saveAll(Arrays.asList(timeEntity,timeEntity1,timeEntity2, timeEntity3, timeEntity4,
                timeEntity5,timeEntity6,timeEntity7,timeEntity8,timeEntity9,timeEntity10,timeEntity11,timeEntity12));

        // when
        List<TimeResult> entities = timeEntityRepository.findEntities2();

        // then
        for(TimeResult timeResult : entities){
            System.out.println(timeResult);
//            System.out.println("count="+timeResult.getCount());
//            System.out.println("name = " + timeResult.getName());
//            System.out.println("timeIndex="+timeResult.getTimeIndex());
        }
//        TimeResult timeResult = entities.get(0);
//        System.out.println(entities.size());
//


    }

}