package com.example.customermanager.repository;

import com.example.customermanager.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
}
