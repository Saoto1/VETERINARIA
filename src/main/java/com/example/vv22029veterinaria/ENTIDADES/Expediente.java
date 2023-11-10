package com.example.vv22029veterinaria.ENTIDADES;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Data
public class Expediente {
    private int id;
    private int idVacuna;
    private int idPaciente;
    private int idCitas;
    private double altura;
    private int edad;


    public Expediente() {}

    public Expediente(String str) {

        String[] partes = str.split(",");

        this.id = Integer.parseInt(partes[0]);



        this.idVacuna = Integer.parseInt(partes[1]);
        this.idPaciente = Integer.parseInt(partes[2]);
        this.idCitas = Integer.parseInt(partes[3]);
        this.altura = Double.parseDouble(partes[4]);
        this.edad = Integer.parseInt(partes[5]);
    }


}
