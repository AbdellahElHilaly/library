package org.example.app.backup;


import org.example.app.mrs.model.dto.StatisticsDto;
import org.example.app.mrs.model.entity.StatisticsEvolution;

import java.util.List;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.example.app.shared.Helper.file.ExcelHelper;

import java.io.IOException;


public class StatisticsBackup {

    public static void createExcelFile(List<StatisticsDto> data, String fileName , String directory) {
        try (Workbook workbook = new HSSFWorkbook()) {

            Sheet sheet = workbook.createSheet("Library Books");

            String[] headers = data.get(0).toArrayHeader();

            ExcelHelper.createHeaderRow(sheet , headers);

            for (int i = 0; i < data.size(); i++) {
                ExcelHelper.createBodyRow(sheet, i, data.get(i).toArrayValue());
            }


            ExcelHelper.autoSizeColumns(sheet, headers);

            ExcelHelper.saveWorkbook(workbook, fileName , directory);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void createExcelFileEvolution(List<StatisticsEvolution> data, String fileName, String directory) {
        try (Workbook workbook = new HSSFWorkbook()) {

            Sheet sheet = workbook.createSheet("Library Books");

            String[] headers = data.get(0).toArrayHeader();

            ExcelHelper.createHeaderRow(sheet , headers);

            for (int i = 0; i < data.size(); i++) {
                ExcelHelper.createBodyRow(sheet, i, data.get(i).toArrayValue());
            }


            ExcelHelper.autoSizeColumns(sheet, headers);

            ExcelHelper.saveWorkbook(workbook, fileName , directory);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
