package com.clinica.clinica_api.controller;

import com.clinica.clinica_api.entities.Paciente;
import com.clinica.clinica_api.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    /*
    private PacienteService service;
    public PacienteController(PacienteService service){
        this.service = service;
    }
     */

    @GetMapping("")
    public List<Paciente> obtenerPacientes(){
        return  pacienteService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Paciente obtenerPaciente(@PathVariable Long id){
        return pacienteService.buscarPorId(id);
    }

    @PostMapping("")
    public Paciente guardarPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardarPaciente(paciente);
    }

}
