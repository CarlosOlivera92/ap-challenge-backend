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
    public boolean existsById(int id){
        return userRepository.existsById(id);
    }
    public void delete(int id){
        userRepository.deleteById(id);
    }
    public Optional<Usuario> getOne(int id){
        return userRepository.findById(id);
    }

}
