package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Page<Blog> findAllBlog(Pageable pageable);
    List<Blog> findAllBlog();
    void createBlog(Blog blog);

    Blog findBlogById(Integer id);
    void updateBlog(Blog blog);
    void deleteBlog(Integer id);
    List<Blog> getBlogByCategoryId(Integer categoryId);
    Page<Blog> pageBlog(Pageable pageable,String name);
}


