package com.daniel.restauranteTacos.repository;

import com.daniel.restauranteTacos.model.AcompanhamentoModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcompanhamentoRepository extends MongoRepository<AcompanhamentoModel, String> {
}

