package com.portfolio.backend.controllers;

import com.portfolio.backend.dto.Mensaje;
import com.portfolio.backend.models.StatesTownships;
import com.portfolio.backend.services.StatesTownshipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/states-townships")
@CrossOrigin("https://portfolioapp-a55ab.web.app/")
public class StatesTownshipsController {
    @Autowired
    private StatesTownshipsService service;
    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<StatesTownships> add(@RequestBody StatesTownships statesTownships) {
        StatesTownships item = service.add(statesTownships);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }
    @GetMapping("/list")
    @ResponseBody
    public List<StatesTownships> list(){
        return service.listAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        service.delete(id);
        return new ResponseEntity(new Mensaje("Item eliminado"), HttpStatus.OK);
    }
}
