//Evidencia Final Java Version 1
//Prueba de conexión

import DAO.PacienteCRUD;
import Entidades.Doctor;
import java.util.Date;
import DAO.DoctorCRUD;
import Entidades.Paciente;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
        ArrayList<Doctor> lista = new ArrayList<Doctor>();
        Doctor a = new Doctor();
        a.setID("0000");
        a.setNombre("Diego");
        a.setApellidoP("Perez");
        a.setApellidoM("Castillo");
        a.setEspecialidad("Medicina General");
        a.setTelefono("992375635");
        a.setCorreo("diego_castimora@gmail.com");
        a.setGenero("Masculino");
        a.setDiaFN("18");
        a.setMesFN("Febrero");
        a.setAnioFN("1990");
        //Fecha de Nacimiento con Date
        Date fechaN = new Date(90, 2, 18);
        a.setFechaNac(fechaN);
        lista.add(a);


        Doctor b = new Doctor();
        b.setID("0001");
        b.setNombre("Carmen");
        b.setApellidoP("Valladares");
        b.setApellidoM("Montiel");
        b.setEspecialidad("Cardiología");
        b.setTelefono("994892732");
        b.setCorreo("carmen_vallamonte@gmail.com");
        b.setGenero("Femenino");
        //Fecha de Nacimiento con Date
        Date fechaNa = new Date(92, 4, 6);
        b.setFechaNac(fechaN);

        b.setDiaFN("6");
        b.setMesFN("Abril");
        b.setAnioFN("1992");

         */
        ArrayList<Paciente> lista = new ArrayList<Paciente>();
        Paciente a = new Paciente();
        a.setID("0000");
        a.setNombre("Daniel");
        a.setApellidoP("Flores");
        a.setApellidoM("Gutierrez");
        a.setTelefono("998567253");
        a.setCorreo("daniel_flores@gmail.com");
        a.setGenero("Masculino");
        a.setDiaFNP("29");
        a.setMesFNP("Agosto");
        a.setAnioFNP("2001");
        a.setObservacionM("Alergia al chocolate y al Ibuprofeno");
        PacienteCRUD.insertarPaciente(a);
        System.out.println(PacienteCRUD.buscarPacientePorID("0000"));
        System.out.println(a.getObservacionM());
        /*
        try{
            FileOutputStream escribir=
                new FileOutputStream("C:\\evidenciajava\\listaPaciente.txt");
            ObjectOutputStream miStream=
                    new ObjectOutputStream(escribir);
            miStream.writeObject(lista);
            miStream.close();
            //Leer lista desde archivo
            FileInputStream leer=
                    new FileInputStream("C:\\evidenciajava\\listaPaciente.txt");
            ObjectInputStream miStream2 =
                    new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<Doctor> otralista= (ArrayList<Doctor>)o;
            miStream2.close();

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error de E/S");
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Error de lectura");
        }



         /*
        b.setEspecialidad("Cardiología");

        System.out.println(b.getEspecialidad());
        System.out.println(a.getEspecialidad());
        System.out.println(DoctorCRUD.buscarDoctorPorID("0001"));

          */
    }

    }
