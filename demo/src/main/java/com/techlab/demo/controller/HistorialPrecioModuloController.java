package com.techlab.demo.controller;

import com.techlab.demo.entity.HistorialPrecioModuloEntity;
import com.techlab.demo.service.HistorialPrecioModuloService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class HistorialPrecioModuloController {
    public final HistorialPrecioModuloService historialPrecioModuloService;

    public HistorialPrecioModuloController(HistorialPrecioModuloService historialPrecioModuloService) {
        this.historialPrecioModuloService = historialPrecioModuloService;
    }

    @PostMapping("/modulo")
    public HistorialPrecioModuloEntity crearModulo(@RequestBody HistorialPrecioModuloEntity modulo){
        return historialPrecioModuloService.crearPrecioModulo(modulo);
    }

    @DeleteMapping("/modulo/{id}")
    public boolean eliminarPrecioModulo(@PathVariable Long id){
        return historialPrecioModuloService.eliminarPrecioModulo(id);
    }

    @GetMapping("/modulo/{id}")
    public Optional<HistorialPrecioModuloEntity> obtenerPrecioModulo(@PathVariable Long id){
        return historialPrecioModuloService.consultarPrecioModulo(id);
    }
}
