package com.techlab.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import types.TipoMoneda;

import java.time.LocalDateTime;

@Entity
public class ConceptoEntity {
    private Long id;
    private LocalDateTime validoDesde;
    @Enumerated(EnumType.STRING)
    private TipoMoneda moneda;
    private double cantidad;

    public ConceptoEntity(LocalDateTime validoDesde, TipoMoneda moneda, double cantidad) {
        this.validoDesde = validoDesde;
        this.moneda = moneda;
        this.cantidad = cantidad;
    }
}
