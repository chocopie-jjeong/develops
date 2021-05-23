package com.test.time.domain;

import lombok.ToString;

@ToString
public class TimeResult{
    String name;
    Long count;
    Integer timeIndex;

    protected TimeResult(){}

    public TimeResult(String name, Long count, Integer timeIndex) {
        this.name = name;
        this.count = count;
        this.timeIndex = timeIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Integer getTimeIndex() {
        return timeIndex;
    }

    public void setTimeIndex(Integer timeIndex) {
        this.timeIndex = timeIndex;
    }
}
