package com.portfolio.backend.services;

import com.portfolio.backend.models.ProjectsModel;

import java.util.List;
import java.util.Optional;

public interface ProjectsService {
    public abstract ProjectsModel add(ProjectsModel obj);
    public abstract void delete(Long id);
    public abstract List<ProjectsModel> listAll();
    /*
    public abstract List<ProjectsModel> listByName(String filtro);

     */
    Optional<ProjectsModel> getOne(Long id);

    public abstract Optional<ProjectsModel> listByiD(Long id);
    boolean existsById(Long id);
}
