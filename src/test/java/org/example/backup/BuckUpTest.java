package org.example.backup;

import junit.framework.TestCase;
import org.example.app.backup.StatisticsBackup;
import org.example.app.mrs.service.impl.StatisticService;
import org.example.app.shared.Helper.Printer;

import java.io.IOException;

public class BuckUpTest extends TestCase {

    public void testDirectoryFromUser() {

        Printer.info(StatisticsBackup.getDirectoryFromUser());
    }

    public void testCreateFile() {

        String directory = "C:\\Users\\Youcode\\Desktop\\buckuptest\\";
        StatisticService statisticService = new StatisticService();


        try {
            StatisticsBackup.createCsvFile(directory ,statisticService.getAllIsbnStatistics());
        } catch (IOException e) {
            Printer.error("Error creating file");
            throw new RuntimeException(e);

        }

        Printer.success("File created");

    }




}
