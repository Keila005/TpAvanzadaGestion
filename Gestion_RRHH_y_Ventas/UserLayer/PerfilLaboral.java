package UserLayer;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import LogicLayer.Usuario;
import LogicLayer.Vendedor;
import DLL.ControllerEmpleado;
import DLL.ControllerVenta;
import java.awt.Color;

public class PerfilLaboral extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private Usuario usuario;
    private JLabel lblNombre;
    private JLabel lblDni;
    private JLabel lblCorreo;
    private JLabel lblCargo;
    private JLabel lblSueldoBase;
    private JLabel lblVentas;
    private JLabel lblUltimaVenta;

    public PerfilLaboral(Usuario usuario) {
        this.usuario = usuario;

        ControllerEmpleado ce = new ControllerEmpleado();
        Vendedor vendedor = ce.buscarVendedorPorUsuario(usuario.getIdUsuario());
        ControllerVenta cv = new ControllerVenta();
        String ultimaVenta = cv.obtenerUltimaVenta(vendedor.getIdEmpleado());

        JLabel lblTitulo = new JLabel("Perfil Laboral");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 250, 30);
        contentPane.add(lblTitulo);

        lblNombre = new JLabel("Nombre: " + vendedor.getNombre() + " " + vendedor.getApellido());
        lblNombre.setForeground(new Color(50, 50, 50));
        lblNombre.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        lblNombre.setBounds(250, 120, 400, 25);
        contentPane.add(lblNombre);

        lblDni = new JLabel("DNI: " + vendedor.getDni());
        lblDni.setForeground(new Color(50, 50, 50));
        lblDni.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        lblDni.setBounds(250, 155, 400, 25);
        contentPane.add(lblDni);

        lblCorreo = new JLabel("Correo: " + vendedor.getMail());
        lblCorreo.setForeground(new Color(50, 50, 50));
        lblCorreo.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        lblCorreo.setBounds(250, 190, 400, 25);
        contentPane.add(lblCorreo);

        lblCargo = new JLabel("Cargo: Vendedor");
        lblCargo.setForeground(new Color(50, 50, 50));
        lblCargo.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        lblCargo.setBounds(250, 225, 400, 25);
        contentPane.add(lblCargo);

        lblSueldoBase = new JLabel("Sueldo Base: $" + vendedor.getSueldoBase());
        lblSueldoBase.setForeground(new Color(50, 50, 50));
        lblSueldoBase.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        lblSueldoBase.setBounds(250, 260, 400, 25);
        contentPane.add(lblSueldoBase);

        lblVentas = new JLabel("Ventas realizadas: " + vendedor.getVentasTotales());
        lblVentas.setForeground(new Color(50, 50, 50));
        lblVentas.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        lblVentas.setBounds(250, 295, 400, 25);
        contentPane.add(lblVentas);

        lblUltimaVenta = new JLabel("Ultima Venta: " + cv.obtenerUltimaVenta(vendedor.getIdEmpleado()));
        lblUltimaVenta.setForeground(new Color(50, 50, 50));
        lblUltimaVenta.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        lblUltimaVenta.setBounds(250, 330, 400, 25);
        contentPane.add(lblUltimaVenta);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setBackground(new Color(0, 91, 0));
        btnVolver.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnVolver.setBounds(350, 400, 150, 45);
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
            MenuVendedor menu = new MenuVendedor(usuario);
            menu.setVisible(true);
            dispose();
        });
        contentPane.add(btnVolver);

        JButton btnSalir = crearBotonRojo("Salir", EstilosGlobales.ANCHO_VENTANA - 130, EstilosGlobales.ALTO_VENTANA - 55, 110, 35);
        btnSalir.addActionListener(e -> {
            MenuVendedor menu = new MenuVendedor(usuario);
            menu.setVisible(true);
            dispose();
        });
        contentPane.add(btnSalir);

        cargarPerfil();
        seleccionarTabPorIndice(0);
    }

    private void cargarPerfil() {
        lblNombre.setText("Nombre: " + usuario.getNombre() + " " + usuario.getApellido());
        lblCorreo.setText("Correo: " + usuario.getMail());
        lblCargo.setText("Cargo: Vendedor");

        ControllerEmpleado ce = new ControllerEmpleado();
        Vendedor vendedor = ce.buscarVendedorPorUsuario(usuario.getIdUsuario());

        if (vendedor == null) {
            return;
        }

        if (vendedor != null) {
            lblDni.setText("DNI: " + vendedor.getDni());
            lblSueldoBase.setText("Sueldo Base: $" + vendedor.getSueldoBase());
        }

        ControllerVenta cv = new ControllerVenta();
        lblVentas.setText("Ventas realizadas: " + vendedor.getVentasTotales());
        lblUltimaVenta.setText("Ultima Venta: " + cv.obtenerUltimaVenta(vendedor.getIdEmpleado()));
    }
}