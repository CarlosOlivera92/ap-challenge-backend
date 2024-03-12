package com.portfolio.backend.controllers;

import com.portfolio.backend.dto.Mensaje;
import com.portfolio.backend.models.UsuarioEducacion;
import com.portfolio.backend.services.UsuarioEducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200/"} )
@RestController
@RequestMapping("/auth/userinstitutes")
public class UsuarioEducacionController {
    @Autowired
    private UsuarioEducacionService usuarioEducacionService;
    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<UsuarioEducacion> add(@RequestBody UsuarioEducacion usuarioEducacion) {
        UsuarioEducacion user = usuarioEducacionService.añadirActualizarInfo(usuarioEducacion);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/list")
    @ResponseBody
    public List<UsuarioEducacion> list(){
        return usuarioEducacionService.listAll();
    }
    @GetMapping("/list/{id}")
    @ResponseBody
    public ResponseEntity<List<UsuarioEducacion>> listById(@PathVariable Long id){
        if(!usuarioEducacionService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        UsuarioEducacion userEdu = usuarioEducacionService.getOne(id).get();
        return new ResponseEntity(userEdu, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        if(!usuarioEducacionService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        usuarioEducacionService.deleteUsuarioEducacion(id);
        return new ResponseEntity(new Mensaje("Item eliminado"), HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    @ResponseBody
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        if(!usuarioEducacionService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        UsuarioEducacion userEdu = usuarioEducacionService.getOne(id).get();
        return new ResponseEntity(userEdu, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody UsuarioEducacion usuarioEducacion){
        UsuarioEducacion userEdu =usuarioEducacionService.listBYiD(id).get();
        userEdu.setTitulo(usuarioEducacion.getTitulo());
        userEdu.setDescripcion(usuarioEducacion.getDescripcion());
        userEdu.setInstitute(usuarioEducacion.getInstitute());
        userEdu.setUsuario(usuarioEducacion.getUsuario());
        usuarioEducacionService.añadirActualizarInfo(userEdu);
        return new ResponseEntity<>(userEdu, HttpStatus.OK);
    }
}
