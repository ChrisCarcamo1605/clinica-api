package com.clinica.clinica_api.dtos;

import jakarta.validation.constraints.*;

public record SavePacienteDTO(
        @NotBlank(message = "Nombre no debe estar vacio")
        @Size(min = 3, max = 20, message = "El tamanio del nombre debe ser entre 3 - 20 caracteres")
        String nombre,
        @NotBlank(message = "Apellido no debe estar vacio")
        @Size(min = 3, max = 20, message = "El tamanio del nombre debe ser entre 3 - 20 caracteres")
        String apellido,
        @Min(value = 10, message = "La edad debe ser mayor o igual a 10")
        @Max(value = 120, message = "La edad debe ser realista")
        int edad,
        @Size(min = 8, max = 50, message = "Diagnostico debe tener minimo 8 - 50 caracteres")
        String diagnostico) {
}
