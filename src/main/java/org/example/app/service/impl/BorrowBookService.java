package org.example.app.service.impl;

import org.example.app.model.BorrowBook;
import org.example.app.repository.BorrowBookRepository;
import org.example.app.service.CrudService;

import java.sql.SQLException;
import java.util.List;

public class BorrowBookService implements CrudService<BorrowBook> {
    private final BorrowBook borrower = new BorrowBook();
    private final BorrowBookRepository borrowerRepository = new BorrowBookRepository();

    @Override
    public BorrowBook save(BorrowBook borrowBook) throws SQLException {
        return null;
    }

    @Override
    public BorrowBook select(int id) throws SQLException {
        return null;
    }

    @Override
    public List<BorrowBook> selectAll() throws SQLException {
        return null;
    }

    @Override
    public BorrowBook update(BorrowBook borrowBook, int id) throws SQLException {
        return null;
    }

    @Override
    public void delete(int id) throws SQLException {

    }
}