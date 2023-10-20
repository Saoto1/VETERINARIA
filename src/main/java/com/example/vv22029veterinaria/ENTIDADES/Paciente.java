package com.example.vv22029veterinaria.ENTIDADES;

import java.util.Date;

public class Paciente {

    private String id;
    private String nombre;
    private String nombrePropietario;
    private int edad;
    private String idCategoria;
    private String sexo;
    private String idRazaInscripcion;
    private String idRaza;
    private double altura;
    private double peso;
    private Date fechaNacimiento;
    private String estadoPaciente;

    public Paciente(String id, String nombre, String nombrePropietario, int edad, String idCategoria, String sexo, String idRazaInscripcion, String idRaza, double altura, double peso, Date fechaNacimiento, String estadoPaciente) {
        this.id = id;
        this.nombre = nombre;
        this.nombrePropietario = nombrePropietario;
        this.edad = edad;
        this.idCategoria = idCategoria;
        this.sexo = sexo;
        this.idRazaInscripcion = idRazaInscripcion;
        this.idRaza = idRaza;
        this.altura = altura;
        this.peso = peso;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoPaciente = estadoPaciente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getIdRazaInscripcion() {
        return idRazaInscripcion;
    }

    public void setIdRazaInscripcion(String idRazaInscripcion) {
        this.idRazaInscripcion = idRazaInscripcion;
    }

    public String getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(String idRaza) {
        this.idRaza = idRaza;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstadoPaciente() {
        return estadoPaciente;
    }

    public void setEstadoPaciente(String estadoPaciente) {
        this.estadoPaciente = estadoPaciente;
    }
}
