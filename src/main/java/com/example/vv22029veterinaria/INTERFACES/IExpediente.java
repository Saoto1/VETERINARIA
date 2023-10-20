package com.example.vv22029veterinaria.INTERFACES;

import com.example.vv22029veterinaria.ENTIDADES.Citas;
import com.example.vv22029veterinaria.ENTIDADES.Expediente;

import java.util.List;

public interface IExpediente {

    public List<Expediente> ObtenerExpediente();

    public boolean Crear(Expediente expediente);

    public boolean Actualizar(Expediente expediente);

    public boolean Eliminar(int id);

}
