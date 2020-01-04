package com.sneaker.Sneaker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Sneaker {
    private final UUID id;
    private final String name;
    private final Double price;
    private final String website;

    public Sneaker(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty("price") Double price, @JsonProperty("website") String website) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.website = website;
    }


    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getWebsite() {
        return website;
    }
}
