package com.daniel.restauranteTacos.controller;


import com.daniel.restauranteTacos.model.AcompanhamentoModel;
import com.daniel.restauranteTacos.service.AcompanhamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/acompanhamentos")
public class AcompanhamentoController {

    private final AcompanhamentoService service;

    @GetMapping
    public List<AcompanhamentoModel> listarAcompanhamentos(){
        return service.listarTodos();
    }
}
