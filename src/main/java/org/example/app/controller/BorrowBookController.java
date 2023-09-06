package org.example.app.controller;

import org.example.app.mrs.model.dto.BorrowerBooksDto;
import org.example.app.mrs.model.entity.Book;
import org.example.app.mrs.model.entity.BorrowBook;
import org.example.app.mrs.model.entity.Borrower;
import org.example.app.mrs.service.impl.BorrowBookService;
import org.example.app.shared.Helper.LogicHelper;
import org.example.app.shared.Helper.Printer;

import java.util.Date;

public class BorrowBookController {

    private  final  BorrowBook tempBorrowBook = new BorrowBook();
    private BorrowerBooksDto tempBorrowerBooksDto = new BorrowerBooksDto();
    private  final BorrowBookService borrowBookService = new BorrowBookService();

    public BorrowBook addBorrowBook(Book book, Borrower borrower, int borrowingDays) {

        tempBorrowBook.initializeObject();

        tempBorrowBook.setBook_id(book.getId());
        tempBorrowBook.setBorrower_id(borrower.getId());
        tempBorrowBook.setReturnDate(LogicHelper.generateReturnDate(borrowingDays));
        tempBorrowBook.setStartDate(new Date());

        return  borrowBookService.addBorrowBook(tempBorrowBook);

    }

    public BorrowerBooksDto findBorrowedBooksByBorrowerCni(String cni) {
        tempBorrowerBooksDto =  borrowBookService.selectBooksBorrowed(cni);
        if (tempBorrowerBooksDto == null) {
            Printer.warning("No books borrowed by this borrower");
            return null;
        }
        return tempBorrowerBooksDto;
    }
}
