package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.xml.soap.Name;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService{

    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public Page<Blog> findAllBlog(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findAllBlog() {
        return blogRepository.findAll();
    }

    @Override
    public void createBlog(Blog blog) {
        blogRepository.save(blog);
    }


    @Override
    public Blog findBlogById(Integer id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void updateBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteBlog(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> getBlogByCategoryId(Integer categoryId) {
        return blogRepository.getBlogByCategoryId(categoryId);
    }

    @Override
    public Page<Blog> pageBlog(Pageable pageable, String name) {
        return blogRepository.findBlogByNameContaining(pageable,name);
    }

}