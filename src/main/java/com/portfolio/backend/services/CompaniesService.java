package com.portfolio.backend.services;

import com.portfolio.backend.models.Companies;

import java.util.List;
import java.util.Optional;

public interface CompaniesService {

    public abstract Companies addCompany(Companies obj);
    public abstract List<Companies> listCompanies();

    public Optional<Companies> findCompanyById(Long id);

}
