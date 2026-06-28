package UserLayer;

import DLL.ControllerProyecto;
import DLL.ControllerReunion;
import LogicLayer.Proyecto;
import LogicLayer.Reunion;
import LogicLayer.Usuario;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VerReuniones extends VentanaBase {

    private static final long serialVersionUID = 1L;

    public VerReuniones(Usuario usuario) {

        JLabel lblTitulo = new JLabel("Ver Reuniones");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 250, 30);
        contentPane.add(lblTitulo);

        JLabel lblUsuario = new JLabel(usuario.getNombre() + " " + usuario.getApellido());
        lblUsuario.setForeground(new Color(120, 120, 120));
        lblUsuario.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        lblUsuario.setBounds(390, 90, 200, 20);
        contentPane.add(lblUsuario);

        JLabel lblProyecto = new JLabel("Elegir proyecto:");
        lblProyecto.setForeground(new Color(0, 91, 0));
        lblProyecto.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        lblProyecto.setBounds(200, 130, 150, 25);
        contentPane.add(lblProyecto);

        JComboBox<String> comboProyectos = new JComboBox<>();
        comboProyectos.setBackground(Color.WHITE);
        comboProyectos.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        comboProyectos.setBounds(360, 130, 250, 35);
        contentPane.add(comboProyectos);

        JLabel lblReunion = new JLabel("Elegir reunión:");
        lblReunion.setForeground(new Color(0, 91, 0));
        lblReunion.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        lblReunion.setBounds(200, 190, 150, 25);
        contentPane.add(lblReunion);

        JComboBox<String> comboReuniones = new JComboBox<>();
        comboReuniones.setBackground(Color.WHITE);
        comboReuniones.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        comboReuniones.setBounds(360, 190, 250, 35);
        contentPane.add(comboReuniones);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setForeground(Color.WHITE);
        btnAceptar.setBackground(new Color(0, 91, 0));
        btnAceptar.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnAceptar.setBounds(280, 270, 150, 45);
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
                AsistenciaRegistrada asistencia = new AsistenciaRegistrada();
                asistencia.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnAceptar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBackground(new Color(180, 50, 50));
        btnCancelar.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        btnCancelar.setBounds(450, 270, 150, 45);
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
                MiembroDelProyecto miembro = new MiembroDelProyecto(usuario);
                miembro.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnCancelar);

        JButton btnVolver = crearBotonRojo("Volver", EstilosGlobales.ANCHO_VENTANA - 130, EstilosGlobales.ALTO_VENTANA - 55, 110, 35);
        btnVolver.addActionListener(e -> {
            MiembroDelProyecto miembro = new MiembroDelProyecto(usuario);
            miembro.setVisible(true);
            dispose();
        });
        contentPane.add(btnVolver);

        // Cargar proyectos
        ControllerProyecto cp = new ControllerProyecto();
        int idOperativo = 2;
        LinkedList<Proyecto> proyectos = cp.obtenerProyectosMiembro(idOperativo);
        for (Proyecto p : proyectos) {
            comboProyectos.addItem(p.getNombre());
        }

        // Cargar reuniones
        ControllerReunion cr = new ControllerReunion();
        int idProyecto = 1;
        LinkedList<Reunion> reuniones = cr.obtenerReunionesProyecto(idProyecto);
        for (Reunion r : reuniones) {
            comboReuniones.addItem(r.getTitulo());
        }

        seleccionarTabPorIndice(0);
    }
}