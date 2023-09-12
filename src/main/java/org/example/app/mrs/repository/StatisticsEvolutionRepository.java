package org.example.app.mrs.repository;

import org.example.app.mrs.model.entity.StatisticsEvolution;
import org.example.app.shared.Helper.LogicHelper;
import org.example.dao.ORM.BaseRepository;

import java.sql.ResultSet;
import java.util.Date;

public class StatisticsEvolutionRepository extends BaseRepository<StatisticsEvolution> {
    public StatisticsEvolutionRepository(Class<StatisticsEvolution> modelClass) {
        super(modelClass);
    }

    public StatisticsEvolutionRepository() {
        super(StatisticsEvolution.class);
    }

    public ResultSet findByDate(String date) {
        return this.findBy("date", date);
    }
    public ResultSet findToday() {
        return this.findByDate(LogicHelper.dateToString(new Date()));
    }

}
