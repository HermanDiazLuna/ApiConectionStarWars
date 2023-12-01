package com.example.starwars.exceptions;

import com.example.starwars.dto.PeliculaDTO;

public class PeliculaExceptions extends RuntimeException {

    public PeliculaExceptions(String msj){
        super(msj);
    }
}
