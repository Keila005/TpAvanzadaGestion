package UserLayer;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import LogicLayer.Usuario;
import java.sql.ResultSet;

public class GestionarAsistencia extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel model;
    private JTextField txtEntrada;
    private JTextField txtSalida;
    private JComboBox<String> comboPresente;
    private int idSeleccionado = -1;

    public GestionarAsistencia(Usuario usuario) {
        JOptionPane.showMessageDialog(null, "Para modificar la asistencia:\nSeleccionar empleado -> Modificar asistencia -> Editar los datos -> Actualizar");

        JLabel lblTitulo = new JLabel("Gestion de Asistencia");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 300, 30);
        contentPane.add(lblTitulo);

        model = new DefaultTableModel(new String[]{"N°", "Fecha", "Empleado", "Hora Entrada", "Hora Salida", "Presente"}, 0);
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
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(80);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(new LineBorder(new Color(0, 91, 0), 2));
        scrollPane.setBounds(80, 110, 762, 200);
        contentPane.add(scrollPane);
        cargarTabla();

        JLabel lblEntrada = new JLabel("Entrada:");
        lblEntrada.setForeground(new Color(0, 91, 0));
        lblEntrada.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblEntrada.setBounds(200, 340, 80, 25);
        contentPane.add(lblEntrada);

        txtEntrada = new JTextField();
        txtEntrada.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        txtEntrada.setBounds(280, 340, 150, 35);
        txtEntrada.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(txtEntrada);

        JLabel lblSalida = new JLabel("Salida:");
        lblSalida.setForeground(new Color(0, 91, 0));
        lblSalida.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblSalida.setBounds(460, 340, 80, 25);
        contentPane.add(lblSalida);

        txtSalida = new JTextField();
        txtSalida.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        txtSalida.setBounds(540, 340, 150, 35);
        txtSalida.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(txtSalida);

        JLabel lblPresente = new JLabel("Presente:");
        lblPresente.setForeground(new Color(0, 91, 0));
        lblPresente.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblPresente.setBounds(200, 400, 80, 25);
        contentPane.add(lblPresente);

        comboPresente = new JComboBox<>(new String[]{"1 - Presente", "0 - Ausente"});
        comboPresente.setBackground(Color.WHITE);
        comboPresente.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        comboPresente.setBounds(280, 400, 200, 35);
        contentPane.add(comboPresente);

        JButton btnModificar = new JButton("Modificar");
        btnModificar.setForeground(Color.WHITE);
        btnModificar.setBackground(new Color(0, 91, 0));
        btnModificar.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnModificar.setBounds(200, 470, 150, 45);
        btnModificar.setBorder(null);
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.setFocusPainted(false);
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificar.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificar.setBackground(new Color(0, 91, 0));
            }
        });
        btnModificar.addActionListener(e -> modifDatosAntes());
        contentPane.add(btnModificar);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setBackground(new Color(0, 91, 0));
        btnActualizar.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnActualizar.setBounds(370, 470, 150, 45);
        btnActualizar.setBorder(null);
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.setFocusPainted(false);
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnActualizar.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnActualizar.setBackground(new Color(0, 91, 0));
            }
        });
        btnActualizar.addActionListener(e -> modificarAsistencia());
        contentPane.add(btnActualizar);

        JButton btnVolver = crearBotonRojo("Volver", EstilosGlobales.ANCHO_VENTANA - 130, EstilosGlobales.ALTO_VENTANA - 55, 110, 35);
        btnVolver.addActionListener(e -> {
            MenuAdministrador menuAdmin = new MenuAdministrador(usuario);
            menuAdmin.setVisible(true);
            dispose();
        });
        contentPane.add(btnVolver);

        seleccionarTabPorIndice(0);
    }

    public void cargarTabla() {
        model.setRowCount(0);
        DLL.ControllerAsistencia ca = new DLL.ControllerAsistencia();
        try {
            ResultSet rs = ca.getTodasAsistencias();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_asistencia"),
                    rs.getString("fecha"),
                    rs.getString("nombre") + " " + rs.getString("apellido"),
                    rs.getString("hora_entrada"),
                    rs.getString("hora_salida"),
                    rs.getInt("presente") == 1 ? "SI" : "NO"
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void modifDatosAntes() {
        int fila = table.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una asistencia primero");
            return;
        }
        idSeleccionado = Integer.parseInt(model.getValueAt(fila, 0).toString());
        txtEntrada.setText(model.getValueAt(fila, 3).toString());
        txtSalida.setText(model.getValueAt(fila, 4).toString());
        String presente = model.getValueAt(fila, 5).toString();
        comboPresente.setSelectedIndex(presente.equals("SI") ? 0 : 1);
    }

    private void modificarAsistencia() {
        if (idSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una asistencia");
            return;
        }
        String entrada = txtEntrada.getText();
        String salida = txtSalida.getText();
        int presente = comboPresente.getSelectedIndex() == 0 ? 1 : 0;
        DLL.ControllerAsistencia ca = new DLL.ControllerAsistencia();
        ca.actualizarAsistencia(idSeleccionado, entrada, salida, presente);
        cargarTabla();
        JOptionPane.showMessageDialog(this, "Asistencia actualizada");
    }
}