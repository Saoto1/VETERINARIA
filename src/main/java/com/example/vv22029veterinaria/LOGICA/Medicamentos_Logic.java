package com.example.vv22029veterinaria.LOGICA;

import com.example.vv22029veterinaria.ENTIDADES.Medicamentos;
import com.example.vv22029veterinaria.ENTIDADES.Raza;
import com.example.vv22029veterinaria.INTERFACES.IMedicamentos;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Medicamentos_Logic implements IMedicamentos {

    String FileDirectorio;

    public Medicamentos_Logic() {
        CargarDirectorio();
    }

    public void CargarDirectorio() {

        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/main/java/com/example/vv22029veterinaria/Config.properties")) {
            properties.load(fileInputStream);

            // Accede a valores de configuración
            FileDirectorio = properties.getProperty("Archivo_Medicamentos");

            System.out.println("Direcotrio de archivo Raza: " + FileDirectorio);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public List<Medicamentos> ObtenerMedicamentos() {

        List<Medicamentos> medicamentos = new ArrayList<>();

        try
        {

            BufferedReader reader = new BufferedReader(new FileReader(FileDirectorio));

            String linea;
            while ((linea = reader.readLine()) != null && !linea.equals("")) {
                Medicamentos raza = new Medicamentos(linea);
                medicamentos.add(raza);
            }

        } catch (IOException e)
        {
            System.out.println(e.toString());
        }

        return medicamentos;

    }

    @Override
    public boolean Crear(Medicamentos medicamentos) {

        try {
            List<Medicamentos> medicamentos1 = this.ObtenerMedicamentos();
            int size = medicamentos1.size();
            int id = 1;

            if (size > 0) {
                id = medicamentos1.get(size - 1).getId() + 1;
            }

            medicamentos.setId(id);


            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fechaFormateada = sdf.format(medicamentos.getFechaCreacion());

            String razaStr = medicamentos.getId()+","+medicamentos.getNombre()+","+fechaFormateada;

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
    public boolean Actualizar(Medicamentos medicamentos) {

        List<Medicamentos> medicamentosList = this.ObtenerMedicamentos();

        try {
            for (int i = 0; i < medicamentosList.size(); i++) {
                if (medicamentosList.get(i).getId() == medicamentos.getId()) {
                    medicamentosList.set(i, medicamentos);
                    break;
                }
            }

            GuardarMedicamentos(medicamentosList);

            return true;
        } catch (Exception e) {
            return false;
        }

    }


    private void GuardarMedicamentos(List<Medicamentos> medicamentos) {
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileDirectorio, false))) {
                for (Medicamentos medicamentos1 : medicamentos) {

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String fechaFormateada = sdf.format(medicamentos1.getFechaCreacion());

                    String razaStr = medicamentos1.getId()+","+medicamentos1.getNombre()+","+fechaFormateada;

                    writer.write(razaStr);
                    writer.newLine();
                }
            }

        } catch (IOException e) {
        }
    }

    @Override
    public boolean Eliminar(int idMedicamentps) {

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
                        if (id != idMedicamentps) {
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

            System.out.println("Línea con ID " + idMedicamentps + " eliminada exitosamente.");

            return true;
        } catch (IOException e) {
            e.printStackTrace();

            return false;
        }

    }
}
