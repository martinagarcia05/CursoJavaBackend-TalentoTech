package com.techlab.demo.controller;

import com.techlab.demo.entity.ConceptoEntity;
import com.techlab.demo.service.ConceptoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ConceptoController {
    public final ConceptoService conceptoService;
    public ConceptoController(ConceptoService conceptoService) {
        this.conceptoService = conceptoService;
    }

    @PostMapping("/concepto")
    public ConceptoEntity crearConcepto(@RequestBody ConceptoEntity conceptoEntity) {
        return conceptoService.crearConcepto(conceptoEntity);
    }

    @GetMapping("/concepto/{dni}")
    public ConceptoEntity consultarConcepto(@PathVariable("dni") Integer dni) {
        return conceptoService.consultarConceptoActualByDni(dni);
    }

    @PutMapping("/concepto/{id}")
    public ConceptoEntity actuailizarConcepto(@PathVariable("id") Long id,  @RequestBody ConceptoEntity dataToEdit) {
        return conceptoService.actualizarConcepto(id, dataToEdit);
    }

    @DeleteMapping("/concepto/{id}")
    public void eliminarConcepto(@PathVariable Long id) {
        conceptoService.eliminarConcepto(id);
    }
}
