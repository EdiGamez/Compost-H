package com.composth.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "fase")
@Data
public class Fase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fase")
    private String fase;
    @OneToMany(mappedBy = "fase", cascade = CascadeType.ALL)
    private Set<Registros> registros;
}
