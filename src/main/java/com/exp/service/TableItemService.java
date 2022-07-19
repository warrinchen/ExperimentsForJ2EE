package com.exp.service;

import com.exp.entity.TableItem;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TableItemService {
    public List<TableItem> getTableItems(String filePath) {
        List<TableItem> items = new ArrayList<>();

        try{
            OPCPackage pkg = OPCPackage.open(filePath);
            XSSFWorkbook execl = new XSSFWorkbook(pkg);
            // 获取第一个sheet
            XSSFSheet sheet0 = execl.getSheetAt(0);

            for(Iterator rowIter = sheet0.iterator(); rowIter.hasNext();){//遍历每一行
                TableItem item = new TableItem();
                if(items.size() == 0)
                    rowIter.next();
                XSSFRow row = (XSSFRow) rowIter.next();
                int idx = 0;
                for(Iterator iter = row.cellIterator();iter.hasNext();idx++){
                    XSSFCell cell = (XSSFCell) iter.next();
                    switch (idx){
                        case 0 :
                            item.setId(cell.getStringCellValue());
                            break;
                        case 1 :
                            item.setName(cell.getStringCellValue());
                            break;
                        case 2 :
                            item.setGender(cell.getStringCellValue());
                            break;
                        case 3 :
                            if (DateUtil.isCellDateFormatted(cell)) { // 单元格数据是一个日期类型
//                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            try {
//                                sdf.format(cell.getDateCellValue());
                                item.setBirthDay(cell.getDateCellValue());// 日期
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                            break;
                        case 4 :
                            item.setPoliticalStatus(cell.getStringCellValue());
                            break;
                        case 5 :
                            item.setBirthplace(cell.getStringCellValue());
                            break;
                        case 6 :
                            item.setFlatId(cell.getStringCellValue());
                            break;
                        case 7 :
                            item.setAdmissionScore(new BigDecimal(cell.getNumericCellValue()).intValue());
                            break;
                        case 8 :
                            item.setAverageScore(new BigDecimal(cell.getNumericCellValue()).floatValue());
                            break;
                        case 9 :
                            item.setRanking(new BigDecimal(cell.getNumericCellValue()).intValue());
                            break;
                        case 10 :
                            item.setNote(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                }
                items.add(item);
            }
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return items;
    }
}
