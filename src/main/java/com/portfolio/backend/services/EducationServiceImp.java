package com.portfolio.backend.services;

import com.portfolio.backend.models.Education;
import com.portfolio.backend.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationServiceImp implements EducationService {
    @Autowired
    private EducationRepository educationRepository;

    @Override
    public List<Education> listEducation() {
        return educationRepository.findAll();
    }

    @Override
    public Optional<Education> buscarEducacion(Long id) {
        Optional<Education> education = educationRepository.findById(id);
        return education;
    }
}
