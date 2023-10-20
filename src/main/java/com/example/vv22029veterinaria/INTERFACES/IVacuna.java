package com.example.vv22029veterinaria.INTERFACES;

import com.example.vv22029veterinaria.ENTIDADES.Citas;
import com.example.vv22029veterinaria.ENTIDADES.Vacunas;

import java.util.List;

public interface IVacuna {

    public List<Vacunas> ObtenerVacunas();

    public boolean Crear(Vacunas vacunas);

    public boolean Actualizar(Vacunas vacunas);

    public boolean Eliminar(int id);

}
