package com.portfolio.backend.controllers;

import com.portfolio.backend.models.Education;
import com.portfolio.backend.services.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/institutes")
@CrossOrigin("/**")
public class InstituteController {
    @Autowired
    private EducationService educationService;



    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Education> addInstitute(@RequestBody Education institute) {
        Education institutes = educationService.addItem(institute);
        return new ResponseEntity<>(institutes, HttpStatus.OK);
    }
    @GetMapping("/list")
    @ResponseBody
    public List<Education> listEducation(){
        return educationService.listEducation();
    }
}
