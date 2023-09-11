package org.example.app.mrs.model.entity;

import org.example.dao.ORM.ModelMapper;
import org.example.app.shared.util.enums.BookStatus;

public class Book extends ModelMapper<Book>{
    private int id;
    private String author;
    private String title;
    private int shelfNumber;
    private String ISBN;
    private String status;

    public Book(String author, String title, String ISBN) {
        this.id = 0;
        this.author = author;
        this.title = title;
        this.ISBN = ISBN;
        this.status = BookStatus.AVAILABLE.toString();
    }

    public Book() {
    }

    public Book(int id, String author, String title, String isbn) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.ISBN = isbn;
    }

    public Book(int borrowerId, String author, String title, String isbn, String status) {
        this.id = borrowerId;
        this.author = author;
        this.title = title;
        this.ISBN = isbn;
        this.status = status;
    }

    @Override
    public Book createInstance() {
        return new Book();
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setShelfNumber(int shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setId(int bookId) {
        this.id = bookId;
    }

    public String getISBN() {
        return this.ISBN;
    }
}


