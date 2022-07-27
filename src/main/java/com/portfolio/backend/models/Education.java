package com.portfolio.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "institutes")
public class Education implements Serializable {
    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    private String institute;
    @OneToMany( mappedBy = "institute",fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,CascadeType.MERGE
    }) @JsonIgnore
    private Set<UsuarioEducacion> usuarioEducacion;
    public Education() {

    }
    public Education(@NotNull String establecimiento) {
        this.institute = establecimiento;
    }
}
