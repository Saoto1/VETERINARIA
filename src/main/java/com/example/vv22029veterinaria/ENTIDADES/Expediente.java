package com.example.vv22029veterinaria.ENTIDADES;

public class Expediente {
    private String id;
    private String idVacuna;
    private String idPaciente;
    private String idCitas;
    private double altura;
    private int edad;

    public Expediente(String id, String idVacuna, String idPaciente, String idCitas, double altura, int edad) {
        this.id = id;
        this.idVacuna = idVacuna;
        this.idPaciente = idPaciente;
        this.idCitas = idCitas;
        this.altura = altura;
        this.edad = edad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(String idVacuna) {
        this.idVacuna = idVacuna;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getIdCitas() {
        return idCitas;
    }

    public void setIdCitas(String idCitas) {
        this.idCitas = idCitas;
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
}
