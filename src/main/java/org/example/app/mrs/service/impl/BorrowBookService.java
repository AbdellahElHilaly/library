package org.example.app.mrs.service.impl;

import org.example.app.mrs.model.dto.BorrowerBooksDto;
import org.example.app.mrs.model.entity.Book;
import org.example.app.mrs.model.entity.BorrowBook;
import org.example.app.mrs.repository.BorrowBookRepository;
import org.example.app.mrs.service.CrudService;

import java.sql.ResultSet;
import java.util.List;

public class BorrowBookService implements CrudService<BorrowBook> {
    private final BorrowBook borrowBook = new BorrowBook();
    private ResultSet resultSet = null;
    private final BorrowerBooksDto borrowerBooksDto = new BorrowerBooksDto();

    private final BorrowBookRepository borrowerRepository = new BorrowBookRepository();


    @Override
    public BorrowBook save(BorrowBook borrowBook) {
        return null;
    }

    @Override
    public BorrowBook select(int id) {
        return null;
    }

    @Override
    public List<BorrowBook> selectAll() {
        return null;
    }

    @Override
    public BorrowBook update(BorrowBook borrowBook, int id) {
        return null;
    }

    @Override
    public void delete(int id) {
        borrowerRepository.delete(id);
    }

    public BorrowBook addBorrowBook(BorrowBook tempBorrowBook) {
        return borrowBook.mapData(borrowerRepository.save(tempBorrowBook));
    }

    public BorrowerBooksDto selectBooksBorrowed(String cni) {
         resultSet = borrowerRepository.selectBooksBorrowed(cni);
        if(resultSet == null) return null;
        return borrowerBooksDto.mapMultipleData(resultSet);
    }


}
