package com.portfolio.backend.services;

import com.portfolio.backend.models.Companies;
import com.portfolio.backend.repository.CompaniesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompaniesServiceImp implements CompaniesService {
    @Autowired
    private CompaniesRepository repository;

    @Override
    public Companies addCompany(Companies obj) {
        return repository.save(obj);
    }

    @Override
    public List<Companies> listCompanies() {
        return repository.findAll();
    }

    @Override
    public Optional<Companies> findCompanyById(Long id) {
        Optional<Companies> companies = repository.findById(id);
        return companies;
    }
}
