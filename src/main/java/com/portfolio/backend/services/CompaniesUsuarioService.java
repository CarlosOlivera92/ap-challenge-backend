package com.portfolio.backend.services;

import com.portfolio.backend.models.CompaniesUsuario;

import java.util.List;
import java.util.Optional;

public interface CompaniesUsuarioService {
    public abstract CompaniesUsuario add(CompaniesUsuario obj);
    public abstract void delete(Long id);
    public abstract List<CompaniesUsuario> listAll();
    /*
    public abstract List<CompaniesUsuario> listByName(String filtro);

     */
    Optional<CompaniesUsuario> getOne(Long id);

    public abstract Optional<CompaniesUsuario> listByiD(Long id);
    boolean existsById(Long id);
}
