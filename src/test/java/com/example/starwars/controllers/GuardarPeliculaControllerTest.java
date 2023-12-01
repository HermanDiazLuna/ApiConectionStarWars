package com.example.starwars.controllers;

import com.example.starwars.dto.PeliculaDTO;
import com.example.starwars.services.consultarPeliculaService.IConsultarPeliculaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GuardarPeliculaControllerTest {
    @Mock
    private IConsultarPeliculaService iPeliculaService;

    @InjectMocks
    private GuardarPeliculaController peliculaController;


    @Test
    void consultarPeliculaTest() throws JsonProcessingException {

        String idPelicula = "123";
        PeliculaDTO pelicula = new PeliculaDTO();
        when(iPeliculaService.consultar(idPelicula)).thenReturn(pelicula);

        ResponseEntity<?> response = peliculaController.consultarPelicula(idPelicula);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(pelicula, response.getBody());
        verify(iPeliculaService, times(1)).consultar(idPelicula);
    }
}
