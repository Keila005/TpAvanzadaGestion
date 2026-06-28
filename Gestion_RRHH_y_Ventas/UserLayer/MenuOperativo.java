package UserLayer;

import LogicLayer.Usuario;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class MenuOperativo extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private JPanel panelContenido;

    public MenuOperativo(Usuario usuario) {
        
        JLabel lblTitulo = new JLabel("Panel Operativo");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 250, 30);
        contentPane.add(lblTitulo);
        
        JLabel lblUsuario = new JLabel(usuario.getNombre() + " " + usuario.getApellido());
        lblUsuario.setForeground(new Color(120, 120, 120));
        lblUsuario.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        lblUsuario.setBounds(390, 90, 200, 20);
        contentPane.add(lblUsuario);

        JButton btnInfoPersonal = crearBoton("Ver Informacion Personal", 200, 170, 220, 50);
        btnInfoPersonal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VerInfoPersonal verInfo = new VerInfoPersonal(usuario, (LogicLayer.Operativo) usuario);
                verInfo.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnInfoPersonal);

        JButton btnCrearSolicitud = crearBoton("Crear Solicitud", 450, 170, 220, 50);
        btnCrearSolicitud.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CrearSolicitud crearSolicitud = new CrearSolicitud();
                crearSolicitud.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnCrearSolicitud);

        JButton btnComentar = crearBoton("Comentar", 200, 250, 220, 50);
        btnComentar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Comentar comentar = new Comentar();
                comentar.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnComentar);

        JButton btnCargo = crearBoton("Cargo", 450, 250, 220, 50);
        btnCargo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cargo cargo = new Cargo(usuario);
                cargo.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnCargo);

        JButton btnSalir = crearBotonRojo("Salir", EstilosGlobales.ANCHO_VENTANA - 120, EstilosGlobales.ALTO_VENTANA - 50, 100, 35);
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Cerrando sesion...");
                Login login = new Login();
                login.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnSalir);

        seleccionarTabPorIndice(0);
    }
}