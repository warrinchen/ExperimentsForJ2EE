package com.exp.service;

import com.exp.entity.TableItem;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TableItemServiceTest {

    @Test
    public void testGetTableItems() {
        List<TableItem> list = new TableItemService().getTableItems(".\\src\\main\\webapp\\data.xlsx");
        for(TableItem item : list){
            System.out.println(item);
        }
    }
}