package DAO;
import Entidades.Paciente;
import java.io.*;
import java.util.ArrayList;
public class PacienteCRUD {

    public static void escribirArchivoPaciente(ArrayList<Paciente> lista) {
        try {
            FileOutputStream escribir =
                    new FileOutputStream("C:\\evidenciajava\\listaPaciente.txt");
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

    public static ArrayList<Paciente> leerArchivoPaciente() {
        ArrayList<Paciente> otraLista = new ArrayList<>();
        try {
            FileInputStream leer =
                    new FileInputStream("C:\\evidenciajava\\listaPaciente.txt");
            ObjectInputStream miStream2 =
                    new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            otraLista = (ArrayList<Paciente>) o;
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error de E/S o lectura");
            System.out.println(e);
        }
        return otraLista;
    }

    public static void insertarPaciente(Paciente nuevoPaciente) {
        ArrayList<Paciente> lista = leerArchivoPaciente();
        lista.add(nuevoPaciente);
        escribirArchivoPaciente(lista);
    }

    public static Paciente buscarPacientePorID(String ID) {
        ArrayList<Paciente> lista = leerArchivoPaciente();
        for (Paciente paciente : lista) {
            if (paciente.getID().equals(ID)) {
                System.out.println("Paciente encontrado: " + paciente);
                return paciente;
            }
        }
        System.out.println("Paciente no encontrado para el ID: " + ID);
        return null;
    }

    public static void eliminarPaciente (Paciente paciente){
        ArrayList<Paciente> lista = leerArchivoPaciente();
        lista.removeIf(d -> d.getID().equals(paciente.getID()));
        escribirArchivoPaciente(lista);
    }

}
