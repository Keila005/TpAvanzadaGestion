package UserLayer;

import java.util.LinkedList;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import DLL.ControllerEmpleado;
import DLL.ControllerUsuario;
import LogicLayer.Administrador;
import LogicLayer.Empleado;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.table.JTableHeader;
import javax.swing.JSeparator;

public class MenuGestionar extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel model;
    private Empleado empleadoSeleccionado;
    private JTextField inpFiltro;
    private JLabel lblImg;
    private static ControllerEmpleado contEmpleado;

    public MenuGestionar(Administrador admin) {
        ControllerUsuario usuarioController = new ControllerUsuario();

        JLabel lblTitulo = new JLabel("Gestion de Empleados");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 300, 30);
        contentPane.add(lblTitulo);

        JLabel lblSeleccionado = new JLabel("Seleccione un empleado");
        lblSeleccionado.setForeground(new Color(120, 120, 120));
        lblSeleccionado.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        lblSeleccionado.setBounds(80, 95, 500, 20);
        contentPane.add(lblSeleccionado);

        model = new DefaultTableModel(new String[]{"ID", "Nombre", "Apellido", "Email", "Dni", "Sueldo"}, 0);
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
        table.getColumnModel().getColumn(3).setPreferredWidth(150);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        table.getColumnModel().getColumn(5).setPreferredWidth(80);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(null);
        scrollPane.setBounds(80, 120, 550, 200);
        contentPane.add(scrollPane);

        cargarTabla();

        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    int id = (int) model.getValueAt(row, 0);
                    for (Empleado emp : contEmpleado.mostrarEmpleados()) {
                        if (emp.getIdEmpleado() == id) {
                            empleadoSeleccionado = emp;
                            mostrarImagen(emp.getPerfil());
                            break;
                        }
                    }
                    empleadoSeleccionado = new Empleado(
                        (String) model.getValueAt(row, 1),
                        (String) model.getValueAt(row, 2),
                        (String) model.getValueAt(row, 3),
                        "",
                        (int) model.getValueAt(row, 0),
                        (int) model.getValueAt(row, 4),
                        (double) model.getValueAt(row, 5)
                    );
                    lblSeleccionado.setText("Seleccionado: " + empleadoSeleccionado.getNombre() + " " + empleadoSeleccionado.getApellido());
                }
            }
        });

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.setBackground(new Color(0, 91, 0));
        btnAgregar.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnAgregar.setBounds(80, 350, 150, 45);
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
            pantallaCrearEmpleado crearEmpleado = new pantallaCrearEmpleado(MenuGestionar.this, admin);
            crearEmpleado.setVisible(true);
            cargarTabla();
        });
        contentPane.add(btnAgregar);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setForeground(Color.WHITE);
        btnEditar.setBackground(new Color(0, 91, 0));
        btnEditar.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnEditar.setBounds(250, 350, 150, 45);
        btnEditar.setBorder(null);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setFocusPainted(false);
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditar.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditar.setBackground(new Color(0, 91, 0));
            }
        });
        btnEditar.addActionListener(e -> {
            cargarTabla();
            if (empleadoSeleccionado != null) {
                EditarUsuario selectEditar = new EditarUsuario(empleadoSeleccionado, admin);
                selectEditar.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un empleado");
            }
        });
        contentPane.add(btnEditar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setBackground(new Color(180, 50, 50));
        btnEliminar.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnEliminar.setBounds(420, 350, 150, 45);
        btnEliminar.setBorder(null);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setFocusPainted(false);
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminar.setBackground(new Color(150, 30, 30));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminar.setBackground(new Color(180, 50, 50));
            }
        });
        btnEliminar.addActionListener(e -> {
            if (empleadoSeleccionado != null) {
                int confirm = JOptionPane.showConfirmDialog(null,
                    "¿Eliminar a " + empleadoSeleccionado.getNombre() + "?",
                    "Confirmar", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    usuarioController.eliminarEmpleado(empleadoSeleccionado.getIdEmpleado());
                    cargarTabla();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un empleado");
            }
        });
        contentPane.add(btnEliminar);

        JLabel lblFiltro = new JLabel("Filtro:");
        lblFiltro.setForeground(new Color(0, 91, 0));
        lblFiltro.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblFiltro.setBounds(660, 350, 60, 25);
        contentPane.add(lblFiltro);

        inpFiltro = new JTextField();
        inpFiltro.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        inpFiltro.setBounds(660, 380, 150, 35);
        inpFiltro.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(inpFiltro);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setBackground(new Color(0, 91, 0));
        btnBuscar.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        btnBuscar.setBounds(660, 420, 150, 35);
        btnBuscar.setBorder(null);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.setFocusPainted(false);
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscar.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscar.setBackground(new Color(0, 91, 0));
            }
        });
        btnBuscar.addActionListener(e -> {
            cargarTablaFiltradaStream(inpFiltro.getText());
        });
        contentPane.add(btnBuscar);

        lblImg = new JLabel("");
        lblImg.setBounds(660, 120, 150, 150);
        lblImg.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        contentPane.add(lblImg);

        JLabel lblPerfil = new JLabel("Foto de Perfil");
        lblPerfil.setForeground(new Color(0, 91, 0));
        lblPerfil.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblPerfil.setBounds(680, 95, 120, 25);
        contentPane.add(lblPerfil);

        JButton btnVolver = crearBotonRojo("Volver", EstilosGlobales.ANCHO_VENTANA - 130, EstilosGlobales.ALTO_VENTANA - 55, 110, 35);
        btnVolver.addActionListener(e -> {
            MenuAdministrador menuAdmin = new MenuAdministrador(admin);
            menuAdmin.setVisible(true);
            dispose();
        });
        contentPane.add(btnVolver);

        seleccionarTabPorIndice(0);
    }

    public void cargarTabla() {
        model.setRowCount(0);
        contEmpleado = new ControllerEmpleado();
        LinkedList<Empleado> empleados = contEmpleado.mostrarEmpleados();
        for (Empleado e : empleados) {
            model.addRow(new Object[]{
                e.getIdEmpleado(),
                e.getNombre(),
                e.getApellido(),
                e.getMail(),
                e.getDni(),
                e.getSueldoBase()
            });
        }
    }

    private void cargarTablaFiltradaStream(String filtro) {
        LinkedList<Empleado> filtradasPorLetra = contEmpleado.mostrarEmpleados().stream()
            .filter(empleado ->
                (empleado.getNombre() != null && empleado.getNombre().toLowerCase().contains(filtro.toLowerCase()))
                || (empleado.getApellido() != null && empleado.getApellido().toLowerCase().contains(filtro.toLowerCase()))
                || (empleado.getMail() != null && empleado.getMail().toLowerCase().contains(filtro.toLowerCase())))
            .collect(Collectors.toCollection(LinkedList::new));
        model.setRowCount(0);
        for (Empleado e : filtradasPorLetra) {
            model.addRow(new Object[]{
                e.getIdEmpleado(),
                e.getNombre(),
                e.getApellido(),
                e.getMail(),
                e.getDni(),
                e.getSueldoBase()
            });
        }
    }

    private void mostrarImagen(byte[] imagenBytes) {
        if (imagenBytes != null && imagenBytes.length > 0) {
            ImageIcon icon = new ImageIcon(imagenBytes);
            Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            lblImg.setIcon(new ImageIcon(img));
        } else {
            lblImg.setIcon(null);
            lblImg.setText("Sin imagen");
        }
    }
}