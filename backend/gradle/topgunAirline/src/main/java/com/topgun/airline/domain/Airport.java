package com.topgun.airtravel.domain;

public enum Airport {
    GRU("Guarulhos International Airport"),
    CGH("Congonhas Airport"),
    BSB("Brasília International Airport"),
    GIG("Rio de Janeiro–Galeão International Airport"),
    SDU("Santos Dumont Airport");

    private final String description;

    Airport(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
