package org.example.app.mrs.service.impl;

import org.example.app.mrs.model.entity.Book;
import org.example.app.mrs.repository.LibraryRepository;
import org.example.app.mrs.service.CrudService;
import org.example.app.mrs.repository.BookRepository;

import java.util.List;

public class BookService implements CrudService<Book> {
    private Book tempBook = new Book();
    BookRepository bookRepository = new BookRepository();
    LibraryRepository libraryRepository = new LibraryRepository();

    @Override
    public Book save(Book book) {
        return book.mapData(bookRepository.save(book));
    }

    @Override
    public Book select(int id) {
        return tempBook.mapData(bookRepository.find(id));
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
        tempBook = tempBook.mapData(bookRepository.findBy("isbn", isbn));
        if (tempBook != null) {
            return tempBook;
        }
        return null;
    }
}
