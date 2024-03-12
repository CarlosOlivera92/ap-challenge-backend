package com.portfolio.backend.controllers;

import com.portfolio.backend.dto.Mensaje;
import com.portfolio.backend.exceptions.ResourceNotFoundException;
import com.portfolio.backend.security.entity.Usuario;
import com.portfolio.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200/*"} )
@RestController
@RequestMapping("/auth/users")
public class UserControllers {
    @Autowired
    UserService userService;

    @GetMapping("/list")
    public ResponseEntity<List<Usuario>> list(){
        List<Usuario> list = userService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }
    @GetMapping("/list/{id}")
    public ResponseEntity<List<Usuario>> getUserById(@PathVariable Long id){
        if(!userService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Usuario producto = userService.getOne(id).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Usuario> actualizarEmpleado(@PathVariable("id")Long id,@RequestBody Usuario user){
        Usuario usuario = userService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el usuario con el ID : " + id));

        usuario.setNombre(user.getNombre());
        usuario.setApellido(user.getApellido());
        usuario.setAbout(user.getAbout());
        usuario.setBirthday(user.getBirthday());

        Usuario userUpdated = userService.save(usuario);
        return ResponseEntity.ok(userUpdated);
    }
    @PutMapping("/updateImg/{id}")
    public ResponseEntity<Usuario> updateProfilePic(@PathVariable("id")Long id,@RequestBody Usuario user){
        Usuario usuario = userService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el usuario con el ID : " + id));

        usuario.setProfileUrl(user.getProfileUrl());

        Usuario userUpdated = userService.save(usuario);
        return ResponseEntity.ok(userUpdated);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        if(!userService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        userService.delete(id);
        return new ResponseEntity(new Mensaje("Usuario eliminado"), HttpStatus.OK);
    }
}
