package com.portfolio.backend.controllers;

import com.portfolio.backend.dto.Mensaje;
import com.portfolio.backend.models.UsuarioEducacion;
import com.portfolio.backend.services.UsuarioEducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/userinstitutes")
@CrossOrigin(origins = "http://localhost:4200/")
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
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        if(!usuarioEducacionService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        usuarioEducacionService.deleteUsuarioEducacion(id);
        return new ResponseEntity(new Mensaje("Item eliminado"), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody UsuarioEducacion usuarioEducacion){
        UsuarioEducacion educacion = usuarioEducacionService.listBYiD(id).get();
        educacion.setInstitute(educacion.getInstitute());
        educacion.setTitulo(educacion.getTitulo());
        educacion.setUsuario(educacion.getUsuario());
        educacion.setDescripcion(educacion.getDescripcion());
        usuarioEducacionService.añadirActualizarInfo(educacion);
        return new ResponseEntity(new Mensaje("Item actualizado"), HttpStatus.OK);
    }
}
