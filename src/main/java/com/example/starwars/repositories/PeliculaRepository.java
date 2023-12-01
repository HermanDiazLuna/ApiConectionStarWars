package com.example.starwars.repositories;

import com.example.starwars.entities.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {

}
