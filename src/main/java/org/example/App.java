package org.example;


import org.example.app.shared.Helper.Printer;
import org.example.app.view.DrawLogo;
import org.example.app.view.Menu;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {

        DrawLogo.start();

//        Initialize.start();

//        Authentication.start();

        Menu.start();

    }



}











