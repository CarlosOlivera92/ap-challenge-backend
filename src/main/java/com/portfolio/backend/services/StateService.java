package com.portfolio.backend.services;

import com.portfolio.backend.models.States;

import java.util.List;
import java.util.Optional;

public interface StateService {

    public abstract States add(States obj);
    public abstract List<States> list();

    public Optional<States> findById(Long id);

}
