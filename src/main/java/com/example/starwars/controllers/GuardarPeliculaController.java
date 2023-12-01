package com.example.starwars.controllers;

import com.example.starwars.services.consultarPeliculaService.IConsultarPeliculaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GuardarPeliculaController {

    @Autowired
    private IConsultarPeliculaService iPeliculaService;

    @GetMapping("/consultar-pelicula/{id}")
    public ResponseEntity<?> consultarPelicula(@PathVariable("id") String idPelicula) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iPeliculaService.consultar(idPelicula));
    }


}
