package com.example.books.service;

import com.example.books.model.Book;
import com.example.books.model.Oder;

import java.util.List;

public interface IOderService {
    List<Oder> findAllOrder();

    Oder findByIdOrder(long id);

    Oder saveOder(Oder oder);
}
