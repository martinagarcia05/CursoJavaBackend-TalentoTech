package com.techlab.demo.service;

import com.techlab.demo.entity.ClienteEntity;
import com.techlab.demo.entity.ConceptoEntity;
import com.techlab.demo.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public boolean crearCliente(Integer dni, String nombre, String apellido, String mail, Integer cuit, String claveFiscalAFIP, String claveFiscalCarga, String observaciones, ConceptoEntity concepto) {
        ClienteEntity cliente = new ClienteEntity(dni, nombre, apellido, mail, cuit, claveFiscalAFIP, claveFiscalCarga, observaciones, concepto);
        return true;
    }

    public ClienteEntity consultarCliente(Integer dni){ //devuelve cliente
        return clienteRepository.findByDni(dni);
    }

    public Long  obtenerIdCliente(Integer dni){ //devuelve id
        return clienteRepository.findById(dni).get().getId();
    }

    public boolean eliminarCliente(Integer dni){
        ClienteEntity cli = consultarCliente(dni);
        if (cli != null) {
            clienteRepository.deleteById(Math.toIntExact(cli.getId()));
            return true;
        }
        return false;
    }

    public boolean actualizarCliente(Integer dni, Optional<String> nombre, Optional<String> apellido, Optional<String> mail, Optional<Integer> cuit, Optional<String> claveFiscalAFIP, Optional<String> claveFiscalCarga, Optional<String> observaciones){
        ClienteEntity cli = consultarCliente(dni);
        if (cli != null) {
            cli.setNombre(nombre.orElse(cli.getNombre()));
            cli.setApellido(apellido.orElse(cli.getApellido()));
            cli.setMail(mail.orElse(cli.getMail()));
            cli.setCuit(cuit.orElse(cli.getCuit()));
            cli.setClaveFiscalAFIP(claveFiscalAFIP.orElse(cli.getClaveFiscalAFIP()));
            cli.setObservaciones(observaciones.orElse(cli.getObservaciones()));
            cli.setClaveFiscalCarga(claveFiscalCarga.orElse(cli.getClaveFiscalCarga()));
            return true;
        }
        return false;
    }

}
