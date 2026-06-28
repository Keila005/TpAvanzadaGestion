package UserLayer;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import LogicLayer.Usuario;
import LogicLayer.Operativo;
import java.awt.Color;

public class MisDatos extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private Usuario usuario;
    private Operativo operativo;

    public MisDatos(Usuario usuario, Operativo operativo) {
        this.usuario = usuario;
        this.operativo = operativo;

        JLabel lblTitulo = new JLabel("Mis Datos");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 200, 30);
        contentPane.add(lblTitulo);

        JLabel lblEmpleado = new JLabel("Empleado: " + usuario.getNombre());
        lblEmpleado.setForeground(new Color(0, 91, 0));
        lblEmpleado.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
        lblEmpleado.setBounds(300, 120, 300, 25);
        contentPane.add(lblEmpleado);

        JLabel lblId = new JLabel("ID: " + operativo.getIdUsuario());
        lblId.setForeground(new Color(80, 80, 80));
        lblId.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        lblId.setBounds(300, 160, 200, 25);
        contentPane.add(lblId);

        JLabel lblRol = new JLabel("Rol: " + operativo.getRol());
        lblRol.setForeground(new Color(80, 80, 80));
        lblRol.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        lblRol.setBounds(300, 200, 200, 25);
        contentPane.add(lblRol);

        JLabel lblRendimiento = new JLabel("Rendimiento: " + operativo.getRendimiento() + "%");
        lblRendimiento.setForeground(new Color(80, 80, 80));
        lblRendimiento.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        lblRendimiento.setBounds(300, 240, 200, 25);
        contentPane.add(lblRendimiento);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setForeground(Color.WHITE);
        btnAceptar.setBackground(new Color(0, 91, 0));
        btnAceptar.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnAceptar.setBounds(350, 320, 150, 45);
        btnAceptar.setBorder(null);
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.setFocusPainted(false);
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAceptar.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAceptar.setBackground(new Color(0, 91, 0));
            }
        });
        btnAceptar.addActionListener(e -> {
            dispose();
        });
        contentPane.add(btnAceptar);

        JButton btnVolver = crearBotonRojo("Volver", EstilosGlobales.ANCHO_VENTANA - 130, EstilosGlobales.ALTO_VENTANA - 55, 110, 35);
        btnVolver.addActionListener(e -> {
            dispose();
        });
        contentPane.add(btnVolver);

        seleccionarTabPorIndice(0);
    }
}