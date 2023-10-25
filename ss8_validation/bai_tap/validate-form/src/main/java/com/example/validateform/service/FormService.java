package com.example.validateform.service;

import com.example.validateform.model.Form;
import com.example.validateform.repository.IFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;


@Service
public class FormService implements IFormService{
    @Autowired
    private IFormRepository formRepository;

    @Override
    public void save(Form form) {
        formRepository.save(form);
    }
}
