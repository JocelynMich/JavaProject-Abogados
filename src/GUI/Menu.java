package GUI;

import DAO.CitaCRUD;
import DAO.ClienteCRUD;
import DAO.AbogadoCRUD;
import Entidades.Cliente;
import Entidades.Abogado;
import Entidades.Cita;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Menu extends JFrame{
    private JPanel MiPanel;
    private JTabbedPane TPMenu;
    private JTextField txtIDA;
    private JTextField txtApellidoPA;
    private JTextField txtApellidoMA;
    private JTextField txtNombreA;
    private JLabel lblIDA;
    private JLabel lblNombreA;
    private JLabel lblApellidoPA;
    private JLabel lblApellidoMA;
    private JLabel lblEspecialidadA;
    private JComboBox cbEspecialidadA;
    private JComboBox cbGeneroA;
    private JTextField txtTelefonoA;
    private JPanel JPgtD;
    private JLabel lblGeneroA;
    private JLabel lblTelefonoD;
    private JLabel lblCorreoA;
    private JTextField txtCorreoA;
    private JLabel lblFechaNacA;
    private JTextField txtFechaNacD;
    private JButton btnBuscarA;
    private JPanel JPbtnD;
    private JButton btnCrearA;
    private JButton btnEditarA;
    private JButton btnEliminarA;
    private JComboBox cbDiaFNA;
    private JComboBox cbMesFNA;
    private JComboBox cbAnioFNA;
    private JTextField txtIDP;
    private JLabel lblIDCL;
    private JTextField txtNombreCL;
    private JTextField txtApellidoPCL;
    private JTextField txtApellidoMCL;
    private JLabel lblNombreCL;
    private JLabel lblApellidoPCL;
    private JLabel lblApellidoMCL;
    private JLabel lblFechaNacCL;
    private JComboBox cbDiaCL;
    private JComboBox cbMesCL;
    private JComboBox cbAnioCL;
    private JLabel lblTelefonoCL;
    private JTextField txtTelefonoCL;
    private JComboBox cbGeneroCL;
    private JLabel lblGeneroCL;
    private JTextField txtCorreoCL;
    private JLabel lblCorreoCL;
    private JLabel lblDTCL;
    private JTextField txtDICL;
    private JButton btnBuscarCL;
    private JButton btnCrearCL;
    private JButton btnEditarCL;
    private JButton btnBorrarCL;
    private JComboBox cbAbogadoID;
    private JComboBox cbClienteID;
    private JLabel lblAbogado;
    private JLabel lblCliente;
    private JTextField txtObservacionesC;
    private JLabel lblObservacionesC;
    private JLabel lblFechaC;
    private JButton btnCrearC;
    private JButton btnEditarC;
    private JButton btnBorrarC;
    private JPanel PanBtnC;
    private JPanel PanDatosDC;
    private JPanel PanObservacionesC;
    private JPanel PanFechaC;
    private JTextField txtNombreDC;
    private JTextField txtNombreCC;
    private JLabel lblNombreAC;
    private JLabel lblNombreCC;
    private JButton btnBuscarC;
    private JLabel lblIDC;
    private JTextField txtIDC;
    private JTextField txtFechaC;
    private JComboBox cbDiaC;
    private JComboBox cbMesC;
    private JComboBox cbAnioC;
    private JTextField txtFechaNACA;
    private JTextField txtFechaNacCL;
    private JButton btnCerrarSesión;
    private JTextField txtEspecialiadAC;
    private JLabel lblEspecialidadAC;
    ArrayList<Abogado> listaA;
    ArrayList<Cliente> listaC;


    //Metodo de Seleccionar en ComboBox de Abogado
    private void seleccionarMesEnComboBox(String mes) {
        cbMesFNA.setSelectedItem(mes);
    }
    private void seleccionarDiaEnComboBox(String dia) {
        cbDiaFNA.setSelectedItem(dia);
    }
    private void seleccionarAnioEnComboBox(String anio) {
        cbAnioFNA.setSelectedItem(anio);
    }
    private void seleccionarGeneroEnComboBox(String Genero) {
        cbGeneroA.setSelectedItem(Genero);
    }
    private void seleccionarEspecialidadEnComboBox(String Especialidad) {
        cbEspecialidadA.setSelectedItem(Especialidad);
    }

    //Metodo para Seleccionar en ComboBOX de Cliente
    private void seleccionarDiaPEnComboBox(String DiaP) {
        cbDiaCL.setSelectedItem(DiaP);
    }
    private void seleccionarMesPEnComboBox(String MesP) {
        cbMesCL.setSelectedItem(MesP);
    }
    private void seleccionarAnioPEnComboBox(String AnioP) {
        cbAnioCL.setSelectedItem(AnioP);
    }
    private void seleccionarGeneroPEnComboBox(String GeneroP) {
        cbGeneroCL.setSelectedItem(GeneroP);
    }

    //Metodo para Seleccionar en ComboBOX de Cita
    private void seleccionarIDAbogado(String IDD) { cbAbogadoID.setSelectedItem(IDD);}
    private void seleccionarIDCliente (String IDP) { cbClienteID.setSelectedItem(IDP);
    }
    private void seleccionarDiaCita(String DiaC) { cbDiaC.setSelectedItem(DiaC);}
    private void seleccionarMesCita (String MesC) { cbMesC.setSelectedItem(MesC);
    }
    private void seleccionarAnioCita (String AnioC) { cbAnioC.setSelectedItem(AnioC);
    }

    public Menu(boolean esAdmin) {
        setContentPane(MiPanel);
        if (!esAdmin) {
            TPMenu.removeTabAt(1);
            TPMenu.removeTabAt(0);
        }
        btnBuscarA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //buscar Abogado
                AbogadoCRUD crud = new AbogadoCRUD();
                String ID= txtIDA.getText();
                Abogado abogado = crud.buscarAbogadoPorID(ID);
                if (abogado==null){
                    int respuesta= JOptionPane.showConfirmDialog(MiPanel, "No se encontro el abogado por ID: " + ID+ "\n¿Deseas dar de alta?","Abogado no Encontrado",JOptionPane.YES_NO_OPTION);
                    if(respuesta==0){
                        limpiarFormularioAbogado();
                        btnEliminarA.setEnabled(false);
                        btnEditarA.setEnabled(false);
                        btnCrearA.setEnabled(true);
                        txtNombreA.requestFocus();
                    } else if(respuesta==1){
                        limpiarFormularioAbogado();
                    } else if(respuesta==-1){
                        limpiarFormularioAbogado();
                    }
                } else {
                    txtNombreA.setText(abogado.getNombre());
                    txtApellidoPA.setText(abogado.getApellidoP());
                    txtApellidoMA.setText(abogado.getApellidoM());
                    txtTelefonoA.setText(abogado.getTelefono());
                    txtCorreoA.setText(abogado.getCorreo());
                    //txtFechaNacD.setText(abogado.getFechaNac());
                    String MesFND = abogado.getMesFN();
                    seleccionarMesEnComboBox(MesFND);
                    String DiaFND = abogado.getDiaFN();
                    seleccionarDiaEnComboBox(DiaFND);
                    String AnioFND = abogado.getAnioFN();
                    seleccionarAnioEnComboBox(AnioFND);
                    String GeneroD = abogado.getGenero();
                    seleccionarGeneroEnComboBox(GeneroD);
                    String EspecialidadD = abogado.getEspecialidad();
                    seleccionarEspecialidadEnComboBox(EspecialidadD);
                    txtFechaNACA.setText(abogado.getFechaFN());
                    btnEliminarA.setEnabled(true);
                    btnEditarA.setEnabled(true);
                    btnCrearA.setEnabled(false);
                }
            }
        });

        btnCrearA.addActionListener(new ActionListener() {
            @Override
            //Crear un nuevo abogado
            public void actionPerformed(ActionEvent e) {
                String fecha = cbDiaFNA.getSelectedItem().toString() + "/" +
                        cbMesFNA.getSelectedItem().toString() + "/" +
                        cbAnioFNA.getSelectedItem().toString();
                boolean fechaValida = validarFecha(fecha);

                boolean camposAbogadoValidos = validarCampos();
                if (camposAbogadoValidos && fechaValida) {
                    Abogado a = new Abogado();
                    a.setID(txtIDA.getText());
                    a.setNombre(txtNombreA.getText());
                    a.setApellidoP(txtApellidoPA.getText());
                    a.setApellidoM(txtApellidoMA.getText());
                    String especialidad = (String) cbEspecialidadA.getSelectedItem();
                    a.setEspecialidad(especialidad);
                    a.setTelefono(txtTelefonoA.getText());
                    a.setCorreo(txtCorreoA.getText());
                    String genero = (String) cbGeneroA.getSelectedItem();
                    a.setGenero(genero);
                    String diaFN = (String) cbDiaFNA.getSelectedItem();
                    a.setDiaFN(diaFN);
                    String mesFN = (String) cbMesFNA.getSelectedItem();
                    a.setMesFN(mesFN);
                    String anioFN = (String) cbAnioFNA.getSelectedItem();
                    a.setAnioFN(anioFN);
                    a.setFechaFN(fecha);
                    AbogadoCRUD crud = new AbogadoCRUD();
                    crud.insertarAbogado(a);
                    limpiarFormularioAbogado();
                    crud.asignarIDAbogadoCB(cbAbogadoID);

                    JOptionPane.showMessageDialog(MiPanel, "Abogado creado con éxito");
                } else {
                    JOptionPane.showMessageDialog(MiPanel, "Error en los campos del abogado o en la validación de la fecha");

                    if (!fechaValida) {
                        txtFechaNACA.requestFocus();
                    }

                }
            }
        });
        btnEliminarA.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed (ActionEvent e){
                    //Eliminar Abogado
                    String ID = txtIDA.getText();
                    int respuesta = JOptionPane.showConfirmDialog(MiPanel, "¿Quieres eliminar al abogado?", "Eliminar Abogado", JOptionPane.YES_NO_OPTION);
                    if (respuesta == 0) {
                        if (!ID.isEmpty()) {
                            //Crear el abogado a eliminar
                            Abogado abogadoBorrar = new Abogado();
                            abogadoBorrar.setID(ID);
                            //Eliminar el abogado con el metodo crud
                            AbogadoCRUD crud = new AbogadoCRUD();
                            crud.eliminarAbogado(abogadoBorrar);
                            JOptionPane.showMessageDialog(MiPanel, "Se elimino el abogado exitosamente", "Abogado Eliminado", JOptionPane.INFORMATION_MESSAGE);
                            limpiarFormularioAbogado();
                        } else if (ID.isEmpty()) {
                            Abogado abogadoBorrar = new Abogado();
                            abogadoBorrar.setID(ID);
                            JOptionPane.showMessageDialog(MiPanel, "No especificaste el abogado a eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } else if (respuesta == 1) {
                        JOptionPane.showMessageDialog(MiPanel, "No se elimino el Abogado", "Abogado no Eliminado", JOptionPane.ERROR_MESSAGE);
                    } else if (respuesta == -1)
                        JOptionPane.showMessageDialog(MiPanel, "No se elimino el Abogado", "Abogado no Eliminado", JOptionPane.ERROR_MESSAGE);
                }
        });
        //Metodo de Cliente
        btnBuscarCL.addActionListener(new ActionListener() {
            @Override
            //Buscar cliente con ID
            public void actionPerformed(ActionEvent e) {
                ClienteCRUD crud1 = new ClienteCRUD();
                String ID= txtIDP.getText();
                Cliente cliente = crud1.buscarClientePorID(ID);
                if (cliente==null){
                    int respuesta=JOptionPane.showConfirmDialog(MiPanel, "No se encontro el cliente por ID: " + ID+ "\n¿Deseas dar de alta?","Cliente no Encontrado",JOptionPane.YES_NO_OPTION);
                    if(respuesta==0){
                        limpiarFormularioCliente();
                        btnBorrarCL.setEnabled(false);
                        btnEditarCL.setEnabled(false);
                        btnCrearCL.setEnabled(true);
                        txtNombreCL.requestFocus();
                    } else if(respuesta==1){
                        limpiarFormularioCliente();
                    } else if(respuesta==-1){
                        limpiarFormularioCliente();
                    }
                } else {
                    txtNombreCL.setText(cliente.getNombre());
                    txtApellidoPCL.setText(cliente.getApellidoP());
                    txtApellidoMCL.setText(cliente.getApellidoM());
                    txtTelefonoCL.setText(cliente.getTelefono());
                    txtCorreoCL.setText(cliente.getCorreo());
                    //txtFechaNacD.setText(abogado.getFechaNac());
                    String MesFNP = cliente.getMesFNP();
                    seleccionarMesPEnComboBox(MesFNP);
                    String DiaFNP = cliente.getDiaFNP();
                    seleccionarDiaPEnComboBox(DiaFNP);
                    String AnioFNP = cliente.getAnioFNP();
                    seleccionarAnioEnComboBox(AnioFNP);
                    String GeneroP = cliente.getGenero();
                    seleccionarGeneroEnComboBox(GeneroP);
                    txtDICL.setText(cliente.getObservacionM());
                    txtFechaNacCL.setText(cliente.getFechaN());
                    btnBorrarCL.setEnabled(true);
                    btnEditarCL.setEnabled(true);
                    btnCrearCL.setEnabled(false);
                }
            }

        });
        btnCrearCL.addActionListener(new ActionListener() {
            //Boton para crear Clientes
            @Override
            public void actionPerformed(ActionEvent e) {
                String fecha = cbDiaCL.getSelectedItem().toString() + "/" +
                        cbMesCL.getSelectedItem().toString() + "/" +
                        cbAnioCL.getSelectedItem().toString();

                boolean fechaValida = validarFecha(fecha);
                boolean camposClienteValidos = validarCamposCliente();

                if (camposClienteValidos && fechaValida) {
                    Cliente b = new Cliente();
                    b.setID(txtIDP.getText());
                    b.setNombre(txtNombreCL.getText());
                    b.setApellidoP(txtApellidoPCL.getText());
                    b.setApellidoM(txtApellidoMCL.getText());
                    b.setTelefono(txtTelefonoCL.getText());
                    b.setCorreo(txtCorreoCL.getText());
                    String generoP = (String) cbGeneroCL.getSelectedItem();
                    b.setGenero(generoP);
                    String diaFNP= (String) cbDiaCL.getSelectedItem();
                    b.setDiaFNP(diaFNP);
                    String mesFNP = (String) cbMesCL.getSelectedItem();
                    b.setMesFNP(mesFNP);
                    String anioFNP = (String) cbAnioCL.getSelectedItem();
                    b.setAnioFNP(anioFNP);
                    b.setObservacionM(txtDICL.getText());
                    b.setFechaN(fecha);
                    ClienteCRUD crud1 = new ClienteCRUD();
                    crud1.insertarCliente(b);
                    limpiarFormularioCliente();
                    crud1.asignarIDClienteCB(cbClienteID);

                    JOptionPane.showMessageDialog(MiPanel, "Cliente creado con éxito");
                } else {
                    JOptionPane.showMessageDialog(MiPanel, "Error en los campos del cliente o en la validación de la fecha");

                    if (!fechaValida) {
                        txtFechaNacCL.requestFocus();
                    }

                }
            }

        });

        //Mostrar las IDs de la lista de Abogados y Clientes en el ComboBox en las Consultas
                AbogadoCRUD crud= new AbogadoCRUD();
                crud.asignarIDAbogadoCB(cbAbogadoID);
                ClienteCRUD crud1 = new ClienteCRUD();
                crud1.asignarIDClienteCB(cbClienteID);
        cbClienteID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idClienteS = (String) cbClienteID.getSelectedItem();
                Cliente clienteSeleccionado = ClienteCRUD.buscarClientePorID(idClienteS);
                if (clienteSeleccionado != null) {
                    txtNombreCC.setText(clienteSeleccionado.getNombre() + " "+ clienteSeleccionado.getApellidoP() +" " + clienteSeleccionado.getApellidoM());
                } else {
                    txtNombreCC.setText("");
                }
            }
        });

        cbAbogadoID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idAbogadoS = (String) cbAbogadoID.getSelectedItem();
                Abogado abogadoSeleccionado = AbogadoCRUD.buscarAbogadoPorID(idAbogadoS);
                if (abogadoSeleccionado != null) {
                    txtNombreDC.setText(abogadoSeleccionado.getNombre() + " "+ abogadoSeleccionado.getApellidoP() + " " + abogadoSeleccionado.getApellidoM());
                    txtEspecialiadAC.setText(abogadoSeleccionado.getEspecialidad());
                } else {
                    txtNombreDC.setText("");
                }
            }
        });
        btnCrearC.addActionListener(new ActionListener() {
            //Boton para crear citas
            @Override
            public void actionPerformed(ActionEvent e) {
                String fecha = cbDiaC.getSelectedItem().toString() + "/" +
                        cbMesC.getSelectedItem().toString() + "/" +
                        cbAnioC.getSelectedItem().toString();

                boolean fechaValida = validarFecha(fecha);

                boolean camposCitaValidos = validarCamposCita();

                if (camposCitaValidos && fechaValida) {
                    Cita c = new Cita();
                    CitaCRUD crud3= new CitaCRUD();
                    c.setID(txtIDC.getText());
                    String idAbogado = (String) cbAbogadoID.getSelectedItem();
                    c.setIDAbogado(idAbogado);
                    String idCliente = (String) cbClienteID.getSelectedItem();
                    c.setIDCliente(idCliente);
                    c.setNombreAbogado(txtNombreDC.getText());
                    c.setNombreCliente(txtNombreCC.getText());
                    c.setEspecialidadAbogado(txtEspecialiadAC.getText());
                    c.setObservaciones(txtObservacionesC.getText());
                    c.setFechaC(fecha);
                    String diaC = (String) cbDiaC.getSelectedItem();
                    c.setDiaC(diaC);
                    String mesC = (String) cbMesC.getSelectedItem();
                    c.setMesC(mesC);
                    String anioC = (String) cbAnioC.getSelectedItem();
                    c.setAnioC(anioC);
                    crud3.insertarCita(c);
                    limpiarFormularioCita();

                    JOptionPane.showMessageDialog(MiPanel, "Cita creada con éxito");
                } else {
                    JOptionPane.showMessageDialog(MiPanel, "Error en los campos de la cita o en la fecha");

                    if (!fechaValida) {
                        txtFechaC.requestFocus();
                    }
                }
            }
        });
        btnBuscarC.addActionListener(new ActionListener() {
            //Boton para buscar citas por ID
            @Override
            public void actionPerformed(ActionEvent e) {
                CitaCRUD crud2 = new CitaCRUD();
                String ID= txtIDC.getText();
                Cita cita = crud2.buscarCitaPorID(ID);
                if (cita==null){
                    int respuesta=JOptionPane.showConfirmDialog(MiPanel, "No se encontro la cita por ID: " + ID+ "\n¿Deseas crear una cita?","Cita no Encontrada",JOptionPane.YES_NO_OPTION);
                    if(respuesta==0){
                        limpiarFormularioCita();
                        btnBorrarC.setEnabled(false);
                        btnEditarC.setEnabled(false);
                        btnCrearC.setEnabled(true);
                        txtObservacionesC.requestFocus();
                    } else if(respuesta==1){
                        limpiarFormularioCita();
                    } else if(respuesta==-1){
                        limpiarFormularioCita();
                    }
                } else {
                    txtObservacionesC.setText(cita.getObservaciones());
                    txtFechaC.setText(cita.getFechaC());
                    String IDAC = cita.getIDAbogado();
                    seleccionarIDAbogado(IDAC);
                    String IDCC = cita.getIDCliente();
                    seleccionarIDCliente(IDCC);
                    txtNombreDC.setText(cita.getNombreAbogado());
                    txtNombreCC.setText(cita.getNombreCliente());
                    txtEspecialiadAC.setText(cita.getEspecialidadAbogado());
                    txtObservacionesC.setText(cita.getObservaciones());
                    txtFechaC.setText(cita.getFechaC());
                    String DiaC = cita.getDiaC();
                    seleccionarDiaCita(DiaC);
                    String MesC = cita.getMesC();
                    seleccionarMesCita(MesC);
                    String AnioC= cita.getAnioC();
                    seleccionarAnioCita(AnioC);
                    btnBorrarC.setEnabled(true);
                    btnEditarC.setEnabled(true);
                    btnCrearC.setEnabled(false);
                }

            }

        }
        );

        btnBorrarC.addActionListener(new ActionListener() {
            @Override
            //Boton para borrar citas
            public void actionPerformed(ActionEvent e) {
                String ID = txtIDC.getText();
                int respuesta = JOptionPane.showConfirmDialog(MiPanel, "¿Quieres eliminar la cita?", "Eliminar Cita", JOptionPane.YES_NO_OPTION);
                if (respuesta == 0) {
                    if (!ID.isEmpty()) {
                        //Crear la cita a eliminar
                        Cita citaBorrar = new Cita();
                        citaBorrar.setID(ID);
                        //Eliminar la cita con el metodo crud
                        CitaCRUD crud = new CitaCRUD();
                        crud.eliminarCita(citaBorrar);
                        JOptionPane.showMessageDialog(MiPanel, "Se elimino la cita exitosamente", "Cita Eliminada", JOptionPane.INFORMATION_MESSAGE);
                        limpiarFormularioCita();
                    } else if (ID.isEmpty()) {
                        Cita citaBorrar = new Cita();
                        citaBorrar.setID(ID);
                        JOptionPane.showMessageDialog(MiPanel, "No especificaste la cita a eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } else if (respuesta == 1) {
                    JOptionPane.showMessageDialog(MiPanel, "No se elimino el Abogado", "Abogado no Eliminado", JOptionPane.ERROR_MESSAGE);
                } else if (respuesta == -1)
                    JOptionPane.showMessageDialog(MiPanel, "No se elimino el Abogado", "Abogado no Eliminado", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCerrarSesión.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(MiPanel, "¿Estás seguro de que deseas cerrar sesión?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    // Abrir de nuevo el Login
                    JFrame frame = new JFrame("Login");
                    frame.setContentPane(new Login().getJLogin());  // 👈 Necesitamos crear este getter abajo
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(300, 200);
                    frame.setLocationRelativeTo(null);  // Centra la ventana
                    frame.setVisible(true);

                    dispose();
                }
            }

        });

    }

    //Metodo de limpiar Formularios
    private void limpiarFormularioAbogado(){
        txtNombreA.setText("");
        txtApellidoPA.setText("");
        txtApellidoMA.setText("");
        txtTelefonoA.setText("");
        txtCorreoA.setText("");
        cbEspecialidadA.setSelectedIndex(0);
        cbGeneroA.setSelectedIndex(0);
        cbDiaFNA.setSelectedIndex(0);
        cbMesFNA.setSelectedIndex(0);
        cbAnioFNA.setSelectedIndex(0);
    }

    private void limpiarFormularioCliente(){
        txtNombreCL.setText("");
        txtApellidoPCL.setText("");
        txtApellidoMCL.setText("");
        txtTelefonoCL.setText("");
        txtCorreoCL.setText("");
        cbGeneroCL.setSelectedIndex(0);
        cbDiaCL.setSelectedIndex(0);
        cbMesCL.setSelectedIndex(0);
        cbAnioCL.setSelectedIndex(0);
        txtDICL.setText("");
    }


    private void limpiarFormularioCita(){
        //Hacerlo despues
        cbAbogadoID.setSelectedIndex(0);
        cbClienteID.setSelectedIndex(0);
        txtNombreDC.setText("");
        txtNombreCC.setText("");
        txtObservacionesC.setText("");
        txtEspecialiadAC.setText("");
        txtFechaC.setText("");
        cbDiaC.setSelectedIndex(0);
        cbMesC.setSelectedIndex(0);
        cbAnioC.setSelectedIndex(0);
    }

    //Metodos de validarCampos
    public boolean validarCampos() {
        if (txtIDA.getText().isEmpty() || txtNombreA.getText().isEmpty()|| txtApellidoPA.getText().isEmpty() || txtApellidoMA.getText().isEmpty() || cbEspecialidadA.getSelectedIndex()==0|| txtTelefonoA.getText().isEmpty()
        || txtTelefonoA.getText().isEmpty() || txtCorreoA.getText().isEmpty() || cbGeneroA.getSelectedIndex()==0 || cbDiaFNA.getSelectedIndex()==0 || cbMesFNA.getSelectedIndex()==0 || cbAnioFNA.getSelectedIndex()==0) {
            JOptionPane.showMessageDialog(MiPanel, "Hay una casilla vacia o con un valor invalido, cheque de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
        }
        else{
            return true;
        }
    }

    public boolean validarCamposCliente() {
        if (txtIDP.getText().isEmpty() || txtNombreCL.getText().isEmpty()|| txtApellidoPCL.getText().isEmpty() || txtApellidoMCL.getText().isEmpty() || txtTelefonoCL.getText().isEmpty()|| txtDICL.getText().isEmpty()
                || txtTelefonoCL.getText().isEmpty() || txtCorreoCL.getText().isEmpty() || cbGeneroCL.getSelectedIndex()==0 || cbDiaCL.getSelectedIndex()==0 || cbMesCL.getSelectedIndex()==0 || cbAnioCL.getSelectedIndex()==0) {
            JOptionPane.showMessageDialog(MiPanel, "Hay una casilla vacia o con un valor invalido, cheque de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            return true;
        }
    }

    public boolean validarCamposCita() {
        if (txtIDC.getText().isEmpty()|| cbAbogadoID.getSelectedIndex()==0 || cbClienteID.getSelectedIndex()==0 || txtNombreDC.getText().isEmpty() || txtNombreCC.getText().isEmpty()
                || txtObservacionesC.getText().isEmpty() ||cbDiaC.getSelectedIndex()==0||cbMesC.getSelectedIndex()==0||cbAnioC.getSelectedIndex()==0 ) {
            JOptionPane.showMessageDialog(MiPanel, "Hay una casilla vacia o con un valor invalido, cheque de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            return true;
        }
    }

    //Metodos para Validar fechas
    public boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha =
                    new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            Date miFecha = formatoFecha.parse(fecha);
            System.out.println(miFecha);
        } catch (Exception e) {
            return false;
        }
        return true;


    }


/*
    public static void main(String[] args){
        Menu v= new Menu();
        v.setContentPane(v.MiPanel);
        v.setSize(700,400);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);
    }
*/

}
