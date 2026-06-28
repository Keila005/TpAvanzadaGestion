package UserLayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import DLL.ControllerOperativo;
import DLL.ControllerProyecto;
import DLL.ControllerTarea;
import LogicLayer.Operativo;
import LogicLayer.Proyecto;
import LogicLayer.Usuario;

public class CrearTarea extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JComboBox<Proyecto> cmbProyecto;
    private JComboBox<Operativo> cmbEmpleado;

    public CrearTarea(Usuario Usuario) {

        JLabel lblTitulo = new JLabel("Crear Tarea");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 200, 30);
        contentPane.add(lblTitulo);

        JLabel lblNombre = new JLabel("Nombre de la Tarea");
        lblNombre.setForeground(new Color(0, 91, 0));
        lblNombre.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblNombre.setBounds(200, 120, 150, 25);
        contentPane.add(lblNombre);

        textField = new JTextField();
        textField.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        textField.setBounds(360, 120, 200, 35);
        textField.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblDescripcion = new JLabel("Descripcion");
        lblDescripcion.setForeground(new Color(0, 91, 0));
        lblDescripcion.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblDescripcion.setBounds(200, 170, 100, 25);
        contentPane.add(lblDescripcion);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        textField_1.setBounds(360, 170, 200, 35);
        textField_1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblProyecto = new JLabel("Seleccione el proyecto");
        lblProyecto.setForeground(new Color(0, 91, 0));
        lblProyecto.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblProyecto.setBounds(200, 220, 200, 25);
        contentPane.add(lblProyecto);

        cmbProyecto = new JComboBox<>();
        cmbProyecto.setBackground(Color.WHITE);
        cmbProyecto.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        cmbProyecto.setBounds(360, 220, 200, 35);
        contentPane.add(cmbProyecto);

        JLabel lblEmpleado = new JLabel("Asignar a");
        lblEmpleado.setForeground(new Color(0, 91, 0));
        lblEmpleado.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblEmpleado.setBounds(200, 270, 100, 25);
        contentPane.add(lblEmpleado);

        cmbEmpleado = new JComboBox<>();
        cmbEmpleado.setBackground(Color.WHITE);
        cmbEmpleado.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        cmbEmpleado.setBounds(360, 270, 200, 35);
        contentPane.add(cmbEmpleado);

        JLabel lblFechaInicio = new JLabel("Fecha de inicio (AAAA-MM-DD)");
        lblFechaInicio.setForeground(new Color(0, 91, 0));
        lblFechaInicio.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblFechaInicio.setBounds(200, 320, 250, 25);
        contentPane.add(lblFechaInicio);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        textField_2.setBounds(460, 320, 150, 35);
        textField_2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblFechaFin = new JLabel("Fecha de fin (AAAA-MM-DD)");
        lblFechaFin.setForeground(new Color(0, 91, 0));
        lblFechaFin.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblFechaFin.setBounds(200, 370, 250, 25);
        contentPane.add(lblFechaFin);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        textField_3.setBounds(460, 370, 150, 35);
        textField_3.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        ControllerProyecto cp = new ControllerProyecto();
        LinkedList<Proyecto> proyectos = cp.obtenerProyectosTabla();
        for (Proyecto p : proyectos) {
            cmbProyecto.addItem(p);
        }

        ControllerOperativo co = new ControllerOperativo();
        LinkedList<Operativo> miembros = co.obtenerMiembrosProyecto();
        for (Operativo op : miembros) {
            cmbEmpleado.addItem(op);
        }

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setForeground(Color.WHITE);
        btnAceptar.setBackground(new Color(0, 91, 0));
        btnAceptar.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnAceptar.setBounds(280, 450, 150, 45);
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
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Proyecto proyecto = (Proyecto) cmbProyecto.getSelectedItem();
                Operativo operativo = (Operativo) cmbEmpleado.getSelectedItem();
                ControllerTarea ct = new ControllerTarea();
                ct.crearTarea(textField.getText(), textField_1.getText(), proyecto.getIdProyecto(), operativo.getIdOperativo());
                JOptionPane.showMessageDialog(null, "Tarea creada correctamente");
                dispose();
            }
        });
        contentPane.add(btnAceptar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBackground(new Color(180, 50, 50));
        btnCancelar.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        btnCancelar.setBounds(450, 450, 150, 45);
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
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LiderDelProyecto ventana = new LiderDelProyecto(Usuario);
                ventana.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnCancelar);

        JButton btnVolver = crearBotonRojo("Volver", EstilosGlobales.ANCHO_VENTANA - 130, EstilosGlobales.ALTO_VENTANA - 55, 110, 35);
        btnVolver.addActionListener(e -> {
            LiderDelProyecto ventana = new LiderDelProyecto(Usuario);
            ventana.setVisible(true);
            dispose();
        });
        contentPane.add(btnVolver);

        seleccionarTabPorIndice(0);
    }
}