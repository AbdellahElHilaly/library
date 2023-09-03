package org.example.app.mrs.service.impl;

import org.example.app.mrs.model.BookStatistic;
import org.example.app.mrs.repository.BookStatisticRepository;
import org.example.app.mrs.service.CrudService;

import java.util.List;

public class BookStatisticService implements CrudService<BookStatistic> {

    BookStatistic bookStatistic = new BookStatistic();
    BookStatisticRepository bookStatisticRepository = new BookStatisticRepository();


    @Override
    public BookStatistic save(BookStatistic bookStatistic) {
        return null;
    }

    @Override
    public BookStatistic select(int id) {
        return null;
    }

    @Override
    public List<BookStatistic> selectAll() {
        return null;
    }

    @Override
    public BookStatistic update(BookStatistic bookStatistic, int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
