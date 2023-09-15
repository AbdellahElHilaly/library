package org.example.app.mrs.repository;

import org.example.app.mrs.model.entity.Library;
import org.example.framwork.dao.ORM.BaseRepository;

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
