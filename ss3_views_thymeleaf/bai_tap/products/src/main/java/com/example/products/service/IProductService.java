package com.example.products.service;



import com.example.products.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showAllProduct();
    void addProduct(Product product);
    void updateProduct(Integer id, Product product);
    void deleteProduct(Integer id);
    Product getProduct(Integer id);
    List<Product> searchProduct(String nameProduct);
}
