package Entidades;

import java.io.Serializable;
import java.util.Date;

//Modificaciones en Citas

public class Cita implements Serializable {
    String ID,IDAbogado,IDCliente,nombreAbogado,nombreCliente,observaciones,fechaC, diaC, mesC, anioC,especialidadAbogado;

    public String getDiaC() {
        return diaC;
    }

    public void setDiaC(String diaC) {
        this.diaC = diaC;
    }

    public String getMesC() {
        return mesC;
    }

    public void setMesC(String mesC) {
        this.mesC = mesC;
    }

    public String getAnioC() {
        return anioC;
    }

    public void setAnioC(String anioC) {
        this.anioC = anioC;
    }

    public String getNombreAbogado() {
        return nombreAbogado;
    }

    public void setNombreAbogado(String nombreAbogado) {
        this.nombreAbogado = nombreAbogado;
    }


    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getEspecialidadAbogado() {
        return especialidadAbogado;
    }

    public void setEspecialidadAbogado(String especialidadAbogado) {
        this.especialidadAbogado = especialidadAbogado;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }


    public void setIDAbogado(String IDAbogado) {
        this.IDAbogado = IDAbogado;
    }

    public String getIDAbogado() {
        return IDAbogado;
    }



    public String getIDCliente() {
        return IDCliente;
    }


    public void setIDCliente(String IDCliente) {
        this.IDCliente = IDCliente;
    }


    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }


    public String getFechaC() {
        return fechaC;
    }

    public void setFechaC(String fechaC) {
        this.fechaC = fechaC;
    }
}
