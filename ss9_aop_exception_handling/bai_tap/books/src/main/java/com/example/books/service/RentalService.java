package com.example.books.service;

import com.example.books.exception.RentalException;
import com.example.books.model.Rental;
import com.example.books.repository.IRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalService implements IRentalService{
    @Autowired
    private IRentalRepository rentalRepository;

    @Override
    public void createRental(Rental rental) {
        rentalRepository.save(rental);
    }

    @Override
    public void updateRental(Rental rental) {
        rentalRepository.save(rental);
    }

    @Override
    public Rental findByCodeRental(Integer id) throws RentalException {
        if (rentalRepository.findByCodeRental(id) == null) {
            throw new RentalException("Nothing");
        }
        return rentalRepository.findByCodeRental(id);
    }
}
