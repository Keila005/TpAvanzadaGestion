package UserLayer;


import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import DLL.ControllerEquipo;
import DLL.ControllerOperativo;
import DLL.ControllerProyecto;
import LogicLayer.Equipo;
import LogicLayer.Operativo;
import LogicLayer.Proyecto;
import LogicLayer.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class MenuProyecto extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel model;
    private JTextField iptName;
    private JTextField textField;
    private JComboBox<String> comboLider;
    private JComboBox<String> comboEquipo;
    private static LinkedList<Operativo> lideres;
    private static LinkedList<Equipo> equipos;
    private static ControllerProyecto proyectoController = new ControllerProyecto();
    private JButton btnCrear;
    private JDateChooser dateInicio;
    private JDateChooser dateFin;
    private JPanel panel;

    public MenuProyecto(Usuario usuario) {

        JLabel lblTitulo = new JLabel("Gestion de Proyectos");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 300, 30);
        contentPane.add(lblTitulo);

        model = new DefaultTableModel(new String[]{"N°", "Nombre", "Descripcion", "Inicio", "Fin", "Lider", "Equipo"}, 0);
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
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(100);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(null);
        scrollPane.setBounds(80, 110, 762, 180);
        contentPane.add(scrollPane);

        cargarProyectos();

        panel = new JPanel();
        panel.setBackground(new Color(0, 91, 0));
        panel.setBounds(80, 310, 762, 240);
        panel.setLayout(null);
        contentPane.add(panel);

        JLabel lblCrear = new JLabel("Crear Proyecto");
        lblCrear.setForeground(Color.WHITE);
        lblCrear.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        lblCrear.setBounds(280, 10, 200, 30);
        panel.add(lblCrear);

        JLabel lblName = new JLabel("Nombre");
        lblName.setForeground(Color.WHITE);
        lblName.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        lblName.setBounds(30, 50, 100, 20);
        panel.add(lblName);

        iptName = new JTextField();
        iptName.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        iptName.setBounds(30, 72, 180, 30);
        iptName.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        panel.add(iptName);

        JLabel lblDescripcion = new JLabel("Descripcion");
        lblDescripcion.setForeground(Color.WHITE);
        lblDescripcion.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        lblDescripcion.setBounds(30, 110, 100, 20);
        panel.add(lblDescripcion);

        textField = new JTextField();
        textField.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        textField.setBounds(30, 132, 180, 50);
        textField.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        panel.add(textField);

        JLabel lblLider = new JLabel("Lider");
        lblLider.setForeground(Color.WHITE);
        lblLider.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        lblLider.setBounds(250, 50, 100, 20);
        panel.add(lblLider);

        comboLider = new JComboBox<>();
        comboLider.setBackground(Color.WHITE);
        comboLider.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        comboLider.setBounds(250, 72, 180, 30);
        panel.add(comboLider);

        JLabel lblEquipo = new JLabel("Equipo");
        lblEquipo.setForeground(Color.WHITE);
        lblEquipo.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        lblEquipo.setBounds(250, 110, 100, 20);
        panel.add(lblEquipo);

        comboEquipo = new JComboBox<>();
        comboEquipo.setBackground(Color.WHITE);
        comboEquipo.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        comboEquipo.setBounds(250, 132, 180, 30);
        panel.add(comboEquipo);

        JLabel lblFechaInicio = new JLabel("Fecha Inicio");
        lblFechaInicio.setForeground(Color.WHITE);
        lblFechaInicio.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        lblFechaInicio.setBounds(470, 50, 100, 20);
        panel.add(lblFechaInicio);

        dateInicio = new JDateChooser();
        dateInicio.setBounds(470, 72, 150, 30);
        dateInicio.getDateEditor().setEnabled(false);
        panel.add(dateInicio);

        JLabel lblFechaFin = new JLabel("Fecha Fin");
        lblFechaFin.setForeground(Color.WHITE);
        lblFechaFin.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        lblFechaFin.setBounds(470, 110, 100, 20);
        panel.add(lblFechaFin);

        dateFin = new JDateChooser();
        dateFin.setBounds(470, 132, 150, 30);
        dateFin.getDateEditor().setEnabled(false);
        panel.add(dateFin);

        dateInicio.setMinSelectableDate(new Date());
        dateInicio.addPropertyChangeListener("date", e -> {
            Date inicio = dateInicio.getDate();
            if (inicio != null) {
                dateFin.setMinSelectableDate(inicio);
            }
        });

        btnCrear = new JButton("Crear Proyecto");
        btnCrear.setForeground(Color.WHITE);
        btnCrear.setBackground(new Color(28, 137, 16));
        btnCrear.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnCrear.setBounds(290, 175, 180, 35);
        btnCrear.setBorder(null);
        btnCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrear.setFocusPainted(false);
        btnCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrear.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrear.setBackground(new Color(28, 137, 16));
            }
        });
        btnCrear.addActionListener(e -> {
            crearProyecto();
            cargarProyectos();
        });
        panel.add(btnCrear);

        cargarMenuDesplegable();

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
        ControllerOperativo operativoController = new ControllerOperativo();
        lideres = operativoController.obtenerLideres();
        comboLider.removeAllItems();
        for (Operativo op : lideres) {
            comboLider.addItem(op.getNombre() + " " + op.getApellido());
        }

        ControllerEquipo equipoController = new ControllerEquipo();
        equipos = equipoController.mostrarEquipo();
        comboEquipo.removeAllItems();
        for (Equipo eq : equipos) {
            comboEquipo.addItem(eq.getNombre());
        }
    }

    public void crearProyecto() {
        Date inicioDate = dateInicio.getDate();
        Date finDate = dateFin.getDate();

        if (inicioDate == null || finDate == null) {
            JOptionPane.showMessageDialog(null, "Selecciona las fechas");
            return;
        }

        java.sql.Date inicioSQL = new java.sql.Date(inicioDate.getTime());
        java.sql.Date finSQL = new java.sql.Date(finDate.getTime());

        String nombre = iptName.getText();
        String descripcion = textField.getText();

        if (nombre.trim().isEmpty() || descripcion.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
            return;
        }

        String seleccionadoLider = (String) comboLider.getSelectedItem();
        String seleccionadoEquipo = (String) comboEquipo.getSelectedItem();

        int idLider = -1;
        for (Operativo op : lideres) {
            String nombreCompleto = op.getNombre() + " " + op.getApellido();
            if (nombreCompleto.equals(seleccionadoLider)) {
                idLider = op.getIdOperativo();
                break;
            }
        }

        int idEquipo = -1;
        for (Equipo eq : equipos) {
            if (eq.getNombre().equals(seleccionadoEquipo)) {
                idEquipo = eq.getId_equipo();
                break;
            }
        }

        proyectoController.crearProyecto(nombre, descripcion, inicioSQL, finSQL, idLider, idEquipo);
        JOptionPane.showMessageDialog(null, "Proyecto creado correctamente");

        iptName.setText("");
        textField.setText("");
        dateInicio.setDate(null);
        dateFin.setDate(null);
    }

    private void cargarProyectos() {
        model.setRowCount(0);
        LinkedList<Proyecto> proyectos = proyectoController.obtenerProyectosTabla();
        for (Proyecto c : proyectos) {
            model.addRow(new Object[]{
                c.getIdProyecto(),
                c.getNombre(),
                c.getDescripcion(),
                c.getFechaInicio(),
                c.getFechaFin(),
                c.getLider(),
                c.getEquipo()
            });
        }
    }
}