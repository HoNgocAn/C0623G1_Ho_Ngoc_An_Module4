package com.example.books.service;

import com.example.books.model.Oder;
import com.example.books.repository.IOderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OderService implements IOderService {
    @Autowired
    private IOderRepository oderRepository;

    @Override
    public List<Oder> findAllOrder() {
        return oderRepository.findAll();
    }

    @Override
    public Oder findByIdOrder(long id) {
        return oderRepository.findById(id).get();
    }

    @Override
    public Oder saveOder(Oder oder) {
        return oderRepository.save(oder);
    }
}
