package org.example.app.view;


import org.example.app.shared.Helper.Printer;
import org.example.app.shared.Helper.ViewHelper;


public class Menu {

    private static String choice;

    public static void start() {
        Printer.info("welcome to the menu app please enter your choice, (help) for help");
        while (true){
            handleChoice();
        }
    }

    public static void handleChoice() {
        choice = ViewHelper.getChoice();

        switch (choice) {
            case "a br":
                BorrowerView.addBorrower();
                break;
            case "a bk":
                BookView.addBook();
                break;
            case "b bk":
                BookView.borrowBook();
                break;
            case "l a br":
                BorrowerView.listAllBorrowers();
                break;
            case "l a bk":
                BookView.listAllBooks();
                break;
            default:
                Printer.warning("invalid choice");
                break;
        }


    }


    public static void showMenu() {

        Printer.info("Available commands:");
        Printer.printKeyVal("help", "Show all available commands");
        Printer.printKeyVal("exit", "Exit from the program");
        Printer.printKeyVal("clear", "Clear screen");

        Printer.printKeyVal("a br", "Add new borrower");
        Printer.printKeyVal("a bk", "Add new book");

        Printer.printKeyVal("b bk", "Borrow book");

        Printer.printKeyVal("l a br", "List all users");
        Printer.printKeyVal("l a bk", "List all books");

        Printer.printKeyVal("f br", "Find user by identity");
        Printer.printKeyVal("f bk", "Find book by ISBN");

        Printer.printKeyVal("d br", "Remove user by identity");
        Printer.printKeyVal("d bk", "Remove book by id");

    }







}
