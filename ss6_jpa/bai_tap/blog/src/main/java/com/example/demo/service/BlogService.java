package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{

    @Autowired
    private IBlogRepository blogRepository;

    public Page<Blog> getAllBlog(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }
    @Override
    public List<Blog> getAllBlog() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void createBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteBlog(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void updateBlog(Integer id, Blog blog) {
        blogRepository.save(blog);
    }
    @Override
    public List<Blog> getBlogByCategoryId(Integer categoryId) {
        return blogRepository.getBlogByCategoryId(categoryId);
    }

}
