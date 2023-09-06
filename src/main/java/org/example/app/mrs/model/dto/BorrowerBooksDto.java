package org.example.app.mrs.model.dto;

import org.example.app.mrs.model.entity.Borrower;
import org.example.app.shared.Helper.Printer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowerBooksDto {
    private List<BookBorrowed> booksDto;
    private Borrower borrower = new Borrower();


    public BorrowerBooksDto mapMultipleData(ResultSet resultSet) {
        try {

            this.borrower = new Borrower();
            this.borrower = this.borrower.mapData(resultSet);
            this.borrower.setId(resultSet.getInt("Borrower_id"));


            this.booksDto = new ArrayList<>();
            while (resultSet.next()) {
                BookBorrowed bookDto = new BookBorrowed();
                bookDto = bookDto.mapData(resultSet);
                this.booksDto.add(bookDto);
            }


            return this;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }





    public void show() {
        Printer.printClass(this.borrower);
        Printer.printClassList(this.booksDto);
    }

    public Borrower getBorrower() {
        return this.borrower;
    }
}