package org.example.app.view.app_view;

import org.example.app.shared.Helper.Printer;

public class DrawLogo extends Printer {

    private static final String space = "    ";
    private static String[] A = {
            "  *   ",
            " * *  ",
            "*   * ",
            "***** ",
            "*   * ",
            "*   * ",
            "*   * "
    };
    private static String[] B = {
            "****  ",
            "*   * ",
            "*   * ",
            "****  ",
            "*   * ",
            "*   * ",
            "****  "
    };

    private static String[] C = {
            " **** ",
            "*    *",
            "*     ",
            "*     ",
            "*     ",
            "*    *",
            " **** "
    };

    private static String[] D = {
            "****  ",
            "*   * ",
            "*    *",
            "*    *",
            "*    *",
            "*   * ",
            "****  "
    };

    private static String[] E = {
            "***** ",
            "*     ",
            "*     ",
            "***** ",
            "*     ",
            "*     ",
            "***** "
    };

    private static String[] I = {
            "***** ",
            "  *   ",
            "  *   ",
            "  *   ",
            "  *   ",
            "  *   ",
            "***** "
    };

    private static String[] L = {
            "*     ",
            "*     ",
            "*     ",
            "*     ",
            "*     ",
            "*     ",
            "***** "
    };

    private static String[] O = {
            " ***  ",
            "*   * ",
            "*   * ",
            "*   * ",
            "*   * ",
            "*   * ",
            " ***  "
    };

    private static String[] R = {
            "****  ",
            "*   * ",
            "*   * ",
            "****  ",
            "* *   ",
            "*  *  ",
            "*   * "
    };

    private static final String[] U = {
            "*   * ",
            "*   * ",
            "*   * ",
            "*   * ",
            "*   * ",
            "*   * ",
            " ***  "
    };

    private static final String[] Y = {
            "*   * ",
            "*   * ",
            "*   * ",
            " ***  ",
            "  *   ",
            "  *   ",
            "  *   "
    };


    public static void start() {
        tempColor = "yellow";
        line();
        lineEnd();
        tempColor = "cyan";
        line();
        lineEnd();


        tempColor = "yellow";
        // print YOU CODE

        for (int i = 0; i < 7; i++) {
            print(Y[i] + space + O[i] + space + U[i] + space + C[i] + space + O[i] + space + D[i] + space + E[i]);
            endl(1);
        }


        endl(2);


        tempColor = "green";
        for (int i = 0; i < 7; i++) {
            print(L[i] + space + I[i] + space + B[i] + space + R[i] + space + A[i] + space + R[i] + space + Y[i]);
            endl(1);
        }
        tempColor = "cyan";
        line();
        lineEnd();
        tempColor = "yellow";
        line();
        lineEnd();

        endl(2);

    }
}













