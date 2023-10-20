package com.example.vv22029veterinaria.INTERFACES;

import com.example.vv22029veterinaria.ENTIDADES.Categoria;

import java.util.List;

public interface ICategoria {

    public List<Categoria> ObtenerCategorias();

    public boolean Crear(Categoria categoria);

    public boolean Actualizar(Categoria categoria);

    public boolean Eliminar(int idCategoria);


}
