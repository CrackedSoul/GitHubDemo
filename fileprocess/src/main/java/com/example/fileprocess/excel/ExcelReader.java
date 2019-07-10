package com.example.fileprocess.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.hssf.eventusermodel.HSSFEventFactory;
import org.apache.poi.hssf.eventusermodel.HSSFRequest;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelReader {
  String xls="F:/csv/LTE_manual_BJ_conf_bbu_20190417000000.xls";
  String xlsx="F:/xls/配置信息.xlsx";
  
  public static void main(String args[]) throws IOException {
    new ExcelReader().run();
  }

  private void run() throws IOException {
    try (FileInputStream fin = new FileInputStream(xls);
      POIFSFileSystem poifs = new POIFSFileSystem(fin);
      InputStream din = poifs.createDocumentInputStream("Workbook")){
      // 构造 HSSFRequest 对象
      HSSFRequest req = new HSSFRequest();
      // 监听所有的Record
      XlsListener listener=new XlsListener();
      req.addListenerForAllRecords(listener);
      // 创建EventFactory
      HSSFEventFactory factory = new HSSFEventFactory();
      // 将输入流交给EventFactory解析生成事件
      factory.processEvents(req, din);
      // 事件处理完后关闭输入流
      System.out.println("done."+listener.getChao());
    } finally {

    }
  }

}
