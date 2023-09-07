package org.example.app.mrs.model.dto;

import org.example.dao.ORM.ModelMapper;

import java.util.Date;

public class BookBorrowed extends  ModelMapper<BookBorrowed>{
    private int Book_id;
    private String author;
    private String title;
    private int shelfNumber;
    private String ISBN;
    private String status;
    private Date startDate;
    private Date returnDate;

        @Override
        public BookBorrowed createInstance() {
            return new BookBorrowed();
        }


    public int getId() {
        return Book_id;
    }
}
