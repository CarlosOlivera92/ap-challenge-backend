package com.portfolio.backend.controllers;

import com.portfolio.backend.dto.Mensaje;
import com.portfolio.backend.models.ProjectsModel;
import com.portfolio.backend.services.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"https://portfolioapp-a55ab.web.app", "https://pacific-retreat-26374.herokuapp.com/**, https://pacific-retreat-26374.herokuapp.com"} )
@RestController
@RequestMapping("/auth/projects")
public class ProjectsController {
    @Autowired
    private ProjectsService projectsService;
    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<ProjectsModel> add(@RequestBody ProjectsModel project) {
        ProjectsModel item = projectsService.add(project);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }
    @GetMapping("/list")
    @ResponseBody
    public List<ProjectsModel> list(){
        return projectsService.listAll();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        if(!projectsService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        projectsService.delete(id);
        return new ResponseEntity(new Mensaje("Item eliminado"), HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        if(!projectsService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        ProjectsModel professions = projectsService.getOne(id).get();
        return new ResponseEntity(professions, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody ProjectsModel projects){
        ProjectsModel project = projectsService.listByiD(id).get();
        project.setProjectName(projects.getProjectName());
        project.setDescription(projects.getDescription());
        project.setRepositoryUrl(projects.getRepositoryUrl());
        project.setUsuario(projects.getUsuario());
        projectsService.add(project);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }
}
