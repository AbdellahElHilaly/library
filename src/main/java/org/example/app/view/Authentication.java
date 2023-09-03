package org.example.app.view;

import org.example.app.mrs.model.Library;
import org.example.app.mrs.service.impl.LibraryService;
import org.example.app.shared.Helper.Printer;
import org.example.app.shared.Helper.ViewHelper;
import org.example.dao.Helper.PrintHelper;

public class Authentication {
    static LibraryService libraryService = new LibraryService();
    static Library library = libraryService.selectAll().get(0);
    private static String userName;
    private static String password;



    public static  void go() {
        Printer.info("welcome to " + library.getName() + "please enter your username and password");



        while (true){

            if (login()) {
                Printer.info("welcome " + library.getOuner());
            } else {
                Printer.error("wrong username or password");
                return;
            }

        }

    }


    private static boolean login() {
        Printer.set("enter your username");
        userName = ViewHelper.getChoice();

        Printer.set("enter your password");
        password = ViewHelper.getChoice();

        return userName.equals(library.getOuner()) && password.equals(library.getPassword());

    }

}
