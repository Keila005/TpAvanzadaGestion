package UserLayer;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import DLL.ControllerVenta;
import LogicLayer.Usuario;
import LogicLayer.Venta;

public class HistorialVentas extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private Usuario usuario;
    private JTable tablaHistorial;
    private DefaultTableModel modeloHistorial;

    public HistorialVentas(Usuario usuario) {
        this.usuario = usuario;

        JLabel lblTitulo = new JLabel("Historial de Ventas");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 250, 30);
        contentPane.add(lblTitulo);

        modeloHistorial = new DefaultTableModel(new String[]{"ID Venta", "Fecha", "Total"}, 0);
        tablaHistorial = new JTable(modeloHistorial);
        tablaHistorial.setBackground(Color.WHITE);
        tablaHistorial.setForeground(new Color(50, 50, 50));
        tablaHistorial.setGridColor(new Color(200, 200, 200));
        tablaHistorial.setSelectionBackground(new Color(0, 91, 0));
        tablaHistorial.setSelectionForeground(Color.WHITE);
        tablaHistorial.setRowHeight(28);
        tablaHistorial.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        tablaHistorial.getTableHeader().setBackground(new Color(0, 91, 0));
        tablaHistorial.getTableHeader().setForeground(Color.WHITE);
        tablaHistorial.getTableHeader().setFont(new Font("Helvetica Neue", Font.BOLD, 13));

        tablaHistorial.getColumnModel().getColumn(0).setPreferredWidth(80);
        tablaHistorial.getColumnModel().getColumn(1).setPreferredWidth(150);
        tablaHistorial.getColumnModel().getColumn(2).setPreferredWidth(100);

        JScrollPane scroll = new JScrollPane(tablaHistorial);
        scroll.setBorder(null);
        scroll.setBounds(80, 110, 762, 250);
        contentPane.add(scroll);

        JButton btnVerVenta = new JButton("Ver Venta");
        btnVerVenta.setForeground(Color.WHITE);
        btnVerVenta.setBackground(new Color(0, 91, 0));
        btnVerVenta.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnVerVenta.setBounds(280, 400, 180, 45);
        btnVerVenta.setBorder(null);
        btnVerVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerVenta.setFocusPainted(false);
        btnVerVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVerVenta.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVerVenta.setBackground(new Color(0, 91, 0));
            }
        });
        btnVerVenta.addActionListener(e -> {
            int fila = tablaHistorial.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione una venta.");
                return;
            }
            int idVenta = (int) modeloHistorial.getValueAt(fila, 0);
            VerVenta ventana = new VerVenta(idVenta, usuario);
            ventana.setVisible(true);
            dispose();
        });
        contentPane.add(btnVerVenta);

        JButton btnVolver = crearBotonRojo("Volver", EstilosGlobales.ANCHO_VENTANA - 130, EstilosGlobales.ALTO_VENTANA - 55, 110, 35);
        btnVolver.addActionListener(e -> {
            MenuVendedor menu = new MenuVendedor(usuario);
            menu.setVisible(true);
            dispose();
        });
        contentPane.add(btnVolver);

        cargarTabla();
        seleccionarTabPorIndice(0);
    }

    public void cargarTabla() {
        modeloHistorial.setRowCount(0);
        ControllerVenta cv = new ControllerVenta();
        int idEmpleado = ((LogicLayer.Vendedor) usuario).getIdEmpleado();
        for (Venta v : cv.mostrarVentas(idEmpleado)) {
            modeloHistorial.addRow(new Object[]{v.getIdVenta(), v.getFecha(), v.getTotal()});
        }
    }
}