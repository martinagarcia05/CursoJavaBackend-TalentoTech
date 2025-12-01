package com.techlab.demo.controller;

import com.techlab.demo.entity.CobroEntity;
import com.techlab.demo.service.CobroService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CobroController {
    private CobroService cobroService;

    @PostMapping("/cobro")
    public CobroEntity crearCobro(@RequestBody CobroEntity cobroEntity){
        return cobroService.crearCobro(cobroEntity);
    }
}
