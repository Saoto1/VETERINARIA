package com.example.vv22029veterinaria.INTERFACES;

import com.example.vv22029veterinaria.ENTIDADES.Citas;
import com.example.vv22029veterinaria.ENTIDADES.Paciente;

import java.util.List;

public interface ICitas {

    public List<Citas> ObtenerCitas();

    public boolean Crear(Citas medicamentos);

    public boolean Actualizar(Citas medicamentos);

    public boolean Eliminar(int id);

    public boolean ValidarLimiteCitas(int idPaciente);

    public boolean CrearCitaPacienteNuevo(Paciente paciente,Citas cita);

}
