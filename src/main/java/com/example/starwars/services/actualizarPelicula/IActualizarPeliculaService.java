package com.example.starwars.services.actualizarPelicula;

import com.example.starwars.dto.PeliculaDTO;


public interface IActualizarPeliculaService {

    PeliculaDTO actualizar(PeliculaDTO peliculaDTO, Integer id);
}
