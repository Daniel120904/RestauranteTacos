package com.daniel.restauranteTacos.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PedidoResponseDTO {
    private String id;
    private String nomeCliente;
    private List<String> tacos;
    private List<String> bebidas;
    private List<String> acompanhamentos;
    private double precoTotal;
    private String tipoPagamento;
    private LocalDateTime dataPagamento;
}
