package org.example.app.view.data_view;

import org.example.app.controller.BookController;
import org.example.app.controller.BorrowBookController;
import org.example.app.controller.BorrowerController;
import org.example.app.controller.StatisticController;
import org.example.app.mrs.model.dto.BorrowerBooksDto;
import org.example.app.mrs.model.entity.Book;
import org.example.app.mrs.model.entity.BorrowBook;
import org.example.app.mrs.model.entity.Borrower;
import org.example.app.shared.Helper.Printer;
import org.example.app.shared.Helper.ViewHelper;
import org.example.app.shared.util.enums.BookStatus;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.example.app.shared.Helper.ViewHelper.handelChoice;

public class BookView {

    private static Book tempBook = new Book();
    private static Borrower tempBorrower = new Borrower();
    private static BorrowBook tempBorrowBook = new BorrowBook();
    private static BorrowerBooksDto borrowerBooksDto = new BorrowerBooksDto();


    private static final BookController bookController = new BookController();
    private static final BorrowerController borrowerController = new BorrowerController();
    private static final BorrowBookController borrowBookController = new BorrowBookController();

    private static String tempQuantity;
    private static int tempBorrowingDays;



    public static void addBook() {
        Printer.set("Enter book quantity");

        if (!handelChoice()) return;
        tempQuantity = ViewHelper.choice;

        Printer.printClassList(bookController.addBooks(setBook(), tempQuantity));
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

        return tempBook;
    }

    public static void listAllBooks() {
        Printer.printClassList(bookController.findAllBooks());
    }

    public static void borrowBook() {

        reset();

        Printer.set("Enter borrower cni");

        if(!handelChoice()) return;

        borrowerBooksDto = borrowBookController.findBorrowedBooksByBorrowerCni(ViewHelper.choice);

        if (borrowerBooksDto == null) return;

        tempBorrower = borrowerController.findBorrowerByCni(ViewHelper.choice);

        borrowerBooksDto.getBorrower().setId(tempBorrower.getId());



        while (true) {
            Printer.set("Enter book isbn");
            if(!handelChoice()) return;

            tempBook = bookController.findAvailableBookByIsbn(ViewHelper.choice);
            if (tempBook == null) Printer.warning("this book not exist, or not available try again");
            else break;
        }


        Printer.set("How many days would you like to borrow this book? Max 30 days");
        if(!handelChoice()) return;
        tempBorrowingDays = Integer.parseInt(ViewHelper.choice);

        tempBorrowBook = borrowBookController.addBorrowBook(tempBook, tempBorrower, tempBorrowingDays);

        if (tempBorrowBook == null){
            Printer.error("Unknown Error while borrowing book"); return;
        }

        borrowerBooksDto = borrowBookController.findBorrowedBooksByBorrowerCni(tempBorrower.getCni());

    }



    public static void returnBook() {

        reset();

        Printer.set("Enter borrower cni");

        if(!handelChoice()) return;

        borrowerBooksDto = borrowBookController.findBorrowedBooksByBorrowerCni(ViewHelper.choice);

        if (borrowerBooksDto == null) return;

        tempBorrower = borrowerController.findBorrowerByCni(ViewHelper.choice);

        borrowerBooksDto.getBorrower().setId(tempBorrower.getId());



        while (true) {
            Printer.set("Enter book id");
            if(!handelChoice()) return;
            if (checkifBookExist(ViewHelper.choice)) break;
        }

        tempBook = bookController.findBookById(Integer.parseInt(ViewHelper.choice));
        tempBook.setStatus(BookStatus.AVAILABLE.toString());

        borrowBookController.returnBorrowBook(tempBook, borrowerBooksDto.getId());


    }

    private static boolean checkifBookExist(String choice) {
        AtomicBoolean result = new AtomicBoolean(false);
        borrowerBooksDto.getBooks().forEach(book -> {
            if (book.getId() == Integer.parseInt(choice)) {
                result.set(true);
            }
        });
        if (!result.get()) Printer.warning("this book not borrowed by this borrower, try again");
        return result.get();
    }




    public static void reset(){
        if (tempBook == null) tempBook = new Book();
        else tempBook.initializeObject();

        if (tempBorrower == null) tempBorrower = new Borrower();
        else tempBorrower.initializeObject();

        if (tempBorrowBook == null) tempBorrowBook = new BorrowBook();
        else tempBorrowBook.initializeObject();

        if (borrowerBooksDto == null) borrowerBooksDto = new BorrowerBooksDto();
        else borrowerBooksDto.initializeObject();

        tempQuantity = null;
        ViewHelper.choice = null;
        tempBorrowingDays = 0;

    }


    public static void updateBook() {
        reset();

        Printer.set("Enter book isbn");

        if(!handelChoice()) return;

        tempBook = bookController.findBookByIsbn(ViewHelper.choice);

        if (tempBook == null) return;

        Printer.set("Enter book title");
        tempBook.setTitle(ViewHelper.getChoice());

        Printer.set("Enter book author");
        tempBook.setAuthor(ViewHelper.getChoice());

        Printer.set("Enter book status");
        tempBook.setStatus(ViewHelper.getChoice());

        Printer.set("Enter book shelf number");
        tempBook.setShelfNumber(Integer.parseInt(ViewHelper.getChoice()));

        Printer.printClass(bookController.updateBooksByIsbn(tempBook));

    }
}
