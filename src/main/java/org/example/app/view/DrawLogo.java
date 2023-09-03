package org.example.app.view;

import org.example.app.Helper.Printer;

public class DrawLogo extends Printer {


    private static String[] L = {
            "  _     ",
            " | |    ",
            " | |    ",
            " | |___ ",
            " |_____|",
    };

    private static String[] I = {
            "  ___ ",
            " |_ _|",
            "  | | ",
            "  | | ",
            " |___|",
    };

    private static String[] B = {
            " ____ ",
            "|    \\",
            "|____/",
            "|    \\",
            "|____/",
    };

    private static String[] R = {
            " ____ ",
            "|    \\",
            "|____/",
            "|  \\  ",
            "|   \\ ",
    };

    private static String[] A = {
            "  ___  ",
            " / _ \\ ",
            "/ /_\\ \\",
            "|  _  |",
            "|_| |_|",
    };

    private  static   String[] Y = {

    };





    public static void go() {
        tempColor = "yellow";
        line();lineEnd();
        tempColor = "cyan";
        line();lineEnd();

        tempColor = "green";
        for (int i = 0; i < 5; i++) {
            print(L[i] + " " + I[i] + " " + B[i] + " " + R[i] + " " + A[i] + " " + R[i] + " " + I[i]);
            System.out.println();
        }
        tempColor = "cyan";
        line();lineEnd();
        tempColor = "yellow";
        line();lineEnd();

    }
}













