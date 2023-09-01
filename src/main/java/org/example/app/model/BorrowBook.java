package org.example.app.model;

import org.example.app.Helper.AppHelper;

import java.util.Date;

public class BorrowBook {
    private int id;
    private int Book_id;
    private int Borrower_id;
    private Date startDate;
    private Date returnDate;

    public BorrowBook() {
    }

    public BorrowBook(int book_id, int borrower_id, String returnDate) {
        this.id = 0;
        this.Book_id = book_id;
        this.Borrower_id = borrower_id;
        this.startDate = new Date();
        this.returnDate = AppHelper.stringToDate(returnDate);
    }
}
