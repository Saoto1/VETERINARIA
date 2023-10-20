package com.example.vv22029veterinaria.ENTIDADES;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Raza {

    private int id;

    private String Nombre;

    private Date FechaCreacion;

    public Raza(String str) {

        String[] partes = str.split(",");

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        this.id = Integer.parseInt(partes[0]);;
        Nombre =  partes[1];

        try {
            FechaCreacion = formato.parse(partes[2]);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
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
