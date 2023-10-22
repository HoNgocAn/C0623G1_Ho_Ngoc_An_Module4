package com.example.demo.service;

import com.example.demo.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getAllBlog();
    Blog findById(int id);

    void createBlog(Blog blog);

    void deleteBlog(int id);

}
