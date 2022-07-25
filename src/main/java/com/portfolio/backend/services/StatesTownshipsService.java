package com.portfolio.backend.services;

import com.portfolio.backend.models.StatesTownships;

import java.util.List;
import java.util.Optional;

public interface StatesTownshipsService {
    public abstract StatesTownships add(StatesTownships obj);
    public abstract void delete(Long id);
    public abstract List<StatesTownships> listAll();
    /*
    public abstract List<StatesTownships> listByName(String filtro);

     */
    public abstract Optional<StatesTownships> listByiD(Long id);
    boolean existsById(Long id);
}
