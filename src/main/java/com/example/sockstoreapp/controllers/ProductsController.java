package com.example.sockstoreapp.controllers;

import com.example.sockstoreapp.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.io.InvalidObjectException;

public class ProductsController {
    private final SockService sockService;

    public ProductsController(SockService sockService) {
        this.sockService = sockService;
    }

    @GetMapping("/{socks}")
    @Operation(summary = "Search socks by characteristics ", description = " ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found"),
            @ApiResponse(responseCode = "400", description = "Product is unavailable, wrong request format"),
            @ApiResponse(responseCode = "500", description = "Server error")
    }
    )
    public int getProductQuantity(@RequestParam (required = false, name = "colour")Colour colour,
                                  @RequestParam (required = false, name = "size")Size size,
                                  @RequestParam (required = false, name = "cottonMin")Integer cottonMin,
                                  @RequestParam (required = false, name = "cottonMax")Integer cottonMax)
    {
        return sockService.getSocksQuantity(colour, size, cottonMin, cottonMax);
    }

    @PostMapping()
    @Operation(summary = "Add socks by characteristics ", description = "Registers the arrival of goods at the warehouse")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Request completed, item added to stock"),
            @ApiResponse(responseCode = "400", description = "Product is unavailable, wrong request format"),
            @ApiResponse(responseCode = "500", description = "Server error")
    }
    )
    public void addProduct(@RequestBody SocksStock socksStock) throws InvalidObjectException {
        sockService.addSock(socksStock);
    }

    @PutMapping()
    @Operation(summary = "Update socks by characteristics ", description = "Registers the release of socks from the warehouse")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Request completed, item updated from stock"),
            @ApiResponse(responseCode = "400", description = "Product is unavailable, wrong request format"),
            @ApiResponse(responseCode = "500", description = "Server error")
    }
    )
    public void updateProduct(@RequestBody SocksStock socksStock) throws InvalidObjectException {
        sockService.reduceSocksQuantity(socksStock);
    }

    @DeleteMapping()
    @Operation(summary = "Delete socks by characteristics ", description = "Registers the write-off of damaged (defective) socks.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Request completed, item removed from stock"),
            @ApiResponse(responseCode = "400", description = "Product is unavailable, wrong request format"),
            @ApiResponse(responseCode = "500", description = "Server error")
    }
    )
    public void removeProduct(@RequestBody SocksStock socksStock) throws InvalidObjectException {
        sockService.reduceSocksQuantity(socksStock);
    }
}

