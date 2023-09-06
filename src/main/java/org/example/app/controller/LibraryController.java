package org.example.app.controller;

import org.example.app.mrs.model.entity.Library;
import org.example.app.mrs.service.impl.LibraryService;

public class LibraryController {
    static LibraryService libraryService = new LibraryService();

    public static boolean isInitialized() {
        return !libraryService.selectAll().isEmpty();
    }

    public static void initialize(Library library) {
        libraryService.save(library);
    }

}
