package org.example.app.mrs.service.impl;

import org.example.app.mrs.model.entity.StatisticsEvolution;
import org.example.app.mrs.repository.StatisticsEvolutionRepository;
import org.example.app.mrs.service.CrudService;

import java.util.List;

public class StatisticsEvolutionService implements CrudService<StatisticsEvolution> {
    StatisticsEvolutionRepository statisticsEvolutionRepository = new StatisticsEvolutionRepository();
    StatisticsEvolution statisticsEvolution = new StatisticsEvolution();

    @Override
    public StatisticsEvolution save(StatisticsEvolution statisticsEvolution) {

        this.statisticsEvolution = selectForToday();

        if(this.statisticsEvolution == null) {
            return statisticsEvolution.mapData(statisticsEvolutionRepository.save(statisticsEvolution));
        }

        else if (!statisticsEvolution.checkIfAlreadyExist(this.statisticsEvolution.getDate())) {
            return statisticsEvolution.mapData(statisticsEvolutionRepository.save(statisticsEvolution));
        }
        else return null;
    }

    public StatisticsEvolution selectForToday() {
        return this.statisticsEvolution.mapData(statisticsEvolutionRepository.findToday());
    }


    @Override
    public StatisticsEvolution select(int id) {
        return null;
    }

    @Override
    public List<StatisticsEvolution> selectAll() {
        return statisticsEvolution.mapDataList(statisticsEvolutionRepository.findAll());
    }

    @Override
    public StatisticsEvolution update(StatisticsEvolution statisticsEvolution, int id) {
        return statisticsEvolution.mapData(statisticsEvolutionRepository.update(statisticsEvolution, id));
    }

    @Override
    public void delete(int id) {

    }
}
