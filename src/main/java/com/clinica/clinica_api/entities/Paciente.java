package com.clinica.clinica_api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Paciente {

    Long id;
    private String nombre;
    private String apellido;
    private String diagnostico;
}

