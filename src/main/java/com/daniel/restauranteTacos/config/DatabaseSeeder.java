package com.daniel.restauranteTacos.config;

import com.daniel.restauranteTacos.model.AcompanhamentoModel;
import com.daniel.restauranteTacos.model.BebidaModel;
import com.daniel.restauranteTacos.model.TacoModel;
import com.daniel.restauranteTacos.model.TipoPagamentoModel;
import com.daniel.restauranteTacos.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import java.util.List;

@Component
public class DatabaseSeeder {

    @Autowired
    private TacoRepository tacoRepository;

    @Autowired
    private BebidaRepository bebidaRepository;

    @Autowired
    private AcompanhamentoRepository acompanhamentoRepository;

    @Autowired
    private TipoPagamentoRepository tipoPagamentoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostConstruct
    public void seedDatabase() {

        tacoRepository.deleteAll();
        bebidaRepository.deleteAll();
        acompanhamentoRepository.deleteAll();
        tipoPagamentoRepository.deleteAll();
        pagamentoRepository.deleteAll();
        pedidoRepository.deleteAll();


        tacoRepository.saveAll(List.of(
                new TacoModel(null, "Taco de Carne", 10.0),
                new TacoModel(null, "Taco de Frango", 9.0),
                new TacoModel(null, "Taco Carnitas", 11.0),
                new TacoModel(null, "Taco Al Pastor", 12.0)
        ));

        bebidaRepository.saveAll(List.of(
                new BebidaModel(null, "Guaraná", 5.0),
                new BebidaModel(null, "Coca-Cola", 6.0),
                new BebidaModel(null, "Suco de Laranja", 7.0),
                new BebidaModel(null, "Água", 3.0),
                new BebidaModel(null, "Tequila", 10.0)
        ));

        acompanhamentoRepository.saveAll(List.of(
                new AcompanhamentoModel(null, "Pimenta", 1.0),
                new AcompanhamentoModel(null, "Limão", 0.5),
                new AcompanhamentoModel(null, "Cebola", 1.0),
                new AcompanhamentoModel(null, "Guacamole", 2.0)
        ));

        tipoPagamentoRepository.saveAll(List.of(
                new TipoPagamentoModel(null, "Dinheiro"),
                new TipoPagamentoModel(null, "Cartão de Crédito"),
                new TipoPagamentoModel(null, "Cartão de Débito"),
                new TipoPagamentoModel(null, "Pix")
        ));


        System.out.println("Banco populado com sucesso!");
    }
}
