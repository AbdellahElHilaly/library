package org.example.dao.database.connection;

import org.example.dao.utils.config.AppConfig;
import org.example.dao.Helper.PrintHelper;
import org.example.dao.utils.config.DatabaseConfig;
import org.example.dao.utils.enums.AppMood;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection extends DatabaseConfig {
    private static java.sql.Connection connection;

    public static java.sql.Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            initializeConnection();
        }
        return connection;
    }

    private synchronized static void initializeConnection() throws SQLException {
        if(AppConfig.APP_MOOD.equals(AppMood.Development.name())) {
            PrintHelper.printInfoMessage("Connecting to "+ DATABASE_TYPE +" database (name : " + DATABASE_NAME + ") ...................................");
        }

        connection = DriverManager.getConnection("jdbc:"+DATABASE_TYPE+"://" + HOST + ":" + PORT + "/" + DATABASE_NAME, USERNAME, PASSWORD);

        if(AppConfig.APP_MOOD.equals(AppMood.Development.name())) {
            PrintHelper.printSuccessMessage("Connected to to "+ DATABASE_TYPE +" database (name : " + DATABASE_NAME + ") successfully");
        }
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
