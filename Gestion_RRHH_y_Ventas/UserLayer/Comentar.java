package UserLayer;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import LogicLayer.Usuario;

public class Comentar extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private JTextField textField;


    public Comentar(Usuario usuario) {
     
        JLabel lblTitulo = new JLabel("Comentar");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 250, 30);
        contentPane.add(lblTitulo);

        JLabel lblSubtitulo = new JLabel("Escriba un comentario sobre el clima laboral");
        lblSubtitulo.setForeground(new Color(120, 120, 120));
        lblSubtitulo.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        lblSubtitulo.setBounds(280, 100, 350, 25);
        contentPane.add(lblSubtitulo);

        textField = new JTextField();
        textField.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        textField.setBounds(200, 140, 500, 80);
        textField.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblSentimiento = new JLabel("Sentimiento");
        lblSentimiento.setForeground(new Color(0, 91, 0));
        lblSentimiento.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblSentimiento.setBounds(200, 240, 100, 25);
        contentPane.add(lblSentimiento);

        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.addItem("Positivo");
        comboBox.addItem("Negativo");
        comboBox.addItem("Neutro");
        comboBox.setBounds(200, 270, 200, 35);
        comboBox.setBackground(Color.WHITE);
        comboBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        contentPane.add(comboBox);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setForeground(Color.WHITE);
        btnAceptar.setBackground(new Color(0, 91, 0));
        btnAceptar.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnAceptar.setBounds(280, 340, 150, 45);
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
            JOptionPane.showMessageDialog(null, "Comentario enviado correctamente");
            MenuOperativo menu = new MenuOperativo(usuario);
            menu.setVisible(true);
            dispose();
        });
        contentPane.add(btnAceptar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBackground(new Color(180, 50, 50));
        btnCancelar.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        btnCancelar.setBounds(450, 340, 150, 45);
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
            MenuOperativo menu = new MenuOperativo(usuario);
            menu.setVisible(true);
            dispose();
        });
        contentPane.add(btnCancelar);

        JButton btnVolver = crearBotonRojo("Volver", EstilosGlobales.ANCHO_VENTANA - 130, EstilosGlobales.ALTO_VENTANA - 55, 110, 35);
        btnVolver.addActionListener(e -> {
            MenuOperativo menu = new MenuOperativo(usuario);
            menu.setVisible(true);
            dispose();
        });
        contentPane.add(btnVolver);

        seleccionarTabPorIndice(0);
    }
}