package org.example.app.service.impl;

import org.example.app.model.Book;
import org.example.app.repository.BookRepository;
import org.example.app.repository.LibraryRepository;
import org.example.app.service.CrudService;

import java.sql.SQLException;
import java.util.List;

public class BookService implements CrudService<Book> {
    private final Book book = new Book();
    BookRepository bookRepository = new BookRepository();
    LibraryRepository libraryRepository = new LibraryRepository();

    @Override
    public Book save(Book book) {
         book.mapData(bookRepository.save(book));
        libraryRepository.updateTotalBooks(1);
        return null;

    }

    @Override
    public Book select(int id){
        return book.mapData(bookRepository.find(id));
    }

    @Override
    public List<Book> selectAll() {
        return book.mapDataList(bookRepository.findAll());
    }

    @Override
    public Book update(Book book, int id){
        return book.mapData(bookRepository.update(book, id));
    }

    @Override
    public void delete(int id) {
        bookRepository.delete(id);
    }


}
