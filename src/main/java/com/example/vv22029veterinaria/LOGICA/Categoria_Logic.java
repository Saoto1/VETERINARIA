package com.example.vv22029veterinaria.LOGICA;

import com.example.vv22029veterinaria.ENTIDADES.Categoria;
import com.example.vv22029veterinaria.ENTIDADES.Categoria;
import com.example.vv22029veterinaria.INTERFACES.ICategoria;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Categoria_Logic implements ICategoria {

    String FileDirectorio;

    public Categoria_Logic() {
        CargarDirectorio();
    }

    public void CargarDirectorio() {

        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/main/java/com/example/vv22029veterinaria/Config.properties")) {
            properties.load(fileInputStream);

            // Accede a valores de configuración
            FileDirectorio = properties.getProperty("Archivo_Categoria");

            System.out.println("Direcotrio de archivo Categoria: " + FileDirectorio);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Categoria> ObtenerCategorias() {
        List<Categoria> LstCategorias = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(FileDirectorio));

            String linea;
            while ((linea = reader.readLine()) != null && !linea.equals("")) {
                Categoria Categoria = new Categoria(linea);
                LstCategorias.add(Categoria);
            }

        } catch (IOException e) {
            System.out.println(e.toString());
        }

        return LstCategorias;

    }

    @Override
    public boolean Crear(Categoria Categoria) {

        try {
            List<Categoria> LstCategorias = this.ObtenerCategorias();
            int size = LstCategorias.size();
            int id = 1;

            if (size > 0) {
                id = LstCategorias.get(size - 1).getId() + 1;
            }

            Categoria.setId(id);


            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fechaFormateada = sdf.format(Categoria.getFechaCreacion());

            String CategoriaStr = Categoria.getId() + "," + Categoria.getNombre() + "," + fechaFormateada;

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.FileDirectorio, true))) {
                writer.write(CategoriaStr);
                writer.newLine();
            }

            return true;
        } catch (IOException e) {
            return false;
        }

    }

    @Override
    public boolean Actualizar(Categoria Categoria) {

        List<Categoria> LstCategorias = this.ObtenerCategorias();

        try {
            for (int i = 0; i < LstCategorias.size(); i++) {
                if (LstCategorias.get(i).getId() == Categoria.getId()) {
                    LstCategorias.set(i, Categoria);
                    break;
                }
            }

            GuardarCategorias(LstCategorias);

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    private void GuardarCategorias(List<Categoria> LstCategorias) {
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileDirectorio, false))) {
                for (Categoria Categoria : LstCategorias) {

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String fechaFormateada = sdf.format(Categoria.getFechaCreacion());

                    String CategoriaStr = Categoria.getId() + "," + Categoria.getNombre() + "," + fechaFormateada;

                    writer.write(CategoriaStr);
                    writer.newLine();
                }
            }

        } catch (IOException e) {
        }
    }


    @Override
    public boolean Eliminar(int idCategoria) {

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
                        if (id != idCategoria) {
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

            System.out.println("Línea con ID " + idCategoria + " eliminada exitosamente.");

            return true;
        } catch (IOException e) {
            e.printStackTrace();

            return false;
        }


    }

}
