package DAO;

import Entidades.Cita;
import java.io.*;
import java.util.ArrayList;

public class CitaCRUD {
    public static void escribirArchivoCita(ArrayList<Cita> lista) {
        try {
            FileOutputStream escribir =
                    new FileOutputStream("C:\\evidenciajava\\listaCita.txt");
            ObjectOutputStream miStream =
                    new ObjectOutputStream(escribir);
            miStream.writeObject(lista);
            System.out.println("Datos de citas escritos correctamente.");

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error de E/S");
            System.out.println(e);
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




}
