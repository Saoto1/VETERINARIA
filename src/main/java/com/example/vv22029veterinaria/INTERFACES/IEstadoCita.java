package com.example.vv22029veterinaria.INTERFACES;

import com.example.vv22029veterinaria.ENTIDADES.EstadoCita;
import com.example.vv22029veterinaria.ENTIDADES.Raza;

import java.util.List;

public interface IEstadoCita {

    public List<EstadoCita> ObtenerEstadoCita();

    public boolean Crear(EstadoCita estadoCita);

    public boolean Actualizar(EstadoCita estadoCita);

    public boolean Eliminar(int id);

}
