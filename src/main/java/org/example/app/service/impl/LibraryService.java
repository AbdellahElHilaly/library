package org.example.app.service.impl;

import org.example.app.model.Library;
import org.example.app.repository.LibraryRepository;
import org.example.app.service.CrudService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LibraryService implements CrudService<Library>{

    Library library = new Library();
    private final LibraryRepository libraryRepository = new LibraryRepository();

    public void updateTotalBooks(int newBooksNumber) {
        this.libraryRepository.updateTotalBooks(newBooksNumber);
    }

    @Override
    public Library save(Library library) {
        return library.mapData(libraryRepository.save(library));
    }

    public ResultSet save2(Library library) {
        return (libraryRepository.save(library));
    }

    @Override
    public Library select(int id) {
        return null;
    }

    @Override
    public List<Library> selectAll() {
        return library.mapDataList(libraryRepository.findAll());
    }

    @Override
    public Library update(Library library, int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
