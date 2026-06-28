package UserLayer;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import DLL.ControllerProducto;
import DLL.ControllerStock;
import DLL.ControllerVenta;
import LogicLayer.Producto;
import LogicLayer.Usuario;
import LogicLayer.Venta;
import LogicLayer.detalle_venta;

public class AgregarVenta extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private JTextField textCantida;
    private Venta venta;
    private Usuario usuario;
    private JTable tablaProductos;
    private JTable tablaDetalle;
    private DefaultTableModel modeloProductos;
    private DefaultTableModel modeloDetalle;
    private JLabel lblTotal;

    public AgregarVenta(Usuario usuario) {
        this.venta = new Venta();
        this.usuario = usuario;
        venta.setIdVendedor(((LogicLayer.Vendedor) usuario).getIdEmpleado());

        JLabel lblTitulo = new JLabel("Nueva Venta");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 250, 30);
        contentPane.add(lblTitulo);

        JLabel lblUsuario = new JLabel(usuario.getNombre() + " " + usuario.getApellido());
        lblUsuario.setForeground(new Color(120, 120, 120));
        lblUsuario.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        lblUsuario.setBounds(390, 90, 200, 20);
        contentPane.add(lblUsuario);

        modeloProductos = new DefaultTableModel(new String[]{"ID", "Nombre", "Precio", "Stock"}, 0);
        tablaProductos = new JTable(modeloProductos);
        tablaProductos.setBackground(Color.WHITE);
        tablaProductos.setForeground(new Color(50, 50, 50));
        tablaProductos.setGridColor(new Color(200, 200, 200));
        tablaProductos.setSelectionBackground(new Color(0, 91, 0));
        tablaProductos.setSelectionForeground(Color.WHITE);
        tablaProductos.setRowHeight(28);
        tablaProductos.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        tablaProductos.getTableHeader().setBackground(new Color(0, 91, 0));
        tablaProductos.getTableHeader().setForeground(Color.WHITE);
        tablaProductos.getTableHeader().setFont(new Font("Helvetica Neue", Font.BOLD, 13));

        JScrollPane scrollProductos = new JScrollPane(tablaProductos);
        scrollProductos.setBorder(null);
        scrollProductos.setBounds(80, 140, 762, 180);
        contentPane.add(scrollProductos);

        JLabel lblSeleccionar = new JLabel("Seleccione un producto");
        lblSeleccionar.setForeground(new Color(0, 91, 0));
        lblSeleccionar.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblSeleccionar.setBounds(80, 120, 200, 20);
        contentPane.add(lblSeleccionar);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setForeground(new Color(0, 91, 0));
        lblCantidad.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblCantidad.setBounds(80, 340, 80, 25);
        contentPane.add(lblCantidad);

        textCantida = new JTextField();
        textCantida.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        textCantida.setBounds(170, 340, 120, 35);
        textCantida.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(textCantida);
        textCantida.setColumns(10);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.setBackground(new Color(0, 91, 0));
        btnAgregar.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnAgregar.setBounds(320, 340, 140, 35);
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
            int fila = tablaProductos.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un producto");
                return;
            }
            try {
                int cantidad = Integer.parseInt(textCantida.getText());
                if (cantidad <= 0) {
                    JOptionPane.showMessageDialog(null, "Ingrese una cantidad valida");
                    return;
                }
                int idProducto = (int) modeloProductos.getValueAt(fila, 0);
                ControllerProducto cp = new ControllerProducto();
                Producto producto = cp.buscarProductoPorId(idProducto);
                ControllerStock cs = new ControllerStock();
                if (!cs.hayStock(idProducto, cantidad)) {
                    JOptionPane.showMessageDialog(null, "No hay stock suficiente");
                    return;
                }
                detalle_venta detalle = new detalle_venta(producto, cantidad);
                venta.agregarDetalle(detalle);
                int stockActual = (int) modeloProductos.getValueAt(fila, 3);
                modeloProductos.setValueAt(stockActual - cantidad, fila, 3);
                modeloDetalle.addRow(new Object[]{producto.getNombre(), cantidad, producto.getPrecio(), detalle.getSubtotal()});
                actualizarTotal();
                textCantida.setText("");
                tablaProductos.clearSelection();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese un numero valido");
            }
        });
        contentPane.add(btnAgregar);

        modeloDetalle = new DefaultTableModel(new String[]{"Producto", "Cantidad", "Precio Unitario", "SubTotal"}, 0);
        tablaDetalle = new JTable(modeloDetalle);
        tablaDetalle.setBackground(Color.WHITE);
        tablaDetalle.setForeground(new Color(50, 50, 50));
        tablaDetalle.setGridColor(new Color(200, 200, 200));
        tablaDetalle.setSelectionBackground(new Color(0, 91, 0));
        tablaDetalle.setSelectionForeground(Color.WHITE);
        tablaDetalle.setRowHeight(28);
        tablaDetalle.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        tablaDetalle.getTableHeader().setBackground(new Color(0, 91, 0));
        tablaDetalle.getTableHeader().setForeground(Color.WHITE);
        tablaDetalle.getTableHeader().setFont(new Font("Helvetica Neue", Font.BOLD, 13));

        JScrollPane scrollDetalle = new JScrollPane(tablaDetalle);
        scrollDetalle.setBorder(null);
        scrollDetalle.setBounds(80, 410, 762, 120);
        contentPane.add(scrollDetalle);

        JLabel lblDetalle = new JLabel("Detalle de Venta");
        lblDetalle.setForeground(new Color(0, 91, 0));
        lblDetalle.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
        lblDetalle.setBounds(80, 385, 200, 25);
        contentPane.add(lblDetalle);

        lblTotal = new JLabel("Total: $0");
        lblTotal.setForeground(new Color(0, 91, 0));
        lblTotal.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        lblTotal.setBounds(80, 550, 200, 30);
        contentPane.add(lblTotal);

        JButton btnFinalizar = new JButton("Finalizar Venta");
        btnFinalizar.setForeground(Color.WHITE);
        btnFinalizar.setBackground(new Color(0, 91, 0));
        btnFinalizar.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnFinalizar.setBounds(350, 550, 200, 45);
        btnFinalizar.setBorder(null);
        btnFinalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFinalizar.setFocusPainted(false);
        btnFinalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFinalizar.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFinalizar.setBackground(new Color(0, 91, 0));
            }
        });
        btnFinalizar.addActionListener(e -> {
            if (venta.getDetalles().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay productos en la venta.");
                return;
            }
            ControllerVenta cv = new ControllerVenta();
            cv.generarVenta(venta);
            JOptionPane.showMessageDialog(null, "Venta registrada correctamente.");
            MenuVendedor menu = new MenuVendedor(usuario);
            menu.setVisible(true);
            dispose();
        });
        contentPane.add(btnFinalizar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBackground(new Color(180, 50, 50));
        btnCancelar.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        btnCancelar.setBounds(570, 550, 200, 45);
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
            MenuVendedor menu = new MenuVendedor(usuario);
            menu.setVisible(true);
            dispose();
        });
        contentPane.add(btnCancelar);

        cargarTablaProductos();
        seleccionarTabPorIndice(0);
    }

    private void cargarTablaProductos() {
        modeloProductos.setRowCount(0);
        ControllerProducto cp = new ControllerProducto();
        ControllerStock cs = new ControllerStock();
        for (Producto p : cp.mostrarProductos()) {
            modeloProductos.addRow(new Object[]{p.getIdproducto(), p.getNombre(), p.getPrecio(), cs.obtenerStockActual(p.getIdproducto())});
        }
    }

    private void actualizarTotal() {
        lblTotal.setText("Total: $" + venta.calcularTotal());
    }
}