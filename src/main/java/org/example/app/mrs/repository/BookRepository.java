package org.example.app.mrs.repository;

import org.example.app.mrs.model.entity.Book;
import org.example.framwork.console.print.Printer;
import org.example.framwork.dao.ORM.BaseRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRepository extends BaseRepository<Book> {
    public BookRepository() {
        super(Book.class);
    }

    public ResultSet findAvailableBookByIsbn(String isbn) {
        String query = "SELECT * FROM book WHERE status = 'AVAILABLE' AND isbn = '" + isbn + "' LIMIT 1";
        try {
            this.resultSet = this.statement.executeQuery(query);
            query = null;
            return resultSet.next() ? resultSet : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public ResultSet getTotalBooksStatistics() {
        String sql = "SELECT " +
                "COUNT(*) AS QuantityTotal, " +
                "SUM(CASE WHEN status = 'BORROWED' THEN 1 ELSE 0 END) AS QuantityBorrowed, " +
                "SUM(CASE WHEN status = 'AVAILABLE' THEN 1 ELSE 0 END) AS QuantityAvailable, " +
                "SUM(CASE WHEN status = 'LOST' THEN 1 ELSE 0 END) AS QuantityLost " +
                "FROM book";
        try {
            resultSet = this.statement.executeQuery(sql);
            if (!resultSet.next()) {
                Printer.error("No books found");
                return resultSet;
            }
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getBooksStatisticsByIsbn(String isbn) {
        String sql = "SELECT isbn," +
                "COUNT(*) AS QuantityTotal, " +
                "SUM(CASE WHEN status = 'BORROWED' THEN 1 ELSE 0 END) AS QuantityBorrowed, " +
                "SUM(CASE WHEN status = 'AVAILABLE' THEN 1 ELSE 0 END) AS QuantityAvailable, " +
                "SUM(CASE WHEN status = 'LOST' THEN 1 ELSE 0 END) AS QuantityLost " +
                "FROM book" +
                " WHERE isbn = '" + isbn + "'";
        try {
            resultSet = this.statement.executeQuery(sql);
            if (!resultSet.next()) {
                Printer.error("No books found");
                return resultSet;
            }
            return resultSet;
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public ResultSet getAllIsbnStatistics() {
        String sql = "SELECT " +
                "isbn, " +
                "COUNT(*) AS QuantityTotal, " +
                "SUM(CASE WHEN status = 'BORROWED' THEN 1 ELSE 0 END) AS QuantityBorrowed, " +
                "SUM(CASE WHEN status = 'AVAILABLE' THEN 1 ELSE 0 END) AS QuantityAvailable, " +
                "SUM(CASE WHEN status = 'LOST' THEN 1 ELSE 0 END) AS QuantityLost " +
                "FROM book " +
                "GROUP BY isbn";

        try {
            resultSet = this.statement.executeQuery(sql);
            resultSet = this.statement.executeQuery(sql);
            if (!resultSet.next()) {
                Printer.error("No books found");
                return resultSet;
            }
            return resultSet;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
