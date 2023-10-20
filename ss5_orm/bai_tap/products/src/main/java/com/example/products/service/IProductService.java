package com.example.products.service;

import com.example.products.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void addProduct(Product product);

    Product findProduct(Integer id);
    void deleteProduct(Integer id);
}
