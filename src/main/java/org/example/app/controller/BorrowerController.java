package org.example.app.controller;

import org.example.app.mrs.model.entity.Borrower;
import org.example.app.mrs.service.impl.BorrowerService;
import org.example.framwork.console.print.Printer;

import java.util.List;

public class BorrowerController {

    private  static Borrower tempBorrower = new Borrower();
    private final BorrowerService borrowerService = new BorrowerService();

    public Borrower addBorrower(Borrower borrower) {

        return borrowerService.save(borrower);

    }

    public Borrower findBorrowerByCni(String cni) {
        tempBorrower = borrowerService.findByCni(cni);
        if (tempBorrower != null) {
            return tempBorrower;
        }
        Printer.warning("borrower not found");
        return null;
    }


    public List<Borrower> findAllBorrowers() {
        return borrowerService.selectAll();
    }
}
