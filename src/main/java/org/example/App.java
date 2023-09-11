package org.example;


import org.example.app.backup.StatisticsBackup;
import org.example.app.view.app_view.Authentication;
import org.example.app.view.app_view.DrawLogo;
import org.example.app.view.app_view.Initialize;
import org.example.app.view.app_view.Menu;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {


        DrawLogo.start();

//        Initialize.start();

//        Authentication.start();

        Menu.start();

    }



}











