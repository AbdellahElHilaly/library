package org.example.entity;

import junit.framework.TestCase;
import org.example.app.mrs.model.entity.Book;
import org.example.app.mrs.service.impl.BookService;
import org.example.app.shared.Helper.Printer;

public class BookTest extends TestCase {

    public void testInsert() {
        BookService bookService = new BookService();


        // Author: J.K. Rowling
        Printer.printClass(bookService.save(new Book("J.K. Rowling", "Harry Potter and the Sorcerers Stone", "978-3-16-148410-5")));
        Printer.printClass(bookService.save(new Book("J.K. Rowling", "Harry Potter and the Chamber of Secrets", "978-3-16-148410-6")));
        Printer.printClass(bookService.save(new Book("J.K. Rowling", "Harry Potter and the Prisoner of Azkaban", "978-3-16-148410-7")));
        Printer.printClass(bookService.save(new Book("J.K. Rowling", "Harry Potter and the Goblet of Fire", "978-3-16-148410-8")));

        // Author: F. Scott Fitzgerald
        Printer.printClass(bookService.save(new Book("F. Scott Fitzgerald", "The Great Gatsby", "978-3-16-148410-9")));
        Printer.printClass(bookService.save(new Book("F. Scott Fitzgerald", "Tender Is the Night", "978-3-16-148410-10")));
        Printer.printClass(bookService.save(new Book("F. Scott Fitzgerald", "This Side of Paradise", "978-3-16-148410-11")));

        // ... Add more authors and books as needed

    }

    public  void testSelectAll(){
        BookService bookService = new BookService();
        bookService.selectAll().forEach(Printer::printClass);
    }


}
