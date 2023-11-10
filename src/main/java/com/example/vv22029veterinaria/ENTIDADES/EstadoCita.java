package com.example.vv22029veterinaria.ENTIDADES;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class EstadoCita {

    private int id;

    private String Nombre;

    private Date FechaCreacion;

    public EstadoCita() {}

    public EstadoCita(String str) {

        String[] partes = str.split(",");

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        this.id = Integer.parseInt(partes[0]);

        this.Nombre = partes[1];

        try {
            this.FechaCreacion = formato.parse(partes[2]);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }



}
