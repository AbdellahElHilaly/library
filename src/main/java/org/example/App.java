package org.example;


import org.example.app.model.BorrowBook;
import org.example.app.service.impl.BorrowBookService;
import org.example.app.service.impl.BorrowerService;
import org.example.dao.Helper.PrintHelper;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {

        BorrowBookService borrowBookService = new BorrowBookService();
    }

}
