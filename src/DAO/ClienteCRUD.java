package DAO;

import Entidades.Cliente;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class ClienteCRUD {

    public static void escribirArchivoCliente(ArrayList<Cliente> lista) {
        try {
            String directorio = "C:\\evidenciajava";
            String archivoRuta = directorio + "\\listaCliente.txt";

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
            System.out.println("Datos de cliente escrito correctamente en " + archivoRuta);

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error de E/S");
            e.printStackTrace();
        }
    }

    public static ArrayList<Cliente> leerArchivoCliente() {
        ArrayList<Cliente> otraLista = new ArrayList<>();
        try {
            FileInputStream leer =
                    new FileInputStream("C:\\evidenciajava\\listaCliente.txt");
            ObjectInputStream miStream2 =
                    new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            otraLista = (ArrayList<Cliente>) o;
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error de E/S o lectura");
            System.out.println(e);
        }
        return otraLista;
    }

    public static void insertarCliente(Cliente nuevoCliente) {
        ArrayList<Cliente> lista = leerArchivoCliente();
        lista.add(nuevoCliente);
        escribirArchivoCliente(lista);
    }

    public static Cliente buscarClientePorID(String ID) {
        ArrayList<Cliente> lista = leerArchivoCliente();
        for (Cliente cliente : lista) {
            if (cliente.getID().equals(ID)) {
                System.out.println("Cliente encontrado: " + cliente);
                return cliente;
            }
        }
        System.out.println("Cliente no encontrado para el ID: " + ID);
        return null;
    }

    public static void eliminarCliente (Cliente cliente){
        ArrayList<Cliente> lista = leerArchivoCliente();
        lista.removeIf(d -> d.getID().equals(cliente.getID()));
        escribirArchivoCliente(lista);
    }

    public static void asignarIDClienteCB(JComboBox<String> cmbIDClienteC) {
        ArrayList<Cliente> lista = leerArchivoCliente();
        for (Cliente a: lista) {
            cmbIDClienteC.addItem(a.getID());
        }
    }

}

