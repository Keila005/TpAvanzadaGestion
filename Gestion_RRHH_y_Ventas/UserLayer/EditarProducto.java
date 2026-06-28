package UserLayer;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import DLL.ControllerProducto;
import LogicLayer.Producto;
import LogicLayer.Usuario;

public class EditarProducto extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private JTextField txtNombre;
    private JTextField txtPrecio;
  
    public EditarProducto(Producto producto, Usuario usuario) {

        JLabel lblTitulo = new JLabel("Editar Producto");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 250, 30);
        contentPane.add(lblTitulo);

        JLabel lblNombre = new JLabel("Nuevo Nombre:");
        lblNombre.setForeground(new Color(0, 91, 0));
        lblNombre.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblNombre.setBounds(200, 120, 150, 25);
        contentPane.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setText(producto.getNombre());
        txtNombre.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        txtNombre.setBounds(360, 120, 250, 35);
        txtNombre.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(txtNombre);
        txtNombre.setColumns(10);

        JLabel lblPrecio = new JLabel("Nuevo Precio:");
        lblPrecio.setForeground(new Color(0, 91, 0));
        lblPrecio.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblPrecio.setBounds(200, 180, 150, 25);
        contentPane.add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setText(String.valueOf(producto.getPrecio()));
        txtPrecio.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        txtPrecio.setBounds(360, 180, 250, 35);
        txtPrecio.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(txtPrecio);
        txtPrecio.setColumns(10);

        JButton btnGuardar = new JButton("Guardar Cambios");
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setBackground(new Color(0, 91, 0));
        btnGuardar.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnGuardar.setBounds(280, 260, 180, 45);
        btnGuardar.setBorder(null);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setFocusPainted(false);
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardar.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardar.setBackground(new Color(0, 91, 0));
            }
        });
        btnGuardar.addActionListener(e -> {
            producto.setNombre(txtNombre.getText());
            producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
            ControllerProducto cp = new ControllerProducto();
            cp.modificarProducto(producto);
            JOptionPane.showMessageDialog(null, "Producto modificado correctamente");
            MenuStock menu = new MenuStock(usuario);
            menu.setVisible(true);
            dispose();
        });
        contentPane.add(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBackground(new Color(180, 50, 50));
        btnCancelar.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        btnCancelar.setBounds(480, 260, 180, 45);
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

        seleccionarTabPorIndice(0);
    }
}