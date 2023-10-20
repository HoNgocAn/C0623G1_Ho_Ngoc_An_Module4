package com.example.products.repository;

import com.example.products.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

import static com.example.products.repository.ConnectionUtil.sessionFactory;

@Repository
public class ProductRepository implements IProductRepository{
    @Override
    public List<Product> findAll() {
        Session session = null;
        List<Product> productList = null;
        try {
            session = sessionFactory.openSession();
            productList = session.createQuery(" from Product").getResultList();
        } finally {
            session.close();
        }
        return productList;
    }

    @Override
    public void addProduct(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
           session = ConnectionUtil.sessionFactory.openSession();
           transaction = session.beginTransaction();
           session.save(product);
           transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public Product findProduct(Integer id) {
        Session session = null;
        session = sessionFactory.openSession();
        String queryStr = "SELECT p FROM Product AS p WHERE p.id = :id";
        TypedQuery<Product> query = session.createQuery(queryStr, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void deleteProduct(Integer id) {
        Product product = findProduct(id);
        if (product != null) {
            Transaction transaction = null;
            try (Session session = sessionFactory.openSession()) {
                transaction = session.beginTransaction();
                session.remove(product);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                if (transaction != null) {
                    transaction.rollback();
                }
            }
        }

    }
}
