package com.techlab.demo.model;

import com.techlab.demo.entity.LiquidacionEntity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import types.FormaPago;

import java.time.LocalDateTime;

public class Cobro {
    @Id
    private Long id;
    private LocalDateTime fecha;
    private double monto;
    private FormaPago formaDePago;
    private String observaciones;
    @OneToOne
    private LiquidacionEntity liquidacion;
}
