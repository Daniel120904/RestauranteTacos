package com.daniel.restauranteTacos.repository;

import com.daniel.restauranteTacos.model.TacoModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepository extends MongoRepository<TacoModel, String> {
}
