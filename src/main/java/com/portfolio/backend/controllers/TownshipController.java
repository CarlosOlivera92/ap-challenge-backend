package com.portfolio.backend.controllers;

import com.portfolio.backend.models.Townships;
import com.portfolio.backend.services.TownshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/townships")
@CrossOrigin(origins = "http://localhost:4200/")
public class TownshipController {
    @Autowired
    private TownshipService service;
    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Townships> add(@RequestBody Townships townships) {
        Townships township = service.add(townships);
        return new ResponseEntity<>(township, HttpStatus.OK);
    }
    @GetMapping("/list")
    @ResponseBody
    public List<Townships> list(){
        return service.list();
    }
}