package com.techlab.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.logging.log4j.util.Lazy;
import types.FormaPago;

import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
public class CobroEntity {
    private Long id;
    private LocalDateTime fecha;
    private double monto;
    private FormaPago formaDePago;
    private String observaciones;
    @OneToOne
    private LiquidacionEntity liquidacion;
    @OneToMany
    private ClienteEntity cliente;

    public CobroEntity(LocalDateTime fecha, double monto, FormaPago formaDePago, String observaciones, LiquidacionEntity liquidacion, ClienteEntity cliente) {
        this.fecha = fecha;
        this.monto = monto;
        this.formaDePago = formaDePago;
        this.observaciones = observaciones;
        this.liquidacion = liquidacion;
        this.cliente = cliente;
    }
}
