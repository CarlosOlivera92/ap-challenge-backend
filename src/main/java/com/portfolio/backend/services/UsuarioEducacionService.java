package com.portfolio.backend.services;

import com.portfolio.backend.models.UsuarioEducacion;

import java.util.List;
import java.util.Optional;

public interface UsuarioEducacionService {
    public abstract UsuarioEducacion añadirActualizarInfo(UsuarioEducacion obj);
    public abstract void deleteUsuarioEducacion(Long id);
    public abstract List<UsuarioEducacion> listAll();
    /*
    public abstract List<UsuarioEducacion> listByName(String filtro);

     */
    public abstract Optional<UsuarioEducacion> listBYiD(Long id);

}
