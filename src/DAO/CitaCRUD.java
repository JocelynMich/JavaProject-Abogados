package DAO;

import Entidades.Cita;
import Entidades.Cliente;

import java.io.*;
import java.util.ArrayList;

public class CitaCRUD {
    public static void escribirArchivoCita(ArrayList<Cita> lista) {
        try {
            String directorio = "C:\\evidenciajava";
            String archivoRuta = directorio + "\\listaCita.txt";

            File carpeta = new File(directorio);
            if (!carpeta.exists()) {
                boolean creada = carpeta.mkdirs();
                if (creada) {
                    System.out.println("Carpeta creada: " + directorio);
                } else {
                    System.out.println("No se pudo crear la carpeta: " + directorio);
                }
            }

            FileOutputStream escribir = new FileOutputStream(archivoRuta);
            ObjectOutputStream miStream = new ObjectOutputStream(escribir);
            miStream.writeObject(lista);
            miStream.close();
            System.out.println("Datos de citas escritos correctamente en " + archivoRuta);

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error de E/S");
            e.printStackTrace();
        }
    }


    public static ArrayList<Cita> leerArchivoCita() {
        ArrayList<Cita> otraLista = new ArrayList<>();
        try {
            FileInputStream leer =
                    new FileInputStream("C:\\evidenciajava\\listaCita.txt");
            ObjectInputStream miStream2 =
                    new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            otraLista = (ArrayList<Cita>) o;
            System.out.println("Datos de citas leidos correctamente.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error de E/S o lectura");
            System.out.println(e);
        }
        return otraLista;
    }

    public static void insertarCita(Cita nuevaCita) {
        ArrayList<Cita> lista = leerArchivoCita();
        lista.add(nuevaCita);
        escribirArchivoCita(lista);
        System.out.println("Cita insertada: " + nuevaCita);
    }

    public static Cita buscarCitaPorID(String ID) {
        ArrayList<Cita> lista = leerArchivoCita();
        for (Cita cita : lista) {
            if (cita.getID().equals(ID)) {
                System.out.println("Cita encontrada: " + cita);
                return cita;
            }
        }
        System.out.println("Cita no encontrado para el ID: " + ID);
        return null;
    }

    public static void eliminarCita (Cita cita){
        ArrayList<Cita> lista = leerArchivoCita();
        lista.removeIf(d -> d.getID().equals(cita.getID()));
        escribirArchivoCita(lista);
    }



}
