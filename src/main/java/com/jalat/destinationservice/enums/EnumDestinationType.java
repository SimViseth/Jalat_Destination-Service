package com.jalat.destinationservice.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EnumDestinationType {
    MOUNTAIN("Mountain"),
    SEA("Sea"),
    HISTORIC("Historic"),
    MUSEUM("Museum");

    private final String value;

    EnumDestinationType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
