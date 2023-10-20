package com.example.vv22029veterinaria.LOGICA;

import com.example.vv22029veterinaria.ENTIDADES.Raza;
import com.example.vv22029veterinaria.INTERFACES.IRaza;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Raza_Logic implements IRaza {

    String FileDirectorio;

    public Raza_Logic() {
        CargarDirectorio();
    }

    public void CargarDirectorio() {

        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Gamer\\Desktop\\Archivos de proyectos\\VV22029-VETERINARIA\\src\\main\\java\\com\\example\\vv22029veterinaria\\Config.properties")) {
            properties.load(fileInputStream);

            // Accede a valores de configuración
            FileDirectorio = properties.getProperty("Directorio_Archivo");

            System.out.println("Direcotrio de archivo Raza: " + FileDirectorio);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Raza> ObtenerRaza() {
        List<Raza> LstRazas = new ArrayList<>();

        try
        {

            BufferedReader reader = new BufferedReader(new FileReader(FileDirectorio));

            String linea;
            while ((linea = reader.readLine()) != null && !linea.equals("")) {
                Raza raza = new Raza(linea);
                LstRazas.add(raza);
            }

        } catch (IOException e)
        {
            System.out.println(e.toString());
        }

        return LstRazas;

    }

    @Override
    public boolean Crear(Raza raza) {

        return false;
    }

    @Override
    public boolean Actualizar(Raza raza) {
        return false;
    }

    @Override
    public boolean Eliminar(int idRaza) {
        return false;
    }
}
