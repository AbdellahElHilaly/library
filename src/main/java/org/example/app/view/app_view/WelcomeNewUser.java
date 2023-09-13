package org.example.app.view.app_view;

import org.example.app.shared.Helper.print.Printer;
import org.example.app.shared.Helper.ViewHelper;
import org.example.app.controller.LibraryController;
import org.example.app.mrs.model.entity.Library;

public class WelcomeNewUser {


    private static String choice;
    private static final Library library = new Library();

    public static void start() {
        if (!LibraryController.isInitialized()) initializeApp();
    }

    private static void initializeApp() {
        Printer.info("welcome to the library app");
        drawMenu();
        handleChoice();
    }

    private static void drawMenu() {
        Printer.info("welcome to the library app");
        System.out.println("(init) :  start initialization" + "\n(exit) :  exit the app" + "\n(clear):  clear the console");
    }

    private static void handleChoice() {
        choice = ViewHelper.getChoice();

        if (choice.equals("init")) {
            setData();
        } else if (choice.equals("exit")) {
            Printer.info("good bye");
            System.exit(0);
        } else if (choice.equals("clear")) {
            ViewHelper.clearScreen();
            drawMenu();
            handleChoice();
        } else {
            Printer.error("wrong input");
            drawMenu();
            handleChoice();
        }

    }

    private static void setData() {

        Printer.set("enter your name");
        library.setOuner(ViewHelper.getChoice());

        Printer.set("enter your library name");
        library.setName(ViewHelper.getChoice());

        Printer.set("enter your library capacity");
        library.setCapacity(Integer.parseInt(ViewHelper.getChoice()));

        Printer.set("enter your library address");
        library.setAddress(ViewHelper.getChoice());


        library.setPassword(setPawword());

        LibraryController.initialize(library);


    }

    private static String setPawword() {
        Printer.set("enter your new password");
        String password1 = ViewHelper.getChoice();

        Printer.set("confirm your password");
        String password2 = ViewHelper.getChoice();

        if (password1.equals(password2)) {
            return password1;
        } else {
            Printer.error("passwords are not match");
            return setPawword();
        }


    }

}


