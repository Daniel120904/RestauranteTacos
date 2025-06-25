package com.daniel.restauranteTacos.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bebidas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BebidaModel implements ItemPedido {

    @Id
    private String id;

    private String Descricao;
    private double preco;

    @Override
    public String getDescricao() {
        return Descricao;
    }

    @Override
    public double getPreco() {
        return preco;
    }
}
