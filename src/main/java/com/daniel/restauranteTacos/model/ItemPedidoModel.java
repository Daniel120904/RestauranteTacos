package com.daniel.restauranteTacos.model;

import com.daniel.restauranteTacos.enums.TipoItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoModel {
    private String idItem;
    private String descricao;
    private double precoUnitario;
    private int quantidade;
    private TipoItem tipo;

    public double getSubtotal() {
        return precoUnitario * quantidade;
    }
}
