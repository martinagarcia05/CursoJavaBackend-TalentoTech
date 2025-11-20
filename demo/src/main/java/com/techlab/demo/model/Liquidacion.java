package com.techlab.demo.model;

import com.techlab.demo.entity.ClienteEntity;
import com.techlab.demo.entity.HistorialPrecioModuloEntity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class Liquidacion {
    @Id
    private Long id;
    private LocalDateTime fecha;
    private double total;
    @ManyToOne
    private ClienteEntity cliente;
    @ManyToOne
    private HistorialPrecioModuloEntity  historialPrecioModulo;
}
