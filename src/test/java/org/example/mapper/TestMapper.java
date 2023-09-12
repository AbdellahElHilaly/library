package org.example.mapper;

import junit.framework.TestCase;
import org.example.app.mrs.model.entity.Book;
import org.example.app.mrs.service.impl.BookService;

public class TestMapper extends TestCase {


    public  void testConvertToArrayHeader(){
        Book book = new Book();

        String[] header = book.toArrayHeader();

        for (String s : header) {
            System.out.println(s);
        }
    }

    public  void testConvertToArrayValue(){


        Book book = new Book();
        BookService bookService = new BookService();
        book = bookService.select(40);
        String[] values = book.toArrayValue();

        for (String s : values) {
            System.out.println(s);
        }
    }



}
