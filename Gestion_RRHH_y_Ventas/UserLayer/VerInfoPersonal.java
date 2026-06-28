package UserLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import LogicLayer.Operativo;
import LogicLayer.Usuario;
import LogicLayer.Empleado;
import java.awt.Color;
import java.awt.Font;

public class VerInfoPersonal extends VentanaBase {

    private static final long serialVersionUID = 1L;

    public VerInfoPersonal(Usuario usuario, Operativo operativo, Empleado empleado) {

        JLabel lblTitulo = new JLabel("Informacion Personal");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(330, 60, 300, 30);
        contentPane.add(lblTitulo);

        JLabel lblUsuario = new JLabel(usuario.getNombre() + " " + usuario.getApellido());
        lblUsuario.setForeground(new Color(120, 120, 120));
        lblUsuario.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        lblUsuario.setBounds(390, 95, 200, 20);
        contentPane.add(lblUsuario);

        JLabel lblSeccion = new JLabel("Seleccione una opcion");
        lblSeccion.setForeground(new Color(0, 91, 0));
        lblSeccion.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
        lblSeccion.setBounds(350, 140, 250, 25);
        contentPane.add(lblSeccion);

        JButton btnMisDatos = crearBoton("Mis Datos", 280, 190, 180, 45);
        btnMisDatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MisDatos misDatos = new MisDatos(usuario, operativo);
                misDatos.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnMisDatos);

        JButton btnRendimiento = crearBoton("Rendimiento", 480, 190, 180, 45);
        btnRendimiento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Rendimiento rendimiento = new Rendimiento(operativo);
                rendimiento.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnRendimiento);

        JButton btnMiSueldo = crearBoton("Mi Sueldo", 280, 260, 180, 45);
        btnMiSueldo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MiSueldo miSueldo = new MiSueldo();
                miSueldo.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnMiSueldo);

        JButton btnAusencias = crearBoton("Ver Ausencias", 480, 260, 180, 45);
        btnAusencias.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MisAusencias MisAusencias = new MisAusencias(empleado);
                MisAusencias.setVisible(true);
                dispose();
            }
        });
        
        contentPane.add(btnAusencias);

        JButton btnVolver = crearBotonRojo("Volver", EstilosGlobales.ANCHO_VENTANA - 130, EstilosGlobales.ALTO_VENTANA - 55, 110, 35);
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuOperativo menuOperativo = new MenuOperativo(usuario);
                menuOperativo.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnVolver);

        seleccionarTabPorIndice(0);
    }
}