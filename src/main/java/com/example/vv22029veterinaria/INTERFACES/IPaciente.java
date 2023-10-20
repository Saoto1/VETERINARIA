package com.example.vv22029veterinaria.INTERFACES;

import com.example.vv22029veterinaria.ENTIDADES.Medicamentos;
import com.example.vv22029veterinaria.ENTIDADES.Paciente;

import java.util.List;

public interface IPaciente {

    public List<Paciente> ObtenerPacientes();

    public boolean Crear(Paciente paciente);

    public boolean Actualizar(Paciente paciente);

    public boolean Eliminar(int id);


}
