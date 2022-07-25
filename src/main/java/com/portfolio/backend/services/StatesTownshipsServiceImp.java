package com.portfolio.backend.services;

import com.portfolio.backend.models.CompaniesUsuario;
import com.portfolio.backend.models.StatesTownships;
import com.portfolio.backend.repository.StatesTownshipsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatesTownshipsServiceImp implements StatesTownshipsService {
    @Autowired
    private StatesTownshipsRepository repository;

    @Override
    public StatesTownships add(StatesTownships obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<StatesTownships> listAll() {
        return repository.findAll();
    }
    /*
    @Override
    public List<CompaniesUsuario> listByName(String filtro) {
        return repository.listByName(filtro);
    }

     */

    @Override
        public Optional<StatesTownships> listByiD(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
