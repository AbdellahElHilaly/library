package org.example.app.view.app_view;


import org.example.app.shared.Helper.print.Printer;
import org.example.app.shared.Helper.ViewHelper;
import org.example.app.view.data_view.BookView;
import org.example.app.view.data_view.BorrowerView;
import org.example.app.view.data_view.StatisticView;


public class Menu {

    private static String choice;

    public static void start() {
        Printer.info("welcome to the menu app please enter your choice, (help) for help");
        while (true) {
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
            case "u bk":
                BookView.updateBook();
                break;
            case "br bk":
                BookView.borrowBook();
                break;
            case "l a br":
                BorrowerView.listAllBorrowers();
                break;
            case "l a bk":
                BookView.listAllBooks();
                break;
            case "ch lb st":
                StatisticView.showLibrrayStatistic();
                break;
            case "ch bk st":
                StatisticView.showBookStatics();
                break;
            case "ch a st":
                StatisticView.showAllStatics();
                break;
            case "ch st ev":
                StatisticView.showAllStatisticsEvolution();
                break;
            case "bk a st":
                StatisticView.buckupAllStatistics();
                break;
            case "bk e st":
                StatisticView.buckupStatisticsEvolution();
                break;
            case "rt bk":
                BookView.returnBook();
                break;
            case "stop":
                Printer.info("You have stopped the current process");
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
        Printer.printKeyVal("stop", "Stop the Current process and go back to the main menu");

        Printer.printKeyVal("a br", "Add new borrower");
        Printer.printKeyVal("a bk", "Add new book");

        Printer.printKeyVal("br bk", "Borrow book");
        Printer.printKeyVal("rt bk", "Return book");

        Printer.printKeyVal("u bk", "update book by isbn");

        Printer.printKeyVal("l a br", "List all users");
        Printer.printKeyVal("l a bk", "List all books");

        Printer.printKeyVal("f br", "Find user by identity");
        Printer.printKeyVal("f bk", "Find book by ISBN");

        Printer.printKeyVal("d br", "Remove user by identity");
        Printer.printKeyVal("d bk", "Remove book by id");

        Printer.printKeyVal("ch lb st", "Show statistics about library");
        Printer.printKeyVal("ch bk st", "Show book statistics");
        Printer.printKeyVal("ch a st", "Show total books  statistics");
        Printer.printKeyVal("ch st ev", "Show statistics evolution");

        Printer.printKeyVal("bk a st", "Backup all statistics");
        Printer.printKeyVal("bk e st", "Backup statistics evolution");

    }


}
