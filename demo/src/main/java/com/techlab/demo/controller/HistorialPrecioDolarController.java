package com.techlab.demo.controller;

import com.techlab.demo.entity.HistorialPrecioDolarEntity;
import com.techlab.demo.service.HistorialPrecioDolarService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class HistorialPrecioDolarController {
    public final HistorialPrecioDolarService historialPrecioDolarService;

    public HistorialPrecioDolarController(HistorialPrecioDolarService historialPrecioDolarService) {
        this.historialPrecioDolarService = historialPrecioDolarService;
    }

    @PostMapping("/dolar")
    public HistorialPrecioDolarEntity crearModulo(@RequestBody HistorialPrecioDolarEntity modulo){
        return historialPrecioDolarService.crearPrecioDolar(modulo);
    }

    @DeleteMapping("/dolar/{id}")
    public boolean eliminarPrecioDolar(@PathVariable Long id){
        return historialPrecioDolarService.eliminarPrecioDolar(id);
    }

    @GetMapping("/dolar/{id}")
    public Optional<HistorialPrecioDolarEntity> obtenerPrecioDolar(@PathVariable Long id){
        return historialPrecioDolarService.consultarPrecioDolar(id);
    }
}
