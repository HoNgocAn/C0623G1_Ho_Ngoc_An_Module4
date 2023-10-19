package com.example.products.repository;

import com.example.products.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class ProductRepository implements IProductRepository{
    private final static List<Product> products;
    static {
        products = new ArrayList<>();
        products.add(new Product(1,"Beef","clean, fresh, delicious ",100000.0, "Japan"));
        products.add(new Product(2,"Milk","nutritious",20000.0,"American"));
        products.add(new Product(3,"Coffee","popular type",30000.0,"Viet Nam"));

    }
    @Override
    public List<Product> showAllProduct() {
        return products;
    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void updateProduct(Integer id, Product product) {

    }

    @Override
    public void deleteProduct(Integer id) {

    }

    @Override
    public Product getProduct(Integer id) {
        return null;
    }

    @Override
    public List<Product> searchProduct(String nameProduct) {
        return null;
    }
}
