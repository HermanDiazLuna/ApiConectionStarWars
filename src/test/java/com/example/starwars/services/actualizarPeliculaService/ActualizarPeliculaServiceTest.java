package com.example.starwars.services.actualizarPeliculaService;

import com.example.starwars.dto.PeliculaDTO;
import com.example.starwars.entities.Pelicula;
import com.example.starwars.repositories.PeliculaRepository;
import com.example.starwars.services.actualizarPelicula.ImplActualizarPeliculaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

public class ActualizarPeliculaServiceTest {
    @Mock
    private PeliculaRepository peliculaRepository;

    @InjectMocks
    private ImplActualizarPeliculaService peliculaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testActualizarExistente() {

        Integer id = 1;

        Pelicula peliculaExistente = new Pelicula();
        peliculaExistente.setId(id);
        peliculaExistente.setEpisode_id(4);
        peliculaExistente.setTitle("Star Wars: A New Hope");
        peliculaExistente.setRelease_date(new Date(121, Calendar.MAY, 25));


        when(peliculaRepository.findById(id)).thenReturn(Optional.of(peliculaExistente));


        when(peliculaRepository.save(any(Pelicula.class))).thenAnswer(invocation -> invocation.getArgument(0));


        PeliculaDTO result = peliculaService.actualizar(new PeliculaDTO(), id);

        assertNotNull(result);
        assertEquals(4, result.getEpisode_id());

    }
}
