package com.portfolio.backend.controllers;

import com.portfolio.backend.models.Education;
import com.portfolio.backend.models.UsuarioEducacion;
import com.portfolio.backend.security.entity.Usuario;
import com.portfolio.backend.services.EducationService;
import com.portfolio.backend.services.UsuarioEducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200/")
public class UsuarioEducacionController {
    @Autowired
    private EducationService educationService;
    @Autowired
    private UsuarioEducacionService usuarioEducacionService;

    private Education edu;
    private Usuario user;

    @GetMapping("/listareducacion")
    @ResponseBody
    public List<Education> listEducation(){
        return educationService.listEducation();
    }
    @GetMapping("/listausuarioyeducacion")
    @ResponseBody
    public List<UsuarioEducacion> listarUusuariosEducacion(){
        return usuarioEducacionService.listAll();
    }

    @PostMapping("/anadiractualizar")
    @ResponseBody
    public ResponseEntity<UsuarioEducacion> añadirActualizar(@RequestBody UsuarioEducacion usuarioEducacion) {
        UsuarioEducacion user = usuarioEducacionService.añadirActualizarInfo(usuarioEducacion);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}
