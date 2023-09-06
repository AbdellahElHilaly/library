package org.example.app.mrs.repository;

import org.example.app.mrs.model.entity.BorrowBook;
import org.example.dao.ORM.BaseRepository;

import java.sql.ResultSet;

public class BorrowBookRepository extends BaseRepository<BorrowBook> {
    public BorrowBookRepository() {
        super(BorrowBook.class);
    }

    public ResultSet selectBooksBorrowed(String cni) {
        String query = "SELECT * \n" +
                "FROM borrow_book\n" +
                "INNER JOIN book ON borrow_book.Book_id = book.id\n" +
                "RIGHT JOIN borrower ON borrow_book.Borrower_id = borrower.id\n" +
                "WHERE borrower.cni = '" + cni + "';";
        try {
            resultSet = this.statement.executeQuery(query);
            query = null;
            return resultSet.next() ? resultSet : null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
