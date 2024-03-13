package com.portfolio.backend.controllers;

import com.portfolio.backend.dto.Mensaje;
import com.portfolio.backend.models.CompaniesUsuario;
import com.portfolio.backend.services.CompaniesService;
import com.portfolio.backend.services.CompaniesUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"https://ap-challenge-angular.web.app"})
@RestController
@RequestMapping("/auth/uerscompanies")

public class CompaniesUsuarioController {
    @Autowired
    private CompaniesService companiesService;
    @Autowired
    private CompaniesUsuarioService companiesUsuarioService;
    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<CompaniesUsuario> add(@RequestBody CompaniesUsuario companiesUsuario) {
        CompaniesUsuario item = companiesUsuarioService.add(companiesUsuario);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }
    @GetMapping("/list")
    @ResponseBody
    public List<CompaniesUsuario> list(){
        return companiesUsuarioService.listAll();
    }
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        if(!companiesUsuarioService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        companiesUsuarioService.delete(id);
        return new ResponseEntity(new Mensaje("Item eliminado"), HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    @ResponseBody
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        if(!companiesUsuarioService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        CompaniesUsuario professions = companiesUsuarioService.getOne(id).get();
        return new ResponseEntity(professions, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody CompaniesUsuario companies){
        CompaniesUsuario userEdu = companiesUsuarioService.listByiD(id).get();
        userEdu.setPosition(companies.getPosition());
        userEdu.setDescription(companies.getDescription());
        userEdu.setCompany(companies.getCompany());
        userEdu.setUsuario(companies.getUsuario());
        companiesUsuarioService.add(userEdu);
        return new ResponseEntity<>(userEdu, HttpStatus.OK);
    }
}
