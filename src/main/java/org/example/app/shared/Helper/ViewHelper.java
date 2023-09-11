package org.example.app.shared.Helper;

import org.example.app.view.app_view.Menu;

import java.util.Scanner;

public class ViewHelper {
    private static final Scanner scanner = new Scanner(System.in);
    public static String choice;

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String getChoice() {


        while (true) {
            System.out.print(">> ");
            choice = scanner.nextLine();

            if (choice.equals("exit")) {
                Printer.info("Goodbye!");
                System.exit(0);
            } else if (choice.equals("clear")) {
                clearScreen();
                System.out.println("Screen has been cleared.");
            } else if (choice.equals("help")) {
                Menu.showMenu();
            } else {
                return choice;
            }
        }
    }


    public static boolean  handelChoice(){
        choice = ViewHelper.getChoice();
        if (choice.equals("stop")) {
            Printer.success("Stopping Operation");
            return false;
        }
        return true;
    }




}
