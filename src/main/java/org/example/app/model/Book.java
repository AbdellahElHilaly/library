package org.example.app.model;

import org.example.dao.ORM.ModelMapper;
import org.example.util.enums.BookStatus;

public class Book extends ModelMapper<Book>{
    int id;
    String author;
    String title;
    String ISBN;
    String status;

    public Book(String author, String title, String ISBN) {
        this.id = 0;
        this.author = author;
        this.title = title;
        this.ISBN = ISBN;
        this.status = String.valueOf(BookStatus.AVAILABLE);
    }

    public Book() {
    }

    @Override
    public Book createInstance() {
        return new Book();
    }
}
