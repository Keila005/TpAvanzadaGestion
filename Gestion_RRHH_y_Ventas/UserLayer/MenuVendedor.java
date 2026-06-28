package UserLayer;

import LogicLayer.Usuario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;

public class MenuVendedor extends VentanaBase {

    private static final long serialVersionUID = 1L;

    public MenuVendedor(Usuario usuario) {
        
        JLabel lblTitulo = new JLabel("Panel Vendedor");
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
        linea.setBounds(150, 130, 622, 1);
        contentPane.add(linea);

        JLabel lblSeccion1 = new JLabel("VENTAS");
        lblSeccion1.setForeground(new Color(0, 91, 0));
        lblSeccion1.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        lblSeccion1.setBounds(150, 155, 200, 25);
        contentPane.add(lblSeccion1);

        JButton btnVenta = crearBoton("Nueva Venta", 150, 190, 280, 55);
        btnVenta.addActionListener(e -> {
            AgregarVenta venta = new AgregarVenta(usuario);
            venta.setVisible(true);
            dispose();
        });
        contentPane.add(btnVenta);

        JButton btnHistorial = crearBoton("Historial de Ventas", 450, 190, 280, 55);
        btnHistorial.addActionListener(e -> {
            HistorialVentas historial = new HistorialVentas(usuario);
            historial.setVisible(true);
            dispose();
        });
        contentPane.add(btnHistorial);

        JLabel lblSeccion2 = new JLabel("STOCK Y PERFIL");
        lblSeccion2.setForeground(new Color(0, 91, 0));
        lblSeccion2.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        lblSeccion2.setBounds(150, 280, 200, 25);
        contentPane.add(lblSeccion2);

        JButton btnStock = crearBoton("Gestionar Stock", 150, 315, 280, 55);
        btnStock.addActionListener(e -> {
            MenuStock stock = new MenuStock(usuario);
            stock.setVisible(true);
            dispose();
        });
        contentPane.add(btnStock);

        JButton btnPerfil = crearBoton("Mi Perfil Laboral", 450, 315, 280, 55);
        btnPerfil.addActionListener(e -> {
            PerfilLaboral perfil = new PerfilLaboral(usuario);
            perfil.setVisible(true);
            dispose();
        });
        contentPane.add(btnPerfil);

        JButton btnSalir = crearBotonRojo("Cerrar Sesion", EstilosGlobales.ANCHO_VENTANA - 140, EstilosGlobales.ALTO_VENTANA - 55, 120, 35);
        btnSalir.addActionListener(e -> {
                Saludos chau = new Saludos();
                chau.setVisible(true);
                dispose();

                DLL.ControllerAsistencia asis = new DLL.ControllerAsistencia();
                int idEmpleado = asis.getIdEmpleadoByUsuario(usuario.getIdUsuario());

                if (idEmpleado != -1) {
                    asis.registrarSalida(idEmpleado);
                    JOptionPane.showMessageDialog(null, "Salida registrada. Hasta luego!");
                }
        });
        contentPane.add(btnSalir);
        
        seleccionarTabPorIndice(0);
    }
}