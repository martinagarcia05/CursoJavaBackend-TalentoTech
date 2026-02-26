package com.techlab.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import types.FormaPago;
import types.TipoMoneda;

import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
public class LiquidacionEntity {
    private Long id;
    private LocalDateTime fecha;
    private double totalPesos; //SE CALCULA:
    @Enumerated(EnumType.STRING)
    private TipoMoneda moneda;
    private double cantidadMoneda;
    @ManyToOne
    private ClienteEntity cliente;

    public LiquidacionEntity(LocalDateTime fecha, double total, ClienteEntity cliente, double cantidadMoneda, TipoMoneda moneda) {
        this.fecha = fecha;
        this.totalPesos = total;
        this.moneda = moneda;
        this.cantidadMoneda = cantidadMoneda;
        this.cliente = cliente;
    }
}
