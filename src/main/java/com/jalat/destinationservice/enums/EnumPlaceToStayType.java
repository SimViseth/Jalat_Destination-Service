package com.jalat.destinationservice.enums;

public enum EnumPlaceToStayType {
    HOTEL("Hotel"),
    GUESS_HOUSE("Guest house");

    private final String display;

    EnumPlaceToStayType(String display) {
        this.display = display;
    }
    @Override
    public String toString() {
        return display;
    }
}
