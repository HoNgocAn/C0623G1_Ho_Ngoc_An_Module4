package com.example.extendedblog.service;

import com.example.extendedblog.model.Category;
import com.example.extendedblog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepository categoryRepository;


    @Override
    public Iterable<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findByIdCategory(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void removeCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}
