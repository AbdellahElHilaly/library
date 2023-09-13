package org.example.app.controller;

import org.example.app.mrs.model.dto.StatisticsDto;
import org.example.app.mrs.model.entity.StatisticsEvolution;
import org.example.app.mrs.service.impl.StatisticService;
import org.example.app.mrs.service.impl.StatisticsEvolutionService;
import org.example.app.shared.Helper.print.Printer;

public class StatisticInitializerController {

    StatisticService statisticService = new StatisticService();
    StatisticsEvolutionService statisticsEvolutionService = new StatisticsEvolutionService();
    StatisticsEvolution statisticsEvolution = new StatisticsEvolution();
    StatisticsDto statisticsDto = new StatisticsDto();

    public void initialize() {
        statisticsDto = statisticService.getTotalStatistics();
        statisticsEvolution.setTodayDayStatistic(statisticsDto);
        if (statisticsEvolutionService.save(statisticsEvolution) != null) {

            Printer.success("Statistics evolution initialized successfully");

        }
    }

}
