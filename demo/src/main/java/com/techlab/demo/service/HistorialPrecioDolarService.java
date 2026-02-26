package com.techlab.demo.service;

import com.techlab.demo.entity.HistorialPrecioDolarEntity;
import com.techlab.demo.repository.HistorialPrecioDolarRepository;

import java.util.Optional;

public class HistorialPrecioDolarService {
    private HistorialPrecioDolarRepository historialPrecioDolarRepository;

    public HistorialPrecioDolarEntity crearPrecioDolar(HistorialPrecioDolarEntity dolar) {
        this.historialPrecioDolarRepository.save(dolar);
        return dolar;
    }

    public Optional<HistorialPrecioDolarEntity> consultarPrecioDolar(Long id){ //deberia ser paginado dinamico, a partir de una fecha
        return historialPrecioDolarRepository.findById(id);
    }

    public boolean eliminarPrecioDolar(Long id){
        Optional<HistorialPrecioDolarEntity> mod = consultarPrecioDolar(id);
        if (mod.isPresent()) {
            historialPrecioDolarRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
