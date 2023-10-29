package com.example.customermanagementjpa.repository;

import com.example.customermanagementjpa.exception.DuplicateEmailException;
import com.example.customermanagementjpa.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer) throws DuplicateEmailException;

    void remove(Long id);

}

