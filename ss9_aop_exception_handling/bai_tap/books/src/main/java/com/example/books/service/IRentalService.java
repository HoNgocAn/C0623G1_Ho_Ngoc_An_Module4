package com.example.books.service;

import com.example.books.exception.RentalException;
import com.example.books.model.Rental;

public interface IRentalService {
    void createRental(Rental rental);
    void updateRental(Rental rental);
    Rental findByCodeRental(Integer id) throws RentalException;
}

