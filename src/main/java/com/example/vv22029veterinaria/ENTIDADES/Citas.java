package com.example.vv22029veterinaria.ENTIDADES;

import java.util.Date;

public class Citas {
    private String id;
    private Date fechaCita;
    private String nombrePaciente;
    private String motivoCita;
    private String idPaciente;
    private String idEstadoCita;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getMotivoCita() {
        return motivoCita;
    }

    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getIdEstadoCita() {
        return idEstadoCita;
    }

    public void setIdEstadoCita(String idEstadoCita) {
        this.idEstadoCita = idEstadoCita;
    }
}
