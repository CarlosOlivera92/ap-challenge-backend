package com.portfolio.backend.models;

import com.portfolio.backend.security.entity.Usuario;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "educacion_usuario")
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
    @JoinColumn(name = "educacion_id_educacion")
    Education education;

    public UsuarioEducacion() {
    }


    public UsuarioEducacion(String titulo, String descripcion, Usuario usuario, Education education) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.education = education;
    }

    public UsuarioEducacion(String titulo, String descripcion, List<Education> educacion, List<Usuario> usuario) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
