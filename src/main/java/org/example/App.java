package org.example;



import org.example.app.view.app_view.Authentication;
import org.example.app.view.app_view.DrawLogo;
import org.example.app.view.app_view.WelcomeNewUser;
import org.example.app.view.app_view.Menu;
import org.example.app.view.data_view.PrepareApp;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {

        DrawLogo.start();

        WelcomeNewUser.start();

        Authentication.start();

        PrepareApp.start();

        Menu.start();

    }





}











