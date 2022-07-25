package com.portfolio.backend.models;

import com.portfolio.backend.security.entity.Usuario;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "institutes_usuario")
@Getter @Setter @EqualsAndHashCode
public class UsuarioEducacion implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo = " ";

    private String descripcion = "";

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "institutes_id")
    Education institute;

    public UsuarioEducacion() {
    }
    public UsuarioEducacion(String titulo, String descripcion, Usuario usuario, Education institute) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.institute = institute;
    }

}
