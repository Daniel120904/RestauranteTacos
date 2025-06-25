package com.daniel.restauranteTacos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tipos_pagamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoPagamentoModel {

    @Id
    private String id;
    private String nome;
}

