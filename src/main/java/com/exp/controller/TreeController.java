package com.exp.controller;

import com.exp.entity.TreeItem;
import com.exp.service.TreeItemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller("treeController")
public class TreeController {

    @Resource
    private TreeItemService treeItemService;

    @GetMapping("/exp2")
    public ModelAndView showTree(){
        ModelAndView mav = new ModelAndView("/exp2"); // exp2.ftl
        return mav;
    }

    @GetMapping("/exp2json")
    @ResponseBody
    public String getExp2JSON(){
        if(treeItemService == null) System.out.println("treeItemService in TreeController is null");
        List<TreeItem> list = treeItemService.getTreeData();
        String result = null;
        try {
            result = new ObjectMapper().writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
