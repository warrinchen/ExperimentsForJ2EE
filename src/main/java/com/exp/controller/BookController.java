package com.exp.controller;

import com.exp.entity.Book;
import com.exp.entity.User;
import com.exp.service.BookService;
import com.exp.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("user")
public class BookController {
    @Resource
    private UserService userService;
    @Resource
    private BookService bookService;

    //首页
    @GetMapping("exp3")
    public ModelAndView exp3(){
        ModelAndView mav = new ModelAndView("/exp3");
        return mav;
    }

    //处理登陆请求
    @PostMapping("/exp3/login")
    public ModelAndView login(String username, String password){
        ModelAndView mav;
        User currentUser = userService.getUser(username, password);
        if(currentUser != null){
            mav = new ModelAndView("/exp3-content");
            mav.addObject("user", currentUser);
        }else{
            mav = new ModelAndView("/exp3");
            mav.addObject("err_info", "用户名或密码错误,请重新输入");
        }
        return mav;
    }

    //详情页
    @GetMapping("/exp3/book-detail")
    public ModelAndView booksDetailView(){
        ModelAndView mav = new ModelAndView("/book-detail");
        List<Book> books = bookService.getAllBooks();
        mav.addObject("books", books);
        return mav;
    }

    //添加页
    @GetMapping("/exp3/book-add")
    public ModelAndView bookAddView(){
        ModelAndView mav = new ModelAndView("/book-add");
        return mav;
    }

    //处理修改请求
    @PostMapping("/exp3/modify-book")
    @ResponseBody
    public String modifyBook(Book book){
        String res = null;
        Map<String, String> map = new HashMap<>();
        System.out.println("web前端传来的待修改book信息:"+book);
        map.put("status", "ok");
        try {
            bookService.updateBook(book);
        }catch (Exception e){
//            e.printStackTrace();
            map.put("status", "error");
        }
        try {
            res = new ObjectMapper().writeValueAsString(map);
            System.out.println(res);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return res;
    }
    //处理添加请求
    @PostMapping("/exp3/insert-book")
    @ResponseBody
    public String addBook(Book book){
        String res = null;
        Map<String, String> map = new HashMap<>();
        System.out.println("web前端传来的待添加book信息:"+book);
        map.put("status", "ok");
        try {
            bookService.insertBook(book);
        }catch (Exception e){
            e.printStackTrace();
            map.put("status", "error");
        }
        try {
            res = new ObjectMapper().writeValueAsString(map);
            System.out.println(res);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return res;
    }
    //处理删除请求
    @PostMapping("/exp3/delete-book")
    @ResponseBody
    public String deleteBook(Integer id){
        String res = null;
        Map<String, String> map = new HashMap<>();
        map.put("status", "ok");
        try {
            bookService.deleteBook(id);
        }catch (Exception e){
            e.printStackTrace();
            map.put("status", "error");
        }
        try {
            res = new ObjectMapper().writeValueAsString(map);
            System.out.println("in deleteBook: "+res);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return res;
    }
}
