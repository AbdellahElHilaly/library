package org.example.app.shared.Helper;

import java.util.Scanner;

public class ViewHelper {
    private static final Scanner scanner = new Scanner(System.in);
    private static String choice;

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
            } else {
                return choice;
            }
        }
    }


}
