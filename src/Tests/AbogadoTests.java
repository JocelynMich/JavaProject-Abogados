package Tests;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import Entidades.Abogado;
import DAO.AbogadoCRUD;
import java.io.File;
import java.util.ArrayList;

public class AbogadoTests {
    @Test
    @Order(1)
    void testInsertarYBuscarAbogado() {
        Abogado abogado = new Abogado();
        abogado.setID("A004");
        abogado.setNombre("Jocelyn");
        abogado.setApellidoP("Morales");
        abogado.setApellidoM("Montiel");
        abogado.setEspecialidad("Derecho Internacional");
        abogado.setTelefono("1234567890");
        abogado.setCorreo("jocelyn@ejemplo.com");
        abogado.setGenero("Femenino");
        abogado.setDiaFN("13");
        abogado.setMesFN("09");
        abogado.setAnioFN("1994");
        abogado.setFechaFN("13/09/1994");
        AbogadoCRUD.insertarAbogado(abogado);
        Abogado resultado = AbogadoCRUD.buscarAbogadoPorID("A004");

        assertNotNull(resultado);
        assertEquals("Jocelyn", resultado.getNombre());
        assertEquals("Derecho Internacional", resultado.getEspecialidad());
    }

    @Test
    @Order(2)
    void testEliminarAbogado() {
        Abogado abogado = new Abogado();
        abogado.setID("A002");
        abogado.setNombre("Carlos");
        abogado.setApellidoP("Pérez");
        abogado.setApellidoM("Hernández");
        abogado.setEspecialidad("Laboral");
        abogado.setTelefono("0987654321");
        abogado.setCorreo("carlos@ejemplo.com");
        abogado.setGenero("Masculino");
        abogado.setDiaFN("15");
        abogado.setMesFN("08");
        abogado.setAnioFN("1985");
        abogado.setFechaFN("15/08/1985");
        AbogadoCRUD.insertarAbogado(abogado);
        assertNotNull(AbogadoCRUD.buscarAbogadoPorID("A002"));

        AbogadoCRUD.eliminarAbogado(abogado);
        assertNull(AbogadoCRUD.buscarAbogadoPorID("A002"));
    }
}