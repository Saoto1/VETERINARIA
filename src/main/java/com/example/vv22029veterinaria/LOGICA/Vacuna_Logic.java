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
    public  boolean Eliminar(int id) {

        //Busca el registro
        List<Vacunas> vacunas = ObtenerVacunas();
        Vacunas VacunaEliminar = null;
        for (Vacunas Vacuna : vacunas) {
            if (Vacuna.getId() == id) {
                VacunaEliminar = Vacuna;
                break;
            }
        }

        //Lo elimina de la lista y sobre escribe el archivo
        if (VacunaEliminar != null) {
            vacunas.remove(VacunaEliminar);
            guardarListaEnArchivo(vacunas);
            System.out.println("Objeto con ID " + id + " eliminado con éxito.");

            return true;
        } else {
            System.out.println("No se encontró ningún objeto con el ID " + id);

            return false;
        }
    }


    public  void guardarListaEnArchivo(List<Vacunas> lista) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileDirectorio, false))) {

            if (lista.isEmpty()){return;}

            for (Vacunas objeto : lista) {
                // Crear un objeto SimpleDateFormat con el formato deseado
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                // Formatear la fecha a una cadena
                String fechaFormateada = formato.format(objeto.getFechaVaccuna());

                String objetoAEscribir = objeto.getId()+","+fechaFormateada+"," +objeto.getNombreVaccuna()+"," +objeto.getPeso()+"," +objeto.getAltura()+"," +objeto.getEdad()+"," +objeto.getIdPaciente()+",";
                writer.write(objetoAEscribir);
                writer.newLine();

            }
            System.out.println("Lista actualizada y guardada en el archivo: " + FileDirectorio);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
