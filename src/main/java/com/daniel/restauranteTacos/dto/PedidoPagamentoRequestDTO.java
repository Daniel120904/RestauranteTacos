package com.daniel.restauranteTacos.dto;

import lombok.Data;

@Data
public class PedidoPagamentoRequestDTO {
    private String pedidoId;
    private String tipoPagamentoId;
}
