package com.example.starwars.services.eliminarPeliculaService;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.starwars.entities.Pelicula;
import com.example.starwars.repositories.PeliculaRepository;
import com.example.starwars.services.eliminarPelicula.ImplEliminarPeliculaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class EliminarPeliculaServiceTest {

    @Mock
    private PeliculaRepository peliculaRepository;

    @InjectMocks
    private ImplEliminarPeliculaService peliculaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testEliminarExistente() {

        Integer id = 1;


        when(peliculaRepository.findById(id)).thenReturn(Optional.of(new Pelicula()));


        doNothing().when(peliculaRepository).deleteById(id);


        peliculaService.eliminar(id);


    }
}
