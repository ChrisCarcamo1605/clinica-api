package com.clinica.clinica_api.services;

import com.clinica.clinica_api.entities.Paciente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {

    private final List<Paciente> listaPacientes = new ArrayList<>();
    private Long idAutoIncremental = 1L;

    public PacienteService(){
        listaPacientes.add(new Paciente(idAutoIncremental++,  "Carlos", "Mendoza","Gripe aviar"));
        listaPacientes.add((new Paciente(idAutoIncremental++, "Ana" ,"Gomez", "Cancer de pelo")));
    }

    public List<Paciente> obtenerTodos(){
        return listaPacientes;
    }

    public Paciente guardarPaciente(Paciente paciente){
        paciente.setId(idAutoIncremental);
        listaPacientes.add(paciente);
        return  paciente;
    }

    public Paciente buscarPorId(Long id){
        Paciente paciente = null;

        for(int i = 0; i < listaPacientes.size(); i++){
            paciente = listaPacientes.get(i);
              if(paciente.getId() == id){
                  return paciente;
              }
      }
        return  paciente;
    }

}




