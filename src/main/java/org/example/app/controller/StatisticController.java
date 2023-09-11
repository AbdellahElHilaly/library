package org.example.app.controller;

import org.example.app.backup.StatisticsBackup;
import org.example.app.mrs.model.dto.StatisticsDto;
import org.example.app.mrs.model.entity.Book;
import org.example.app.mrs.service.impl.BookService;
import org.example.app.mrs.service.impl.StatisticService;
import org.example.app.shared.Helper.Printer;

import java.io.IOException;
import java.util.List;

public class StatisticController {
    StatisticService statisticService = new StatisticService();
    BookService bookService = new BookService();
    Book book = new Book();


    public StatisticsDto getTotalStatistics() {
        return statisticService.getTotalStatistics();
    }


    public boolean show(String isbn) {
        book = bookService.findByISBN(isbn);

        if (book == null) {
            Printer.error("Book not found");
            return false;
        }
        Printer.printClass(book);

        Printer.printClass(statisticService.getBookStatisticsDto(isbn));
        return true;
    }

    public List<StatisticsDto> getAllStatistics() {
        return statisticService.getAllIsbnStatistics();
    }

    public void buckupAllStatistics() {
        List<StatisticsDto> statisticsDtoList = statisticService.getAllIsbnStatistics();

        String directory = StatisticsBackup.getDirectoryFromUser();

        try {
            StatisticsBackup.createCsvFile(directory, statisticsDtoList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
