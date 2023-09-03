package org.example.app.mrs.service;

import java.sql.SQLException;
import java.util.List;

public interface CrudService<T> {

    T save(T t) ;

    T select(int id);

    List<T> selectAll() ;

    T update(T t, int id) ;

    void delete(int id) ;

}
