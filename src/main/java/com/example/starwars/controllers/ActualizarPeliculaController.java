package com.example.starwars.controllers;

import com.example.starwars.dto.PeliculaDTO;
import com.example.starwars.services.actualizarPelicula.IActualizarPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ActualizarPeliculaController {
    @Autowired
   private IActualizarPeliculaService iActualizarPeliculaService;

    @PutMapping("/actualizar-pelicula/{id}")
    public ResponseEntity<?> actualizar (@PathVariable("id") Integer idPelicula, @RequestBody PeliculaDTO peliculaDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iActualizarPeliculaService.actualizar(peliculaDTO,idPelicula));
    }

}
