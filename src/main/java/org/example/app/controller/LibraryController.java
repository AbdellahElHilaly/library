package org.example.app.controller;

import org.example.app.model.Library;
import org.example.app.service.impl.LibraryService;

import java.sql.SQLException;

public class LibraryController {
    static LibraryService libraryService = new LibraryService();

    public static boolean isInitialized() {
        return !libraryService.selectAll().isEmpty();
    }


    public static void initialize(Library library) {
        libraryService.save(library);
    }
}
