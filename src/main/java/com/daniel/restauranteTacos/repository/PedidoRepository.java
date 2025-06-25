package com.daniel.restauranteTacos.repository;

import com.daniel.restauranteTacos.model.PedidoModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoRepository extends MongoRepository<PedidoModel, String> {
}
