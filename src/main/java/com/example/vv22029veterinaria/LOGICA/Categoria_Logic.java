package com.example.vv22029veterinaria.LOGICA;

import com.example.vv22029veterinaria.ENTIDADES.Categoria;
import com.example.vv22029veterinaria.INTERFACES.ICategoria;

import java.util.List;

public class Categoria_Logic implements ICategoria {

    String DirectorioArchivo;

    public Categoria_Logic() {
        super();
    }



    @Override
    public List<Categoria> ObtenerCategorias() {
        return null;
    }

    @Override
    public boolean Crear(Categoria categoria) {
        return false;
    }

    @Override
    public boolean Actualizar(Categoria categoria) {
        return false;
    }

    @Override
    public boolean Eliminar(int idCategoria) {
        return false;
    }
}
