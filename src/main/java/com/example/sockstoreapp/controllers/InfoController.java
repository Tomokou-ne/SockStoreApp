package com.example.sockstoreapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Первый контроллер", description = "Краткое ИНФО о приложении")
public class InfoController {
    @GetMapping
    public String helloWorld() {
        return "App's running";
    }

    @Operation(summary = "INFO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success")
    }
    )
    @GetMapping("/info")
    public String info() {
        return "Project's author is Bychkova Margarita " + "/n" +
                "Name: SockStoreApp " + "/n" +
                "Date of creation: 26/03/2023" + "/n" +
                "Description: app ";
    }
}
