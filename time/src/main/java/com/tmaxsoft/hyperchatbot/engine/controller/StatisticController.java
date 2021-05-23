package com.tmaxsoft.hyperchatbot.engine.controller;

import com.tmaxsoft.hyperchatbot.engine.controller.requestdto.SupervisionRequestDto;
import com.tmaxsoft.hyperchatbot.engine.controller.handler.StatisticServiceHandler;

import com.tmaxsoft.hyperchatbot.engine.serivce.responsedto.RecordResponseDto;
import com.tmaxsoft.hyperchatbot.engine.serivce.responsedto.StatisticResponseDto;
import com.tmaxsoft.hyperchatbot.engine.statistic.domain.dialog.Dialog;
import com.tmaxsoft.hyperchatbot.engine.statistic.domain.dialog.DialogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Arrays;


@Slf4j
@RequiredArgsConstructor
@RequestMapping("/supervision/dialog")
@RestController
public class StatisticController {

    private final StatisticServiceHandler serviceHandler;
    private final DialogRepository dialogRepository;

//    @PostConstruct
//    public void initialize(){
//        init();
//        System.out.println("Save data in DB");
//    }

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

    private void init(){
        Dialog dialog11 = Dialog.builder()
                .projectId("1_1")
                .projectName("충남대")
                .botId("1")
                .botName("총무팀")
                .scenarioId(1L)
                .scenarioName("등록금")
                .build();

        Dialog dialog12 = Dialog.builder()
                .projectId("1_1")
                .projectName("충남대")
                .botId("1")
                .botName("총무팀")
                .scenarioId(2L)
                .scenarioName("비품구입")
                .build();

        Dialog dialog13 = Dialog.builder()
                .projectId("1_1")
                .projectName("충남대")
                .botId("2")
                .botName("학생처")
                .scenarioId(1L)
                .scenarioName("성적")
                .build();

        Dialog dialog14 = Dialog.builder()
                .projectId("1_1")
                .projectName("충남대")
                .botId("3")
                .botName("대외협력처")
                .scenarioId(1L)
                .scenarioName("동문회")
                .build();

        Dialog dialog15 = Dialog.builder()
                .projectId("1_1")
                .projectName("충남대")
                .botId("1")
                .botName("총무팀")
                .scenarioId(1L)
                .scenarioName("등록금")
                .build();

        Dialog dialog21 = Dialog.builder()
                .projectId("1_2")
                .projectName("충남대")
                .botId("1")
                .botName("총무팀")
                .scenarioId(1L)
                .scenarioName("등록금")
                .build();

        Dialog dialog22 = Dialog.builder()
                .projectId("1_2")
                .projectName("충남대")
                .botId("1")
                .botName("총무팀")
                .scenarioId(2L)
                .scenarioName("비품구입")
                .build();

        Dialog dialog23 = Dialog.builder()
                .projectId("1_2")
                .projectName("충남대")
                .botId("2")
                .botName("학생처")
                .scenarioId(1L)
                .scenarioName("성적")
                .build();

        Dialog dialog24 = Dialog.builder()
                .projectId("1_2")
                .projectName("충남대")
                .botId("3")
                .botName("대외협력처")
                .scenarioId(1L)
                .scenarioName("동문회")
                .build();

        Dialog dialog25 = Dialog.builder()
                .projectId("1_2")
                .projectName("충남대")
                .botId("1")
                .botName("총무팀")
                .scenarioId(1L)
                .scenarioName("등록금")
                .build();

        dialogRepository.saveAll(Arrays.asList(dialog11,dialog12,dialog13,dialog14,dialog15,
                dialog21,dialog22,dialog23,dialog24,dialog25));
    }
}

