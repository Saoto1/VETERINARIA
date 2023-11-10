package com.example.vv22029veterinaria.MAIN;

import com.example.vv22029veterinaria.ENTIDADES.Categoria;
import com.example.vv22029veterinaria.ENTIDADES.Medicamentos;
import com.example.vv22029veterinaria.ENTIDADES.Raza;
import com.example.vv22029veterinaria.ENTIDADES.Vacunas;
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


        //-------Prueba de metodos crud de Vacuna
        Vacunas VacunaCreada = new Vacunas();
        VacunaCreada.setId(9);
        VacunaCreada.setFechaVaccuna(new Date());
        VacunaCreada.setNombreVaccuna("Influenza");
        VacunaCreada.setPeso(3.4);
        VacunaCreada.setAltura(3.4);
        VacunaCreada.setEdad(23);
        VacunaCreada.setIdPaciente(2);

        vacunaLogic.Crear(VacunaCreada);
        VacunaCreada.setNombreVaccuna("H1N1");
        vacunaLogic.Actualizar(VacunaCreada);
        List<Vacunas> vacunasList = vacunaLogic.ObtenerVacunas();
        vacunaLogic.Eliminar(VacunaCreada.getId());


        //-------Prueba de metodos crud de raza
        Medicamentos medicamentosCreado = new Medicamentos();
        medicamentosCreado.setId(3);
        medicamentosCreado.setNombre("Paracetamol");
        medicamentosCreado.setFechaCreacion(new Date());

        medicamentosLogic.Crear(medicamentosCreado);
        medicamentosCreado.setNombre("Acetaminofen");
        medicamentosLogic.Actualizar(medicamentosCreado);
        List<Medicamentos> medicamentosList = medicamentosLogic.ObtenerMedicamentos();
        medicamentosLogic.Eliminar(medicamentosCreado.getId());


        //-------Prueba de metodos crud de Categoria
        Categoria categoria = new Categoria();
        categoria.setId(3);
        categoria.setNombre("Paracetamol");
        categoria.setFechaCreacion(new Date());

        categoriaLogic.Crear(categoria);
        medicamentosCreado.setNombre("Acetaminofen");
        categoriaLogic.Actualizar(categoria);
        List<Categoria> categoriaList = categoriaLogic.ObtenerCategorias();
        categoriaLogic.Eliminar(medicamentosCreado.getId());


    }

}
