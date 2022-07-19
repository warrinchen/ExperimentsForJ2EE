package com.exp.service;

import com.exp.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("bookService")
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public interface BookService {
    List<Book> getAllBooks();
    void updateBook(Book book);
    void insertBook(Book book);
    void deleteBook(Integer id);
}
