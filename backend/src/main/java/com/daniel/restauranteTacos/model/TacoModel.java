package com.daniel.restauranteTacos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tacos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TacoModel implements ItemPedido {

    @Id
    private String id;

    private String descricao;
    private double preco;

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public double getPreco() {
        return preco;
    }
}

