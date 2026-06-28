package UserLayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import DLL.ControllerAsistencia;
import DLL.ControllerEmpleado;
import LogicLayer.Empleado;
import LogicLayer.Usuario;

public class horasExtras extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel model;
    private JComboBox<Empleado> comboBox;
    private JTextField textField;
    private JSpinner spinner;

    public horasExtras(Usuario usuario) {

        JLabel lblTitulo = new JLabel("Horas Extras");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 250, 30);
        contentPane.add(lblTitulo);

        model = new DefaultTableModel(new String[]{"N°", "Nombre", "Horas", "Valor x Hora", "Motivo"}, 0);
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
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(150);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(null);
        scrollPane.setBounds(80, 110, 762, 180);
        contentPane.add(scrollPane);
        cargarTablaExtras();

        JLabel lblAgregar = new JLabel("Agregar Horas Extras");
        lblAgregar.setForeground(new Color(0, 91, 0));
        lblAgregar.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        lblAgregar.setBounds(80, 310, 250, 25);
        contentPane.add(lblAgregar);

        JLabel lblEmpleado = new JLabel("Empleado:");
        lblEmpleado.setForeground(new Color(0, 91, 0));
        lblEmpleado.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblEmpleado.setBounds(80, 350, 100, 25);
        contentPane.add(lblEmpleado);

        comboBox = new JComboBox<Empleado>();
        comboBox.setBackground(Color.WHITE);
        comboBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        comboBox.setBounds(190, 350, 200, 35);
        contentPane.add(comboBox);
        cargarMenuDesplegable();

        JLabel lblHoras = new JLabel("Cantidad de horas:");
        lblHoras.setForeground(new Color(0, 91, 0));
        lblHoras.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblHoras.setBounds(430, 350, 150, 25);
        contentPane.add(lblHoras);

        spinner = new JSpinner();
        spinner.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        spinner.setBounds(590, 350, 100, 35);
        contentPane.add(spinner);

        JLabel lblMotivo = new JLabel("Motivo:");
        lblMotivo.setForeground(new Color(0, 91, 0));
        lblMotivo.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblMotivo.setBounds(80, 400, 100, 25);
        contentPane.add(lblMotivo);

        textField = new JTextField();
        textField.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        textField.setBounds(190, 400, 500, 35);
        textField.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.setBackground(new Color(0, 91, 0));
        btnAgregar.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnAgregar.setBounds(350, 460, 180, 45);
        btnAgregar.setBorder(null);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setFocusPainted(false);
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregar.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregar.setBackground(new Color(0, 91, 0));
            }
        });
        btnAgregar.addActionListener(e -> {
            Empleado emp = (Empleado) comboBox.getSelectedItem();
            if (emp == null) {
                return;
            }
            int horas = (Integer) spinner.getValue();
            String motivo = textField.getText();
            ControllerAsistencia cont = new ControllerAsistencia();
            cont.registrarHorasExtra(emp.getIdEmpleado(), horas, motivo);
            cargarTablaExtras();
            textField.setText("");
            spinner.setValue(0);
            JOptionPane.showMessageDialog(null, "Horas extras registradas correctamente");
        });
        contentPane.add(btnAgregar);

        JButton btnVolver = crearBotonRojo("Volver", EstilosGlobales.ANCHO_VENTANA - 130, EstilosGlobales.ALTO_VENTANA - 55, 110, 35);
        btnVolver.addActionListener(e -> {
            MenuAdministrador menuAdmin = new MenuAdministrador(usuario);
            menuAdmin.setVisible(true);
            dispose();
        });
        contentPane.add(btnVolver);

        seleccionarTabPorIndice(0);
    }

    private void cargarMenuDesplegable() {
        ControllerEmpleado contEmpleado = new ControllerEmpleado();
        LinkedList<Empleado> empleados = contEmpleado.mostrarEmpleados();
        comboBox.removeAllItems();
        for (Empleado e : empleados) {
            comboBox.addItem(e);
        }
    }

    private void cargarTablaExtras() {
        model.setRowCount(0);
        ControllerAsistencia cont = new ControllerAsistencia();
        try {
            ResultSet rs = cont.getHorasExtras();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_hora_extra"),
                    rs.getString("nombre") + " " + rs.getString("apellido"),
                    rs.getInt("horas"),
                    rs.getDouble("valor_hora"),
                    rs.getString("motivo")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}