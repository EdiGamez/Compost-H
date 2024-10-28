package com.composth.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "supervisor")
//@Getter @Setter
@Data
public class Supervisor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "password")
    private String password;

    @Column(name = "permiso")
    private Boolean permiso;

    @OneToMany(mappedBy = "supervisor", cascade = CascadeType.ALL)
    private Set<Registros> registros;

}
