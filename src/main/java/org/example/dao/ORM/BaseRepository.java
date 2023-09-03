package org.example.dao.ORM;

import org.example.dao.Helper.Factory;
import org.example.dao.Helper.PrintHelper;
import org.example.dao.Helper.DaoHelper;
import org.example.dao.utils.config.AppConfig;
import org.example.dao.utils.enums.AppMood;

import java.sql.SQLException;

public  class BaseRepository<T> extends RelationalRepository<T> {

    public BaseRepository(Class<T> modelClass) {
        super(modelClass);
        try {
            if(AppConfig.APP_MOOD.equals(AppMood.Development.name())){
                this.createTable();
                this.addColumns();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void createTable() throws SQLException {
        PrintHelper.printInfoMessage("Creating table " + tableName + "...................................");

        this.statement.execute(Factory.getSqlQueries().createEmptyTable(tableName));

        PrintHelper.printSuccessMessage("Table " + tableName + " created successfully");
    }

    public void addColumns() throws SQLException {
        String[][] fields = DaoHelper.getClassFields(modelClass);
        for (String[] field : fields) {
            PrintHelper.printInfoMessage("Adding column " + field[1] + " to table " + tableName + "...................................");
            this.statement.execute(DaoHelper.getAddColumnQuery(tableName, field[0], field[1]));
            PrintHelper.printSuccessMessage("Column " + field[1] + " added successfully");

            if (DaoHelper.isRelationalField(field[1])) {
                PrintHelper.printInfoMessage("Attaching table " + field[1] + " to table " + tableName + "...................................");
                this.attachingTables(field[1]);
                PrintHelper.printSuccessMessage("Table " + field[1] + " attached successfully");
            }
        }



        fields = null;

    }


}