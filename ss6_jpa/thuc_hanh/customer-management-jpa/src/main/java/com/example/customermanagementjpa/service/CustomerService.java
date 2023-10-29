package com.example.customermanagementjpa.service;

import com.example.customermanagementjpa.exception.DuplicateEmailException;
import com.example.customermanagementjpa.model.Customer;
import com.example.customermanagementjpa.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService implements ICustomerService{

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) throws DuplicateEmailException {
        try{
            iCustomerRepository.save(customer);
        }catch (DataIntegrityViolationException e){
            throw new DuplicateEmailException();
        }
    }

    @Override
    public void remove(Long id) {
        iCustomerRepository.remove(id);
    }
}
