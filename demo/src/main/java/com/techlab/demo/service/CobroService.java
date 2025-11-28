package com.techlab.demo.service;

import com.techlab.demo.entity.ClienteEntity;
import com.techlab.demo.entity.CobroEntity;
import com.techlab.demo.entity.LiquidacionEntity;
import com.techlab.demo.repository.CobroRepository;
import org.springframework.stereotype.Service;
import types.FormaPago;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class CobroService {
    private CobroRepository cobroRepository;

    public CobroEntity crearCobro(LocalDateTime fecha, double monto, FormaPago formaDePago, String observaciones, LiquidacionEntity liquidacion, ClienteEntity cliente) {
        CobroEntity cobro = new CobroEntity(fecha, monto, formaDePago, observaciones, liquidacion, cliente);
        return cobro;
    }

    public List<CobroEntity> consultarCobro(LocalDateTime fecha, Integer dni) {
        return cobroRepository.findByFechaAndClienteDni(fecha, dni);
    } //filtro por fecha y dni

    public boolean eliminarCobro(Integer dni) {
       cobroRepository.deleteByDni(dni);
       return true;
    }

    //no es encesario el actualizar
}
