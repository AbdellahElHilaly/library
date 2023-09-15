package org.example.app.controller;

import org.example.app.mrs.model.entity.Book;
import org.example.app.mrs.service.impl.BookService;
import org.example.framwork.console.print.ObjectPrinter;
import org.example.framwork.console.print.Printer;
import org.example.app.shared.Helper.ViewHelper;

import java.util.ArrayList;
import java.util.List;

public class BookController {
    private final BookService bookService = new BookService();
    private Book tempBook = new Book();
    private List<Book> tempBooks = new ArrayList<>();

    public Book addBook(Book book) {
        return bookService.save(book);
    }

    public List<Book> addBooks(Book book, String tempQuantity) {

        int quantity = Integer.parseInt(tempQuantity);
        for (int i = 0; i < quantity; i++) {

            Printer.set("Enter book shelf number for book " + (i + 1));
            book.setShelfNumber(Integer.parseInt(ViewHelper.getChoice()));

            tempBooks.add(this.addBook(book));

        }
        return tempBooks;
    }

    public Book findBookByIsbn(String isbn) {
        tempBook = bookService.findByISBN(isbn);
        if (tempBook != null) {
            return tempBook;
        }
        Printer.warning("book not found");
        return null;
    }

    public List<Book> findAllBooks() {
        return bookService.selectAll();
    }

    public Book findAvailableBookByIsbn(String isbn) {
        tempBook = bookService.findAvailableBookByIsbn(isbn);
        if (tempBook != null) {
            return tempBook;
        }
        Printer.warning("no available book found");
        return null;
    }

    public Book findBookById(int bookId) {
        tempBook = bookService.select(bookId);
        if (tempBook != null) {
            ObjectPrinter.printClass(tempBook);
            return tempBook;
        }

        return null;
    }

    public Book updateBooksByIsbn(Book tempBook) {
        return bookService.updateByIsbn(tempBook);
    }
}
