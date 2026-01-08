package com.jalat.destinationservice.enums;

public enum enumPlaceToStayType {
    HOTEL("Hotel"),
    GUESS_HOUSE("Guest house");

    private final String display;

    enumPlaceToStayType(String display) {
        this.display = display;
    }
    @Override
    public String toString() {
        return display;
    }
}
