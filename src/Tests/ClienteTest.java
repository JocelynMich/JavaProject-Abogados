package Tests;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import Entidades.Cliente;
import DAO.ClienteCRUD;
import java.io.File;
import java.util.ArrayList;

public class ClienteTest {

    static final String TEST_ID = "TEST123";

    @Test
    @Order(1)
    void testInsertarYBuscarCliente() {
        Cliente cliente = new Cliente();
        cliente.setID(TEST_ID);
        cliente.setNombre("Test");
        cliente.setApellidoP("Apellido");
        cliente.setApellidoM("Prueba");
        cliente.setDiaFNP("01");
        cliente.setMesFNP("01");
        cliente.setAnioFNP("2000");
        cliente.setGenero("Otro");
        cliente.setTelefono("0000000000");
        cliente.setCorreo("test@correo.com");
        cliente.setObservacionM("Cliente de prueba");
        cliente.setFechaN("01/01/2000");

        ClienteCRUD.insertarCliente(cliente);

        Cliente clienteBuscado = ClienteCRUD.buscarClientePorID(TEST_ID);
        assertNotNull(clienteBuscado);
        assertEquals("Test", clienteBuscado.getNombre());
        assertEquals("0000000000", clienteBuscado.getTelefono());
        ClienteCRUD.eliminarCliente(cliente);

    }

    @Test
    @Order(2)
    void testEliminarCliente() {
        Cliente cliente = new Cliente();
        cliente.setID(TEST_ID);
        cliente.setNombre("A eliminar");

        ClienteCRUD.insertarCliente(cliente);

        Cliente clienteBuscado = ClienteCRUD.buscarClientePorID(TEST_ID);
        assertNotNull(clienteBuscado);

        ClienteCRUD.eliminarCliente(cliente);

        Cliente clienteEliminado = ClienteCRUD.buscarClientePorID(TEST_ID);
        assertNull(clienteEliminado);
    }
}