package com.example.vv22029veterinaria.ENTIDADES;

import lombok.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

@Data
public class Raza {

    private int id;

    private String Nombre;

    private Date FechaCreacion;

    public Raza(){}

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


}
