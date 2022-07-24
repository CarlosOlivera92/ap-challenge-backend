package com.portfolio.backend.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable @Getter @Setter @EqualsAndHashCode
public class UsuarioEducacionKey implements Serializable {
    @Column(name = "usuario_id")
    Long usuarioId;

    @Column(name = "educacion_id_educacion")
    Long educacionId;
}
