package org.example.app.view;

import org.example.app.controller.BookController;
import org.example.app.controller.BorrowBookController;
import org.example.app.controller.BorrowerController;
import org.example.app.mrs.model.dto.BorrowerBooksDto;
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
    private static String choice;
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
        choice = ViewHelper.getChoice();
        BorrowerBooksDto borrowerBooksDto = borrowBookController.findBorrowedBooksByBorrowerCni(choice);

        if (borrowerBooksDto == null) return;
        tempBorrower = borrowerController.findBorrowerByCni(choice);

        borrowerBooksDto.getBorrower().setId(tempBorrower.getId());
        borrowerBooksDto.show();





        Printer.set("Enter book isbn");
        tempBook = bookController.findAvailableBookByIsbn(ViewHelper.getChoice());



        if (tempBook == null) return;

        Printer.set("How many days would you like to borrow this book? Max 30 days");
        tempBorrowingDays = Integer.parseInt(ViewHelper.getChoice());

        tempBorrowBook = borrowBookController.addBorrowBook(tempBook , tempBorrower, tempBorrowingDays);

        if (tempBorrowBook == null) return;
        borrowerBooksDto = borrowBookController.findBorrowedBooksByBorrowerCni(tempBorrower.getCni());
        borrowerBooksDto.show();

    }

    public static void listAllBooks() {
        Printer.printClassList(bookController.findAllBooks());
    }


}
