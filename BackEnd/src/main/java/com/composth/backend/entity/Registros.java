package com.composth.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "registros")
@Data
public class Registros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fecha_inicio")
    @UpdateTimestamp
    private Date fechaInicio;

    @ManyToOne
    @JoinColumn(name = "id_supervisor", referencedColumnName = "id")
    private Supervisor supervisor;

    @ManyToOne
    @JoinColumn(name = "id_partida", referencedColumnName = "Partida")
    private Partida partida;

    @ManyToOne
    @JoinColumn(name = "id_fase", referencedColumnName = "id")
    private Fase fase;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Timestamp lastUpdated;

    @ManyToOne
    @JoinColumn(name = "last_updated_by", referencedColumnName = "id")
    private Supervisor lastUpdatedBy;
}
