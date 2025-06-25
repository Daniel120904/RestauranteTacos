package com.daniel.restauranteTacos.controller;

import com.daniel.restauranteTacos.model.TacoModel;
import com.daniel.restauranteTacos.service.TacoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tacos")
public class TacoController {

    private final TacoService service;

    @GetMapping
    public List<TacoModel> ListarTacos(){
        return service.listarTodos();
    }
}
