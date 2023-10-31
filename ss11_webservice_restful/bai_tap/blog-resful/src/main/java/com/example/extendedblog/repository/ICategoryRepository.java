package com.example.extendedblog.repository;

import com.example.extendedblog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
