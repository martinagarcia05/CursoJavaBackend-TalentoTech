package com.techlab.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import types.TipoMoneda;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Concepto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime validoDesde;
    @Enumerated(EnumType.STRING)
    private TipoMoneda moneda;
    private double cantidad;
}
