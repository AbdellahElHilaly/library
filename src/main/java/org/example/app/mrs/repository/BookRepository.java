package org.example.app.mrs.repository;

import org.example.app.mrs.model.entity.Book;
import org.example.dao.ORM.BaseRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRepository extends BaseRepository<Book> {
    public BookRepository() {
        super(Book.class);
    }

    public ResultSet findAvailableBookByIsbn(String isbn) {
        String query = "SELECT * FROM book WHERE status = 'AVAILABLE' AND isbn = '" + isbn + "' LIMIT 1";
        try {
             this.resultSet =  this.statement.executeQuery(query); query = null;
            return resultSet.next() ? resultSet : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
