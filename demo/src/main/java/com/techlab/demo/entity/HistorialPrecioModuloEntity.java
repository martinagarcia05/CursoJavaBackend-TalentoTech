package com.techlab.demo.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
public class HistorialPrecioModuloEntity {
    private Long id;
    private LocalDateTime fecha;
    private double precio;

    public HistorialPrecioModuloEntity(LocalDateTime fecha, double precio) {
        this.fecha = fecha;
        this.precio = precio;
    }
}
