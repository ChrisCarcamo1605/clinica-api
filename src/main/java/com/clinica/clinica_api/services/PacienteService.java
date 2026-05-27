package com.clinica.clinica_api.services;

import com.clinica.clinica_api.entities.Paciente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {

    private final List<Paciente> listaPacientes = new ArrayList<>();
    private Long idAutoIncremental = 1L;

    public PacienteService() {
        listaPacientes.add(new Paciente(idAutoIncremental++, "Carlos", "Mendoza", "Gripe aviar"));
        listaPacientes.add((new Paciente(idAutoIncremental++, "Ana", "Gomez", "Cancer de pelo")));
    }

    public List<Paciente> obtenerTodos() {
        return listaPacientes;
    }

    public Paciente guardarPaciente(Paciente paciente) {
        paciente.setId(idAutoIncremental);
        listaPacientes.add(paciente);
        return paciente;
    }

    public Paciente buscarPorId(Long id) {
        Paciente paciente = null;

        for (int i = 0; i < listaPacientes.size(); i++) {
            paciente = listaPacientes.get(i);
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return paciente;
    }

    public Paciente actualizarParcialPaciente(Long id, Paciente pacienteDatosNuevos) {
        Paciente pacienteAActualizar = buscarPaciente(id);

        if (pacienteAActualizar == null) {
            System.out.println("Paciente con id " + id + " no encontrado");
        }

        if (pacienteDatosNuevos.getApellido() != null) {
            pacienteAActualizar.setApellido(pacienteDatosNuevos.getApellido());
        }

        if (pacienteDatosNuevos.getDiagnostico() != null) {
            pacienteAActualizar.setDiagnostico(pacienteDatosNuevos.getDiagnostico());

        }

        if (pacienteDatosNuevos.getNombre() != null) {
            pacienteAActualizar.setNombre(pacienteDatosNuevos.getNombre());
        }

        return pacienteAActualizar;
    }

    public Paciente actualizarPaciente(Long id, Paciente pacienteDatosNuevos) {
        Paciente pacienteAActualizar = buscarPaciente(id);
        int indice = listaPacientes.indexOf(pacienteAActualizar);

            if (pacienteAActualizar != null) {
                pacienteDatosNuevos.setId(id);
                listaPacientes.set(indice, pacienteDatosNuevos);
                pacienteAActualizar = listaPacientes.get(indice);
            }

    return  pacienteAActualizar;
    }


    public void borrarPaciente (Long id){
        Paciente paciente = buscarPaciente(id);
        int indice = listaPacientes.indexOf(paciente);
        listaPacientes.remove(indice);
    }

    private Paciente buscarPaciente(Long id){
        Paciente paciente = null;

        for (int i = 0; i < listaPacientes.size(); i++) {
            paciente = listaPacientes.get(i);

            if (id == paciente.getId()) {
               return paciente;
            }

        }
        return paciente;
    }
}






