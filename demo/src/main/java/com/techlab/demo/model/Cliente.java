package com.techlab.demo.model;

import com.techlab.demo.entity.ConceptoEntity;
import com.techlab.demo.entity.LiquidacionEntity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import types.EstadoCliente;

import java.util.List;

public class Cliente {
    @Id
    private Long id;
    private Integer dni;
    private String nombre;
    private String apellido;
    private String mail;
    private Integer cuit;
    private String claveFiscalAFIP;
    private String claveFiscalCarga;
    private String observaciones;
    @OneToMany
    private ConceptoEntity concepto;
    @OneToMany
    private List<LiquidacionEntity> liquidaciones;
    private EstadoCliente estado;
}
