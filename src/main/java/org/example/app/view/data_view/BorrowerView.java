package org.example.app.view.data_view;

import org.example.app.controller.BorrowerController;
import org.example.app.mrs.model.entity.Borrower;
import org.example.app.shared.Helper.print.ObjectPrinter;
import org.example.app.shared.Helper.print.Printer;
import org.example.app.shared.Helper.ViewHelper;

public class BorrowerView {

    private static final BorrowerController borrowerController = new BorrowerController();
    private static  Borrower tempBorrower = new Borrower();


    public static void addBorrower() {
        ObjectPrinter.printClass( borrowerController.addBorrower(setBorrower()));
    }

    private static Borrower setBorrower() {

        tempBorrower.initializeObject();
        Printer.set("Enter borrower cni");

        String tempCni = ViewHelper.getChoice();

        tempBorrower = borrowerController.findBorrowerByCni(tempCni);

        if (tempBorrower != null) return tempBorrower;

        tempBorrower = new Borrower();

        tempBorrower.setCni(tempCni); tempCni = null;

        Printer.set("Enter borrower name");
        tempBorrower.setName(ViewHelper.getChoice());

        Printer.set("Enter borrower phone");
        tempBorrower.setPhone(ViewHelper.getChoice());

        Printer.set("Enter borrower mail");
        tempBorrower.setMail(ViewHelper.getChoice());



        return tempBorrower;
    }


    public static void listAllBorrowers() {
        ObjectPrinter.printClassList(borrowerController.findAllBorrowers());
    }
}



