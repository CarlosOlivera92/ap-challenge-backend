package com.portfolio.backend.controllers;

import com.portfolio.backend.dto.Mensaje;
import com.portfolio.backend.models.CompaniesUsuario;
import com.portfolio.backend.services.CompaniesService;
import com.portfolio.backend.services.CompaniesUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/uerscompanies")
@CrossOrigin(origins = "http://localhost:4200/")
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
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        if(!companiesUsuarioService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        companiesUsuarioService.delete(id);
        return new ResponseEntity(new Mensaje("Item eliminado"), HttpStatus.OK);
    }
}
