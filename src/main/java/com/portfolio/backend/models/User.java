package com.portfolio.backend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "usuario")
public class User {

    @Getter @Setter @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter @Setter @Column(name ="nombre")
    private String nombre;
    @Getter @Setter @Column(name = "apellido")
    private String apellido;
    @NotNull
    @Getter @Setter @Column(name = "email")
    private String email;
    @Getter @Setter @Column(name = "telefono")
    private double telefono;
    @Getter @Setter @Column(name = "password")
    private String password;
    @Getter @Setter @Column(name = "birthday")
    private Date birthday;
    @Getter @Setter @Column(unique = true)
    private String nombreUsuario;
    public User() {
    }

    public User(@NotNull String nombre, @NotNull String apellido, @NotNull double telefono, Date birthday  , @NotNull String nombreUsuario, @NotNull String email, @NotNull String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
    }
}
