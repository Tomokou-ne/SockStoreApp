package com.example.sockstoreapp.service;

import lombok.Data;

import java.util.Objects;

@Data
public class Socks {
    private Colour colour;
    private Size size;
    private Integer cottonPart;

    public Socks(Colour colour, Size size, Integer cottonPart) {
        this.colour = colour;
        this.size = size;
        this.cottonPart = cottonPart;
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

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Socks socks = (Socks) o;
        return colour == socks.colour && size == socks.size && cottonPart.equals(socks.cottonPart);
    }
    @Override
    public int hashCode() {
        return Objects.hash(colour, size, cottonPart);
    }
}
