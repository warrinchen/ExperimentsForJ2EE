package com.exp.service;

import com.exp.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class BookServiceTest {
    @Resource
    private BookService bookService;

    @Test
    public void getAllBooks() {
        for(Book book : bookService.getAllBooks()){
            System.out.println(book.getName());
        }
    }

    @Test
    public void updateBook() {
        Book book = new Book();
        book.setId(5);
        book.setName("数据结构");
        book.setAuthor("严蔚敏");
        book.setPrice(22.0f);
        book.setPublisher("清华大学出版社");
        book.setStock(20);
        book.setPublishTime(new Date(2015-1900, 4,5));
        book.setRegisterTime(new Date(2022-1900,3,30));
        book.setRegisterUser(34);
        bookService.updateBook(book);
        System.out.println("updated");
    }

    @Test
    public void insertBook() {
        Book book = new Book();
        book.setName("tstbname");
        book.setAuthor("auth");
        book.setPrice(10.0f);
        book.setPublisher("清华出版社");
        book.setStock(2);
        book.setPublishTime(new Date(2015-1900, 4,5));
        book.setRegisterUser(34);
        bookService.insertBook(book);
    }

    @Test
    public void deleteBook(){
        bookService.deleteBook(7);
    }
}