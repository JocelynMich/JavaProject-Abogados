package DAO;

import Entidades.Doctor;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class DoctorCRUD {
    public static void escribirArchivo(ArrayList<Doctor> lista) {
        try {
            FileOutputStream escribir =
                    new FileOutputStream("C:\\evidenciajava\\listaDoctor.txt");
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

    public static ArrayList<Doctor> leerArchivo() {
        ArrayList<Doctor> otraLista = new ArrayList<>();
        try {
            FileInputStream leer =
                    new FileInputStream("C:\\evidenciajava\\listaDoctor.txt");
            ObjectInputStream miStream2 =
                    new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            otraLista = (ArrayList<Doctor>) o;
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error de E/S o lectura");
            System.out.println(e);
        }
        return otraLista;
    }

    public static void insertarDoctor(Doctor nuevoDoctor) {
        ArrayList<Doctor> lista = leerArchivo();
        lista.add(nuevoDoctor);
        escribirArchivo(lista);
    }


    public static Doctor buscarDoctorPorID(String ID) {
        ArrayList<Doctor> lista = leerArchivo();
        for (Doctor doctor : lista) {
            if (doctor.getID().equals(ID)) {
                System.out.println("Doctor encontrado: " + doctor);
                return doctor;
            }
        }
        System.out.println("Doctor no encontrado para el ID: " + ID);
        return null;
    }

    public static void eliminarDoctor(Doctor doctor) {
        ArrayList<Doctor> lista = leerArchivo();
        lista.removeIf(d -> d.getID().equals(doctor.getID()));
        escribirArchivo(lista);
    }

    public static void asignarIDDoctorCB(JComboBox<String> cmbIDDoctorC) {
        ArrayList<Doctor> lista = leerArchivo();
        for (Doctor a : lista) {
            cmbIDDoctorC.addItem(a.getID());
        }
    }
}



