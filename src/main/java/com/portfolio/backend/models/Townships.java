package com.portfolio.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@EqualsAndHashCode
@Getter
@Setter

public class Townships {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String township;
    @OneToMany( mappedBy = "township",fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,CascadeType.MERGE
    }) @JsonIgnore
    private Set<StatesTownships> statesTownship;

    public Townships() {

    }
    public Townships(String township) {
        this.township = township;
    }
}
