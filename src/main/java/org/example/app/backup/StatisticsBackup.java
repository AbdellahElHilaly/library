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
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        }

        return null; // Return null if the user cancels
    }

    public static void createCsvFile(String directory, List<StatisticsDto> data) throws IOException {
        String fileName = "statistics" + LogicHelper.formatDateTime(new Date()) + ".csv";
        Printer.debug(fileName);
        String filePath = directory + "\\" + "statistics_2023-09-11_14_21_41.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            writer.write("ISBN,Total,Borrowed,Available,Lost");
            writer.newLine();

            for (StatisticsDto statisticsDto : data) {
                writer.write(statisticsDto.getISBN() + "," + statisticsDto.getQuantityTotal() + "," + statisticsDto.getQuantityBorrowed() + "," + statisticsDto.getQuantityAvailable() + "," + statisticsDto.getQuantityLost());
                writer.newLine();
            }

        }


    }
}
