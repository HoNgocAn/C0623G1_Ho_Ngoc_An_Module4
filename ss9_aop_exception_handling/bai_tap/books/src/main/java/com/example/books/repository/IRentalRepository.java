package com.example.books.repository;

import com.example.books.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentalRepository extends JpaRepository<Rental,Integer> {
    Rental findByCodeRental(Integer id);
}
