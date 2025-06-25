package com.daniel.restauranteTacos.repository;

import com.daniel.restauranteTacos.model.BebidaModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidaRepository extends MongoRepository<BebidaModel, String> {
}
