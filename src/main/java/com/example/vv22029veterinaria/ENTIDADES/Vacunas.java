package com.example.vv22029veterinaria.ENTIDADES;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Vacunas {

    private int id;
    private Date fechaVaccuna;
    private String nombreVaccuna;
    private double peso;
    private double altura;
    private int edad;
    private int idPaciente;


    public Vacunas() {
    }

    public Vacunas(String str) {

        try {
            String[] partes = str.split(",");

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");


            this.id = Integer.parseInt(partes[0]);
            this.fechaVaccuna = formato.parse(partes[1]);
            this.nombreVaccuna = partes[2];
            this.peso = Double.parseDouble(partes[3]);
            this.altura = Double.parseDouble(partes[4]);
            this.edad = Integer.parseInt(partes[5]);
            this.idPaciente = Integer.parseInt(partes[6]);

            } catch (ParseException e) {
                throw new RuntimeException(e);
            }


    }


}
