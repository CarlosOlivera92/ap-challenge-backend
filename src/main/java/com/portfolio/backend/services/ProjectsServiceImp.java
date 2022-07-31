package com.portfolio.backend.services;

import com.portfolio.backend.models.ProjectsModel;
import com.portfolio.backend.repository.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectsServiceImp implements ProjectsService {
    @Autowired
    private ProjectsRepository repository;

    @Override
    public ProjectsModel add(ProjectsModel obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
    @Override
    public Optional<ProjectsModel> getOne(Long id){
        return repository.findById(id);
    }


    @Override
    public List<ProjectsModel> listAll() {
        return repository.findAll();
    }
    /*
    @Override
    public List<CompaniesUsuario> listByName(String filtro) {
        return repository.listByName(filtro);
    }

     */

    @Override
    public Optional<ProjectsModel> listByiD(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
