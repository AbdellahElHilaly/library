package org.example.app.service;

import java.sql.SQLException;
import java.util.List;

public interface CrudService<T> {

    T save(T t) throws SQLException;

    T select(int id) throws SQLException;

    List<T> selectAll() throws SQLException;

    T update(T t, int id) throws SQLException;

    void delete(int id) throws SQLException;

}
