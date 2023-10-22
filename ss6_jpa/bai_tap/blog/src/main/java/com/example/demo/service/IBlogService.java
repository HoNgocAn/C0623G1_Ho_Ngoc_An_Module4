package com.example.demo.service;

import com.example.demo.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getAllBlog();
    Blog findById(Integer id);

    void createBlog(Blog blog);

    void deleteBlog(Integer id);

}
