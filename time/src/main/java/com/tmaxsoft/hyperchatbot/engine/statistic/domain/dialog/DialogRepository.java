package com.tmaxsoft.hyperchatbot.engine.statistic.domain.dialog;

import com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DialogRepository extends JpaRepository<Dialog, Long> {


    // 해당 프로젝트에 대한 모든 대화 로그 조회
//    @EntityGraph(attributePaths = "extractedEntities")
    List<Dialog> findDialogsByProjectId(String projectId);


    // 해당 프로젝트의 전체 버전에 대한 특정 일자 기준으로 대화 로그 조회
    @Query("select d " +
            "from Dialog d " +
            "where d.projectId like :projectAllVersion and " +
            "d.createdDate between :start and :end " +
            "order by d.createdDateTime")
    List<Dialog> findTotalDialogs(@Param("projectAllVersion") String projectAllVersion,
                                  @Param("start") LocalDate startTime,
                                  @Param("end")LocalDate endTime);


    // 해당 프로젝트의 특정 버전에 대한 특정 일자 기준으로 대화 로그 조회
    @Query("select d " +
            "from Dialog d " +
            "where d.projectId=:projectId and " +
            "d.createdDate between :start and :end " +
            "order by d.createdDateTime")
    List<Dialog> findDialogs(@Param("projectId") String projectId,
                             @Param("start") LocalDate startTime,
                             @Param("end")LocalDate endTime);


    // 해당 프로젝트의 전체 버전에 대한 특정 일자의 대화량
    @Query(value = "select " +
            "new com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.DialogCountDto(count(d), d.timeIndex) " +
            "from Dialog d " +
            "where d.projectId like :projectAllVersion and d.createdDate=:date " +
            "group by d.timeIndex")
    List<DialogCountDto> findTotalDialogCount(@Param("projectAllVersion") String projectAllVersion,
                                                @Param("date") LocalDate date);


    // 해당 프로젝트의 특정 버전에 대한 특정 일자의 대화량
    @Query(value = "select " +
            "new com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.DialogCountDto(count(d), d.timeIndex) " +
            "from Dialog d " +
            "where d.projectId=:projectId and d.createdDate=:date " +
            "group by d.timeIndex")
    List<DialogCountDto> findDialogCount(@Param("projectId") String projectId,
                                         @Param("date") LocalDate date);


    // 해당 프로젝트의 전체 버전에 대한 특정 일자의 봇별 대화량
    @Query(value = "select " +
            "new com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.BotDialogCountDto(d.botId, d.botName, " +
            "count(d), d.timeIndex) " +
            "from Dialog d " +
            "where d.projectId like :projectAllVersion and d.createdDate=:date " +
            "group by d.botId, d.timeIndex")
    List<BotDialogCountDto> findTotalBotDialogCount(@Param("projectAllVersion") String projectAllVersion,
                                                    @Param("date") LocalDate date);


    // 해당 프로젝트의 특정 버전에 대한 특정 일자의 봇별 대화량
    @Query(value = "select " +
            "new com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.BotDialogCountDto(d.botId, d.botName, " +
            "count(d), d.timeIndex) " +
            "from Dialog d " +
            "where d.projectId=:projectId and d.createdDate=:date " +
            "group by d.botId, d.timeIndex")
    List<BotDialogCountDto> findBotDialogCount(@Param("projectId")String projectId,
                                               @Param("date") LocalDate date);


    // 해당 프로젝트에 대한 봇별 시나리오별 대화량
    @Query(value = "select " +
            "new com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.ScenarioDialogCountDto(d.botId, d.botName, " +
            "d.scenarioId, d.scenarioName, d.timeIndex, count(d)) " +
            "from Dialog d " +
            "where d.projectId like :projectAllVersion and d.createdDate=:date " +
            "group by d.botId, d.scenarioId, d.timeIndex")
    List<ScenarioDialogCountDto> findTotalScenarioDialogCount(@Param("projectAllVersion") String projectAllVersion,
                                                              @Param("date") LocalDate date);


    // 해당 프로젝트에 대한 봇별 시나리오별 대화량
    @Query(value = "select " +
            "new com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.ScenarioDialogCountDto(d.botId, d.botName, " +
            "d.scenarioId, d.scenarioName, d.timeIndex, count(d)) " +
            "from Dialog d " +
            "where d.projectId=:projectId and d.createdDate=:date " +
            "group by d.botId, d.scenarioId, d.timeIndex")
    List<ScenarioDialogCountDto> findScenarioDialogCount(@Param("projectId")String projectId,
                                                         @Param("date") LocalDate date);

}
