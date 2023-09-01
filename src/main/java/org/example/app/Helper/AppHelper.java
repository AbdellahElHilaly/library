package org.example.app.Helper;

import org.example.dao.Helper.PrintHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppHelper {
    private static final  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public static String dateToString(Date date){
        return formatter.format(date);
    }

    public static Date stringToDate(String date) {
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            PrintHelper.printInfoMessage("use dd/MM/yyyy format");
            throw new RuntimeException(e);
        }
    }

}
