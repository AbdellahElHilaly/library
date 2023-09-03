package org.example.app.mrs.service.impl;

import org.example.app.mrs.model.Book;
import org.example.app.mrs.repository.LibraryRepository;
import org.example.app.mrs.service.CrudService;
import org.example.app.mrs.repository.BookRepository;

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
