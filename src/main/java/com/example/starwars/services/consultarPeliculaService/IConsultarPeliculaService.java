package com.example.starwars.services.consultarPeliculaService;

import com.example.starwars.dto.PeliculaDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface IConsultarPeliculaService {

    PeliculaDTO consultar(String idPelicula) throws JsonProcessingException;
}
