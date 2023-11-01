package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/blog")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<Page<Blog>> findAllBlog(@RequestParam(defaultValue = "0", required = false) int page,
                                                  @RequestParam(defaultValue = "",required = false)String name) {
        Pageable pageable = PageRequest.of(page,20, Sort.by("timePost").descending());
        Page<Blog> blogPage = blogService.pageBlog(pageable,name);
        if(blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable Integer id){
        Blog blog = blogService.findBlogById(id);
        if(blog == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
