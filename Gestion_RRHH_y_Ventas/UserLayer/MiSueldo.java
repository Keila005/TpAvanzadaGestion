package UserLayer;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MiSueldo extends VentanaBase {

    private static final long serialVersionUID = 1L;

    public MiSueldo() {

        JLabel lblTitulo = new JLabel("Mi Sueldo");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 200, 30);
        contentPane.add(lblTitulo);

        JLabel lblSueldoBase = new JLabel("Sueldo Base: $1.500.000");
        lblSueldoBase.setForeground(new Color(0, 91, 0));
        lblSueldoBase.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        lblSueldoBase.setBounds(300, 130, 300, 35);
        contentPane.add(lblSueldoBase);

        JLabel lblBonos = new JLabel("Bonos: $150.000");
        lblBonos.setForeground(new Color(80, 80, 80));
        lblBonos.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        lblBonos.setBounds(300, 180, 300, 25);
        contentPane.add(lblBonos);

        JLabel lblHorasExtras = new JLabel("Horas Extras: $200.000");
        lblHorasExtras.setForeground(new Color(80, 80, 80));
        lblHorasExtras.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        lblHorasExtras.setBounds(300, 210, 300, 25);
        contentPane.add(lblHorasExtras);

        JLabel lblTotal = new JLabel("Total: $1.850.000");
        lblTotal.setForeground(new Color(0, 91, 0));
        lblTotal.setFont(new Font("Helvetica Neue", Font.BOLD, 22));
        lblTotal.setBounds(300, 260, 300, 35);
        contentPane.add(lblTotal);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setForeground(Color.WHITE);
        btnAceptar.setBackground(new Color(0, 91, 0));
        btnAceptar.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnAceptar.setBounds(350, 340, 150, 45);
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