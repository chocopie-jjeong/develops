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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


//@SpringBootTest
class DialogRepositoryTest {

//    @Autowired
//    private DialogRepository dialogRepository;
//
//    @Autowired
//    private DialogService dialogService;
//
//    @BeforeEach
//    void init(){
//        Dialog dialog11 = Dialog.builder()
//                .projectId("1_1")
//                .projectName("충남대")
//                .botId("1")
//                .botName("총무팀")
//                .scenarioId("1")
//                .scenarioName("등록금")
//                .intentId("1")
//                .intentName("납부하기")
//                .build();
//
//        Dialog dialog12 = Dialog.builder()
//                .projectId("1_1")
//                .projectName("충남대")
//                .botId("1")
//                .botName("총무팀")
//                .scenarioId("2")
//                .scenarioName("비품구입")
//                .intentId("2")
//                .intentName("구입하기")
//                .build();
//
//        Dialog dialog13 = Dialog.builder()
//                .projectId("1_1")
//                .projectName("충남대")
//                .botId("2")
//                .botName("학생처")
//                .scenarioId("3")
//                .scenarioName("성적")
//                .intentId("3")
//                .intentName("성적확인")
//                .build();
//
//        Dialog dialog14 = Dialog.builder()
//                .projectId("1_1")
//                .projectName("충남대")
//                .botId("3")
//                .botName("대외협력처")
//                .scenarioId("4")
//                .scenarioName("동문회")
//                .intentId("4")
//                .intentName("가입하기")
//                .build();
//
//        Dialog dialog15 = Dialog.builder()
//                .projectId("1_1")
//                .projectName("충남대")
//                .botId("1")
//                .botName("총무팀")
//                .scenarioId("1")
//                .scenarioName("등록금")
//                .intentId("5")
//                .intentName("분할납부")
//                .build();
//
//        Dialog dialog21 = Dialog.builder()
//                .projectId("1_2")
//                .projectName("충남대")
//                .botId("1")
//                .botName("총무팀")
//                .scenarioId("1")
//                .scenarioName("등록금")
//                .intentId("1")
//                .intentName("납부하기")
//                .build();
//
//        Dialog dialog22 = Dialog.builder()
//                .projectId("1_2")
//                .projectName("충남대")
//                .botId("1")
//                .botName("총무팀")
//                .scenarioId("2")
//                .scenarioName("비품구입")
//                .intentId("2")
//                .intentName("구입하기")
//                .build();
//
//        Dialog dialog23 = Dialog.builder()
//                .projectId("1_2")
//                .projectName("충남대")
//                .botId("2")
//                .botName("학생처")
//                .scenarioId("3")
//                .scenarioName("성적")
//                .intentId("3")
//                .intentName("성적확인")
//                .build();
//
//        Dialog dialog24 = Dialog.builder()
//                .projectId("1_2")
//                .projectName("충남대")
//                .botId("3")
//                .botName("대외협력처")
//                .scenarioId("4")
//                .scenarioName("동문회")
//                .intentId("4")
//                .intentName("가입하기")
//                .build();
//
//        Dialog dialog25 = Dialog.builder()
//                .projectId("1_2")
//                .projectName("충남대")
//                .botId("1")
//                .botName("총무팀")
//                .scenarioId("1")
//                .scenarioName("등록금")
//                .intentId("5")
//                .intentName("분할납부")
//                .build();
//
//        Dialog dialog251 = Dialog.builder()
//                .projectId("1_2")
//                .projectName("충남대")
//                .botId("1")
//                .botName("총무팀")
//                .scenarioId("1")
//                .scenarioName("등록금")
//                .intentId("5")
//                .intentName("분할납부")
//                .statusCode(1)
//                .build();
//        Dialog dialog252 = Dialog.builder()
//                .projectId("1_2")
//                .projectName("충남대")
//                .botId("1")
//                .botName("총무팀")
//                .scenarioId("1")
//                .scenarioName("등록금")
//                .intentId("5")
//                .intentName("분할납부")
//                .statusCode(2)
//                .build();
//        Dialog dialog253 = Dialog.builder()
//                .projectId("1_2")
//                .projectName("충남대")
//                .botId("1")
//                .botName("총무팀")
//                .scenarioId("1")
//                .scenarioName("등록금")
//                .intentId("5")
//                .intentName("분할납부")
//                .statusCode(2)
//                .build();
//        Dialog dialog254 = Dialog.builder()
//                .projectId("1_2")
//                .projectName("충남대")
//                .botId("1")
//                .botName("총무팀")
//                .scenarioId("1")
//                .scenarioName("등록금")
//                .intentId("5")
//                .intentName("분할납부")
//                .statusCode(2)
//                .build();
//        Dialog dialog255 = Dialog.builder()
//                .projectId("1_2")
//                .projectName("충남대")
//                .botId("1")
//                .botName("총무팀")
//                .scenarioId("1")
//                .scenarioName("등록금")
//                .intentId("5")
//                .intentName("분할납부")
//                .statusCode(1)
//                .build();
//
//        dialogRepository.saveAll(Arrays.asList(dialog11,dialog12,dialog13,dialog14,dialog15,
//                dialog21,dialog22,dialog23,dialog24,dialog25,
//                dialog251,dialog252,dialog253,dialog254,dialog255));
//
//    }
//
//    @AfterEach
//    void clear(){
//
//        dialogRepository.deleteAll();
//    }
//
//    @Test
//    void 프로젝트_총_대화로그_조회(){
//
//        //given
//        ModelDataDto modeldata = new ModelDataDto("1","1", false,false);
//        SupervisionRequestDto dto = new SupervisionRequestDto(modeldata, LocalDateTime.now(), LocalDateTime.now());
//
//        PageRequest pageRequest = PageRequest.of(1, 5);
//
//        //when
//        Page<DialogDto> dialogs = dialogService.dialogs(dto, pageRequest, true);
//
//        //then
//        System.out.println("전체 페이지 수: "+ dialogs.getTotalPages());
//        for (DialogDto dialog: dialogs){
//            System.out.println(dialog);
//        }
//    }

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

//    @Test
//    void 프로젝트_봇_대화량() {
//
//        //given
//        ModelDataDto modeldata = new ModelDataDto("1","1", false,false);
//        SupervisionRequestDto dto = new SupervisionRequestDto(modeldata, LocalDateTime.now(), LocalDateTime.now());
//
//        //when
//        StatisticResponseDto statistics = dialogService.statistics(dto, false);
//
//        //then
//        System.out.println(statistics);
//
//        System.out.println("getProjectDialogs = " + statistics.getProjectDialogs());
//        System.out.println("getBotTotalDialogs = " + statistics.getBotTotalDialogs());
//        System.out.println("getScenarioTotalUsage = " + statistics.getScenarioTotalUsage());
//        System.out.println("getIntentTotalUsage = " + statistics.getIntentTotalUsage());
//    }
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
