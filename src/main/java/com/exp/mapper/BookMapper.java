package com.exp.mapper;

import com.exp.entity.Book;

import java.util.List;

public interface BookMapper {
    List<Book> getAllBooks();
    void updateBook(Book book);
    void insertBook(Book book);
    void deleteBook(Integer id);
}
