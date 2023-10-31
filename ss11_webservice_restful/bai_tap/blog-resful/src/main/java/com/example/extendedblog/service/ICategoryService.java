package com.example.extendedblog.service;

import com.example.extendedblog.model.Category;

import java.util.Optional;

public interface ICategoryService {

    Iterable<Category> findAllCategory();

    Optional<Category> findByIdCategory(Integer id);

    Category saveCategory(Category category);

    void removeCategory(Integer id);
}
