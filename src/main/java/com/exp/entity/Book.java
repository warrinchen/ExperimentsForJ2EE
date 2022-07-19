package com.exp.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Book {
    private Integer id;
    private String name;
    private String author;
    private String publisher;
    private Integer stock;
    @DateTimeFormat(pattern = "yyyyy-MM-dd")
    private Date publishTime;
    private Float price;
    @DateTimeFormat(pattern = "yyyyy-MM-dd")
    private Date registerTime;
    private Integer registerUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getRegisterUser() {
        return registerUser;
    }

    public void setRegisterUser(Integer registerUser) {
        this.registerUser = registerUser;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", stock=" + stock +
                ", publishTime=" + publishTime +
                ", price=" + price +
                ", registerTime=" + registerTime +
                ", registerUser=" + registerUser +
                '}';
    }
}
