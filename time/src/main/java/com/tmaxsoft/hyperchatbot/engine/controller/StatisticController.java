package com.tmaxsoft.hyperchatbot.engine.controller;

import com.tmaxsoft.hyperchatbot.engine.controller.requestdto.SupervisionRequestDto;

import com.tmaxsoft.hyperchatbot.engine.serivce.DialogService;
import com.tmaxsoft.hyperchatbot.engine.serivce.responsedto.StatisticResponseDto;
import com.tmaxsoft.hyperchatbot.engine.statistic.domain.dialog.Dialog;
import com.tmaxsoft.hyperchatbot.engine.statistic.domain.dialog.DialogRepository;
import com.tmaxsoft.hyperchatbot.engine.statistic.domain.extractedentity.ExtractedEntity;
import com.tmaxsoft.hyperchatbot.engine.statistic.domain.extractedentity.ExtractedEntityRepository;
import com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.DialogDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Arrays;


@Slf4j
@RequiredArgsConstructor
@RequestMapping("/hyperchatbotengine/manage")
@RestController
public class StatisticController {

    private final DialogService dialogService;
    private final DialogRepository dialogRepository;
    private final ExtractedEntityRepository extractedEntityRepository;

//    @PostConstruct
//    public void initialize(){
//        init();
//        System.out.println("Save data in DB");
//    }

    @PostMapping("/dialogs")
    public Page<DialogDto> serveTotalRecords(@PageableDefault(size=15, sort="projectId",
            direction = Sort.Direction.ASC) Pageable pageable,
                                             @RequestBody SupervisionRequestDto request){
        log.info("serveTotalRecords RequestBody: {}", request);
        return dialogService.dialogs(request, pageable, true);
    }

    @PostMapping("/dialogs/project")
    public Page<DialogDto> serveRecords(@PageableDefault(size=15, sort="projectId",
            direction = Sort.Direction.DESC) Pageable pageable,
                                          @RequestBody SupervisionRequestDto request){

        log.info("serveRecords RequestBody: {}", request);
        return dialogService.dialogs(request, pageable,false);
    }

    @PostMapping("/statistics")
    public StatisticResponseDto serveTotalStatistics(@RequestBody SupervisionRequestDto request){

        log.info("serveTotalStatistics RequestBody: {}", request);
        return dialogService.statistics(request, true);
    }

    @PostMapping("/statistics/project")
    public StatisticResponseDto serveStatistics(@RequestBody SupervisionRequestDto request){

        log.info("serveStatistics RequestBody: {}", request);
        return dialogService.statistics(request, false);
    }

    private void init(){ // for test
        Dialog dialog11 = Dialog.builder()
                .projectId("1_1")
                .projectName("?????????")
                .botId("1")
                .botName("?????????")
                .scenarioId("1")
                .scenarioName("?????????")
                .intentId("1")
                .intentName("????????????")
                .build();

        Dialog dialog12 = Dialog.builder()
                .projectId("1_1")
                .projectName("?????????")
                .botId("1")
                .botName("?????????")
                .scenarioId("2")
                .scenarioName("????????????")
                .intentId("2")
                .intentName("????????????")
                .build();

        Dialog dialog13 = Dialog.builder()
                .projectId("1_1")
                .projectName("?????????")
                .botId("2")
                .botName("?????????")
                .scenarioId("3")
                .scenarioName("??????")
                .intentId("3")
                .intentName("????????????")
                .build();

        Dialog dialog14 = Dialog.builder()
                .projectId("1_1")
                .projectName("?????????")
                .botId("3")
                .botName("???????????????")
                .scenarioId("4")
                .scenarioName("?????????")
                .intentId("4")
                .intentName("????????????")
                .build();

        Dialog dialog15 = Dialog.builder()
                .projectId("1_1")
                .projectName("?????????")
                .botId("1")
                .botName("?????????")
                .scenarioId("1")
                .scenarioName("?????????")
                .intentId("5")
                .intentName("????????????")
                .build();

        Dialog dialog21 = Dialog.builder()
                .projectId("1_2")
                .projectName("?????????")
                .botId("1")
                .botName("?????????")
                .scenarioId("1")
                .scenarioName("?????????")
                .intentId("1")
                .intentName("????????????")
                .build();

        Dialog dialog22 = Dialog.builder()
                .projectId("1_2")
                .projectName("?????????")
                .botId("1")
                .botName("?????????")
                .scenarioId("2")
                .scenarioName("????????????")
                .intentId("2")
                .intentName("????????????")
                .build();

        Dialog dialog23 = Dialog.builder()
                .projectId("1_2")
                .projectName("?????????")
                .botId("2")
                .botName("?????????")
                .scenarioId("3")
                .scenarioName("??????")
                .intentId("3")
                .intentName("????????????")
                .build();

        Dialog dialog24 = Dialog.builder()
                .projectId("1_2")
                .projectName("?????????")
                .botId("3")
                .botName("???????????????")
                .scenarioId("4")
                .scenarioName("?????????")
                .intentId("4")
                .intentName("????????????")
                .build();

        Dialog dialog25 = Dialog.builder()
                .projectId("1_2")
                .projectName("?????????")
                .botId("1")
                .botName("?????????")
                .scenarioId("1")
                .scenarioName("?????????")
                .intentId("5")
                .intentName("????????????")
                .build();

        Dialog dialog251 = Dialog.builder()
                .projectId("1_2")
                .projectName("?????????")
                .botId("1")
                .botName("?????????")
                .scenarioId("1")
                .scenarioName("?????????")
                .intentId("5")
                .intentName("????????????")
                .statusCode(1)
                .build();
        Dialog dialog252 = Dialog.builder()
                .projectId("1_2")
                .projectName("?????????")
                .botId("1")
                .botName("?????????")
                .scenarioId("1")
                .scenarioName("?????????")
                .intentId("5")
                .intentName("????????????")
                .statusCode(2)
                .build();
        Dialog dialog253 = Dialog.builder()
                .projectId("1_2")
                .projectName("?????????")
                .botId("1")
                .botName("?????????")
                .scenarioId("1")
                .scenarioName("?????????")
                .intentId("5")
                .intentName("????????????")
                .statusCode(2)
                .build();
        Dialog dialog254 = Dialog.builder()
                .projectId("1_2")
                .projectName("?????????")
                .botId("1")
                .botName("?????????")
                .scenarioId("1")
                .scenarioName("?????????")
                .intentId("5")
                .intentName("????????????")
                .statusCode(2)
                .build();
        Dialog dialog255 = Dialog.builder()
                .projectId("1_2")
                .projectName("?????????")
                .botId("1")
                .botName("?????????")
                .scenarioId("1")
                .scenarioName("?????????")
                .intentId("5")
                .intentName("????????????")
                .statusCode(1)
                .build();

        ExtractedEntity entity1 = ExtractedEntity.builder()
                .entityRoleId(1l)
                .entityRoleName("??????")
                .value("1000000000")
                .build();

        entity1.updateDialog(dialog11);


        ExtractedEntity entity2 = ExtractedEntity.builder()
                .entityRoleId(1l)
                .entityRoleName("??????")
                .value("1000000000")
                .build();

        entity2.updateDialog(dialog15);

        dialog11.addExtractedEntity(entity1);
        dialog15.addExtractedEntity(entity2);


        dialogRepository.saveAll(Arrays.asList(dialog11,dialog12,dialog13,dialog14,dialog15,
                dialog21,dialog22,dialog23,dialog24,dialog25,
                dialog251,dialog252,dialog253,dialog254,dialog255));

        extractedEntityRepository.saveAll(Arrays.asList(entity1, entity2));
    }
}
