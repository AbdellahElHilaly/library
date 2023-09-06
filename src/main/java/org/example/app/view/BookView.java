package org.example.app.view;

import org.example.app.controller.BookController;
import org.example.app.controller.BorrowBookController;
import org.example.app.controller.BorrowerController;
import org.example.app.mrs.model.entity.Book;
import org.example.app.mrs.model.entity.BorrowBook;
import org.example.app.mrs.model.entity.Borrower;
import org.example.app.shared.Helper.Printer;
import org.example.app.shared.Helper.ViewHelper;
import org.example.app.shared.util.enums.BookStatus;

public class BookView {

    private  static Book tempBook = new Book();
    private  static Borrower tempBorrower = new Borrower();
    private  static BorrowBook tempBorrowBook = new BorrowBook();


    private static final BookController bookController = new BookController();
    private static final BorrowerController borrowerController = new BorrowerController();
    private static final BorrowBookController borrowBookController = new BorrowBookController();

    private static String tempQuantity;
    private static  int tempBorrowingDays;


    public static void addBook() {
        Printer.printClassList(bookController.addBooks(setBook() , tempQuantity));
    }

    private static Book setBook() {
        tempBook.initializeObject();

        Printer.set("Enter book isbn");
        tempBook.setISBN(ViewHelper.getChoice());

        Printer.set("Enter book title");
        tempBook.setTitle(ViewHelper.getChoice());

        Printer.set("Enter book author");
        tempBook.setAuthor(ViewHelper.getChoice());

        tempBook.setStatus(BookStatus.AVAILABLE.toString());


        Printer.set("Enter book quantity");
        tempQuantity = ViewHelper.getChoice();

        return tempBook;
    }

    public static void borrowBook() {

        if (tempBook == null) tempBook = new Book();
        else tempBook.initializeObject();

        if (tempBorrower == null) tempBorrower = new Borrower();
        else tempBorrower.initializeObject();


        Printer.set("Enter borrower cni");
        tempBorrower = borrowerController.findBorrowerByCni(ViewHelper.getChoice());

        if (tempBorrower == null) return;

        Printer.set("Enter book isbn");
        tempBook = bookController.findBookByIsbn(ViewHelper.getChoice());

        if (tempBook == null) return;

        Printer.set("How many days would you like to borrow this book? Max 30 days");
        tempBorrowingDays = Integer.parseInt(ViewHelper.getChoice());


        tempBorrowBook = borrowBookController.addBorrowBook(tempBook , tempBorrower, tempBorrowingDays);

        Printer.printClass(tempBook);
        Printer.printClass(tempBorrower);
        Printer.printClass(tempBorrowBook);

    }

    public static void listAllBooks() {
        Printer.printClassList(bookController.findAllBooks());
    }


}
