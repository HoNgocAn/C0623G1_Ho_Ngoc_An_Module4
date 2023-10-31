package com.example.extendedblog.service;

import com.example.extendedblog.model.Blog;
import com.example.extendedblog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public Iterable<Blog> findAllBlog() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findByIdBlog(Integer id) {
        return blogRepository.findById(id);
    }

    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void removeBlog(Integer id) {
        blogRepository.deleteById(id);
    }
}