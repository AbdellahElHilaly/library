package org.example.app.controller;

import org.example.app.backup.StatisticsBackup;
import org.example.app.mrs.model.dto.StatisticsDto;
import org.example.app.mrs.model.entity.Book;
import org.example.app.mrs.model.entity.StatisticsEvolution;
import org.example.app.mrs.service.impl.BookService;
import org.example.app.mrs.service.impl.StatisticService;
import org.example.app.mrs.service.impl.StatisticsEvolutionService;
import org.example.app.shared.Helper.print.ObjectPrinter;
import org.example.app.shared.Helper.print.Printer;
import org.example.app.shared.Helper.file.FileHelper;

import java.util.List;

public class StatisticController {
    StatisticService statisticService = new StatisticService();
    StatisticsEvolutionService statisticsEvolutionService = new StatisticsEvolutionService();
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
        ObjectPrinter.printClass(book);

        ObjectPrinter.printClass(statisticService.getBookStatisticsDto(isbn));
        return true;
    }

    public List<StatisticsDto> getAllStatistics() {
        return statisticService.getAllIsbnStatistics();
    }

    public List<StatisticsEvolution> getAllStatisticsEvolution() {
        return statisticsEvolutionService.selectAll();
    }

    public void buckupAllStatistics() {

        List<StatisticsDto> statisticsDtoList = statisticService.getAllIsbnStatistics();

        String directory = FileHelper.getUserDirectory() + "\\";
        String fileName = statisticsDtoList.get(0).getModelName();

        StatisticsBackup.createExcelFile(statisticsDtoList, fileName, directory);

    }

    public void buckupStatisticsEvolution() {

            List<StatisticsEvolution> statisticsEvolutionList = statisticsEvolutionService.selectAll();

            String directory = FileHelper.getUserDirectory() + "\\";
            String fileName = statisticsEvolutionList.get(0).getModelName();

            StatisticsBackup.createExcelFileEvolution(statisticsEvolutionList, fileName, directory);
    }
}
