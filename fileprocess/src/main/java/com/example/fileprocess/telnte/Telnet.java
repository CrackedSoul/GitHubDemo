package com.example.fileprocess.telnte;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.commons.net.telnet.TelnetClient;
import org.apache.commons.net.telnet.TelnetInputListener;

public class Telnet {
  private static  TelnetClient tc;
public static void main(String args[]) throws IOException, InterruptedException {
  tc = new TelnetClient("VT220");
//  tc.registerInputListener(new MyListener());
  tc.connect("192.168.2.90",22);
  InputStream inputStream=tc.getInputStream();
  StringBuilder stringBuilder=new StringBuilder();
  byte[] bytes=new byte[1024];
  while(inputStream.read(bytes)>-1){
    stringBuilder.append(new String(bytes));
    System.out.println(stringBuilder.toString());
  }
}
private static class MyListener implements TelnetInputListener{
  private BufferedReader bufferedReader;
  public MyListener(){
  }

  @Override
  public void telnetInputAvailable() {
    if(bufferedReader==null){
      bufferedReader=new BufferedReader(new InputStreamReader(tc.getInputStream()));
    }
    try {
      String buff;
      if((buff=bufferedReader.readLine())!=null){
        System.out.println(buff);
      }
      System.out.println();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
}
