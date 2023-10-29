package com.example.customermanagementjpa.repository;

import com.example.customermanagementjpa.exception.DuplicateEmailException;
import com.example.customermanagementjpa.model.Customer;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CustomerRepository implements ICustomerRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c", Customer.class);

        return query.getResultList();
    }

    @Override
    public Customer findById(Long id) {

        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c where c.id=:id", Customer.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(Customer customer) throws DuplicateEmailException {
        try {
            if (customer.getId() != null){
                entityManager.merge(customer);
            }else{
                entityManager.persist(customer);
            }
        } catch (DataIntegrityViolationException e){
            throw new DuplicateEmailException();
        }

    }

    @Override
    public void remove(Long id) {
        Customer customer = findById(id);
        if (customer != null){
            entityManager.remove(customer);
        }

    }
}
