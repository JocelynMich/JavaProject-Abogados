package Entidades;

import java.util.Date;

public class Cita {
    String ID,IDDoctor,IDPaciente,observaciones;
    Date fechaC;

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

    public Date getFechaC() {
        return fechaC;
    }

    public void setFechaC(Date fechaC) {
        this.fechaC = fechaC;
    }
}
