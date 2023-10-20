package com.example.products.repository;

import com.example.products.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void addProduct(Product product);
}
