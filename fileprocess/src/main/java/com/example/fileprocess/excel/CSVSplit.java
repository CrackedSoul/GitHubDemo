package com.example.fileprocess.excel;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class CSVSplit {
  private String head;
  public void  split(String path) throws IOException {
    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream("F:\\wendang\\5月北京.csv"),"gb2312")
       );
    head= bufferedReader.readLine();
    String buffer;
    int count=0;
    int page=0;
    PrintStream printStream=new PrintStream(new FileOutputStream("E:/output/csv"+page+".csv"),true,"gb2312");
    printStream.println(head);
    while((buffer=bufferedReader.readLine())!=null){
      printStream.println(buffer);
      if(++count%100000==0){
        printStream.close();
        printStream=new PrintStream("E:/output/csv"+(++page)+".csv");
        printStream.println(head);
      }
    }
  }
}
