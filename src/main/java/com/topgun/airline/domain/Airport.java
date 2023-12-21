package com.topgun.airline.domain;

public enum Airport {

    PAR("Paris, France"),
    NYC("New York City, USA"),
    ROM("Rome, Italy"),
    TOK("Tokyo, Japan"),
    RIO("Rio de Janeiro, Brazil");



    private final String description;

    Airport(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
