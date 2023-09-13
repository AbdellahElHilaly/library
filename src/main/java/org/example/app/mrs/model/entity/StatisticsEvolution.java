package org.example.app.mrs.model.entity;

import org.example.app.mrs.model.dto.StatisticsDto;
import org.example.app.shared.Helper.LogicHelper;
import org.example.dao.ORM.ModelMapper;

import java.util.Date;
import java.util.Objects;


public class StatisticsEvolution extends ModelMapper<StatisticsEvolution> {
    private  int id;
    private int QuantityTotal;
    private int QuantityBorrowed;
    private int QuantityAvailable;
    private  int QuantityLost;
    private String date;



    public void setTodayDayStatistic(StatisticsDto statisticsDto) {
        this.QuantityTotal = (int) statisticsDto.getQuantityTotal();
        this.QuantityBorrowed = (int) statisticsDto.getQuantityBorrowed();
        this.QuantityAvailable = (int) statisticsDto.getQuantityAvailable();
        this.QuantityLost = (int) statisticsDto.getQuantityLost();
        this.date = LogicHelper.dateToString(new Date());

    }


    public  boolean checkIfAlreadyExist(String date) {
        return Objects.equals(this.date, date);
    }

    @Override
    public StatisticsEvolution createInstance() {
        return new StatisticsEvolution();
    }

    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public int getQuantityTotal() {
        return QuantityTotal;
    }

    public int getQuantityBorrowed() {
        return QuantityBorrowed;
    }

    public int getQuantityAvailable() {
        return QuantityAvailable;
    }

    public int getQuantityLost() {
        return QuantityLost;
    }
}
