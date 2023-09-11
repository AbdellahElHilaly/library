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


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

    public static void createExcelFile(List<StatisticsDto> books, String fileName) {
        try (Workbook workbook = new HSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Library Books");

            // Create a title style
            CellStyle titleStyle = workbook.createCellStyle();
            Font titleFont = workbook.createFont();
            titleFont.setBold(true);
            titleFont.setFontHeightInPoints((short) 14);
            titleStyle.setFont(titleFont);

            // Create a header style
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerStyle.setFont(headerFont);

            // Create the header row
            Row headerRow = sheet.createRow(0);
            String[] headers = {"Number", "Title", "Author", "ISBN", "Quantity", "Language", "Quantity Borrowed", "Quantity Lost"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(headerStyle);
            }

            // Fill in the data
            for (int i = 0; i < books.size(); i++) {
                StatisticsDto book = books.get(i);
                Row dataRow = sheet.createRow(i + 1);
                dataRow.createCell(0).setCellValue(i + 1);
                dataRow.createCell(1).setCellValue(book.getISBN());
                dataRow.createCell(2).setCellValue(book.getQuantityTotal());
                dataRow.createCell(3).setCellValue(book.getQuantityAvailable());
                dataRow.createCell(4).setCellValue(book.getQuantityAvailable());
                dataRow.createCell(5).setCellValue(book.getQuantityAvailable());
                dataRow.createCell(6).setCellValue(book.getQuantityBorrowed());
                dataRow.createCell(7).setCellValue(book.getQuantityAvailable());
            }
            // Auto-size columns
            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // Save the workbook to a file
            String home = System.getProperty("user.home");
            File file = new File(home + "/Downloads/" + fileName + ".xls");
            try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
                workbook.write(fileOutputStream);
            }

            System.out.println("File created successfully. You can find it in the Downloads folder.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
