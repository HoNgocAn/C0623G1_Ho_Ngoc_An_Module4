package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> getAllBlog(Pageable pageable);

    List<Blog> getAllBlog();

    Blog findById(Integer id);

    void createBlog(Blog blog);

    void deleteBlog(Integer id);

    void updateBlog(Integer id, Blog blog);

    List<Blog> getBlogByCategoryId(Integer categoryId);
}


