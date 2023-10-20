package com.example.vv22029veterinaria.INTERFACES;

import com.example.vv22029veterinaria.ENTIDADES.EstadoCita;
import com.example.vv22029veterinaria.ENTIDADES.Medicamentos;

import java.util.List;

public interface IMedicamentos {

    public List<Medicamentos> ObtenerMedicamentos();

    public boolean Crear(Medicamentos medicamentos);

    public boolean Actualizar(Medicamentos medicamentos);

    public boolean Eliminar(int id);


}
