package com.example.books.service;

import com.example.books.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAllBook();

    Book findByIdBook(long id);

    Book saveBook(Book book);
}
