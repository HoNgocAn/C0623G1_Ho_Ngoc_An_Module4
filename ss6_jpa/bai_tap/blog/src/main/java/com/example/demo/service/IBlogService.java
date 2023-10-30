package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Iterable<Blog> findAllBlog();

    Optional<Blog> findByIdBlog(Integer id);

    Blog saveBlog(Blog blog);

    void removeBlog(Integer id);
}


