package com.techlab.demo.service;

import com.techlab.demo.entity.ClienteEntity;
import com.techlab.demo.entity.ConceptoEntity;
import com.techlab.demo.repository.ConceptoRepository;
import org.springframework.stereotype.Service;
import types.TipoMoneda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConceptoService {
    private ConceptoRepository conceptoRepository;

    public ConceptoEntity crearConcepto(ConceptoEntity conceptoEntity) {
        return conceptoRepository.save(conceptoEntity);
    }

    public ConceptoEntity consultarConceptoActualByDni(Integer dni) {
        if (dni != null) {
            ClienteService clienteService = new ClienteService();
            ClienteEntity cliente = clienteService.consultarCliente(dni);
            List<ConceptoEntity> historialConceptos = conceptoRepository.findByClienteContaining(cliente);
            ConceptoEntity actual = historialConceptos.get(0);
            for (ConceptoEntity concepto : historialConceptos) {
                if (concepto.getValidoDesde().isAfter(actual.getValidoDesde())) {
                    actual = concepto;
                }
            }
            return actual;
        }
        return null;
    }

    public ConceptoEntity actualizarConcepto(Long id, ConceptoEntity dataToEdit) {
        ConceptoEntity concepto = conceptoRepository.findById(id).orElse(null);
        if (concepto != null) {
            if (dataToEdit.getValidoDesde() != null) {
                concepto.setValidoDesde(dataToEdit.getValidoDesde());
            }
            if (dataToEdit.getMoneda() != null) {
                concepto.setMoneda(dataToEdit.getMoneda());
            }
            if (dataToEdit.getCantidad() !== null) {
                concepto.setCantidad(dataToEdit.getCantidad());
            }
            if (dataToEdit.getCliente() != null) {
                concepto.setCliente(dataToEdit.getCliente());
            }
            conceptoRepository.save(concepto);
            return concepto;
        }
        return null;
    }

    public void eliminarConcepto(Long id) {
        ConceptoEntity concepto = conceptoRepository.findById(id).orElse(null);
        if (concepto != null) {
            conceptoRepository.delete(concepto);
        }
    }
}
