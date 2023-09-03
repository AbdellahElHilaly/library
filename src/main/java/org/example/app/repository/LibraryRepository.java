package org.example.app.repository;

import org.example.app.model.Library;
import org.example.dao.ORM.BaseRepository;

import java.sql.SQLException;

public class LibraryRepository extends BaseRepository<Library> {
    public LibraryRepository() {
        super(Library.class);
    }


    public void updateTotalBooks(int newBooksNumber) {
        try {
            this.statement.execute("UPDATE library SET totalBooks = " + newBooksNumber + " WHERE id = 1");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
