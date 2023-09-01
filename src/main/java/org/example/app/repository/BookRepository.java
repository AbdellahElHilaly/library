package org.example.app.repository;

import org.example.app.model.Book;
import org.example.dao.ORM.BaseRepository;

public class BookRepository extends BaseRepository<Book> {
    public BookRepository() {
        super(Book.class);
    }
}
