package com.techlab.demo.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import types.TipoMoneda;

import java.time.LocalDateTime;

public class Concepto {
    @Id
    private Long id;
    private LocalDateTime validoDesde;
    @Enumerated(EnumType.STRING)
    private TipoMoneda moneda;
    private double cantidad;
}
