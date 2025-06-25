package com.daniel.restauranteTacos.dto;

import lombok.Data;
import java.util.List;

@Data
public class PedidoRequestDTO {
    private String nomeCliente;
    private List<String> tacosIds;
    private List<String> bebidasIds;
    private List<String> acompanhamentosIds;
}
