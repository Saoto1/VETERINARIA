package com.example.vv22029veterinaria.LOGICA;

import com.example.vv22029veterinaria.ENTIDADES.Raza;
import com.example.vv22029veterinaria.INTERFACES.IRaza;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
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
        try (FileInputStream fileInputStream = new FileInputStream("src/main/java/com/example/vv22029veterinaria/Config.properties")) {
            properties.load(fileInputStream);

            // Accede a valores de configuración
            FileDirectorio = properties.getProperty("Archivo_Raza");

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

        try {
            List<Raza> LstRazas = this.ObtenerRaza();
            int size = LstRazas.size();
            int id = 1;

            if (size > 0) {
                id = LstRazas.get(size - 1).getId() + 1;
            }

            raza.setId(id);


            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fechaFormateada = sdf.format(raza.getFechaCreacion());

            String razaStr = raza.getId()+","+raza.getNombre()+","+fechaFormateada;

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.FileDirectorio, true))) {
                writer.write(razaStr);
                writer.newLine();
            }

            return true;
        } catch (IOException e) {
            return false;
        }

    }

    @Override
    public boolean Actualizar(Raza raza) {

        List<Raza> LstRazas = this.ObtenerRaza();

        try {
            for (int i = 0; i < LstRazas.size(); i++) {
                if (LstRazas.get(i).getId() == raza.getId()) {
                    LstRazas.set(i, raza);
                    break;
                }
            }

            GuardarRazas(LstRazas);

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    private void GuardarRazas(List<Raza> LstRazas) {
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileDirectorio, false))) {
                for (Raza raza : LstRazas) {

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String fechaFormateada = sdf.format(raza.getFechaCreacion());

                    String razaStr = raza.getId()+","+raza.getNombre()+","+fechaFormateada;

                    writer.write(razaStr);
                    writer.newLine();
                }
            }

        } catch (IOException e) {
        }
    }


    @Override
    public boolean Eliminar(int idRaza) {

        try {
            // Leer el archivo y almacenar las líneas en una lista
            List<String> lines = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(FileDirectorio));
            String line;
            while ((line = reader.readLine()) != null) {
                // Dividir la línea en partes (considerando que el ID es la primera parte)
                String[] parts = line.split(",");
                if (parts.length > 0) {
                    try {
                        int id = Integer.parseInt(parts[0]);
                        if (id != idRaza) {
                            // Agregar la línea al contenido si el ID no coincide con el ID a eliminar
                            lines.add(line);
                        }
                    } catch (NumberFormatException e) {
                        // Manejar el caso en el que no se pueda convertir el ID a un número
                        System.err.println("Error al leer el ID en la línea: " + line);
                    }
                }
            }
            reader.close();

            // Sobrescribir el archivo con el contenido actualizado
            BufferedWriter writer = new BufferedWriter(new FileWriter(FileDirectorio));
            for (String newLine : lines) {
                writer.write(newLine);
                writer.newLine(); // Agregar un salto de línea
            }
            writer.close();

            System.out.println("Línea con ID " + idRaza + " eliminada exitosamente.");

            return true;
        } catch (IOException e) {
            e.printStackTrace();

            return false;
        }


    }
}
