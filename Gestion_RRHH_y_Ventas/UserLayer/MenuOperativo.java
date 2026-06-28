package UserLayer;

import LogicLayer.Usuario;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class MenuOperativo extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private JPanel panelContenido;

    public MenuOperativo(Usuario usuario) {
        
        JLabel lblTitulo = new JLabel("Panel Operativo");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 250, 30);
        contentPane.add(lblTitulo);
        
        JLabel lblUsuario = new JLabel(usuario.getNombre() + " " + usuario.getApellido());
        lblUsuario.setForeground(new Color(120, 120, 120));
        lblUsuario.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        lblUsuario.setBounds(390, 90, 200, 20);
        contentPane.add(lblUsuario);

        // BOTON 1 - Ver Informacion Personal (NO cierra MenuOperativo)
        JButton btnInfoPersonal = crearBoton("Ver Informacion Personal", 200, 170, 220, 50);
        btnInfoPersonal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VerInfoPersonal verInfo = new VerInfoPersonal(usuario, (LogicLayer.Operativo) usuario);
                verInfo.setVisible(true);
            }
        });
        contentPane.add(btnInfoPersonal);

        // BOTON 2 - Crear Solicitud (NO cierra MenuOperativo)
        JButton btnCrearSolicitud = crearBoton("Crear Solicitud", 450, 170, 220, 50);
        btnCrearSolicitud.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CrearSolicitud crearSolicitud = new CrearSolicitud();
                crearSolicitud.setVisible(true);
            }
        });
        contentPane.add(btnCrearSolicitud);

        // BOTON 3 - Comentar (NO cierra MenuOperativo)
        JButton btnComentar = crearBoton("Comentar", 200, 250, 220, 50);
        btnComentar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Comentar comentar = new Comentar(usuario);
                comentar.setVisible(true);
            }
        });
        contentPane.add(btnComentar);

        // BOTON 4 - Cargo (CIERRA MenuOperativo porque abre Cargo)
        JButton btnCargo = crearBoton("Cargo", 450, 250, 220, 50);
        btnCargo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cargo cargo = new Cargo(usuario);
                cargo.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnCargo);

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