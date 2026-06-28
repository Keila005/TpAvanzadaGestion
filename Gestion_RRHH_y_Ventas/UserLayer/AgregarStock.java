package UserLayer;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.time.LocalDate;
import DLL.ControllerStock;
import LogicLayer.Producto;
import LogicLayer.Stock;
import LogicLayer.Usuario;

public class AgregarStock extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private Producto producto;
    private Usuario usuario;
    private JTextField textCantidad;

    public AgregarStock(Producto producto, Usuario usuario) {
        this.producto = producto;
        this.usuario = usuario;

        JLabel lblTitulo = new JLabel("Agregar Stock");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 250, 30);
        contentPane.add(lblTitulo);

        JLabel lblProducto = new JLabel("Producto: " + producto.getNombre());
        lblProducto.setForeground(new Color(0, 91, 0));
        lblProducto.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
        lblProducto.setBounds(300, 110, 400, 25);
        contentPane.add(lblProducto);

        JLabel lblStockActual = new JLabel("Stock actual: " + new ControllerStock().obtenerStockActual(producto.getIdproducto()));
        lblStockActual.setForeground(new Color(120, 120, 120));
        lblStockActual.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        lblStockActual.setBounds(350, 140, 250, 25);
        contentPane.add(lblStockActual);

        JLabel lblCantidad = new JLabel("Cantidad a Agregar:");
        lblCantidad.setForeground(new Color(0, 91, 0));
        lblCantidad.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblCantidad.setBounds(280, 190, 150, 25);
        contentPane.add(lblCantidad);

        textCantidad = new JTextField();
        textCantidad.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        textCantidad.setBounds(440, 190, 200, 35);
        textCantidad.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(textCantidad);
        textCantidad.setColumns(10);

        JButton btnAgregar = new JButton("Agregar Stock");
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.setBackground(new Color(0, 91, 0));
        btnAgregar.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnAgregar.setBounds(280, 270, 180, 45);
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
            try {
                int cantidad = Integer.parseInt(textCantidad.getText());
                Stock stock = new Stock(producto, cantidad, LocalDate.now(), "INGRESO");
                ControllerStock controller = new ControllerStock();
                controller.registrarMovimiento(stock);
                JOptionPane.showMessageDialog(null, "Stock agregado correctamente");
                MenuStock menu = new MenuStock(usuario);
                menu.setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese una cantidad valida");
            }
        });
        contentPane.add(btnAgregar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBackground(new Color(180, 50, 50));
        btnCancelar.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        btnCancelar.setBounds(480, 270, 180, 45);
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
            MenuStock menu = new MenuStock(usuario);
            menu.setVisible(true);
            dispose();
        });
        contentPane.add(btnCancelar);

        JButton btnVolver = crearBotonRojo("Volver", EstilosGlobales.ANCHO_VENTANA - 130, EstilosGlobales.ALTO_VENTANA - 55, 110, 35);
        btnVolver.addActionListener(e -> {
            MenuStock menu = new MenuStock(usuario);
            menu.setVisible(true);
            dispose();
        });
        contentPane.add(btnVolver);
    }
}