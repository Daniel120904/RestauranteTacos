package com.daniel.restauranteTacos.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "pedidos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoModel {

    @Id
    private String id;
    private String nomeCliente;
    private List<ItemPedidoModel> itens;
    private double valorTotal;
    private PagamentoModel pagamento;

    public void calcularValorTotal() {
        this.valorTotal = itens.stream()
                .mapToDouble(ItemPedidoModel::getSubtotal)
                .sum();
    }
}
