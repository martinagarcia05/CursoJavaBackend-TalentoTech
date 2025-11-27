package com.techlab.demo.model;

import com.techlab.demo.entity.LiquidacionEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import types.FormaPago;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Cobro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fecha;
    private double monto;
    private FormaPago formaDePago;
    private String observaciones;
    @OneToOne
    private LiquidacionEntity liquidacion;
}
