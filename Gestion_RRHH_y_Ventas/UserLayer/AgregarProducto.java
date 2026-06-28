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

public class AgregarProducto extends VentanaBase {

    private static final long serialVersionUID = 1L;

    private JTextField textNombre;
    private JTextField textPrecio;

    public AgregarProducto(Usuario usuario) {

        JLabel lblTitulo = new JLabel("Agregar Producto");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 250, 30);
        contentPane.add(lblTitulo);

        JLabel lblNombre = new JLabel("Nombre del Producto:");
        lblNombre.setForeground(new Color(0, 91, 0));
        lblNombre.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblNombre.setBounds(200, 130, 150, 25);
        contentPane.add(lblNombre);

        textNombre = new JTextField();
        textNombre.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        textNombre.setBounds(360, 130, 250, 35);
        textNombre.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(textNombre);
        textNombre.setColumns(10);

        JLabel lblPrecio = new JLabel("Precio del Producto:");
        lblPrecio.setForeground(new Color(0, 91, 0));
        lblPrecio.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblPrecio.setBounds(200, 190, 150, 25);
        contentPane.add(lblPrecio);

        textPrecio = new JTextField();
        textPrecio.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        textPrecio.setBounds(360, 190, 250, 35);
        textPrecio.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(textPrecio);
        textPrecio.setColumns(10);

        JButton btnGuardar = new JButton("Guardar Producto");
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setBackground(new Color(0, 91, 0));
        btnGuardar.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnGuardar.setBounds(260, 270, 180, 45);
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
            try {
                String nombre = textNombre.getText();
                if (textNombre.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese un nombre");
                    return;
                }
                double precio = Double.parseDouble(textPrecio.getText());
                Producto producto = new Producto(0, nombre, precio);
                ControllerProducto cp = new ControllerProducto();
                cp.agregarProducto(producto);
                JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
                MenuStock menu = new MenuStock(usuario);
                menu.setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese un precio valido");
            }
        });
        contentPane.add(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBackground(new Color(180, 50, 50));
        btnCancelar.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        btnCancelar.setBounds(460, 270, 180, 45);
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