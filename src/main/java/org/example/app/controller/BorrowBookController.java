package org.example.app.controller;

import org.example.app.mrs.model.entity.Book;
import org.example.app.mrs.model.entity.BorrowBook;
import org.example.app.mrs.model.entity.Borrower;
import org.example.app.mrs.service.impl.BorrowBookService;
import org.example.app.shared.Helper.LogicHelper;

import java.util.Date;

public class BorrowBookController {

    private  final  BorrowBook tempBorrowBook = new BorrowBook();
    private  final BorrowBookService borrowBookService = new BorrowBookService();

    public BorrowBook addBorrowBook(Book book, Borrower borrower, int borrowingDays) {
        tempBorrowBook.initializeObject();

        tempBorrowBook.setBook_id(book.getId());
        tempBorrowBook.setBorrower_id(borrower.getId());
        tempBorrowBook.setReturnDate(LogicHelper.generateReturnDate(borrowingDays));
        tempBorrowBook.setStartDate(new Date());

        return  borrowBookService.addBorrowBook(tempBorrowBook);


    }
}
