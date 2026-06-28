package UserLayer;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class EvaluarCompaniero extends VentanaBase {

    private static final long serialVersionUID = 1L;

    public EvaluarCompaniero() {

        JLabel lblTitulo = new JLabel("Evaluar Compañero");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 250, 30);
        contentPane.add(lblTitulo);

        JLabel lblCompaniero = new JLabel("Seleccione Compañero:");
        lblCompaniero.setForeground(new Color(0, 91, 0));
        lblCompaniero.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblCompaniero.setBounds(200, 120, 180, 25);
        contentPane.add(lblCompaniero);

        JComboBox<String> comboCompaniero = new JComboBox<>();
        comboCompaniero.setBackground(Color.WHITE);
        comboCompaniero.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        comboCompaniero.setBounds(400, 120, 250, 35);
        comboCompaniero.addItem("Seleccione...");
        comboCompaniero.addItem("Juan Perez");
        comboCompaniero.addItem("Maria Gomez");
        comboCompaniero.addItem("Carlos Lopez");
        contentPane.add(comboCompaniero);

        JLabel lblEvaluacion = new JLabel("Evaluacion:");
        lblEvaluacion.setForeground(new Color(0, 91, 0));
        lblEvaluacion.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblEvaluacion.setBounds(200, 180, 150, 25);
        contentPane.add(lblEvaluacion);

        JComboBox<String> comboEvaluacion = new JComboBox<>();
        comboEvaluacion.setBackground(Color.WHITE);
        comboEvaluacion.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        comboEvaluacion.setBounds(400, 180, 250, 35);
        comboEvaluacion.addItem("1");
        comboEvaluacion.addItem("2");
        comboEvaluacion.addItem("3");
        comboEvaluacion.addItem("4");
        comboEvaluacion.addItem("5");
        comboEvaluacion.addItem("6");
        comboEvaluacion.addItem("7");
        comboEvaluacion.addItem("8");
        comboEvaluacion.addItem("9");
        comboEvaluacion.addItem("10");
        contentPane.add(comboEvaluacion);

        JLabel lblComentario = new JLabel("Comentario:");
        lblComentario.setForeground(new Color(0, 91, 0));
        lblComentario.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblComentario.setBounds(200, 240, 150, 25);
        contentPane.add(lblComentario);

        JTextArea txtComentario = new JTextArea();
        txtComentario.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        txtComentario.setBounds(400, 240, 250, 80);
        txtComentario.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));
        txtComentario.setLineWrap(true);
        txtComentario.setWrapStyleWord(true);
        contentPane.add(txtComentario);

        JButton btnEnviar = new JButton("Enviar Evaluacion");
        btnEnviar.setForeground(Color.WHITE);
        btnEnviar.setBackground(new Color(0, 91, 0));
        btnEnviar.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnEnviar.setBounds(350, 360, 200, 45);
        btnEnviar.setBorder(null);
        btnEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnviar.setFocusPainted(false);
        btnEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnviar.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnviar.setBackground(new Color(0, 91, 0));
            }
        });
        btnEnviar.addActionListener(e -> {
            dispose();
        });
        contentPane.add(btnEnviar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBackground(new Color(180, 50, 50));
        btnCancelar.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        btnCancelar.setBounds(570, 360, 150, 45);
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