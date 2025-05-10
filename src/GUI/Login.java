package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JPanel JLogin;
    private JTextField txtUsuario;
    private JPasswordField pasContraseña;
    private JButton btnLogin;
    private JLabel lblUsuario;
    private JLabel lblContraseña;

    public JPanel getJLogin() {
        return JLogin;
    }
    public Login() {
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String usuario = txtUsuario.getText();
                    String password = new String(pasContraseña.getPassword());

                    if (usuario.equals("admin") && password.equals("admin123")) {
                        JOptionPane.showMessageDialog(JLogin, "Bienvenido Administrador");
                        Menu menu = new Menu(true);  // true = admin
                        menu.setSize(700, 400);
                        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        menu.setVisible(true);
                        // Cierra la ventana de login (buscando la ventana padre)
                        SwingUtilities.getWindowAncestor(JLogin).dispose();
                    } else if (usuario.equals("usuario") && password.equals("usuario123")) {
                        JOptionPane.showMessageDialog(JLogin, "Bienvenido Usuario");
                        Menu menu = new Menu(false);  // false = usuario normal
                        menu.setSize(700, 400);
                        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        menu.setVisible(true);
                        SwingUtilities.getWindowAncestor(JLogin).dispose();
                    } else {
                        JOptionPane.showMessageDialog(JLogin, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
                                   }

        public static void main(String[] args) {
            JFrame frame = new JFrame("Login");
            frame.setContentPane(new Login().JLogin);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);
            frame.setLocationRelativeTo(null);  // Centra la ventana
            frame.setVisible(true);
        }
    }