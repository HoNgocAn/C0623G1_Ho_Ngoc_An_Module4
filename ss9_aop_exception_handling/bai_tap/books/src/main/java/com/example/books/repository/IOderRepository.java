package com.example.books.repository;

import com.example.books.model.Oder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOderRepository extends JpaRepository<Oder, Long> {
}
