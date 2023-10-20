package com.example.vv22029veterinaria.INTERFACES;

import com.example.vv22029veterinaria.ENTIDADES.Categoria;
import com.example.vv22029veterinaria.ENTIDADES.Raza;

import java.util.List;

public interface IRaza {

    public List<Raza> ObtenerRaza();

    public boolean Crear(Raza raza);

    public boolean Actualizar(Raza raza);

    public boolean Eliminar(int idRaza);


}
