package com.example.extendedblog.service;

import com.example.extendedblog.model.Blog;

import java.util.Optional;

public interface IBlogService {
    Iterable<Blog> findAllBlog();

    Optional<Blog> findByIdBlog(Integer id);

    Blog saveBlog(Blog blog);

    void removeBlog(Integer id);
}

