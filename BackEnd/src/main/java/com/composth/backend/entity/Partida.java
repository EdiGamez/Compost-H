package com.composth.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "partida")
@Data
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Partida")
    private String partida;

    @Column(name = "Urea")
    private BigDecimal urea;

    @Column(name = "Pollinaza")
    private BigDecimal pollinaza;

    @Column(name = "Harinolina")
    private BigDecimal harinolina;

    @Column(name = "Yeso")
    private BigDecimal yeso;

    @Column(name = "Nit_Teorico")
    private BigDecimal nitTeorico;

    @Column(name = "Total_BS")
    private BigDecimal totalBs;

    @Column(name = "TON_Pollo_BH")
    private BigDecimal tonPolloBh;

    @Column(name = "m3_Vuelta_1")
    private BigDecimal m3Vuelta1;

    @Column(name = "m3_Vuelta_2")
    private BigDecimal m3Vuelta2;

    @Column(name = "m3_Vuelta_3")
    private BigDecimal m3Vuelta3;

    @Column(name = "Humedad_Final")
    private BigDecimal humedadFinal;

    @Column(name = "m3_Vuelta_4")
    private BigDecimal m3Vuelta4;

    @Column(name = "Porc_Humedad_Vueltas")
    private BigDecimal porcHumedadVueltas;

    @Column(name = "BH_LL1")
    private BigDecimal bhLl1;

    @Column(name = "BS_LL1")
    private BigDecimal bsLl1;

    @Column(name = "Humedad_LL1")
    private BigDecimal humedadLl1;

    @Column(name = "BH_LL2")
    private BigDecimal bhLl2;

    @Column(name = "BS_LL2")
    private BigDecimal bsLl2;

    @Column(name = "m3_Ton_LL2")
    private BigDecimal m3TonLl2;

    @Column(name = "BH_LL3")
    private BigDecimal bhLl3;

    @Column(name = "BS_LL3")
    private BigDecimal bsLl3;

    @Column(name = "m3_Ton_LL3")
    private BigDecimal m3TonLl3;

    @OneToMany(mappedBy = "partida", cascade = CascadeType.ALL)
    private Set<Registros> registros;

}
