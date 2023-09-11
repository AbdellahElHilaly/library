package org.example.app.backup;


import org.example.app.mrs.model.dto.StatisticsDto;
import org.example.app.shared.Helper.LogicHelper;
import org.example.app.shared.Helper.Printer;

import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class StatisticsBackup {

    public static String getDirectoryFromUser() {
        Printer.info("Select directory");

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            Printer.success("Directory selected");
            return fileChooser.getSelectedFile().getAbsolutePath();
        }

        Printer.error("Directory not selected successfully");
        return null;
    }

    public static void createCsvFile(String directory, List<StatisticsDto> data) throws IOException {
        Printer.info("Creating file");
        directory += "\\";
        String fileName = "statistics " + LogicHelper.formatDateTime(new Date()) + ".csv";
        String filePath = directory + fileName;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            writer.write("ISBN,Total,Borrowed,Available,Lost");
            writer.newLine();

            for (StatisticsDto statisticsDto : data) {
                writer.write(statisticsDto.getISBN() + "," + statisticsDto.getQuantityTotal() + "," + statisticsDto.getQuantityBorrowed() + "," + statisticsDto.getQuantityAvailable() + "," + statisticsDto.getQuantityLost());
                writer.newLine();
            }

        }
        Printer.success("File created successfully");


    }
}
