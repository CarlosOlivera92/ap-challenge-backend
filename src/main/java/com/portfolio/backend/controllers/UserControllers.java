package com.portfolio.backend.controllers;

import com.portfolio.backend.dto.Mensaje;
import com.portfolio.backend.models.User;
import com.portfolio.backend.repository.UserRepository;
import com.portfolio.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200/")

public class UserControllers {
    @Autowired
    UserService userService;
    UserRepository userRepository;

    @GetMapping("/lista")
    public ResponseEntity<List<User>> list(){
        List<User> list = userService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/lista/{id}")
    public ResponseEntity<List<User>> getUserById(@PathVariable Long id){
        if(!userService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        User producto = userService.getOne(id).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        if(!userService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        userService.delete(id);
        return new ResponseEntity(new Mensaje("Usuario eliminado"), HttpStatus.OK);
    }
}
