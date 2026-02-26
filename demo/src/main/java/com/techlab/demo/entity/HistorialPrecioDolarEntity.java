package com.techlab.demo.entity;

import java.time.LocalDateTime;

public class HistorialPrecioDolarEntity {
    private Long id;
    private LocalDateTime fecha;
    private double precio;

    public HistorialPrecioDolarEntity(LocalDateTime fecha, double precio) {
        this.fecha = fecha;
        this.precio = precio;
    }
}
