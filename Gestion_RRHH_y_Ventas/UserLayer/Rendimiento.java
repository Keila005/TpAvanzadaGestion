package UserLayer;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import LogicLayer.Operativo;
import java.awt.Color;

public class Rendimiento extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private Operativo operativo;

    public Rendimiento(Operativo operativo) {
        this.operativo = operativo;

        JLabel lblTitulo = new JLabel("Mi Rendimiento");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 250, 30);
        contentPane.add(lblTitulo);

        JLabel lblIndividual = new JLabel("Rendimiento Individual: " + operativo.getRendimiento() + "%");
        lblIndividual.setForeground(new Color(50, 50, 50));
        lblIndividual.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        lblIndividual.setBounds(250, 130, 400, 30);
        contentPane.add(lblIndividual);

        JLabel lblGrupal = new JLabel("Rendimiento Grupal: " + operativo.getRendimientoGrupal() + "%");
        lblGrupal.setForeground(new Color(50, 50, 50));
        lblGrupal.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        lblGrupal.setBounds(250, 175, 400, 30);
        contentPane.add(lblGrupal);

        JLabel lblFinal = new JLabel("Rendimiento Final: " + "%");
        lblFinal.setForeground(new Color(0, 91, 0));
        lblFinal.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        lblFinal.setBounds(250, 230, 400, 35);
        contentPane.add(lblFinal);

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