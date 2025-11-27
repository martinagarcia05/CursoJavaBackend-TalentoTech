package com.techlab.demo.repository;

import com.techlab.demo.entity.ClienteEntity;
import com.techlab.demo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClienteRepository extends JpaRepository<Cliente,Integer>, JpaSpecificationExecutor<Cliente> {

    public ClienteEntity findByDni(Integer dni);

}
