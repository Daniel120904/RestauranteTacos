package com.daniel.restauranteTacos.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoItem {
    TACO,
    BEBIDA,
    ACOMPANHAMENTO;

    @JsonCreator
    public static TipoItem fromValue(String value) {
        return TipoItem.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
}



