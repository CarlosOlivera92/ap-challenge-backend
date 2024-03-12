package com.portfolio.backend.controllers;

import com.portfolio.backend.models.Companies;
import com.portfolio.backend.services.CompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200/*"})
@RestController
@RequestMapping("/auth/companies")
public class CompanyController {
    @Autowired
    private CompaniesService companiesService;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Companies> addInstitute(@RequestBody Companies companies) {
        Companies company = companiesService.addCompany(companies);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }
    @GetMapping("/list")
    @ResponseBody
    public List<Companies> listCompanies(){
        return companiesService.listCompanies();
    }
}
