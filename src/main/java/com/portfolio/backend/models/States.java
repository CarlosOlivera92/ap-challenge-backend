package com.portfolio.backend.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity @EqualsAndHashCode @Getter @Setter
public class States {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String state;
    @OneToMany( mappedBy = "state",fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,CascadeType.MERGE
    })
    private Set<StatesTownships> statesTownship;

    public States() {

    }
    public States(String state) {
        this.state = state;
    }
}
