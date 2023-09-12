package org.example.backup;

import junit.framework.TestCase;
import org.example.app.backup.StatisticsBackup;
import org.example.app.mrs.model.dto.StatisticsDto;
import org.example.app.mrs.service.impl.StatisticService;
import org.example.app.shared.Helper.Printer;
import org.example.app.shared.Helper.FileHelper;

import java.io.IOException;
import java.util.List;

public class BuckUpTest extends TestCase {

    public void testDirectoryFromUser() {

        Printer.info(FileHelper.getUserDirectory());
    }




    public  void  testKarimFunction(){
        StatisticService statisticService = new StatisticService();
        List<StatisticsDto> backUp = statisticService.getAllIsbnStatistics();

        String directory = FileHelper.getUserDirectory() +"\\";
        String fileName = backUp.get(0).getModelName();
        StatisticsBackup.createExcelFile(backUp , fileName , directory);

    }




}
