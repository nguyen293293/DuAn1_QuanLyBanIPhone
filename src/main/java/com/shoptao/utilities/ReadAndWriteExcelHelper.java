/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoptao.utilities;

import com.shoptao.viewmodel.SanPhamViewModle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.boot.model.source.internal.hbm.ModelBinder;

/**
 *
 * @author haih7
 */
public class ReadAndWriteExcelHelper {

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

                        list.add(cell.getStringCellValue());

                    }

                }
                in.close();
            } catch (Exception e) {
            }

        }
        return list;
    }

    public static void exportExcel(List<SanPhamViewModle> listInput) {
        try {
            XSSFWorkbook wordbook = new XSSFWorkbook();
            XSSFSheet sheet = wordbook.createSheet("Danh sách sản phẩm ");
            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(0);

            cell = row.createCell(0, Cell.CELL_TYPE_STRING);
            cell.setCellValue("STT");

            cell = row.createCell(1, Cell.CELL_TYPE_STRING);
            cell.setCellValue("Mã sản phẩm");

            cell = row.createCell(2, Cell.CELL_TYPE_STRING);
            cell.setCellValue("Tên");

            cell = row.createCell(3, Cell.CELL_TYPE_STRING);
            cell.setCellValue("Dung lượng");

            cell = row.createCell(4, Cell.CELL_TYPE_STRING);
            cell.setCellValue("Số lượng tồn");

            cell = row.createCell(5, Cell.CELL_TYPE_STRING);
            cell.setCellValue("Năm bảo hành");

            cell = row.createCell(6, Cell.CELL_TYPE_STRING);
            cell.setCellValue("Giá nhập");

            cell = row.createCell(7, Cell.CELL_TYPE_STRING);
            cell.setCellValue("Giá bán");

            cell = row.createCell(8, Cell.CELL_TYPE_STRING);
            cell.setCellValue("Mô tả");

            cell = row.createCell(9, Cell.CELL_TYPE_STRING);
            cell.setCellValue("ảnh");

            cell = row.createCell(10, Cell.CELL_TYPE_STRING);
            cell.setCellValue("barcode");

            cell = row.createCell(11, Cell.CELL_TYPE_STRING);
            cell.setCellValue("Trạng thái");

            cell = row.createCell(12, Cell.CELL_TYPE_STRING);
            cell.setCellValue("Tên dòng sản phẩm");

            cell = row.createCell(13, Cell.CELL_TYPE_STRING);
            cell.setCellValue("Tên màu sắc");

            for (int i = 0; i < listInput.size(); i++) {
                SanPhamViewModle spvm = listInput.get(i);
                row = sheet.createRow(i + 1);

                cell = row.createCell(0, Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(i + 1);

                cell = row.createCell(0, Cell.CELL_TYPE_STRING);
                cell.setCellValue(spvm.getMa());

                cell = row.createCell(1, Cell.CELL_TYPE_STRING);
                cell.setCellValue(spvm.getMa());

                cell = row.createCell(2, Cell.CELL_TYPE_STRING);
                cell.setCellValue(spvm.getTen());

                cell = row.createCell(3, Cell.CELL_TYPE_STRING);
                cell.setCellValue(spvm.getDungluong());

                cell = row.createCell(4, Cell.CELL_TYPE_STRING);
                cell.setCellValue(spvm.getSoluongton());

                cell = row.createCell(5, Cell.CELL_TYPE_STRING);
                cell.setCellValue(spvm.getNambaohanh());

                cell = row.createCell(6, Cell.CELL_TYPE_STRING);
                cell.setCellValue(String.valueOf(spvm.getGianhap()));

                cell = row.createCell(7, Cell.CELL_TYPE_STRING);
                cell.setCellValue(String.valueOf(spvm.getGiaban()));

                cell = row.createCell(8, Cell.CELL_TYPE_STRING);
                cell.setCellValue(spvm.getMota());

                cell = row.createCell(9, Cell.CELL_TYPE_STRING);
                cell.setCellValue(String.valueOf(spvm.getAnhsanpham()));

                cell = row.createCell(10, Cell.CELL_TYPE_STRING);
                cell.setCellValue(spvm.getBarcode());

                cell = row.createCell(11, Cell.CELL_TYPE_STRING);
                cell.setCellValue(spvm.getTrangthai());

                cell = row.createCell(12, Cell.CELL_TYPE_STRING);
                cell.setCellValue(spvm.getTendongsanpham());

                cell = row.createCell(13, Cell.CELL_TYPE_STRING);
                cell.setCellValue(spvm.getTenmausac());

            }
            
            File f = new File("D:\\DanhSachSanPham.xlsx");
            try {
                FileOutputStream fos = new FileOutputStream(f);

                wordbook.write(fos);
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();

            }

            System.out.println("In thanh cong");

        } catch (Exception e) {
        }
    }

}
