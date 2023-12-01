package com.example.starwars.mapper;

import com.example.starwars.dto.PeliculaDTO;
import com.example.starwars.entities.Pelicula;

public class PeliculaMapper {

    public static PeliculaDTO peliculaToDTO(Pelicula pelicula){
        return PeliculaDTO.builder()
                .episode_id(pelicula.getEpisode_id())
                .title(pelicula.getTitle())
                .release_date(pelicula.getRelease_date())
                .build();
    }

    public static Pelicula dtoToPelicula(PeliculaDTO peliculaDto){
        return Pelicula.builder()
                .episode_id(peliculaDto.getEpisode_id())
                .title(peliculaDto.getTitle())
                .release_date(peliculaDto.getRelease_date())
                .build();
    }


}
