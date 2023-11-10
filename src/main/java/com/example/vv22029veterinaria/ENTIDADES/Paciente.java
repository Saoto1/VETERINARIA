package com.example.vv22029veterinaria.ENTIDADES;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Paciente {

    private int id;
    private String nombre;
    private String nombrePropietario;
    private int edad;
    private int idCategoria;
    private String sexo;
    private int idRazaInscripcion;
    private int idRaza;
    private double altura;
    private double peso;
    private Date fechaNacimiento;
    private String estadoPaciente;


    public Paciente() {}

    public Paciente(String str) {

        String[] partes = str.split(",");

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        this.id = Integer.parseInt(partes[0]);
        this.nombre = partes[1];
        this.nombrePropietario = partes[2];
        this.edad = Integer.parseInt(partes[3]);
        this.idCategoria = Integer.parseInt(partes[4]);
        this.sexo = partes[5];
        this.idRazaInscripcion = Integer.parseInt(partes[6]);
        this.idRaza = Integer.parseInt(partes[7]);
        this.altura = Double.parseDouble(partes[8]);
        this.peso = Double.parseDouble(partes[9]);

        try {
            this.fechaNacimiento = formato.parse(partes[10]);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        this.estadoPaciente = partes[11];

    }



}
