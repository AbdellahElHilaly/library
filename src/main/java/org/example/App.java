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













/*


CREATE TRIGGER update_book_status
BEFORE INSERT ON borrow_book
FOR EACH ROW BEGIN DECLARE
today_date DATE;
SET today_date = CURDATE();
IF NEW.returnDate > today_date THEN UPDATE book SET status = 'LOST' WHERE book.id = NEW.book.id;
END IF; END;;

______________________________

if i want to delete this trigger : DROP TRIGGER update_book_status;

 */
