package com.techlab.demo.repository;

import com.techlab.demo.entity.CobroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CobroRepository extends JpaRepository<CobroEntity, Integer> {
    List<CobroEntity> findByFechaAndClienteDni(LocalDateTime fecha, Integer clienteDni);
    CobroEntity findByDni(Integer dni);
    boolean deleteByDni(Integer dni);
}
