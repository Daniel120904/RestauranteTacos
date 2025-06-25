package com.daniel.restauranteTacos.controller;

import com.daniel.restauranteTacos.model.TipoPagamentoModel;
import com.daniel.restauranteTacos.service.TipoPagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tipo-pagamento")
@RequiredArgsConstructor
public class TipoPagamentoController {

    private final TipoPagamentoService service;

    @GetMapping
    public List<TipoPagamentoModel> listarTodos() {
        return service.listarTodos();
    }
}
