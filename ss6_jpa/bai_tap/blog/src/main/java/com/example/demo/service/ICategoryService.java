package com.example.demo.service;

import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {

    Iterable<Category> findAllCategory();

    Optional<Category> findByIdCategory(Integer id);

    Category saveCategory(Category category);

    void removeCategory(Integer id);
}
