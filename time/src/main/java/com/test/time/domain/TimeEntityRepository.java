package com.test.time.domain;

import lombok.ToString;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TimeEntityRepository extends JpaRepository<TimeEntity, Long> {

    @Query("select new com.test.time.domain.TimeResult(t.name, count(t), t.timeIndex) from TimeEntity t group by t.timeIndex")
    List<TimeResult> findEntities();
    @Query("select new com.test.time.domain.TimeResult(t.name, count(t), t.timeIndex) from TimeEntity t group by t.timeIndex, t.name")
    List<TimeResult> findEntities2();
}


