package com.jalat.destinationservice.enums;

public enum EnumProvince {
    PHNOM_PENH("Phnom Penh"),
    KANDAL("Kandal"),
    TAKEO("Takeo"),
    PURSAT("Pursat"),
    KOH_KONG("Koh kong"),
    PREAH_SIHANOUK("Preah Sihanouk"),
    KAMPOT("Kampot"),
    KEP("Kep"),
    SVAY_RIENG("Svay Rieng"),
    PREY_VENG("Prey Veng"),
    KAMPONG_SPEU("Kampong Speu"),
    KAMPONG_CHAM("Kampong Cham"),
    KAMPONG_CHHNANG("Kampong Chhnang"),
    KAMPONG_THOM("Kampong Thom"),
    BATTAMBANG("Battambang"),
    PAILIN("Pailin"),
    BANTEAY_MEANCHEY("Banteay Meanchey"),
    SIEM_REAP("Siem Reap"),
    ODDAR_MEANCHEY("Oddar Meanchey"),
    PREAH_VIHEAR("Preah Vihear"),
    STUNG_TRENG("Stung Treng"),
    RATTANAKIRI("Rattanakiri"),
    KRATIE("Kratie"),
    MONDULKIRI("Mondulkiri"),
    TBOUNG_KHMUM("Tboung Khmum");

    private final String display;

    EnumProvince(String display) {
        this.display = display;
    }
    @Override
    public String toString() {
        return display;
    }
}
