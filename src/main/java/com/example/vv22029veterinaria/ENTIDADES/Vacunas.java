package com.example.vv22029veterinaria.ENTIDADES;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaVaccuna() {
        return fechaVaccuna;
    }

    public void setFechaVaccuna(Date fechaVaccuna) {
        this.fechaVaccuna = fechaVaccuna;
    }

    public String getNombreVaccuna() {
        return nombreVaccuna;
    }

    public void setNombreVaccuna(String nombreVaccuna) {
        this.nombreVaccuna = nombreVaccuna;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
}
