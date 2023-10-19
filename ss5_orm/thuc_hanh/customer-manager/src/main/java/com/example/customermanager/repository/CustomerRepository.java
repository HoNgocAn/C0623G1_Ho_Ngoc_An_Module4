package com.example.customermanager.repository;

import com.example.customermanager.model.Customer;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository{
    @Override
    public List<Customer> findAll() {
        Session session = null;
        List<Customer> customerList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            customerList = session.createQuery("select c from Customer as c").getResultList();
        } finally {
            session.close();
        }
        return customerList;
    }
}
