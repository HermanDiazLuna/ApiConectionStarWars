package com.example.starwars.mapper;

import com.example.starwars.dto.PeliculaDTO;
import com.example.starwars.entities.Pelicula;
import org.mapstruct.Mapper;

@Mapper
public interface PeliculaTransformer {

    Pelicula toDTOPelicula(PeliculaDTO peliculaDTO);
    PeliculaDTO peliculaToDTO(Pelicula pelicula);
}
