package com.techlab.demo.model;

import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class HistorialPrecioModulo {
    @Id
    private Long id;
    private LocalDateTime fecha;
    private double precio;
}
