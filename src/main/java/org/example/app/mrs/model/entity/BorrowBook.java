package org.example.app.mrs.model.entity;


import org.example.app.shared.Helper.LogicHelper;
import org.example.framwork.dao.ORM.ModelMapper;

import java.util.Date;

public class BorrowBook extends ModelMapper<BorrowBook> {
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
        this.returnDate = LogicHelper.stringToDate(returnDate);
    }

    public void setBook_id(int book_id) {
        Book_id = book_id;
    }

    public void setBorrower_id(int borrower_id) {
        Borrower_id = borrower_id;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public BorrowBook createInstance() {
        return new BorrowBook();
    }


}
