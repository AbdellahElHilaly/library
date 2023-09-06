package org.example.app.shared.Helper;

import org.example.dao.Helper.PrintHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogicHelper {

    private  static  Date tempDate;
    private static final SimpleDateFormat inputFormatter = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
    private static final SimpleDateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");


    public static String dateToString(Date date) {
        return outputFormatter.format(date);
    }

    public static Date stringToDate(String date) {
        try {
            return inputFormatter.parse(date);
        } catch (ParseException e) {
            PrintHelper.printInfoMessage("Use this format: yyyy-MM-dd");
            throw new RuntimeException(e);
        }
    }


    public static Date generateReturnDate(int tempBorrowingDays) {
        tempDate = null;
        tempDate = new Date();
        tempDate.setTime(tempDate.getTime() + ((long) tempBorrowingDays * 24 * 60 * 60 * 1000));

        return (tempDate);
    }



}


