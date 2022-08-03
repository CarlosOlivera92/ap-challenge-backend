package com.portfolio.backend.services;

import com.portfolio.backend.repository.UserRepository;
import com.portfolio.backend.security.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService
{
    @Autowired
    UserRepository userRepository;

    public List<Usuario> list() {
        return userRepository.findAll();
    }
    public Optional<Usuario> findById(Long id) {
        return userRepository.findById(id);
    }
    public Usuario save(Usuario usuario){
        return userRepository.save(usuario);
    }

    public boolean existsById(Long id){
        return userRepository.existsById(id);
    }
    public void delete(Long id){
        userRepository.deleteById(id);
    }
    public Optional<Usuario> getOne(Long id){
        return userRepository.findById(id);
    }

}
