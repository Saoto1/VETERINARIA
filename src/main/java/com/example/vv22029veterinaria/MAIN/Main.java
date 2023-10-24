package com.example.vv22029veterinaria.MAIN;

import com.example.vv22029veterinaria.ENTIDADES.Raza;
import com.example.vv22029veterinaria.LOGICA.*;

import java.util.Date;
import java.util.List;

public class Main {

    public static Raza_Logic razaLogic = new Raza_Logic();
    public static Categoria_Logic categoriaLogic = new Categoria_Logic();
    public static Citas_Logic citasLogic = new Citas_Logic();
    public static EstadoCita_Logic estadoCitaLogic = new EstadoCita_Logic();
    public static Expediente_Logic expedienteLogic = new Expediente_Logic();
    public static Medicamentos_Logic medicamentosLogic = new Medicamentos_Logic();
    public static Paciente_Logic pacienteLogic = new Paciente_Logic();
    public static Vacuna_Logic vacunaLogic = new Vacuna_Logic();

    public Main(Raza_Logic raza,Categoria_Logic categoriaLogic,Citas_Logic citasLogic,EstadoCita_Logic estadoCitaLogic,Expediente_Logic expedienteLogic,
                Medicamentos_Logic medicamentosLogic,Paciente_Logic pacienteLogic,Vacuna_Logic vacunaLogic) {
        this.razaLogic = raza;
        this.categoriaLogic = categoriaLogic;
        this.citasLogic = citasLogic;
        this.estadoCitaLogic = estadoCitaLogic;
        this.expedienteLogic = expedienteLogic;
        this.medicamentosLogic = medicamentosLogic;
        this.pacienteLogic = pacienteLogic;
        this.vacunaLogic = vacunaLogic;
    }

    public static void main(String[] args) {

        //-------Prueba de metodos crud de raza
        Raza Razacreada = new Raza();
        Razacreada.setId(3);
        Razacreada.setNombre("Dalmata");
        Razacreada.setFechaCreacion(new Date());

        razaLogic.Crear(Razacreada);
        Razacreada.setNombre("Danes");
        razaLogic.Actualizar(Razacreada);
        List<Raza> ListaRaza = razaLogic.ObtenerRaza();
        razaLogic.Eliminar(Razacreada.getId());



    }

}
