package UserLayer;

import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import DLL.ControllerSolicitud;
import LogicLayer.Usuario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class verSolicitudes extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel model;
    private JButton btnAceptar;
    private JButton btnRechazar;

    public verSolicitudes(Usuario usuario) {

        JLabel lblTitulo = new JLabel("Gestion de Solicitudes");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(320, 60, 300, 30);
        contentPane.add(lblTitulo);

        model = new DefaultTableModel(new String[]{"N°", "Tipo", "Fecha de inicio", "Fecha de finalizacion", "Estado"}, 0);
        table = new JTable(model);
        table.setBackground(Color.WHITE);
        table.setForeground(new Color(50, 50, 50));
        table.setGridColor(new Color(200, 200, 200));
        table.setSelectionBackground(new Color(0, 91, 0));
        table.setSelectionForeground(Color.WHITE);
        table.setRowHeight(28);
        table.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        table.getTableHeader().setBackground(new Color(0, 91, 0));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setFont(new Font("Helvetica Neue", Font.BOLD, 13));

        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(null);
        scrollPane.setBounds(80, 110, 762, 180);
        contentPane.add(scrollPane);

        JLabel lblSolicitudes = new JLabel("Solicitudes Pendientes");
        lblSolicitudes.setForeground(new Color(0, 91, 0));
        lblSolicitudes.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
        lblSolicitudes.setBounds(80, 85, 250, 25);
        contentPane.add(lblSolicitudes);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setForeground(Color.WHITE);
        btnAceptar.setBackground(new Color(0, 91, 0));
        btnAceptar.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnAceptar.setBounds(280, 320, 150, 45);
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
            int fila = table.getSelectedRow();
            if (fila != -1) {
                int idSolicitud = Integer.parseInt(model.getValueAt(fila, 0).toString());
                ControllerSolicitud cs = new ControllerSolicitud();
                cs.actualizarEstado(idSolicitud, "aceptada");
                cargarSolicitudes("pendiente");
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una solicitud.");
            }
        });
        contentPane.add(btnAceptar);

        btnRechazar = new JButton("Rechazar");
        btnRechazar.setForeground(Color.WHITE);
        btnRechazar.setBackground(new Color(180, 50, 50));
        btnRechazar.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnRechazar.setBounds(450, 320, 150, 45);
        btnRechazar.setBorder(null);
        btnRechazar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRechazar.setFocusPainted(false);
        btnRechazar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRechazar.setBackground(new Color(150, 30, 30));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRechazar.setBackground(new Color(180, 50, 50));
            }
        });
        btnRechazar.addActionListener(e -> {
            int fila = table.getSelectedRow();
            if (fila != -1) {
                int idSolicitud = Integer.parseInt(model.getValueAt(fila, 0).toString());
                ControllerSolicitud cs = new ControllerSolicitud();
                cs.actualizarEstado(idSolicitud, "rechazada");
                cargarSolicitudes("pendiente");
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una solicitud.");
            }
        });
        contentPane.add(btnRechazar);

        JButton btnPendientes = new JButton("Pendientes");
        btnPendientes.setForeground(Color.WHITE);
        btnPendientes.setBackground(new Color(0, 91, 0));
        btnPendientes.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        btnPendientes.setBounds(200, 400, 120, 35);
        btnPendientes.setBorder(null);
        btnPendientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPendientes.setFocusPainted(false);
        btnPendientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPendientes.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPendientes.setBackground(new Color(0, 91, 0));
            }
        });
        btnPendientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarSolicitudes("pendiente");
            }
        });
        contentPane.add(btnPendientes);

        JButton btnAprobadas = new JButton("Aprobadas");
        btnAprobadas.setForeground(Color.WHITE);
        btnAprobadas.setBackground(new Color(0, 91, 0));
        btnAprobadas.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        btnAprobadas.setBounds(340, 400, 120, 35);
        btnAprobadas.setBorder(null);
        btnAprobadas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAprobadas.setFocusPainted(false);
        btnAprobadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAprobadas.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAprobadas.setBackground(new Color(0, 91, 0));
            }
        });
        btnAprobadas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarSolicitudes("aprobada");
            }
        });
        contentPane.add(btnAprobadas);

        JButton btnRechazadas = new JButton("Rechazadas");
        btnRechazadas.setForeground(Color.WHITE);
        btnRechazadas.setBackground(new Color(0, 91, 0));
        btnRechazadas.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        btnRechazadas.setBounds(480, 400, 120, 35);
        btnRechazadas.setBorder(null);
        btnRechazadas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRechazadas.setFocusPainted(false);
        btnRechazadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRechazadas.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRechazadas.setBackground(new Color(0, 91, 0));
            }
        });
        btnRechazadas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarSolicitudes("rechazada");
            }
        });
        contentPane.add(btnRechazadas);

        JButton btnVolver = crearBotonRojo("Volver", EstilosGlobales.ANCHO_VENTANA - 130, EstilosGlobales.ALTO_VENTANA - 55, 110, 35);
        btnVolver.addActionListener(e -> {
            MenuAdministrador menuAdmin = new MenuAdministrador(usuario);
            menuAdmin.setVisible(true);
            dispose();
        });
        contentPane.add(btnVolver);

        cargarSolicitudes("pendiente");
        seleccionarTabPorIndice(0);
    }

    private void cargarSolicitudes(String estado) {
        model.setRowCount(0);
        if (estado.equals("pendiente")) {
            btnAceptar.setVisible(true);
            btnRechazar.setVisible(true);
        } else {
            btnAceptar.setVisible(false);
            btnRechazar.setVisible(false);
        }

        ControllerSolicitud cs = new ControllerSolicitud();
        try {
            ResultSet rs = cs.getSolicitudesPorEstado(estado);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_solicitud"),
                    rs.getString("tipo"),
                    rs.getString("fecha_inicio"),
                    rs.getString("fecha_fin"),
                    rs.getString("estado")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}