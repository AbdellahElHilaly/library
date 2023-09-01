package org.example.app.repository;

import org.example.app.model.BorrowBook;
import org.example.dao.ORM.BaseRepository;

public class BorrowBookRepository extends BaseRepository<BorrowBook> {
    public BorrowBookRepository() {
        super(BorrowBook.class);
    }
}
