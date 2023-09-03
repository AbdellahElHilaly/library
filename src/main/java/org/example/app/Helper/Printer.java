package org.example.app.Helper;

import java.util.Map;

public class Printer {
    protected String message;
    protected static String tempColor;
    protected static String tempEmoji;
    protected static String tempStatus;
    protected final static String line = "----------------------------------------";
    protected static final Map<String, String> colorsCode = Map.of(
            "red", "\033[1;31m",
            "green", "\033[1;32m",
            "yellow", "\033[1;33m",
            "blue", "\033[1;34m",
            "purple", "\033[1;35m",
            "cyan", "\033[1;36m",
            "white", "\033[1;37m",
            "reset", "\033[0m"
    );

    protected static final Map<String, String> emoji = Map.of(
            "info", "\uD83D\uDCAC",
            "warning", "\u26A0\uFE0F",
            "error", "\u274C",
            "success", "\u2705"
    );

    public static void info(String message) {

        tempColor = "blue";
        tempEmoji = "info";
        tempStatus = "info";

        showMassage(message, tempStatus);
    }


    public static void warning(String message) {
        tempColor = "yellow";
        tempEmoji = "warning";
        tempStatus = "warning";

        showMassage(message, tempStatus);

    }

    public static void error(String message) {
        tempColor = "red";
        tempEmoji = "error";
        tempStatus = "error";

        showMassage(message, tempStatus);
    }

    public static void success(String message) {
        tempColor = "green";
        tempEmoji = "success";
        tempStatus = "success";

        showMassage(message, tempStatus);
    }


    private static void showMassage(String message, String status) {
        line();
        print(emoji.get(tempEmoji));
        print(status);
        print(emoji.get(tempEmoji));
        lineEnd();
        print("  " + message);
        System.out.println();
    }

    public static void set(String message) {
        tempColor = "reset";
        print(message + ": ");
        endl();

    }


    protected static void line() {
        System.out.print(colorsCode.get(tempColor) + line + colorsCode.get("reset"));
    }

    protected static void lineEnd() {
        System.out.println(colorsCode.get(tempColor) + line + colorsCode.get("reset"));
    }

    protected static void print(String message) {
        System.out.print(colorsCode.get(tempColor) + " " + message + " " + colorsCode.get("reset"));
    }


    protected static void endl() {
        System.out.println();
    }
}
