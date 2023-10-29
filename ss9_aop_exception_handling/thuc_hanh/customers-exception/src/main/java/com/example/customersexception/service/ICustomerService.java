package com.example.customersexception.service;

import com.example.customersexception.exception.DuplicateEmailException;
import com.example.customersexception.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAllCustomer();

    Customer findById(Integer id);

    void createCustomer(Customer customer) throws DuplicateEmailException;

    void deleteCustomer(Integer id);

    void updateCustomer(Integer id, Customer customer);
}
