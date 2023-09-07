package org.example.app.mrs.model.dto;

import org.example.app.mrs.model.entity.Book;
import org.example.dao.ORM.ModelMapper;

import java.math.BigDecimal;

public class StatisticsDto  extends  ModelMapper<StatisticsDto>{
    private long QuantityTotal;
    private BigDecimal QuantityBorrowed;
    private BigDecimal QuantityAvailable;

    private  BigDecimal QuantityLost;

    @Override
    public StatisticsDto createInstance() {
        return new StatisticsDto();
    }




}
