package org.example.dto;

import junit.framework.TestCase;
import org.example.app.mrs.model.dto.BorrowerBooksDto;

import org.example.app.mrs.service.impl.BorrowBookService;
import org.example.app.shared.Helper.Printer;

public class BorrowerBooksDtoTest extends TestCase {

    public void testSelectBooksBorrowed() {



        BorrowBookService borrowBookService = new BorrowBookService();

        BorrowerBooksDto borrowerBooksDto = borrowBookService.selectBooksBorrowed("123456789");



        borrowerBooksDto.show();

//        Printer.printClass(borrowerBooksDto.getBorrower());





    }
}
