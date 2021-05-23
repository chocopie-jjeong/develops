package com.tmaxsoft.hyperchatbot.engine.statistic.domain.dialog;

import com.tmaxsoft.hyperchatbot.engine.controller.requestdto.ModelDataDto;
import com.tmaxsoft.hyperchatbot.engine.controller.requestdto.SupervisionRequestDto;
import com.tmaxsoft.hyperchatbot.engine.serivce.DialogService;
import com.tmaxsoft.hyperchatbot.engine.serivce.responsedto.StatisticResponseDto;
import com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.BotDialogCountDto;
import com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.DialogDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
class DialogRepositoryTest {

    @Autowired
    private DialogRepository dialogRepository;

    @Autowired
    private DialogService dialogService;

    @BeforeEach
    void init(){
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

    @AfterEach
    void clear(){

        dialogRepository.deleteAll();
    }

    @Test
    void 프로젝트_총_대화로그_조회(){

        //given
        ModelDataDto modeldata = new ModelDataDto("1","1", false,false);
        SupervisionRequestDto dto = new SupervisionRequestDto(modeldata, LocalDateTime.now(), LocalDateTime.now());

        //when
        List<DialogDto> records = dialogService.records(dto, true);

        //then
        System.out.println("전체 조회 수: "+ records.size());
        for (DialogDto dialog: records){
            System.out.println(dialog);
        }

    }

//    @Test
//    void 프로젝트_버전_대화로그_조회(){
//
//        //given
//        ModelDataDto modeldata = new ModelDataDto("1","1", false,false);
//        SupervisionRequestDto dto = new SupervisionRequestDto(modeldata, LocalDateTime.now(), LocalDateTime.now());
//
//        //when
//        List<Dialog> dialogs = dialogRepository.findDialogs(dto.getProjectId()+"_"+dto.getVersion(),
//                dto.getStartDateTime().toLocalDate(), dto.getEndDateTime().toLocalDate());
//
//        //then
//        System.out.println("전체 조회 수: "+dialogs.size());
//        for (Dialog dialog: dialogs){
//            System.out.println(dialog);
//        }
//
//    }
//
    @Test
    void 프로젝트_봇_대화량() {

        //given
        ModelDataDto modeldata = new ModelDataDto("1","1", false,false);
        SupervisionRequestDto dto = new SupervisionRequestDto(modeldata, LocalDateTime.now(), LocalDateTime.now());

        //when
        StatisticResponseDto statistics = dialogService.statistics(dto, false);

        //then
//        System.out.println("전체 조회 수: "+botDialogCount.size());
//        for (BotDialogCountDto countDto: botDialogCount){
//            System.out.println(countDto);
//        }
        statistics.print();

    }
//
//    @Test
//    void 프로젝트_봇_버전_대화량(){
//        //given
//        ModelDataDto modeldata = new ModelDataDto("1","1", false,false);
//        SupervisionRequestDto dto = new SupervisionRequestDto(modeldata, LocalDateTime.now(), LocalDateTime.now());
//
//        //when
//        List<BotDialogCountDto> botDialogCount = dialogRepository.findBotDialogCount(dto.getProjectId() + "_" + dto.getVersion(),
//                dto.getStartDateTime().toLocalDate());
//
//        //then
//        System.out.println("전체 조회 수: "+botDialogCount.size());
//        for (BotDialogCountDto countDto: botDialogCount){
//            System.out.println(countDto);
//        }
//
//
//    }
//
//    @Test
//    void 프로젝트_봇_시나리오_대화량(){
//
//        //given
//        ModelDataDto modeldata = new ModelDataDto("1","1", false,false);
//        SupervisionRequestDto dto = new SupervisionRequestDto(modeldata, LocalDateTime.now(), LocalDateTime.now());
//
//        //when
//        List<ScenarioDialogCountDto> scenarioDialogCount = dialogRepository.findTotalScenarioDialogCount(dto.getStartDateTime().toLocalDate(),
//                dto.getProjectId() + "_%");
//
//        //then
//        System.out.println("전체 조회 수: "+scenarioDialogCount.size());
//        for (ScenarioDialogCountDto countDto: scenarioDialogCount){
//            System.out.println(countDto);
//        }
//
//    }

}
