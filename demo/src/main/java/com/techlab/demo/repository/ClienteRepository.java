package com.techlab.demo.repository;

import com.techlab.demo.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClienteRepository extends JpaRepository<ClienteEntity,Integer>, JpaSpecificationExecutor<ClienteEntity> {

    public ClienteEntity findByDni(Integer dni);

}
