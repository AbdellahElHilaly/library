package org.example;


import org.example.app.view.Authentication;
import org.example.app.view.DrawLogo;
import org.example.app.view.Initialize;

import java.net.Authenticator;
import java.sql.SQLException;


public class App {
    public static void main(String[] args) throws SQLException {

      DrawLogo.go();
      Initialize.go();
      Authentication.go();
    }



}
