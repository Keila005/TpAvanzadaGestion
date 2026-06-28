package UserLayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CrearSolicitud extends VentanaBase {

    private static final long serialVersionUID = 1L;
    JComboBox<String> comboDiaInicio = new JComboBox<>();
    JComboBox<String> comboMesInicio = new JComboBox<>();
    JComboBox<String> comboAnioInicio = new JComboBox<>();
    JComboBox<String> comboDiaFin = new JComboBox<>();
    JComboBox<String> comboMesFin = new JComboBox<>();
    JComboBox<String> comboAnioFin = new JComboBox<>();
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;

    public CrearSolicitud() {

        JLabel lblTitulo = new JLabel("Crear Solicitud");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 250, 30);
        contentPane.add(lblTitulo);

        JLabel lblTipo = new JLabel("Tipo de Solicitud");
        lblTipo.setForeground(new Color(0, 91, 0));
        lblTipo.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblTipo.setBounds(200, 120, 150, 25);
        contentPane.add(lblTipo);

        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.addItem("Seleccione Tipo");
        comboBox.addItem("Vacaciones");
        comboBox.addItem("Dia de Estudio");
        comboBox.addItem("Estudios Medicos");
        comboBox.addItem("Licencia por Maternidad");
        comboBox.addItem("Mudanza");
        comboBox.addItem("Tramites Personales");
        comboBox.setBackground(Color.WHITE);
        comboBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        comboBox.setBounds(200, 150, 200, 35);
        contentPane.add(comboBox);

        JLabel lblDiaInicio = new JLabel("Dia de Inicio");
        lblDiaInicio.setForeground(new Color(0, 91, 0));
        lblDiaInicio.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblDiaInicio.setBounds(200, 220, 120, 20);
        lblDiaInicio.setVisible(false);
        contentPane.add(lblDiaInicio);

        JLabel lblMesInicio = new JLabel("Mes de Inicio");
        lblMesInicio.setForeground(new Color(0, 91, 0));
        lblMesInicio.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblMesInicio.setBounds(200, 270, 120, 20);
        lblMesInicio.setVisible(false);
        contentPane.add(lblMesInicio);

        JLabel lblAnioInicio = new JLabel("Año de Inicio");
        lblAnioInicio.setForeground(new Color(0, 91, 0));
        lblAnioInicio.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblAnioInicio.setBounds(200, 320, 120, 20);
        lblAnioInicio.setVisible(false);
        contentPane.add(lblAnioInicio);

        JLabel lblDiaFin = new JLabel("Dia de Finalizacion");
        lblDiaFin.setForeground(new Color(0, 91, 0));
        lblDiaFin.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblDiaFin.setBounds(450, 220, 150, 20);
        lblDiaFin.setVisible(false);
        contentPane.add(lblDiaFin);

        JLabel lblMesFin = new JLabel("Mes de Finalizacion");
        lblMesFin.setForeground(new Color(0, 91, 0));
        lblMesFin.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblMesFin.setBounds(450, 270, 150, 20);
        lblMesFin.setVisible(false);
        contentPane.add(lblMesFin);

        JLabel lblAnioFin = new JLabel("Año de Finalizacion");
        lblAnioFin.setForeground(new Color(0, 91, 0));
        lblAnioFin.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblAnioFin.setBounds(450, 320, 150, 20);
        lblAnioFin.setVisible(false);
        contentPane.add(lblAnioFin);

        JLabel lblInstitucion = new JLabel("Institucion:");
        lblInstitucion.setForeground(new Color(0, 91, 0));
        lblInstitucion.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblInstitucion.setBounds(200, 380, 150, 25);
        lblInstitucion.setVisible(false);
        contentPane.add(lblInstitucion);

        JLabel lblMateria = new JLabel("Materia:");
        lblMateria.setForeground(new Color(0, 91, 0));
        lblMateria.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblMateria.setBounds(450, 380, 150, 25);
        lblMateria.setVisible(false);
        contentPane.add(lblMateria);

        JLabel lblTipoEstudio = new JLabel("Tipo Estudio:");
        lblTipoEstudio.setForeground(new Color(0, 91, 0));
        lblTipoEstudio.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblTipoEstudio.setBounds(200, 380, 150, 25);
        lblTipoEstudio.setVisible(false);
        contentPane.add(lblTipoEstudio);

        JLabel lblDireccion = new JLabel("Direccion:");
        lblDireccion.setForeground(new Color(0, 91, 0));
        lblDireccion.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblDireccion.setBounds(200, 380, 150, 25);
        lblDireccion.setVisible(false);
        contentPane.add(lblDireccion);

        JLabel lblOrganismo = new JLabel("Organismo:");
        lblOrganismo.setForeground(new Color(0, 91, 0));
        lblOrganismo.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblOrganismo.setBounds(200, 380, 150, 25);
        lblOrganismo.setVisible(false);
        contentPane.add(lblOrganismo);

        comboDiaInicio.setBackground(Color.WHITE);
        comboDiaInicio.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        comboDiaInicio.setBounds(200, 245, 120, 25);
        comboDiaInicio.setVisible(false);
        contentPane.add(comboDiaInicio);

        comboMesInicio.setBackground(Color.WHITE);
        comboMesInicio.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        comboMesInicio.setBounds(200, 295, 120, 25);
        comboMesInicio.setVisible(false);
        contentPane.add(comboMesInicio);

        comboAnioInicio.setBackground(Color.WHITE);
        comboAnioInicio.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        comboAnioInicio.setBounds(200, 345, 120, 25);
        comboAnioInicio.setVisible(false);
        contentPane.add(comboAnioInicio);

        comboDiaFin.setBackground(Color.WHITE);
        comboDiaFin.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        comboDiaFin.setBounds(450, 245, 120, 25);
        comboDiaFin.setVisible(false);
        contentPane.add(comboDiaFin);

        comboMesFin.setBackground(Color.WHITE);
        comboMesFin.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        comboMesFin.setBounds(450, 295, 120, 25);
        comboMesFin.setVisible(false);
        contentPane.add(comboMesFin);

        comboAnioFin.setBackground(Color.WHITE);
        comboAnioFin.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        comboAnioFin.setBounds(450, 345, 120, 25);
        comboAnioFin.setVisible(false);
        contentPane.add(comboAnioFin);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        textField_3.setColumns(10);
        textField_3.setBounds(360, 380, 150, 30);
        textField_3.setVisible(false);
        contentPane.add(textField_3);

        textField_4 = new JTextField();
        textField_4.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        textField_4.setColumns(10);
        textField_4.setBounds(550, 380, 150, 30);
        textField_4.setVisible(false);
        contentPane.add(textField_4);

        textField_5 = new JTextField();
        textField_5.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        textField_5.setColumns(10);
        textField_5.setBounds(360, 380, 150, 30);
        textField_5.setVisible(false);
        contentPane.add(textField_5);

        textField_6 = new JTextField();
        textField_6.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        textField_6.setColumns(10);
        textField_6.setBounds(360, 380, 150, 30);
        textField_6.setVisible(false);
        contentPane.add(textField_6);

        textField_7 = new JTextField();
        textField_7.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        textField_7.setColumns(10);
        textField_7.setBounds(360, 380, 150, 30);
        textField_7.setVisible(false);
        contentPane.add(textField_7);

        for (int i = 1; i <= 31; i++) {
            String valor = String.format("%02d", i);
            comboDiaInicio.addItem(valor);
            comboDiaFin.addItem(valor);
        }

        for (int i = 1; i <= 12; i++) {
            String valor = String.format("%02d", i);
            comboMesInicio.addItem(valor);
            comboMesFin.addItem(valor);
        }

        for (int i = 2026; i <= 2035; i++) {
            comboAnioInicio.addItem(String.valueOf(i));
            comboAnioFin.addItem(String.valueOf(i));
        }

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblDiaInicio.setVisible(false);
                comboDiaInicio.setVisible(false);
                lblMesInicio.setVisible(false);
                comboMesInicio.setVisible(false);
                lblAnioInicio.setVisible(false);
                comboAnioInicio.setVisible(false);
                lblDiaFin.setVisible(false);
                comboDiaFin.setVisible(false);
                lblMesFin.setVisible(false);
                comboMesFin.setVisible(false);
                lblAnioFin.setVisible(false);
                comboAnioFin.setVisible(false);
                lblInstitucion.setVisible(false);
                textField_3.setVisible(false);
                lblMateria.setVisible(false);
                textField_4.setVisible(false);
                lblTipoEstudio.setVisible(false);
                textField_5.setVisible(false);
                lblDireccion.setVisible(false);
                textField_6.setVisible(false);
                lblOrganismo.setVisible(false);
                textField_7.setVisible(false);

                switch (comboBox.getSelectedIndex()) {
                case 1:
                    lblDiaInicio.setVisible(true);
                    comboDiaInicio.setVisible(true);
                    lblMesInicio.setVisible(true);
                    comboMesInicio.setVisible(true);
                    lblAnioInicio.setVisible(true);
                    comboAnioInicio.setVisible(true);
                    lblDiaFin.setVisible(true);
                    comboDiaFin.setVisible(true);
                    lblMesFin.setVisible(true);
                    comboMesFin.setVisible(true);
                    lblAnioFin.setVisible(true);
                    comboAnioFin.setVisible(true);
                    break;
                case 2:
                    lblDiaInicio.setVisible(true);
                    comboDiaInicio.setVisible(true);
                    lblMesInicio.setVisible(true);
                    comboMesInicio.setVisible(true);
                    lblAnioInicio.setVisible(true);
                    comboAnioInicio.setVisible(true);
                    lblDiaFin.setVisible(true);
                    comboDiaFin.setVisible(true);
                    lblMesFin.setVisible(true);
                    comboMesFin.setVisible(true);
                    lblAnioFin.setVisible(true);
                    comboAnioFin.setVisible(true);
                    lblInstitucion.setVisible(true);
                    textField_3.setVisible(true);
                    lblMateria.setVisible(true);
                    textField_4.setVisible(true);
                    break;
                case 3:
                    lblDiaInicio.setVisible(true);
                    comboDiaInicio.setVisible(true);
                    lblMesInicio.setVisible(true);
                    comboMesInicio.setVisible(true);
                    lblAnioInicio.setVisible(true);
                    comboAnioInicio.setVisible(true);
                    lblDiaFin.setVisible(true);
                    comboDiaFin.setVisible(true);
                    lblMesFin.setVisible(true);
                    comboMesFin.setVisible(true);
                    lblAnioFin.setVisible(true);
                    comboAnioFin.setVisible(true);
                    lblTipoEstudio.setVisible(true);
                    textField_5.setVisible(true);
                    break;
                case 4:
                    lblDiaInicio.setVisible(true);
                    comboDiaInicio.setVisible(true);
                    lblMesInicio.setVisible(true);
                    comboMesInicio.setVisible(true);
                    lblAnioInicio.setVisible(true);
                    comboAnioInicio.setVisible(true);
                    lblDiaFin.setVisible(true);
                    comboDiaFin.setVisible(true);
                    lblMesFin.setVisible(true);
                    comboMesFin.setVisible(true);
                    lblAnioFin.setVisible(true);
                    comboAnioFin.setVisible(true);
                    break;
                case 5:
                    lblDireccion.setVisible(true);
                    textField_6.setVisible(true);
                    lblDiaInicio.setVisible(true);
                    comboDiaInicio.setVisible(true);
                    lblMesInicio.setVisible(true);
                    comboMesInicio.setVisible(true);
                    lblAnioInicio.setVisible(true);
                    comboAnioInicio.setVisible(true);
                    lblDiaFin.setVisible(true);
                    comboDiaFin.setVisible(true);
                    lblMesFin.setVisible(true);
                    comboMesFin.setVisible(true);
                    lblAnioFin.setVisible(true);
                    comboAnioFin.setVisible(true);
                    break;
                case 6:
                    lblOrganismo.setVisible(true);
                    textField_7.setVisible(true);
                    lblDiaInicio.setVisible(true);
                    comboDiaInicio.setVisible(true);
                    lblMesInicio.setVisible(true);
                    comboMesInicio.setVisible(true);
                    lblAnioInicio.setVisible(true);
                    comboAnioInicio.setVisible(true);
                    lblDiaFin.setVisible(true);
                    comboDiaFin.setVisible(true);
                    lblMesFin.setVisible(true);
                    comboMesFin.setVisible(true);
                    lblAnioFin.setVisible(true);
                    comboAnioFin.setVisible(true);
                    break;
                }
            }
        });

        JButton btnEnviar = new JButton("Enviar Solicitud");
        btnEnviar.setForeground(Color.WHITE);
        btnEnviar.setBackground(new Color(0, 91, 0));
        btnEnviar.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnEnviar.setBounds(350, 450, 200, 45);
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
        btnCancelar.setBounds(570, 450, 180, 45);
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