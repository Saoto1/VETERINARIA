package com.example.vv22029veterinaria.ENTIDADES;

import java.util.Date;

public class Vacunas {

    private String id;
    private Date fechaVaccuna;
    private String nombreVaccuna;
    private double peso;
    private double altura;
    private int edad;
    private String idPaciente;

    public Vacunas(String id, Date fechaVaccuna, String nombreVaccuna, double peso, double altura, int edad, String idPaciente) {
        this.id = id;
        this.fechaVaccuna = fechaVaccuna;
        this.nombreVaccuna = nombreVaccuna;
        this.peso = peso;
        this.altura = altura;
        this.edad = edad;
        this.idPaciente = idPaciente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }
}
