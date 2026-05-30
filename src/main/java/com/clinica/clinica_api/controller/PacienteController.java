package com.clinica.clinica_api.controller;

import com.clinica.clinica_api.dtos.SavePacienteDTO;
import com.clinica.clinica_api.entities.Paciente;
import com.clinica.clinica_api.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Paciente> guardarPaciente(@Valid @RequestBody SavePacienteDTO paciente){

        Paciente pacienteCreado =  pacienteService.guardarPaciente(paciente);
        return  new ResponseEntity<>(pacienteCreado, HttpStatus.CREATED);

    }

    @PatchMapping("/{id}")
    public Paciente actualizarParcialPaciente(@RequestBody Paciente paciente, @PathVariable Long id){
        return pacienteService.actualizarParcialPaciente(id, paciente);
    }

    @PutMapping("/{id}")
    public Paciente actualizarPaciente(@RequestBody Paciente paciente, @PathVariable Long id){
        return pacienteService.actualizarPaciente(id, paciente);

    }

    //Se me oye?

    @DeleteMapping("/{id}")
    public ResponseEntity borrarPaciente(@PathVariable Long id){

        pacienteService.borrarPaciente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
