package org.example.app.model;

import org.example.dao.ORM.ModelMapper;

public class BookStatistic extends ModelMapper<BookStatistic> {
    private  int id;
    private String SBN;
    private int quantity;
    private int totalAvailable;
    private int totalBorrowed;
    private int totalLost;

    public BookStatistic() {
    }

    @Override
    public BookStatistic createInstance() {
        return new BookStatistic();
    }
}
