package org.example.app.mrs.repository;

import org.example.app.mrs.model.Book;
import org.example.dao.ORM.BaseRepository;

public class BookRepository extends BaseRepository<Book> {
    public BookRepository() {
        super(Book.class);
    }
}
