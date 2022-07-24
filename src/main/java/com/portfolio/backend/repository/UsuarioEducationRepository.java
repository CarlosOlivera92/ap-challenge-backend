package com.portfolio.backend.repository;

import com.portfolio.backend.models.UsuarioEducacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioEducationRepository extends JpaRepository<UsuarioEducacion, Long> {
    /*
    @Query("select x from usuario_educacion x where x-nombre like :var_param")
    public abstract List<UsuarioEducacion> listByName(@Param("var_param")String name);
     */
}
