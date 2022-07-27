package com.portfolio.backend.models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.portfolio.backend.security.entity.Usuario;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter @EqualsAndHashCode
public class StatesTownships {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "state_id")
    States state;
    @ManyToOne
    @JoinColumn(name = "township_id")
    Townships township;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false) @JsonIncludeProperties({"id"})
    Usuario usuario;
    public StatesTownships() {

    }
}
