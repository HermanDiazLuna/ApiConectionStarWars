package com.example.starwars.services.consultarPeliculaService;

import com.example.starwars.dto.PeliculaDTO;
import com.example.starwars.entities.Pelicula;
import com.example.starwars.exceptions.PeliculaExceptions;
import com.example.starwars.mapper.PeliculaMapper;
import com.example.starwars.repositories.PeliculaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsultarPeliculaService implements IConsultarPeliculaService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public PeliculaDTO consultar(String idPelicula){
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        String URL_STAR_WARS = "https://swapi.dev/api/films/";
        Pelicula pelicula = null;
        try {
            ResponseEntity<String> forEntity = restTemplate.getForEntity(URL_STAR_WARS.concat(idPelicula), String.class);
            pelicula = peliculaRepository.save(objectMapper.readValue(forEntity.getBody(), Pelicula.class));
        }catch (HttpClientErrorException | JsonProcessingException ignored){
            throw new PeliculaExceptions("error en la solicitud");
        }
        return PeliculaMapper.peliculaToDTO(pelicula);
    }
}
