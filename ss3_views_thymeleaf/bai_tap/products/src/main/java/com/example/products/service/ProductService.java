package com.example.products.service;

import com.example.products.model.Product;
import com.example.products.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> showAllProduct() {
        return productRepository.showAllProduct();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public void updateProduct(Integer id, Product product) {
        productRepository.updateProduct(id,product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteProduct(id);
    }

    @Override
    public Product findProduct(Integer id) {
        return productRepository.findProduct(id);
    }

    @Override
    public List<Product> searchProduct(String nameProduct) {
        return productRepository.searchProduct(nameProduct);
    }
}
