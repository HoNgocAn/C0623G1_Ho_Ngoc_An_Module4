package com.example.extendedblog.controller;

import com.example.extendedblog.model.Blog;
import com.example.extendedblog.service.IBlogService;
import com.example.extendedblog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;


    @GetMapping
    public ResponseEntity<Iterable<Blog>> findAllBlog() {
        List<Blog> blogs = (List<Blog>) blogService.findAllBlog();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable Integer id){
        Optional<Blog> customerOptional = blogService.findByIdBlog(id);
        if(!customerOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }
}

