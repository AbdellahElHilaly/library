package org.example.app.mrs.model.dto;

import org.example.app.mrs.model.entity.Book;
import org.example.app.mrs.model.entity.Borrower;
import org.example.app.shared.Helper.Printer;

import java.util.Date;
import java.util.List;

public class BorrowerBookDto {

    private Book book;
    private Borrower borrower;

    private Date startDate;
    private Date returnDate;

    public void printDto(){
        Printer.info("Borrower");
        Printer.printClass(this.borrower);
        Printer.info("Book");
        Printer.printClass(this.book);
        Printer.printKeyVal("Start Date" , String.valueOf(this.startDate));
        Printer.printKeyVal("Return Date" , String.valueOf(this.startDate));




    }


}
