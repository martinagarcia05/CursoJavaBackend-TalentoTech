package com.techlab.demo.repository;

import com.techlab.demo.entity.ClienteEntity;
import com.techlab.demo.entity.ConceptoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConceptoRepository extends JpaRepository<ConceptoEntity, Long> {
    List<ConceptoEntity> findByClienteContaining(ClienteEntity cliente);
}
