package org.example.app.view.data_view;

import org.example.app.controller.StatisticInitializerController;

public class PrepareApp {
    private static final StatisticInitializerController statisticInitializerController = new StatisticInitializerController();
    
    public static void start() {
        statisticInitializerController.initialize();
    }
}
