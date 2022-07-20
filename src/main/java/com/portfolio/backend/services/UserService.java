package com.portfolio.backend.services;

import com.portfolio.backend.models.User;
import com.portfolio.backend.repository.UserRepository;
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

    public List<User> list() {
        return userRepository.findAll();
    }
    public boolean existsById(Long id){
        return userRepository.existsById(id);
    }
    public void delete(Long id){
        userRepository.deleteById(id);
    }
    public Optional<User> getOne(Long id){
        return userRepository.findById(id);
    }

}
