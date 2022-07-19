package com.exp.service;

import com.exp.entity.TreeItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TreeItemServiceTest {

    @Resource
    private TreeItemService treeItemService;
    @Test
    public void getTreeItemList() {

        List<TreeItem> list = treeItemService.getTreeData();
        for (TreeItem treeItem : list) {
            System.out.println(treeItem.toString());
        }
    }
}