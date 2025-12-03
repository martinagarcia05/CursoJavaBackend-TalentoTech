package com.techlab.demo.service;

import com.techlab.demo.entity.CobroEntity;
import com.techlab.demo.repository.CobroRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class CobroService {
    private CobroRepository cobroRepository;

    public CobroEntity crearCobro(CobroEntity cobro) {
        this.cobroRepository.save(cobro);
        return cobro;
    }

    public List<CobroEntity> consultarCobro(LocalDateTime fecha, Integer dni) {
        if (fecha != null && dni != null) {
            return cobroRepository.findbyfechacontainingandclientednicontaining(fecha, dni);
        } else if (fecha != null) {
            return cobroRepository.findbyfechacontaining(fecha);
        } else if (dni != null) {
            return cobroRepository.findbydnicontaining(dni);
        }
        return null;

    } //filtro por fecha y dni

    public boolean eliminarCobro(Integer dni) {
       cobroRepository.deleteByDniContaining(dni);
       return true;
    }

    //no es encesario el actualizar
}
