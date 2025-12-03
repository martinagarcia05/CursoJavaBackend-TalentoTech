package com.techlab.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import types.TipoMoneda;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
public class ConceptoEntity {
    private Long id;
    private LocalDate validoDesde;
    @Enumerated(EnumType.STRING)
    private TipoMoneda moneda;
    private double cantidad;
    @ManyToOne
    private ClienteEntity cliente;

    public ConceptoEntity(LocalDateTime validoDesde, TipoMoneda moneda, double cantidad, ClienteEntity cliente) {
        this.validoDesde = validoDesde;
        this.moneda = moneda;
        this.cantidad = cantidad;
    }
}
