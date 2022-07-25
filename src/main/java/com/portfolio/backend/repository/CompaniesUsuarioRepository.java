package com.portfolio.backend.repository;

import com.portfolio.backend.models.CompaniesUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompaniesUsuarioRepository extends JpaRepository<CompaniesUsuario, Long> {
    /*
    @Query("select x from usuario_educacion x where x-nombre like :var_param")
    public abstract List<UsuarioEducacion> listByName(@Param("var_param")String name);
     */
}
