package com.example.starwars.services.eliminarPelicula;

import com.example.starwars.entities.Pelicula;
import com.example.starwars.exceptions.PeliculaExceptions;
import com.example.starwars.repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImplEliminarPeliculaService implements IEliminarPeliculaService{

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public void eliminar(Integer id) {
        Optional<Pelicula> optional = peliculaRepository.findById(id);

        if(optional.isPresent()){
            peliculaRepository.deleteById(id);
        }else{
            throw new PeliculaExceptions("ERROR, La pelicula no existe en la base de datos");
        }
    }
}
