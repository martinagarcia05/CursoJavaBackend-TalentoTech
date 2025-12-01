package com.techlab.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import types.FormaPago;

import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
public class LiquidacionEntity {
    private Long id;
    private LocalDateTime fecha;
    private double total; //SE CALCULA:
    //PARA DOLARES O PESOS: cantidad de concepto
    //PARA MODULOS: cantidad en concepto * (último) precio en preciomensualxmodulo
    @ManyToOne
    private ClienteEntity cliente;
    @ManyToOne
    private HistorialPrecioModuloEntity historialPrecioModulo;
    //debería conocer el concepto?

    public LiquidacionEntity(LocalDateTime fecha, double total, ClienteEntity cliente, HistorialPrecioModuloEntity historialPrecioModulo) {
        this.fecha = fecha;
        this.total = total;
        this.cliente = cliente;
        this.historialPrecioModulo = historialPrecioModulo;
    }
}
