package org.example.app.mrs.model.dto;

import org.example.app.mrs.model.entity.Borrower;
import org.example.framwork.console.print.ObjectPrinter;
import org.example.framwork.dao.ORM.ModelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowerBooksDto  extends ModelMapper<BorrowerBooksDto> {
    private int id;
    private List<BookBorrowed> booksDto;
    private Borrower borrower = new Borrower();


    public BorrowerBooksDto mapMultipleData(ResultSet resultSet) {
        try {

            this.id = resultSet.getInt("id");
            this.borrower = new Borrower();
            this.borrower = this.borrower.mapData(resultSet);
            this.borrower.setId(resultSet.getInt("Borrower_id"));


            this.booksDto = new ArrayList<>();
            while (true) {
                BookBorrowed bookDto = new BookBorrowed();
                bookDto = bookDto.mapData(resultSet);
                this.booksDto.add(bookDto);
                if (!resultSet.next()) break;
            }


            return this;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }





    public void show() {
        ObjectPrinter.printClass(this.borrower);
        ObjectPrinter.printClassList(this.booksDto);
    }

    public Borrower getBorrower() {
        return this.borrower;
    }

    @Override
    public BorrowerBooksDto createInstance() {
        return new BorrowerBooksDto();
    }

    public List<BookBorrowed>  getBooks() {
        return this.booksDto;
    }

    public int getId() {
        return this.id;
    }
}