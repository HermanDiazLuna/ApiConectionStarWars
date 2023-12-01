package com.example.starwars.controllers;

import com.example.starwars.services.eliminarPelicula.IEliminarPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EliminarPeliculaController {

    @Autowired
    private IEliminarPeliculaService iEliminarPeliculaService;

    @DeleteMapping("eliminar/{id}")
    public void eliminarPelicula(@PathVariable("id") Integer id){
        iEliminarPeliculaService.eliminar(id);
    }
}
