package com.example.sockstoreapp.service;

public class SocksStock {

    private final Colour colour;
    private final Size size;
    private final Integer cottonPart;
    private Integer quantity;

    public SocksStock(Colour colour, Size size, Integer cottonPart, Integer quantity) {
        this.colour = colour;
        this.size = size;
        this.cottonPart = cottonPart;
        this.quantity = quantity;
    }

    public Colour getColour() {
        return colour;
    }
    public Size getSize() {
        return size;
    }
    public Integer getCottonPart() {
        return cottonPart;
    }
    public Integer getQuantity() {
        return quantity;
    }

}
