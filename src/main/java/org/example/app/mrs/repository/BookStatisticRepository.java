package org.example.app.mrs.repository;

import org.example.app.mrs.model.BookStatistic;
import org.example.dao.ORM.BaseRepository;

public class BookStatisticRepository extends BaseRepository<BookStatistic> {
    public BookStatisticRepository() {
        super(BookStatistic.class);
    }
}
