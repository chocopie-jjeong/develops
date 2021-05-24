package com.tmaxsoft.hyperchatbot.engine.statistic.domain.dialog;

import com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DialogRepository extends JpaRepository<Dialog, Long> {


    // 해당 프로젝트에 대한 모든 대화 로그 조회
//    @EntityGraph(attributePaths = "extractedEntities")
    Page<Dialog> findDialogsByProjectId(String projectId, Pageable pageable);


    // 해당 프로젝트의 전체 버전에 대한 특정 일자 기준으로 대화 로그 조회
    @Query("select d " +
            "from Dialog d " +
            "where d.projectId like :projectAllVersion and " +
            "d.createdDate between :start and :end " +
            "order by d.createdDateTime")
//    @EntityGraph(attributePaths = "extractedEntities")
    Page<Dialog> findTotalDialogs(@Param("projectAllVersion") String projectAllVersion,
                                  @Param("start") LocalDate startTime,
                                  @Param("end")LocalDate endTime, Pageable pageable);


    // 해당 프로젝트의 특정 버전에 대한 특정 일자 기준으로 대화 로그 조회
    @Query("select d " +
            "from Dialog d " +
            "where d.projectId=:projectId and " +
            "d.createdDate between :start and :end " +
            "order by d.createdDateTime")
//    @EntityGraph(attributePaths = "extractedEntities")
    Page<Dialog> findDialogs(@Param("projectId") String projectId,
                             @Param("start") LocalDate startTime,
                             @Param("end")LocalDate endTime, Pageable pageable);


    // 해당 프로젝트의 전체 버전에 대한 특정 일자의 대화량
    @Query(value = "select " +
            "new com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.DialogCountDto(d.projectName, " +
            "d.timeIndex, count(d)) " +
            "from Dialog d " +
            "where d.projectId like :projectAllVersion and d.createdDate=:date " +
            "group by d.timeIndex")
    List<DialogCountDto> findTotalDialogCount(@Param("projectAllVersion") String projectAllVersion,
                                              @Param("date") LocalDate date);


    // 해당 프로젝트의 특정 버전에 대한 특정 일자의 대화량
    @Query(value = "select " +
            "new com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.DialogCountDto(d.projectName, " +
            "d.timeIndex, count(d)) " +
            "from Dialog d " +
            "where d.projectId=:projectId and d.createdDate=:date " +
            "group by d.timeIndex")
    List<DialogCountDto> findDialogCount(@Param("projectId") String projectId,
                                         @Param("date") LocalDate date);


    // 해당 프로젝트의 전체 버전에 대한 특정 일자의 봇별 대화량
    @Query(value = "select " +
            "new com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.BotDialogCountDto(d.botId, d.botName, " +
            "d.timeIndex, count(d)) " +
            "from Dialog d " +
            "where d.projectId like :projectAllVersion and d.createdDate=:date " +
            "group by d.botId, d.timeIndex")
    List<BotDialogCountDto> findTotalBotDialogCount(@Param("projectAllVersion") String projectAllVersion,
                                                    @Param("date") LocalDate date);


    // 해당 프로젝트의 특정 버전에 대한 특정 일자의 봇별 대화량
    @Query(value = "select " +
            "new com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.BotDialogCountDto(d.botId, d.botName, " +
            "d.timeIndex, count(d)) " +
            "from Dialog d " +
            "where d.projectId=:projectId and d.createdDate=:date " +
            "group by d.botId, d.timeIndex")
    List<BotDialogCountDto> findBotDialogCount(@Param("projectId")String projectId,
                                               @Param("date") LocalDate date);


    // 해당 프로젝트에 대한 봇별 시나리오별 대화량
    @Query(value = "select " +
            "new com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.TargetCountDto(d.botId, d.botName, " +
            "d.scenarioId, d.scenarioName, d.timeIndex, count(d)) " +
            "from Dialog d " +
            "where d.projectId like :projectAllVersion and d.createdDate=:date " +
            "group by d.botId, d.scenarioId, d.timeIndex")
    List<TargetCountDto> findTotalScenarioDialogCount(@Param("projectAllVersion") String projectAllVersion,
                                                              @Param("date") LocalDate date);


    // 해당 프로젝트에 대한 봇별 시나리오별 대화량
    @Query(value = "select " +
            "new com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.TargetCountDto(d.botId, d.botName, " +
            "d.scenarioId, d.scenarioName, d.timeIndex, count(d)) " +
            "from Dialog d " +
            "where d.projectId=:projectId and d.createdDate=:date " +
            "group by d.botId, d.scenarioId, d.timeIndex")
    List<TargetCountDto> findScenarioDialogCount(@Param("projectId")String projectId,
                                                         @Param("date") LocalDate date);


    // 해당 프로젝트의 모든 버전에 대한 봇별 intent 활용 빈도
    @Query(value = "select " +
            "new com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.TargetCountDto(d.botId, d.botName, " +
            "d.intentId, d.intentName, d.timeIndex, count(d)) " +
            "from Dialog d " +
            "where d.projectId like :projectAllVersion and d.createdDate=:date " +
            "group by d.botId, d.intentId, d.timeIndex")
    List<TargetCountDto> findTotalIntentUsageCount(@Param("projectAllVersion") String projectAllVersion,
                                                   @Param("date") LocalDate date);



    // 해당 프로젝트에 포함된 봇의 intent 활용 빈도
    @Query(value = "select " +
            "new com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.TargetCountDto(d.botId, d.botName, " +
            "d.intentId, d.intentName, d.timeIndex, count(d)) " +
            "from Dialog d " +
            "where d.projectId=:projectId and d.createdDate=:date " +
            "group by d.botId, d.intentId, d.timeIndex")
    List<TargetCountDto> findIntentUsageCount(@Param("projectId") String projectId,
                                              @Param("date") LocalDate date);


    // 해당 프로젝트의 모든 버전에 대한 시나리오 별 Fallback 발생 빈도
    @Query(value = "select " +
            "new com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.FallbackCountDto(d.botId, d.botName, " +
            "d.scenarioId, d.scenarioName, d.statusCode, count(d)) " +
            "from Dialog d " +
            "where d.projectId like :projectAllVersion and d.createdDate=:date " +
            "group by d.scenarioId, d.statusCode" )
    List<FallbackCountDto> findTotalFallbackCount(@Param("projectAllVersion") String projectAllVersion,
                                                  @Param("date") LocalDate date);


    // 해당 프로젝트의 특정 버전에 대한 시나리오 별 Fallback 발생 빈도
    @Query(value = "select " +
            "new com.tmaxsoft.hyperchatbot.engine.statistic.resultdto.FallbackCountDto(d.botId, d.botName, " +
            "d.scenarioId, d.scenarioName, d.statusCode, count(d)) " +
            "from Dialog d " +
            "where d.projectId=:projectId and d.createdDate=:date " +
            "group by d.scenarioId, d.statusCode" )
    List<FallbackCountDto> findFallbackCount(@Param("projectId") String projectId,
                                             @Param("date") LocalDate date);

}