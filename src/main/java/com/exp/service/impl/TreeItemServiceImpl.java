package com.exp.service.impl;

import com.exp.entity.TreeItem;
import com.exp.mapper.TreeItemMapper;
import com.exp.service.TreeItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("treeItemService")
public class TreeItemServiceImpl implements TreeItemService {
    @Resource
    private TreeItemMapper treeItemMapper;

    @Override
    public List<TreeItem> getTreeData(){
        if(treeItemMapper == null) System.out.println("treeItemMapper in TreeItemService is null");
        return treeItemMapper.getTreeItemList();
    }
}
