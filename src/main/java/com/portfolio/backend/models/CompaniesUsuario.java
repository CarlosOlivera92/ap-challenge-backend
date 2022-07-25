package com.portfolio.backend.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.portfolio.backend.security.entity.Usuario;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity @Getter @Setter @EqualsAndHashCode
public class CompaniesUsuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String position;
    private String description;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate since;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate until;
    @ManyToOne
    @JoinColumn(name = "companies_id")
    Companies company;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    Usuario usuario;

    public CompaniesUsuario() {}
    public CompaniesUsuario(Long id, String position, String description, LocalDate since, LocalDate until, Companies company, Usuario usuario) {
        this.id = id;
        this.position = position;
        this.description = description;
        this.since = since;
        this.until = until;
        this.company = company;
        this.usuario = usuario;
    }
}
