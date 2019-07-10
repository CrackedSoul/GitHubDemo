package com.example.fileprocess.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {
  public static void main(String args[]){
    test();
  }

  private static void test() {
    try (Workbook workbook = getWorkBook(new File("F:\\csv\\LTE_manual_BJ_conf_bbu_20190417000000.xls"))) {
      Sheet sheet = workbook.getSheetAt(0);
      int i = 0;
      List<String> rowData = new ArrayList<>();
      for (Row row : sheet) { // 行
        int column = 0;
        for (Cell cell : row) { // 单元格
          switch (cell.getCellTypeEnum()) {
            case STRING:
              rowData.add(cell.getRichStringCellValue().getString());
              break;
            case NUMERIC:
              if (DateUtil.isCellDateFormatted(cell)) {
                rowData.add(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
                    .format(cell.getDateCellValue()));
              } else {
                rowData.add(cell.getNumericCellValue() + "");
              }
              break;
            case BOOLEAN:
              rowData.add(cell.getBooleanCellValue() + "");
              break;
            case FORMULA:
              rowData.add(cell.getCellFormula());
              break;
            case BLANK:
              rowData.add("");
              break;
          }
        }
        System.out.println(Arrays.toString(rowData.toArray()));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  private static  Workbook getWorkBook(File file)  {
    try {
      String fileName = file.getName();
      if(fileName.endsWith("xls")){
        return new HSSFWorkbook(new POIFSFileSystem(new FileInputStream(file)));
      } else if(fileName.endsWith("xlsx")){
        return new XSSFWorkbook(file);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
   return null;
  }
}