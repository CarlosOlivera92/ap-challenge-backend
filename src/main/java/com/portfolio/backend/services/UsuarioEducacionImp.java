package com.portfolio.backend.services;

import com.portfolio.backend.models.UsuarioEducacion;
import com.portfolio.backend.repository.UsuarioEducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioEducacionImp implements UsuarioEducacionService {
    @Autowired
    private UsuarioEducationRepository repository;

    @Override
    public UsuarioEducacion añadirActualizarInfo(UsuarioEducacion obj) {
        return repository.save(obj);
    }

    @Override
    public void deleteUsuarioEducacion(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<UsuarioEducacion> listAll() {
        return repository.findAll();
    }

    @Override
    public Optional<UsuarioEducacion> listBYiD(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
