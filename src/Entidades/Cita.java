package Entidades;

import java.io.Serializable;
import java.util.Date;

public class Cita implements Serializable {
    String ID,IDDoctor,IDPaciente,nombreDoctor, nombrePaciente,observaciones,fechaC, diaC, mesC, anioC;

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

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getIDDoctor() {
        return IDDoctor;
    }

    public void setIDDoctor(String IDDoctor) {
        this.IDDoctor = IDDoctor;
    }

    public String getIDPaciente() {
        return IDPaciente;
    }

    public void setIDPaciente(String IDPaciente) {
        this.IDPaciente = IDPaciente;
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
