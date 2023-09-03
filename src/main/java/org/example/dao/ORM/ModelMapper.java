package org.example.dao.ORM;

import org.example.dao.Helper.DaoHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ModelMapper<T> {

    private T instance;
    private final List<T> dataList = new ArrayList<>();

    public T mapData(ResultSet resultSet) {

        try {
            instance = createInstance();

            ResultSetMetaData rsmd = null;

            rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            for (int i = 1; i <= columnsNumber; i++) {
                String columnName = rsmd.getColumnName(i);
                Object columnValue = resultSet.getObject(i);

                DaoHelper.setFieldByName(instance, columnName, columnValue); //pass instance by reference
            }
            rsmd = null;

            return instance;


        } catch (SQLException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    public List<T> mapDataList(ResultSet resultSet)  {
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            instance = createInstance();
            instance = mapData(resultSet);
            this.dataList.add(instance);
        }
        return this.dataList;
    }

    public abstract T createInstance();





}
