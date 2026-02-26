package com.techlab.demo.service;

import com.techlab.demo.entity.HistorialPrecioModuloEntity;
import com.techlab.demo.repository.HistorialPrecioModuloRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class HistorialPrecioModuloService {
    private HistorialPrecioModuloRepository historialPrecioModuloRepository;

    public HistorialPrecioModuloEntity crearPrecioModulo(HistorialPrecioModuloEntity modulo) {
        this.historialPrecioModuloRepository.save(modulo);
        return modulo;
    }

    public Optional<HistorialPrecioModuloEntity> consultarPrecioModulo(Long id){ //deberia ser paginado dinamico, a partir de una fecha
        return historialPrecioModuloRepository.findById(id);
    }

    public boolean eliminarPrecioModulo(Long id){
        Optional<HistorialPrecioModuloEntity> mod = consultarPrecioModulo(id);
        if (mod.isPresent()) {
            historialPrecioModuloRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //public boolean actualizarPrecioModulo(Long id, Optional<LocalDate> fecha, Optional<Double> precio){
      //  Optional<HistorialPrecioModuloEntity> mod = consultarPrecioModulo(id);
        //if (mod.isPresent()) {

        //}
    //}
}
