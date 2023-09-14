package org.example.app.shared.Helper.print;

import org.example.app.mrs.service.impl.BookService;
import org.junit.Test;


public class ObjectPrinterTest {

    @Test
    public void printModelTable() {
        BookService bookService = new BookService();
        ObjectPrinter.printModelTable(bookService.select(40));
    }

    @Test
    public void printModelsTable() {
        BookService bookService = new BookService();
        ObjectPrinter.printModelsTable(bookService.selectAll());
    }
}