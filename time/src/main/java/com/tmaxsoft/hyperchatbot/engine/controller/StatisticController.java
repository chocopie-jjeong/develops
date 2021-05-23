package com.tmaxsoft.hyperchatbot.engine.controller;

import com.tmaxsoft.hyperchatbot.engine.controller.requestdto.SupervisionRequestDto;
import com.tmaxsoft.hyperchatbot.engine.controller.handler.StatisticServiceHandler;

import com.tmaxsoft.hyperchatbot.engine.serivce.responsedto.RecordResponseDto;
import com.tmaxsoft.hyperchatbot.engine.serivce.responsedto.StatisticResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RequestMapping("/supervision/dialog")
@RestController
public class StatisticController {

    private final StatisticServiceHandler serviceHandler;

    @PostMapping("/records")
    public RecordResponseDto serveTotalRecords(@RequestBody SupervisionRequestDto request){

        log.info("serveTotalRecords RequestBody: {}", request);
        return serviceHandler.getRecords(request, true);
    }

    @PostMapping("/records/project")
    public RecordResponseDto serveRecords(@RequestBody SupervisionRequestDto request){

        log.info("serveRecords RequestBody: {}", request);
        return serviceHandler.getRecords(request, false);
    }

    @PostMapping("/statistics")
    public StatisticResponseDto serveTotalStatistics(@RequestBody SupervisionRequestDto request){

        log.info("serveTotalStatistics RequestBody: {}", request);
        return serviceHandler.getStatistics(request, true);
    }

    @PostMapping("/statistics/project")
    public StatisticResponseDto serveStatistics(@RequestBody SupervisionRequestDto request){

        log.info("serveStatistics RequestBody: {}", request);
        return serviceHandler.getStatistics(request, false);
    }
}

