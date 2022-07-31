package com.portfolio.backend.models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.portfolio.backend.security.entity.Usuario;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @EqualsAndHashCode
@Table(name = "projects")
public class ProjectsModel {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    private String projectName;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private String repositoryUrl;

    @Getter @Setter
    @ManyToOne @JsonIncludeProperties({"id"})
    @JoinColumn(name = "usuario_id")
    Usuario usuario;
    public ProjectsModel() {

    }

    public ProjectsModel(String projectName, String description, String repositoryUrl, Usuario usuario) {
        this.projectName = projectName;
        this.description = description;
        this.repositoryUrl = repositoryUrl;
        this.usuario = usuario;
    }


}
