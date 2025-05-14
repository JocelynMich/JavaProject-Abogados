package Tests;
import DAO.CitaCRUD;
import Entidades.Cita;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CitaTest {
    static final String TEST_ID = "CITA_TEST123";
    @Test
    @Order(1)
    void testInsertarCita() {
        Cita cita = new Cita();
        cita.setID(TEST_ID);
        cita.setIDAbogado("AB123");
        cita.setIDCliente("CL456");
        cita.setNombreAbogado("Lic. Prueba");
        cita.setNombreCliente("Cliente Test");
        cita.setEspecialidadAbogado("Penal");
        cita.setDiaC("10");
        cita.setMesC("05");
        cita.setAnioC("2025");
        cita.setFechaC("10/05/2025");
        cita.setObservaciones("Primera cita de prueba");

        CitaCRUD.insertarCita(cita);

        Cita buscada = CitaCRUD.buscarCitaPorID(TEST_ID);
        assertNotNull(buscada);
        assertEquals("Cliente Test", buscada.getNombreCliente());
        assertEquals("Penal", buscada.getEspecialidadAbogado());
        CitaCRUD.eliminarCita(cita);

    }

    @Test
    @Order(2)
    void testEliminarCita() {
        Cita cita = new Cita();
        cita.setID(TEST_ID);
        cita.setNombreCliente("A eliminar");

        CitaCRUD.insertarCita(cita);

        assertNotNull(CitaCRUD.buscarCitaPorID(TEST_ID));

        CitaCRUD.eliminarCita(cita);

        assertNull(CitaCRUD.buscarCitaPorID(TEST_ID));
    }

}
