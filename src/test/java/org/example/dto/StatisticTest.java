package org.example.dto;
import junit.framework.TestCase;
import org.example.app.mrs.service.impl.StatisticService;
import org.example.app.shared.Helper.Printer;

public class StatisticTest extends TestCase {


    public  void  testGetAllStatistic(){
        StatisticService statisticService = new StatisticService();

        Printer.printClass(statisticService.getTotalStatistics());

    }

    public  void testGetBookStatistic(){
        StatisticService statisticService = new StatisticService();

        Printer.printClass(statisticService.getBookStatisticsDto("978-3-16-148410-0"));
    }
    public  void testGetAllIsbnStatistic(){
        StatisticService statisticService = new StatisticService();

        Printer.printClassList(statisticService.getAllIsbnStatistics());

    }




}
