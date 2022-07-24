package com.portfolio.backend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "educacion")
public class Education implements Serializable {
    @Getter @Setter
    @Column(name = "id_educacion")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    private String establecimiento;
    @OneToMany( mappedBy = "education",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<UsuarioEducacion> usuarioEducacion;
    public Education() {

    }
    public Education(@NotNull String establecimiento) {
        this.establecimiento = establecimiento;
    }
}
