package com.example.books.service;

import com.example.books.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAllBook();
    void creatBook(Book book);
    void updateBook(Book book);
    Book getBook(Integer id);
}
