package DAO;

import Entidades.Abogado;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class AbogadoCRUD {
    public static void escribirArchivoAbogado(ArrayList<Abogado> lista) {
        try {
            String directorio = "C:\\evidenciajava";
            String archivoRuta = directorio + "\\listaAbogado.txt";

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
            System.out.println("Datos de abogados escritos correctamente en " + archivoRuta);

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error de E/S");
            e.printStackTrace();
        }
    }


    public static ArrayList<Abogado> leerArchivo() {
        ArrayList<Abogado> otraLista = new ArrayList<>();
        try {
            FileInputStream leer =
                    new FileInputStream("C:\\evidenciajava\\listaAbogado.txt");
            ObjectInputStream miStream2 =
                    new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            otraLista = (ArrayList<Abogado>) o;
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error de E/S o lectura");
            System.out.println(e);
        }
        return otraLista;
    }

    public static void insertarAbogado(Abogado nuevoAbogado) {
        ArrayList<Abogado> lista = leerArchivo();
        lista.add(nuevoAbogado);
        escribirArchivoAbogado(lista);
        System.out.println("Abogado insertado: " + nuevoAbogado);
    }


    public static Abogado buscarAbogadoPorID(String ID) {
        ArrayList<Abogado> lista = leerArchivo();
        for (Abogado abogado : lista) {
            if (abogado.getID().equals(ID)) {
                System.out.println("Abogado encontrado: " + abogado);
                return abogado;
            }
        }
        System.out.println("Abogado no encontrado para el ID: " + ID);
        return null;
    }

    public static void eliminarAbogado(Abogado abogado) {
        ArrayList<Abogado> lista = leerArchivo();
        lista.removeIf(d -> d.getID().equals(abogado.getID()));
        escribirArchivoAbogado(lista);
    }

    public static void asignarIDAbogadoCB(JComboBox<String> cmbIDAbogadoC) {
        ArrayList<Abogado> lista = leerArchivo();
        for (Abogado a : lista) {
            cmbIDAbogadoC.addItem(a.getID());
        }
    }
}



