package com.example.extendedblog.controller;

import com.example.extendedblog.model.Category;
import com.example.extendedblog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<Iterable<Category>> findAllCategory() {
        List<Category> categories = (List<Category>) categoryService.findAllCategory();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}