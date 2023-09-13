package org.example.app.view.data_view;

import org.example.app.controller.StatisticController;
import org.example.app.shared.Helper.print.ObjectPrinter;
import org.example.app.shared.Helper.print.Printer;
import org.example.app.shared.Helper.ViewHelper;

import static org.example.app.shared.Helper.ViewHelper.handelChoice;

public class StatisticView {

    private  static final StatisticController statisticController = new StatisticController();

    public static void showLibrrayStatistic() {
        ObjectPrinter.printClass(statisticController.getTotalStatistics());
    }

    public static void showBookStatics() {
        while (true){
            Printer.set("Enter book isbn");
            if(!handelChoice()) return;
            if(statisticController.show(ViewHelper.choice)) break;
        }
    }

    public static void showAllStatics() {
        ObjectPrinter.printClassList(statisticController.getAllStatistics());
    }

    public static void showAllStatisticsEvolution() {
        ObjectPrinter.printClassList(statisticController.getAllStatisticsEvolution());
    }

    public static void buckupAllStatistics() {
        statisticController.buckupAllStatistics();
    }


    public static void buckupStatisticsEvolution() {
        statisticController.buckupStatisticsEvolution();
    }
}
