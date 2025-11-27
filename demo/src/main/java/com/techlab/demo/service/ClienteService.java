package com.techlab.demo.service;

import com.techlab.demo.entity.ClienteEntity;
import com.techlab.demo.entity.ConceptoEntity;
import com.techlab.demo.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public boolean crearCliente(Integer dni, String nombre, String apellido, String mail, Integer cuit, String claveFiscalAFIP, String claveFiscalCarga, String observaciones, ConceptoEntity concepto) {
        ClienteEntity cliente = new ClienteEntity(dni, nombre, apellido, mail, cuit, claveFiscalAFIP, claveFiscalCarga, observaciones, concepto);
        return true;
    }

    public ClienteEntity consultarCliente(Integer dni){
        return clienteRepository.findByDni(dni);
    }
}
