package com.example.vv22029veterinaria.LOGICA;

import com.example.vv22029veterinaria.ENTIDADES.Raza;
import com.example.vv22029veterinaria.ENTIDADES.Vacunas;
import com.example.vv22029veterinaria.INTERFACES.IVacuna;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Vacuna_Logic implements IVacuna {

    String FileDirectorio;

    public Vacuna_Logic() {
        CargarDirectorio();
    }

    public void CargarDirectorio() {

        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/main/java/com/example/vv22029veterinaria/Config.properties")) {
            properties.load(fileInputStream);

            // Accede a valores de configuración
            FileDirectorio = properties.getProperty("Archivo_Vacuna");

            System.out.println("Direcotrio de archivo Raza: " + FileDirectorio);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Vacunas> ObtenerVacunas() {

        List<Vacunas> vacunasList = new ArrayList<>();

        try
        {

            BufferedReader reader = new BufferedReader(new FileReader(FileDirectorio));

            String linea;
            while ((linea = reader.readLine()) != null && !linea.equals("")) {
                Vacunas vacunas = new Vacunas(linea);
                vacunasList.add(vacunas);
            }

        } catch (IOException e)
        {
            System.out.println(e.toString());
        }

        return vacunasList;

    }

    @Override
    public boolean Crear(Vacunas vacunas) {

        try {
            List<Vacunas> vacunasList = this.ObtenerVacunas();
            int size = vacunasList.size();
            int id = 1;

            if (size > 0) {
                id = vacunasList.get(size - 1).getId() + 1;
            }

            vacunas.setId(id);


            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fechaFormateada = sdf.format(vacunas.getFechaVaccuna());

            String razaStr = vacunas.getId()+","+fechaFormateada+","+vacunas.getNombreVaccuna()+","+vacunas.getPeso()+","+vacunas.getAltura()+","+vacunas.getEdad()+","+vacunas.getIdPaciente();

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
    public boolean Actualizar(Vacunas vacunas) {
        List<Vacunas> vacunasList = this.ObtenerVacunas();

        try {
            for (int i = 0; i < vacunasList.size(); i++) {
                if (vacunasList.get(i).getId() == vacunas.getId()) {
                    vacunasList.set(i, vacunas);
                    break;
                }
            }

            GuardarVacunas(vacunasList);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void GuardarVacunas(List<Vacunas> vacunasList) {
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileDirectorio, false))) {
                for (Vacunas vacunas : vacunasList) {

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String fechaFormateada = sdf.format(vacunas.getFechaVaccuna());

                    String razaStr = vacunas.getId()+","+fechaFormateada+","+vacunas.getNombreVaccuna()+","+vacunas.getPeso()+","+vacunas.getAltura()+","+vacunas.getEdad()+","+vacunas.getIdPaciente();

                    writer.write(razaStr);
                    writer.newLine();
                }
            }

        } catch (IOException e) {
        }
    }

    @Override
    public boolean Eliminar(int idVacuna) {

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
                        if (id != idVacuna) {
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

            System.out.println("Línea con ID " + idVacuna + " eliminada exitosamente.");

            return true;
        } catch (IOException e) {
            e.printStackTrace();

            return false;
        }

    }
}
