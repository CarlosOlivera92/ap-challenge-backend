package com.portfolio.backend.services;

import com.portfolio.backend.models.Townships;

import java.util.List;
import java.util.Optional;

public interface TownshipService {

    public abstract Townships add(Townships obj);
    public abstract List<Townships> list();

    public Optional<Townships> findById(Long id);

}
