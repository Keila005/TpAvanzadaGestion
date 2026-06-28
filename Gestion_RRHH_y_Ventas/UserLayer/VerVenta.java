package UserLayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import DLL.ControllerVenta;
import LogicLayer.Usuario;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;

public class VerVenta extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private int idVenta;
    private JTable table;
    private DefaultTableModel modelo;
    private JLabel lblFecha;
    private JLabel lblVendedor;
    private JLabel lblTotal;
    private Usuario usuario;

    public VerVenta(int idVenta, Usuario usuario) {
        this.idVenta = idVenta;
        this.usuario = usuario;

        JLabel lblTitulo = new JLabel("Venta N° " + idVenta);
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 250, 30);
        contentPane.add(lblTitulo);

        lblFecha = new JLabel("Fecha:");
        lblFecha.setForeground(new Color(50, 50, 50));
        lblFecha.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
        lblFecha.setBounds(200, 110, 400, 25);
        contentPane.add(lblFecha);

        lblVendedor = new JLabel("Vendedor:");
        lblVendedor.setForeground(new Color(50, 50, 50));
        lblVendedor.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
        lblVendedor.setBounds(200, 140, 400, 25);
        contentPane.add(lblVendedor);

        modelo = new DefaultTableModel(new String[]{"Producto", "Cantidad", "Subtotal"}, 0);
        table = new JTable(modelo);
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

        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBorder(null);
        scroll.setBounds(80, 190, 762, 180);
        contentPane.add(scroll);

        lblTotal = new JLabel("Total: $0");
        lblTotal.setForeground(new Color(0, 91, 0));
        lblTotal.setFont(new Font("Helvetica Neue", Font.BOLD, 22));
        lblTotal.setBounds(350, 390, 250, 35);
        contentPane.add(lblTotal);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setBackground(new Color(0, 91, 0));
        btnVolver.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnVolver.setBounds(350, 460, 150, 45);
        btnVolver.setBorder(null);
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.setFocusPainted(false);
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVolver.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVolver.setBackground(new Color(0, 91, 0));
            }
        });
        btnVolver.addActionListener(e -> {
            HistorialVentas historial = new HistorialVentas(usuario);
            historial.setVisible(true);
            dispose();
        });
        contentPane.add(btnVolver);

        JButton btnSalir = crearBotonRojo("Salir", EstilosGlobales.ANCHO_VENTANA - 130, EstilosGlobales.ALTO_VENTANA - 55, 110, 35);
        btnSalir.addActionListener(e -> {
            HistorialVentas historial = new HistorialVentas(usuario);
            historial.setVisible(true);
            dispose();
        });
        contentPane.add(btnSalir);

        cargarVenta();
        seleccionarTabPorIndice(0);
    }

    private void cargarVenta() {
        ControllerVenta cv = new ControllerVenta();
        cv.cargarDetalleVenta(idVenta, modelo, lblFecha, lblVendedor, lblTotal);
    }
}