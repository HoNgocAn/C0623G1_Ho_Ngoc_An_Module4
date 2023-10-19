package com.example.products.repository;

import com.example.products.model.Product;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{
    @Override
    public List<Product> findAll() {
        Session session = null;
        List<Product> productList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery(" from Product").getResultList();
        } finally {
            session.close();
        }
        return productList;
    }
}
