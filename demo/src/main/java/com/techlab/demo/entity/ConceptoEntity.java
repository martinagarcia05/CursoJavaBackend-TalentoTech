package com.techlab.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.mapping.ToOne;
import types.TipoMoneda;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
public class ConceptoEntity {
    private Long id;
    private double totalAdicionalPesos;
    @OneToOne(cascade = CascadeType.ALL)
    private LiquidacionEntity liquidacion;

    public ConceptoEntity(double adicinal, LiquidacionEntity liquidacion) {
        this.totalAdicionalPesos = adicinal;
        this.liquidacion = liquidacion;
    }
}
