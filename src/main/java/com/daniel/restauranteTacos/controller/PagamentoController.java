package com.daniel.restauranteTacos.controller;

import com.daniel.restauranteTacos.model.PagamentoModel;
import com.daniel.restauranteTacos.service.PagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pagamento")
public class PagamentoController {

    private final PagamentoService service;

    @GetMapping
    public List<PagamentoModel> ListarPagamentos(){
        return service.listarPagamentos();
    }
}
