package Entidades;

import java.io.Serializable;

public class Paciente implements Serializable {
    String ID,Nombre,ApellidoP,ApellidoM, DiaFNP, MesFNP, AnioFNP, Genero, Telefono, Correo,ObservacionM;

    public String getObservacionM() {
        return ObservacionM;
    }

    public void setObservacionM(String observacionM) {
        ObservacionM = observacionM;
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

    public String getDiaFNP() {
        return DiaFNP;
    }

    public void setDiaFNP(String diaFNP) {
        DiaFNP = diaFNP;
    }

    public String getMesFNP() {
        return MesFNP;
    }

    public void setMesFNP(String mesFNP) {
        MesFNP = mesFNP;
    }

    public String getAnioFNP() {
        return AnioFNP;
    }

    public void setAnioFNP(String anioFNP) {
        AnioFNP = anioFNP;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
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
}
