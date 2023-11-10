package com.example.vv22029veterinaria.ENTIDADES;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Citas {
    private int id;
    private Date fechaCita;
    private String nombrePaciente;
    private String motivoCita;
    private int idPaciente;
    private int idEstadoCita;


    public Citas() {}

    public Citas(String str) {

        String[] partes = str.split(",");

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        this.id = Integer.parseInt(partes[0]);

        try {
           this.fechaCita = formato.parse(partes[1]);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        this.motivoCita = partes[2];
        this.nombrePaciente = partes[3];
        this.motivoCita = partes[4];
        this.idPaciente = Integer.parseInt(partes[5]);
        this.idEstadoCita = Integer.parseInt(partes[6]);
    }

}
