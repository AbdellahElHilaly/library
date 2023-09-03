package org.example;


import org.example.app.model.Library;
import org.example.app.service.impl.LibraryService;
import org.example.app.view.DrawLogo;
import org.example.app.view.Initialize;
import org.example.dao.Helper.PrintHelper;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {

        DrawLogo.go();
        Initialize.go();




    }


}
