package org.example.app.repository;

import org.example.app.model.BookStatistic;
import org.example.dao.ORM.BaseRepository;

public class BookStatisticRepository extends BaseRepository<BookStatistic> {
    public BookStatisticRepository() {
        super(BookStatistic.class);
    }
}
