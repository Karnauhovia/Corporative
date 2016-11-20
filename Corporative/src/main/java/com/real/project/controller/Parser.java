package com.real.project.controller;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class Parser {

    public static String parse(String name) {

        String result = "";
        InputStream in = null;
        XSSFWorkbook wb = null;
        byte [] bytes = null;
        try {
            in = new FileInputStream(name);

            wb = new XSSFWorkbook(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sheet sheet = wb.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                int cellType = cell.getCellType();
                switch (cellType) {
                    case Cell.CELL_TYPE_STRING:
                        result += cell.getStringCellValue() + " ";
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        result += " " + cell.getNumericCellValue() + " ";
                        break;
                    default:
                        result += " ";
                        break;
                }
            }
            result += "\n";
        }

        return result;
    }

}