package com.example.vv22029veterinaria.ENTIDADES;

import java.util.Date;

public class Categoria {

    private int id;

    private String Nombre;

    private Date FechaCreacion;

    public Categoria(int id, String nombre, Date fechaCreacion) {
        this.id = id;
        Nombre = nombre;
        FechaCreacion = fechaCreacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }
}
