package com.techlab.demo.controller;

import com.techlab.demo.entity.ClienteEntity;
import com.techlab.demo.model.Cliente;
import com.techlab.demo.service.ClienteService;
import jakarta.annotation.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //Endpoints:
    @PostMapping("/cliente")
    public Boolean crearCliente(@RequestBody ClienteEntity cliente){
        clienteService.crearCliente(cliente.getDni(), cliente.getNombre(), cliente.getApellido(), cliente.getMail(), cliente.getCuit(), cliente.getClaveFiscalAFIP(), cliente.getClaveFiscalCarga(), cliente.getObservaciones(), cliente.getConcepto());
        return true;
    }

    @DeleteMapping("/cliente/{dni}")
    public Boolean eliminarCliente(@PathVariable Integer dni){
        clienteService.eliminarCliente(dni);
        return true;
    }

    @GetMapping("/clientes/{dni}")
    public ClienteEntity obtenerCliente(@PathVariable Integer dni){
        return clienteService.consultarCliente(dni);
    }

    @PostMapping("/clientes") //lleva id??
    public Boolean actualizarCliente(@RequestBody ClienteEntity cliente){
        clienteService.actualizarCliente(cliente.getDni(), cliente.getNombre().describeConstable(), cliente.getApellido().describeConstable(), cliente.getMail().describeConstable(), cliente.getCuit().describeConstable(), cliente.getClaveFiscalAFIP().describeConstable(), cliente.getClaveFiscalCarga().describeConstable(), cliente.getObservaciones().describeConstable());
        return true;
    }
}
