package com.tallerwebi.infraestructura;

import org.springframework.stereotype.Service;

@Service
public class ObjetivosService {

    public void guardarObjetivos(String objetivo) {
        System.out.println("Objetivo guardado: " + objetivo);
    }
}
