package com.techlab.demo.repository;

import com.techlab.demo.entity.CobroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CobroRepository extends JpaRepository<CobroEntity, Integer> {
    List<CobroEntity> findbyfechacontainingandclientednicontaining(LocalDateTime fecha, Integer clienteDni);
    List<CobroEntity> findbyfechacontaining(LocalDateTime fecha);
    List<CobroEntity> findbydnicontaining(Integer dni);
    CobroEntity findByDniContaining(Integer dni);
    void deleteByDniContaining(Integer dni);
}
