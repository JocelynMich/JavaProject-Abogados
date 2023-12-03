package DAO;

import Entidades.Cita;
import Entidades.Paciente;
import Entidades.Doctor;
import GUI.Menu;
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
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error de E/S o lectura");
            System.out.println(e);
        }
        return otraLista;
    }



}
