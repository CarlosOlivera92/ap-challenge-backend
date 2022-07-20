package com.portfolio.backend.security.repository;

import com.portfolio.backend.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findUserByEmail(String email);
    boolean existsByEmail(String email);

}
