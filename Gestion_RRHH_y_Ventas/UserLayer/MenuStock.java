package UserLayer;

import LogicLayer.Usuario;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;

public class MenuStock extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private Usuario usuario;

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

        JPanel linea = new JPanel();
        linea.setBackground(new Color(0, 91, 0, 50));
        linea.setBounds(200, 130, 522, 1);
        contentPane.add(linea);

        JLabel lblSeccion1 = new JLabel("PRODUCTOS");
        lblSeccion1.setForeground(new Color(0, 91, 0));
        lblSeccion1.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        lblSeccion1.setBounds(200, 155, 200, 25);
        contentPane.add(lblSeccion1);

        JButton btnAgregarProducto = crearBoton("Agregar Producto", 200, 190, 220, 50);
        btnAgregarProducto.addActionListener(e -> {
            AgregarProducto agregar = new AgregarProducto(usuario);
            agregar.setVisible(true);
            dispose();
        });
        contentPane.add(btnAgregarProducto);

        JButton btnEditar = crearBoton("Editar Producto", 450, 190, 220, 50);
        btnEditar.addActionListener(e -> {
            EditarProducto editar = new EditarProducto(null, usuario);
            editar.setVisible(true);
            dispose();
        });
        contentPane.add(btnEditar);

        JLabel lblSeccion2 = new JLabel("STOCK");
        lblSeccion2.setForeground(new Color(0, 91, 0));
        lblSeccion2.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        lblSeccion2.setBounds(200, 275, 200, 25);
        contentPane.add(lblSeccion2);

        JButton btnAgregarStock = crearBoton("Agregar Stock", 200, 310, 220, 50);
        btnAgregarStock.addActionListener(e -> {
            AgregarStock agregar = new AgregarStock(null, usuario);
            agregar.setVisible(true);
            dispose();
        });
        contentPane.add(btnAgregarStock);

        JButton btnEliminar = crearBotonRojo("Eliminar Producto", 450, 310, 220, 50);
        btnEliminar.addActionListener(e -> {
            // logica eliminar
        });
        contentPane.add(btnEliminar);

        JButton btnVolver = crearBotonRojo("Volver", EstilosGlobales.ANCHO_VENTANA - 130, EstilosGlobales.ALTO_VENTANA - 55, 110, 35);
        btnVolver.addActionListener(e -> {
            MenuVendedor menu = new MenuVendedor(usuario);
            menu.setVisible(true);
            dispose();
        });
        contentPane.add(btnVolver);

        seleccionarTabPorIndice(0);
    }
}