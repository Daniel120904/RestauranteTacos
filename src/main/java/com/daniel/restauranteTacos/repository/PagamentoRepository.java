package com.daniel.restauranteTacos.repository;

import com.daniel.restauranteTacos.model.PagamentoModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends MongoRepository<PagamentoModel, String> {
}
