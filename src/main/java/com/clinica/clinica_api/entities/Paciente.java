package com.clinica.clinica_api.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@Builder
public class Paciente {

    Long id;
    private String nombre;
    private String apellido;
    private String diagnostico;
    private int edad;


}

