package com.daniel.restauranteTacos.controller;

import com.daniel.restauranteTacos.model.BebidaModel;
import com.daniel.restauranteTacos.service.BebidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bebidas")
public class BebidaController {

    private final BebidaService service;

    @GetMapping
    public List<BebidaModel> listarBebidas(){
        return service.listarTodos();
    }
}

