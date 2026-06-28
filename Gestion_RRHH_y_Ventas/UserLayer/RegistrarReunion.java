package UserLayer;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import LogicLayer.Usuario;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class RegistrarReunion extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private JTextField txtTitulo;
    private JTextField txtFecha;
    private JTextField txtHora;
    private JTextField txtDescripcion;

    public RegistrarReunion(Usuario usuario) {

        JLabel lblTitulo = new JLabel("Registrar Reunion");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 250, 30);
        contentPane.add(lblTitulo);

        JLabel lblTituloReunion = new JLabel("Titulo:");
        lblTituloReunion.setForeground(new Color(0, 91, 0));
        lblTituloReunion.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblTituloReunion.setBounds(200, 120, 100, 25);
        contentPane.add(lblTituloReunion);

        txtTitulo = new JTextField();
        txtTitulo.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        txtTitulo.setBounds(310, 120, 300, 35);
        txtTitulo.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(txtTitulo);
        txtTitulo.setColumns(10);

        JLabel lblFecha = new JLabel("Fecha (DD/MM/AAAA):");
        lblFecha.setForeground(new Color(0, 91, 0));
        lblFecha.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblFecha.setBounds(200, 175, 150, 25);
        contentPane.add(lblFecha);

        txtFecha = new JTextField();
        txtFecha.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        txtFecha.setBounds(360, 175, 250, 35);
        txtFecha.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(txtFecha);
        txtFecha.setColumns(10);

        JLabel lblHora = new JLabel("Hora (HH:MM):");
        lblHora.setForeground(new Color(0, 91, 0));
        lblHora.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblHora.setBounds(200, 230, 120, 25);
        contentPane.add(lblHora);

        txtHora = new JTextField();
        txtHora.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        txtHora.setBounds(330, 230, 280, 35);
        txtHora.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(txtHora);
        txtHora.setColumns(10);

        JLabel lblDescripcion = new JLabel("Descripcion:");
        lblDescripcion.setForeground(new Color(0, 91, 0));
        lblDescripcion.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblDescripcion.setBounds(200, 285, 100, 25);
        contentPane.add(lblDescripcion);

        txtDescripcion = new JTextField();
        txtDescripcion.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        txtDescripcion.setBounds(310, 285, 300, 60);
        txtDescripcion.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(txtDescripcion);
        txtDescripcion.setColumns(10);

        JButton btnGuardar = new JButton("Guardar Reunion");
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setBackground(new Color(0, 91, 0));
        btnGuardar.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnGuardar.setBounds(280, 390, 200, 45);
        btnGuardar.setBorder(null);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setFocusPainted(false);
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardar.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardar.setBackground(new Color(0, 91, 0));
            }
        });
        btnGuardar.addActionListener(e -> {
            dispose();
        });
        contentPane.add(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBackground(new Color(180, 50, 50));
        btnCancelar.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        btnCancelar.setBounds(500, 390, 150, 45);
        btnCancelar.setBorder(null);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setFocusPainted(false);
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelar.setBackground(new Color(150, 30, 30));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelar.setBackground(new Color(180, 50, 50));
            }
        });
        btnCancelar.addActionListener(e -> {
            dispose();
        });
        contentPane.add(btnCancelar);

        JButton btnVolver = crearBotonRojo("Volver", EstilosGlobales.ANCHO_VENTANA - 130, EstilosGlobales.ALTO_VENTANA - 55, 110, 35);
        btnVolver.addActionListener(e -> {
            dispose();
        });
        contentPane.add(btnVolver);

        seleccionarTabPorIndice(0);
    }
}