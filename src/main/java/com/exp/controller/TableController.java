package com.exp.controller;

import com.exp.entity.TableItem;
import com.exp.service.TableItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TableController {
    @GetMapping("/test") //访问路径 //localhost/t
    @ResponseBody // 直接向响应输出字符串数据, 不跳转页面
    public String test() {
        return "Hello Spring MVC";
    }

    @GetMapping("exp1")
    public ModelAndView showFTL(){
        /*
        由于在applicationContext.xml中id为freemarkerConfig的Bean已经对freemarker进行了配置,
        因此, "/exp1" 的 "/" 代表 webapp目录下的/WEB-INF/ftl, "exp1" 代表 exp1.ftl 文件
         */
        ModelAndView mav = new ModelAndView("/exp1");
        TableItemService tableItemService = new TableItemService();
        List<TableItem> list = tableItemService.getTableItems("D:/workspace/idea/ExperimentsForJ2EE/src/main/webapp/data.xlsx");
        mav.addObject("list", list);
        return mav;
    }

    @GetMapping("/expriment1")
    public String showModel(ModelMap modelMap) {
        String view = "/exp1";
        TableItemService tableItemService = new TableItemService();
        List<TableItem> list = tableItemService.getTableItems("D:/workspace/idea/ExperimentsForJ2EE/src/main/webapp/data.xlsx");
        modelMap.addAttribute("list", list);
        return view;
    }
}
