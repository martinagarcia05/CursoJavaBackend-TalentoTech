package com.techlab.demo.controller;

import com.techlab.demo.entity.CobroEntity;
import com.techlab.demo.service.CobroService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

public class CobroController {
    private CobroService cobroService;

    @PostMapping("/cobro")
    public CobroEntity crearCobro(@RequestBody CobroEntity cobroEntity){
        return cobroService.crearCobro(cobroEntity);
    }

    @GetMapping("/cobro")
    public List<CobroEntity> consultarCobro(@RequestParam(required = false) LocalDateTime fecha, @RequestParam(required = false) Integer dni) {
        return cobroService.consultarCobro(fecha, dni);
    }

    @DeleteMapping("/cobro/{dni}")
    public boolean eliminarCobro(@PathVariable Integer dni) {
        return cobroService.eliminarCobro(dni);
    }

}
