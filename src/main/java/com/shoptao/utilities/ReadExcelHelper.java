/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoptao.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author haih7
 */
public class ReadExcelHelper {

    public static List<String> ReadExcel() {
        List<String> list = new ArrayList<>();
        List<String> headers = new ArrayList<>();

        JFileChooser openFileChooser = new JFileChooser();
        openFileChooser.setDialogTitle("Open file");
        openFileChooser.removeChoosableFileFilter(openFileChooser.getFileFilter());
        FileFilter filter = new FileNameExtensionFilter("Excel File(.xlsx)", "xlsx");
        openFileChooser.setFileFilter(filter);

        if (openFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File inputFile = openFileChooser.getSelectedFile();
            try ( FileInputStream in = new FileInputStream(inputFile)) {
                XSSFWorkbook importedfile = new XSSFWorkbook(in);
                XSSFSheet sheet1 = importedfile.getSheetAt(0);

                Iterator<Row> rowlterator = sheet1.iterator();
                while (rowlterator.hasNext()) {
                    Row row = rowlterator.next();
                    Iterator<Cell> celllterator = row.cellIterator();
                    while (celllterator.hasNext()) {
                        Cell cell = celllterator.next();
                        if (row.getRowNum() == 0) {
                            headers.add(cell.getStringCellValue());
                        } else {
                            if (cell.getColumnIndex() == 0) {
                                list.add(cell.getStringCellValue());
                            }
                        }
                    }

                }
                in.close();
            } catch (Exception e) {
            }

        }
        return list;
    }

}
