package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepo;
    @Override
    public List<Category> findAllCategory() {
        return categoryRepo.findAll();
    }

    @Override
    public Page<Category> findAllCategory(Pageable pageable) {
        return categoryRepo.findAll(pageable);
    }

    @Override
    public void createCategory(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepo.delete(findCategoryById(id));
    }

    @Override
    public Category findCategoryById(Integer id) {
        return categoryRepo.findById(id).get();
    }
}
