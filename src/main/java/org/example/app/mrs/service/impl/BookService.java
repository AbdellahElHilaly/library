package org.example.app.mrs.service.impl;

import org.example.app.mrs.model.entity.Book;
import org.example.app.mrs.service.CrudService;
import org.example.app.mrs.repository.BookRepository;

import java.sql.ResultSet;
import java.util.List;

public class BookService implements CrudService<Book> {
    private Book tempBook = new Book();
    BookRepository bookRepository = new BookRepository();


    ResultSet resultSet = null;

    @Override
    public Book save(Book book) {
        return book.mapData(bookRepository.save(book));
    }

    @Override
    public Book select(int id) {
        resultSet = bookRepository.find(id);
        if (resultSet == null){
            return null;
        }
        return tempBook.mapData(resultSet);
    }

    @Override
    public List<Book> selectAll() {
        return tempBook.mapDataList(bookRepository.findAll());
    }

    @Override
    public Book update(Book book, int id) {
        return book.mapData(bookRepository.update(book, id));
    }

    @Override
    public void delete(int id) {
        bookRepository.delete(id);
    }


    public Book findByISBN(String isbn) {
        if (tempBook == null) tempBook = new Book();
        else tempBook.initializeObject();
        return  tempBook.mapData(bookRepository.findBy("isbn", isbn));
    }


    public Book findAvailableBookByIsbn(String isbn) {
        if (tempBook == null) tempBook = new Book();
        else tempBook.initializeObject();
        return  tempBook.mapData(bookRepository.findAvailableBookByIsbn(isbn));
    }


    public Book updateByIsbn(Book tempBook) {
        return tempBook.mapData(bookRepository.updateWhere("isbn", tempBook.getISBN(), tempBook));
    }
}
