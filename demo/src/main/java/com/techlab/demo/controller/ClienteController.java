package com.techlab.demo.controller;

import com.techlab.demo.model.Cliente;
import com.techlab.demo.service.ClienteService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //Endpoints:
    @PostMapping("/cliente")
    public Boolean crearCliente(@RequestBody Cliente cliente){
        //clienteService.crearCliente()
        return true;
    }

    @DeleteMapping("/cliente/{id}")
    public Boolean eliminarCliente(@PathVariable int id){
        //buscar x id y hacer set estado: INACTIVO
        return true;
    }

    //@GetMapping("/clientes/{id}")
    //public Cliente obtenerClientePorId(@PathVariable int id){
        //Cliente cliente = clienteService.buscarPorId(id);
        //verificar q no sea null
    //}

    @PostMapping("/clientes/{id}") //lleva id??
    public Boolean actualizarCliente(@RequestBody Cliente cliente){
        return true;
    }
}
