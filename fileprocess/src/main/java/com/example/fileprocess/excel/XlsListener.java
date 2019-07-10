package com.example.fileprocess.excel;

import java.text.SimpleDateFormat;
import org.apache.poi.hssf.eventusermodel.HSSFListener;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.BoundSheetRecord;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.NumberRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RowRecord;
import org.apache.poi.hssf.record.SSTRecord;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;

public class XlsListener implements HSSFListener {
  private SSTRecord sstrec;
  private int currentNum;
  private int chao=0;
  public int getChao(){
    return chao;
  }
  public void processRecord(Record record) {

    switch (record.getSid()) {
      case BOFRecord.sid: // Beginning Of File
        BOFRecord bof = (BOFRecord) record;
        if (bof.getType() == bof.TYPE_WORKBOOK) {
          System.out.println("Encountered workbook");
        } else if (bof.getType() == bof.TYPE_WORKSHEET) {
          System.out.println("Encountered sheet reference");
        }
        break;
      case BoundSheetRecord.sid:
        BoundSheetRecord bsr = (BoundSheetRecord) record;
        System.out.println("New sheet named:" + bsr.getSheetname());
        break;
      case RowRecord.sid: // 行
        RowRecord rowrec = (RowRecord) record;
        currentNum=rowrec.getRowNumber();
//        System.out.println(rowrec.getRowNumber()+"first column:" + rowrec.getFirstCol() + ", last column:" + rowrec.getLastCol());
        break;
      case NumberRecord.sid: // 数字单元格
        NumberRecord numrec = (NumberRecord) record;
        if(currentNum-numrec.getRow()>chao)
          chao=currentNum-numrec.getRow();
        String timeStr=(new SimpleDateFormat("yyyy-MM-dd")).format(HSSFDateUtil.getJavaDate(numrec.getValue()));
//        System.out.println("Row:"+numrec.getRow() + ",Column:" + numrec.getColumn() + ",Number value:" + numrec.getValue());
        break;
      case SSTRecord.sid: // Static String Table Record
        sstrec = (SSTRecord) record;
//        System.out.println("String table value:");
        for (int k = 0; k < sstrec.getNumUniqueStrings(); k++) {
//          System.out.println(k + " = " + sstrec.getString(k));
        }
        break;
      case LabelSSTRecord.sid:
        LabelSSTRecord lrec = (LabelSSTRecord) record;
        if(currentNum-lrec.getRow()>chao)
          chao=currentNum-lrec.getRow();
//        System.out.println("String cell value:" + sstrec.getString(lrec.getSSTIndex()));
        break;
    }}
}
