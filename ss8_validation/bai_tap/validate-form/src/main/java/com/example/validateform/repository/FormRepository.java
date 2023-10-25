package com.example.validateform.repository;

import com.example.validateform.model.Form;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class FormRepository implements IFormRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Form form) {
        if (form.getId() != null) {
            entityManager.merge(form);
        } else {
            entityManager.persist(form);
        }
    }
}
