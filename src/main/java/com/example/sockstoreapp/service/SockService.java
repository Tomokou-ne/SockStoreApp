package com.example.sockstoreapp.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
@Service
public class SockService {
    private final Map<Socks, Integer> socksMap = new LinkedHashMap<>();

    public void addSock(SocksStock socksStock) throws InvalidObjectException {
        wellRequest(socksStock);
        Socks socks = new Socks(socksStock.getColour(), socksStock.getSize(), socksStock.getCottonPart());
        if (socksMap.containsKey(socks)) {
            socksMap.put(socks, socksMap.get(socks) + socksStock.getQuantity());
        } else {
            socksMap.put(socks, socksStock.getQuantity());
        }
    }

    public int getSocksQuantity(Colour colour, Size size, Integer cottonMin, Integer cottonMax) {
        Integer total = 0;
        for (Map.Entry<Socks, Integer> entry : socksMap.entrySet()) {
            if(entry.getKey().getColour().equals(colour)) {
                continue;
            }if(entry.getKey().getSize().equals(size)) {
                continue;
            }if(cottonMin != null && entry.getKey().getCottonPart() > cottonMin) {
                continue;
            }if(cottonMax != null && entry.getKey().getCottonPart() < cottonMax) {
                continue;
            } total += entry.getValue();
        }
        return total;
    }

    public void reduceSocksQuantity(SocksStock socksStock) throws InvalidObjectException {
        wellRequest(socksStock);
        Socks socks = new Socks(socksStock.getColour(), socksStock.getSize(), socksStock.getCottonPart());
        Integer socksQuantity = socksMap.getOrDefault(socks, 0);
        if (socksQuantity >= socksStock.getQuantity()) {
            socksMap.put(socks, socksQuantity - socksStock.getQuantity());
        } else {
            throw new InvalidObjectException("There's no product");
        }
    }

    private void wellRequest(SocksStock socksStock) throws InvalidObjectException {
        if (socksStock.getColour() == null || socksStock.getSize() == null) {
            throw new InvalidObjectException("All fields should be filled");
        } if (socksStock.getCottonPart() < 0 || socksStock.getCottonPart() > 100) {
            throw new InvalidObjectException("Wrong value of cotton percentage");
        } if (socksStock.getQuantity() <= 0) {
            throw new InvalidObjectException("Wrong quantity of product");
        }
    }
}
