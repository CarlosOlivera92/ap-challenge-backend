package com.portfolio.backend.security.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.portfolio.backend.models.CompaniesUsuario;
import com.portfolio.backend.models.ProjectsModel;
import com.portfolio.backend.models.StatesTownships;
import com.portfolio.backend.models.UsuarioEducacion;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity @EqualsAndHashCode
public class Usuario implements Serializable {
    @Id @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter @Setter @Column(name ="nombre")
    private String nombre;
    @Getter @Setter @Column(name = "apellido")
    private String apellido;

    @Getter @Setter @Column(name ="aboutme")
    private String about;
    @NotNull @Getter @Setter @Column(name = "email")
    private String email;
    @Getter @Setter @Column(name = "telefono")
    private double telefono;
    @Getter @Setter @Column(name = "password")
    private String password;
    @Getter @Setter @Column(name = "birthday") @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthday;
    @Getter @Setter @Column(unique = true)
    private String nombreUsuario;

    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_rol", joinColumns = @JoinColumn(name = "id_User"),
    inverseJoinColumns = @JoinColumn(name = "id_rol"))
    private Set<Rol> roles = new HashSet<>();

    @Getter @Setter
    @OneToMany(mappedBy = "usuario", cascade = {
            CascadeType.PERSIST,CascadeType.MERGE
    },fetch = FetchType.LAZY)
    private Collection<UsuarioEducacion> usuarioEducacion;

    @Getter @Setter
    @OneToMany(mappedBy = "usuario", cascade = {
            CascadeType.PERSIST,CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    private Collection<CompaniesUsuario> companiesUsuarios;

    @Getter @Setter
    @OneToMany(mappedBy = "usuario", cascade = {
            CascadeType.PERSIST,CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    private Collection<StatesTownships> statesTownships;

    @Getter @Setter
    @OneToMany(mappedBy = "usuario", cascade = {
            CascadeType.PERSIST,CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    private Collection<ProjectsModel> projects;


    public Usuario() {
    }

    public Usuario(@NotNull String nombre, @NotNull String apellido, @NotNull double telefono, LocalDate birthday  , @NotNull String nombreUsuario,  @NotNull String about, @NotNull String email, @NotNull String password ) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.nombreUsuario = nombreUsuario;
        this.about = about;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

}
