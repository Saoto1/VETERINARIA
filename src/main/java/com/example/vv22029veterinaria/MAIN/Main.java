package com.example.vv22029veterinaria.MAIN;

import com.example.vv22029veterinaria.ENTIDADES.Raza;
import com.example.vv22029veterinaria.INTERFACES.IRaza;
import com.example.vv22029veterinaria.LOGICA.Raza_Logic;

import java.util.List;

public class Main {

    public static Raza_Logic razaLogic = new Raza_Logic();

    public Main(Raza_Logic raza) {
        this.razaLogic = raza;
    }
    public static void main(String[] args) {

      List<Raza> ListaRaza = razaLogic.ObtenerRaza();


    }

}
