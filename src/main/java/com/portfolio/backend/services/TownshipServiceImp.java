package com.portfolio.backend.services;

import com.portfolio.backend.models.Townships;
import com.portfolio.backend.repository.TownshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TownshipServiceImp implements TownshipService {
    @Autowired
    private TownshipRepository repository;

    @Override
    public Townships add(Townships obj) {
        return repository.save(obj);
    }

    @Override
    public List<Townships> list() {
        return repository.findAll();
    }

    @Override
    public Optional<Townships> findById(Long id) {
        Optional<Townships> township = repository.findById(id);
        return township;
    }
}
