package Entidades;

import java.io.Serializable;

public class Abogado implements Serializable {
    String ID,Nombre, ApellidoP, ApellidoM, Especialidad, Telefono, Correo, Genero, DiaFN, MesFN, AnioFN,FechaFN;

    public String getDiaFN() {
        return DiaFN;
    }

    public void setDiaFN(String diaFN) {
        DiaFN = diaFN;
    }

    public String getMesFN() {
        return MesFN;
    }

    public void setMesFN(String mesFN) {
        MesFN = mesFN;
    }

    public String getAnioFN() {
        return AnioFN;
    }

    public void setAnioFN(String anioFN) {
        AnioFN = anioFN;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidoP() {
        return ApellidoP;
    }

    public void setApellidoP(String apellidoP) {
        ApellidoP = apellidoP;
    }

    public String getApellidoM() {
        return ApellidoM;
    }

    public void setApellidoM(String apellidoM) {
        ApellidoM = apellidoM;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String especialidad) {
        Especialidad = especialidad;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getFechaFN() {
        return FechaFN;
    }

    public void setFechaFN(String fechaFN) {
        FechaFN = fechaFN;
    }
}
