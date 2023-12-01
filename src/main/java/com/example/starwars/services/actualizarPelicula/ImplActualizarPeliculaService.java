package com.example.starwars.services.actualizarPelicula;

import com.example.starwars.dto.PeliculaDTO;
import com.example.starwars.entities.Pelicula;
import com.example.starwars.exceptions.PeliculaExceptions;
import com.example.starwars.mapper.PeliculaMapper;
import com.example.starwars.repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImplActualizarPeliculaService implements IActualizarPeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;


    @Override
    public PeliculaDTO actualizar(PeliculaDTO peliculaDTO, Integer id) {
        Pelicula pelicula = null;
        Optional<Pelicula> opPelicula = peliculaRepository.findById(id);
        if(opPelicula.isPresent()){
            pelicula = peliculaRepository.save(Pelicula.builder()
                    .episode_id(opPelicula.get().getEpisode_id())
                    .title(opPelicula.get().getTitle())
                    .release_date(opPelicula.get().getRelease_date())
                    .build());
        }else{
            throw new PeliculaExceptions("ERROR, La pelicula no existe en la base de datos");
        }

        return PeliculaMapper.peliculaToDTO(pelicula);
    }
}
