package com.portfolio.backend.security.controller;

import com.portfolio.backend.dto.Mensaje;
import com.portfolio.backend.security.dto.JwtDto;
import com.portfolio.backend.security.dto.LoginUsuario;
import com.portfolio.backend.security.dto.NuevoUsuario;
import com.portfolio.backend.security.entity.Rol;
import com.portfolio.backend.security.entity.Usuario;
import com.portfolio.backend.security.enums.RolNombre;
import com.portfolio.backend.security.jwt.JwtProvider;
import com.portfolio.backend.security.repository.UsuarioRepository;
import com.portfolio.backend.security.service.RolService;
import com.portfolio.backend.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = {"https://ap-challenge-angular.web.app"})
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioRepository repository;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity(new Mensaje("Campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
            }
            if (usuarioService.existsByEmail(nuevoUsuario.getEmail())) {
                return new ResponseEntity(new Mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);
            }
            Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getApellido(), nuevoUsuario.getTelefono(), nuevoUsuario.getBirthday(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getAbout(), nuevoUsuario.getProfileUrl(), nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));
            Set<Rol> roles = new HashSet<>();
            rolService.getByRolNombre(RolNombre.ROLE_USER).ifPresent(roles::add);
            if (nuevoUsuario.getRoles().contains("admin")) {
                rolService.getByRolNombre(RolNombre.ROLE_ADMIN).ifPresent(roles::add);
            }
            usuario.setRoles(roles);
            usuarioService.save(usuario);
            return new ResponseEntity(new Mensaje("Usuario guardado"), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error al procesar la solicitud: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);
            }
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getEmail(), loginUsuario.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateToken(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Optional<Usuario> user = usuarioService.getByEmail(loginUsuario.getEmail());
            JwtDto jwtDto = new JwtDto(jwt, loginUsuario.getEmail(), userDetails.getAuthorities(), user);
            return new ResponseEntity(jwtDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error al procesar la solicitud: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
