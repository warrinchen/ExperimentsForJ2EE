package com.exp;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class testPOI {
    @Test
    public void test(){
        String path = ".\\src\\main\\webapp\\data.xlsx";
        String text = "";
        try{
            OPCPackage pkg = OPCPackage.open(path);
            XSSFWorkbook execl = new XSSFWorkbook(pkg);
            // 获取第一个sheet
            XSSFSheet sheet0 = execl.getSheetAt(0);
            int fg = 0;
            for(Iterator rowIter = sheet0.iterator(); rowIter.hasNext();){
                XSSFRow row = (XSSFRow) rowIter.next();
                String line = "";
                for(Iterator iter = row.cellIterator();iter.hasNext();){
                    XSSFCell cell = (XSSFCell) iter.next();
                    if(cell.getCellType() == CellType.STRING)
                        line += cell.getStringCellValue() + " ";
                    else if(cell.getCellType() == CellType.NUMERIC) {
                        if (DateUtil.isCellDateFormatted(cell)) { // 单元格数据是一个日期类型
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            try {
                                line += sdf.format(cell.getDateCellValue()) + " ";// 日期
                            } catch (Exception e) {
                                try {
                                    throw new Exception("exception when getting date data !".concat(e.toString()));
                                } catch (Exception e1) {
                                    e1.printStackTrace();
                                }
                            }
                        }  else {
                            BigDecimal bd = new BigDecimal(cell.getNumericCellValue());
                            line += bd.toPlainString()+" ";// 数值 这种用BigDecimal包装再获取plainString，可以防止获取到科学计数值 + " ";
                        }
                    }
                    else if(cell.getCellType() == CellType.FORMULA) // 公式
                        line += cell.getCellFormula();
                    else if(cell.getCellType() == CellType.BLANK) // 空白
                        line += "空值" + " ";
                    else
                        line += "UNKNOWN VALUE";
                    System.out.print(cell.getCellType()+"  ");
                }
                System.out.println();
                text += line +'\n';
            }
            System.out.println("\n"+text);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
