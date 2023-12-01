package com.example.starwars.services.consultarPeliculaService;
import com.example.starwars.dto.PeliculaDTO;
import com.example.starwars.entities.Pelicula;
import com.example.starwars.repositories.PeliculaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ConsultarPeliculaServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private PeliculaRepository peliculaRepository;

    @InjectMocks
    private ConsultarPeliculaService peliculaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConsultar2() throws JsonProcessingException {

        String idPelicula = "1";

        String jsonMock = "{\"id\": 1, \"episode_id\": 4, \"title\": \"A New Hope\", \"release_date\": \"1977-05-25\"}";
        ResponseEntity<String> mockResponseEntity = ResponseEntity.ok(jsonMock);
        when(restTemplate.getForEntity(anyString(), eq(String.class))).thenReturn(mockResponseEntity);

        Pelicula mockPelicula = new Pelicula();
        when(objectMapper.readValue(jsonMock, Pelicula.class)).thenReturn(mockPelicula);

        when(peliculaRepository.save(mockPelicula)).thenReturn(mockPelicula);

        PeliculaDTO result = peliculaService.consultar(idPelicula);

        assertNotNull(result);

    }


}
