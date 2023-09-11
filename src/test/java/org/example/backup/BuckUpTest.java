package org.example.backup;

import junit.framework.TestCase;
import org.example.app.backup.StatisticsBackup;
import org.example.app.mrs.model.dto.StatisticsDto;
import org.example.app.mrs.service.impl.StatisticService;
import org.example.app.shared.Helper.Printer;

import java.io.IOException;
import java.util.List;

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


    public  void  testKarimFunction(){
        StatisticService statisticService = new StatisticService();
        List<StatisticsDto> backUp = statisticService.getAllIsbnStatistics();

        StatisticsBackup.createExcelFile(backUp , "karim");

    }



}
