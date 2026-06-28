package UserLayer;

import LogicLayer.Usuario;
import LogicLayer.Producto;
import DLL.ControllerProducto;
import DLL.ControllerStock;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.util.LinkedList;

public class MenuStock extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private Usuario usuario;
    private JTable table;
    private DefaultTableModel model;
    private ControllerProducto controllerProducto = new ControllerProducto();
    private ControllerStock controllerStock = new ControllerStock();

    public MenuStock(Usuario usuario) {
        this.usuario = usuario;

        JLabel lblTitulo = new JLabel("Gestion de Stock");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 250, 30);
        contentPane.add(lblTitulo);

        JLabel lblUsuario = new JLabel(usuario.getNombre() + " " + usuario.getApellido());
        lblUsuario.setForeground(new Color(120, 120, 120));
        lblUsuario.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        lblUsuario.setBounds(390, 90, 200, 20);
        contentPane.add(lblUsuario);

        // TABLA
        model = new DefaultTableModel(new String[]{"ID", "Nombre", "Precio", "Stock"}, 0);
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

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(null);
        scrollPane.setBounds(80, 130, 762, 160);
        contentPane.add(scrollPane);

        JPanel linea = new JPanel();
        linea.setBackground(new Color(0, 91, 0, 50));
        linea.setBounds(80, 310, 762, 1);
        contentPane.add(linea);

        JLabel lblSeccion1 = new JLabel("PRODUCTOS");
        lblSeccion1.setForeground(new Color(0, 91, 0));
        lblSeccion1.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        lblSeccion1.setBounds(80, 325, 200, 25);
        contentPane.add(lblSeccion1);

        JButton btnAgregarProducto = crearBoton("Agregar Producto", 80, 360, 180, 45);
        btnAgregarProducto.addActionListener(e -> {
            AgregarProducto agregar = new AgregarProducto(usuario);
            agregar.setVisible(true);
            dispose();
        });
        contentPane.add(btnAgregarProducto);

        JButton btnEditar = crearBoton("Editar Producto", 280, 360, 180, 45);
        btnEditar.addActionListener(e -> {
            int fila = table.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un producto");
                return;
            }
            int id = (int) model.getValueAt(fila, 0);
            Producto producto = controllerProducto.buscarProductoPorId(id);
            if (producto != null) {
                EditarProducto editar = new EditarProducto(producto, usuario);
                editar.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnEditar);

        JLabel lblSeccion2 = new JLabel("STOCK");
        lblSeccion2.setForeground(new Color(0, 91, 0));
        lblSeccion2.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        lblSeccion2.setBounds(480, 325, 200, 25);
        contentPane.add(lblSeccion2);

        JButton btnAgregarStock = crearBoton("Agregar Stock", 480, 360, 180, 45);
        btnAgregarStock.addActionListener(e -> {
            int fila = table.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un producto");
                return;
            }
            int id = (int) model.getValueAt(fila, 0);
            Producto producto = controllerProducto.buscarProductoPorId(id);
            if (producto != null) {
                AgregarStock agregar = new AgregarStock(producto, usuario);
                agregar.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnAgregarStock);

        JButton btnEliminar = crearBotonRojo("Eliminar Producto", 680, 360, 180, 45);
        btnEliminar.addActionListener(e -> {
            int fila = table.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un producto");
                return;
            }
            int id = (int) model.getValueAt(fila, 0);
            Producto producto = controllerProducto.buscarProductoPorId(id);
            if (producto != null) {
                int opcion = JOptionPane.showConfirmDialog(null,
                    "¿Esta seguro que desea eliminar el producto?",
                    "Confirmar eliminacion",
                    JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    controllerProducto.eliminarProducto(producto);
                    cargarTabla();
                    JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
                }
            }
        });
        contentPane.add(btnEliminar);

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
        model.setRowCount(0);
        LinkedList<Producto> productos = controllerProducto.mostrarProductos();
        for (Producto p : productos) {
            model.addRow(new Object[]{
                p.getIdproducto(),
                p.getNombre(),
                p.getPrecio(),
                controllerStock.obtenerStockActual(p.getIdproducto())
            });
        }
    }
}