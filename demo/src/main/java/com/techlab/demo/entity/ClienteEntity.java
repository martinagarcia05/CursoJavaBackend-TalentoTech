package com.techlab.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import types.EstadoCliente;

import java.util.List;

@Entity
@Setter
@Getter
@ToString
public class ClienteEntity {
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
    private List<LiquidacionEntity> liquidaciones;
    private EstadoCliente estado;

    // metodo constructor
    public ClienteEntity(int dniC, String nombreC, String apellidoC, String mailC, Integer cuitC, String claveFiscalAFIPC, String claveFiscalCargaC, String observacionesC) {
        dni = dniC;
        nombre = nombreC;
        apellido = apellidoC;
        mail = mailC;
        cuit = cuitC;
        claveFiscalAFIP = claveFiscalAFIPC;
        claveFiscalCarga = claveFiscalCargaC;
        observaciones = observacionesC;
        estado = EstadoCliente.ACTIVO;
    }
}