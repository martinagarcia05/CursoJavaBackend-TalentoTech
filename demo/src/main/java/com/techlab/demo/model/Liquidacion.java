package com.techlab.demo.model;

import com.techlab.demo.entity.ClienteEntity;
import com.techlab.demo.entity.HistorialPrecioModuloEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Liquidacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fecha;
    private double total;
    @ManyToOne
    private ClienteEntity cliente;
    @ManyToOne
    private HistorialPrecioModuloEntity  historialPrecioModulo;
}
