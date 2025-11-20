package com.techlab.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import org.apache.logging.log4j.util.Lazy;
import types.FormaPago;

import java.time.LocalDateTime;

@Entity
public class CobroEntity {
    private Long id;
    private LocalDateTime fecha;
    private double monto;
    private FormaPago formaDePago;
    private String observaciones;
    @OneToOne
    private LiquidacionEntity liquidacion;

    public CobroEntity(LocalDateTime fecha, double monto, FormaPago formaDePago, String observaciones, LiquidacionEntity liquidacion) {
        this.fecha = fecha;
        this.monto = monto;
        this.formaDePago = formaDePago;
        this.observaciones = observaciones;
        this.liquidacion = liquidacion;
    }
}
