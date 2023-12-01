package com.example.starwars.entities;

import com.example.starwars.entities.Pelicula;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Calendar;
import java.util.Date;

public class PeliculaTest {

    @Test
    public void testPeliculaBuilder() {

        Pelicula pelicula = Pelicula.builder()
                .id(1)
                .episode_id(4)
                .title("Star Wars: A New Hope")
                .release_date(new Date(121, Calendar.MAY, 25))
                .build();


        assertEquals(1, pelicula.getId());
        assertEquals(4, pelicula.getEpisode_id());
        assertEquals("Star Wars: A New Hope", pelicula.getTitle());
        assertEquals(new Date(121, Calendar.MAY, 25), pelicula.getRelease_date());
    }

}

