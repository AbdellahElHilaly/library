package org.example.app.view.data_view;

import org.example.app.controller.StatisticController;
import org.example.app.shared.Helper.Printer;
import org.example.app.shared.Helper.ViewHelper;

import static org.example.app.shared.Helper.ViewHelper.handelChoice;

public class StatisticView {

    private  static final StatisticController statisticController = new StatisticController();

    public static void showLibrrayStatistic() {
        Printer.printClass(statisticController.getTotalStatistics());
    }

    public static void showBookStatics() {
        while (true){
            Printer.set("Enter book isbn");
            if(!handelChoice()) return;
            if(statisticController.show(ViewHelper.choice)) break;
        }
    }

    public static void showAllStatics() {
        Printer.printClassList(statisticController.getAllStatistics());
    }

    public static void buckupAllStatistics() {
        statisticController.buckupAllStatistics();
    }
}
