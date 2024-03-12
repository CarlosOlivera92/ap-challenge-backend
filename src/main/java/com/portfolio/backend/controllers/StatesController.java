package com.portfolio.backend.controllers;

import com.portfolio.backend.models.States;
import com.portfolio.backend.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200/*"} )
@RestController
@RequestMapping("/auth/states")
public class StatesController {
    @Autowired
    private StateService service;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<States> addInstitute(@RequestBody States states) {
        States company = service.add(states);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }
    @GetMapping("/list")
    @ResponseBody
    public List<States> listStates(){
        return service.list();
    }
}
