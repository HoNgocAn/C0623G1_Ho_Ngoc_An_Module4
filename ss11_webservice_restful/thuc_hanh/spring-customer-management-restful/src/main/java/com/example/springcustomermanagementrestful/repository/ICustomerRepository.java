package com.example.springcustomermanagementrestful.repository;

import com.example.springcustomermanagementrestful.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
