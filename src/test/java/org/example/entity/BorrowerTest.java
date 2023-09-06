package org.example.entity;

import junit.framework.TestCase;
import org.example.app.mrs.model.entity.Borrower;
import org.example.app.mrs.service.impl.BorrowerService;
import org.example.app.shared.Helper.Printer;

public class BorrowerTest extends TestCase {

    public void testInsert() {
        BorrowerService borrowerService = new BorrowerService();

        Printer.printClass(borrowerService.save(new Borrower("John", "07988736", "john@example.com", "123456789")));
        Printer.printClass(borrowerService.save(new Borrower("Alice", "79839889", "alice@example.com", "987654321")));
        Printer.printClass(borrowerService.save(new Borrower("Bob", "62766288", "bob@example.com", "555555555")));
        Printer.printClass(borrowerService.save(new Borrower("Mike", "62766288", "Mike@example.com", "111111111")));

    }


    public  void testSelectAll(){
        BorrowerService borrowerService = new BorrowerService();
        Printer.printClassList(borrowerService.selectAll());
    }
}
