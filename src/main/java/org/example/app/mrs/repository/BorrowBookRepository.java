package org.example.app.mrs.repository;

import org.example.app.mrs.model.entity.BorrowBook;
import org.example.dao.ORM.BaseRepository;

public class BorrowBookRepository extends BaseRepository<BorrowBook> {
    public BorrowBookRepository() {
        super(BorrowBook.class);
    }
}
