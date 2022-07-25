package com.portfolio.backend.services;

import com.portfolio.backend.models.States;
import com.portfolio.backend.repository.StatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatesServiceImp implements StateService {
    @Autowired
    private StatesRepository repository;

    @Override
    public States add(States obj) {
        return repository.save(obj);
    }

    @Override
    public List<States> list() {
        return repository.findAll();
    }

    @Override
    public Optional<States> findById(Long id) {
        Optional<States> states = repository.findById(id);
        return states;
    }
}
