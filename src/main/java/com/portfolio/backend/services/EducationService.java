package com.portfolio.backend.services;

import com.portfolio.backend.models.Education;

import java.util.List;
import java.util.Optional;

public interface EducationService {
    public abstract List<Education> listEducation();

    public Optional<Education> buscarEducacion(Long id);

}
