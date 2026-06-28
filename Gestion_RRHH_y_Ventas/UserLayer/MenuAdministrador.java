package UserLayer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import LogicLayer.Administrador;
import LogicLayer.Usuario;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Cursor;


public class MenuAdministrador extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private JPanel panelContenido;
    private JButton btnEmpleados, btnProyectos, btnRendimiento, btnSolicitudes;
    private JButton btnHorasExtras, btnBonos, btnAsistencia, btnVentas, btnClima;

    public MenuAdministrador(Usuario usuario) {
    	navbar.setBounds(0, 0, 922, 50);
        Administrador admin = (Administrador) usuario;
        contentPane.setLayout(null);
        
        JLabel lblTitulo = new JLabel("Panel Administrador");
        lblTitulo.setBounds(350, 55, 250, 30);
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        contentPane.add(lblTitulo);
        
        JLabel lblUsuario = new JLabel(usuario.getNombre() + " " + usuario.getApellido());
        lblUsuario.setBounds(390, 85, 200, 20);
        lblUsuario.setForeground(new Color(120, 120, 120));
        lblUsuario.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        contentPane.add(lblUsuario);
        
        int tabY = 130;
        int tabH = 40;
        int tabGap = 2;
        
        btnEmpleados = crearTab("Gestionar Empleados", 80, tabY, 180, tabH);
        btnEmpleados.addActionListener(e -> {
            seleccionarTab(btnEmpleados, "empleados");
            MenuGestionar menu = new MenuGestionar(admin);
            menu.setVisible(true);
            dispose();
        });
        contentPane.add(btnEmpleados);
        
        btnProyectos = crearTab("Registrar Proyectos", 80 + 180 + tabGap, tabY, 180, tabH);
        btnProyectos.addActionListener(e -> {
            seleccionarTab(btnProyectos, "proyectos");
            MenuProyecto menu = new MenuProyecto(usuario);
            menu.setVisible(true);
            dispose();
        });
        contentPane.add(btnProyectos);
        
        btnRendimiento = crearTab("Rendimiento", 80 + 360 + tabGap * 2, tabY, 180, tabH);
        btnRendimiento.addActionListener(e -> {
            seleccionarTab(btnRendimiento, "rendimiento");
            RendimientoEmpleado rendimiento = new RendimientoEmpleado(usuario);
            rendimiento.setVisible(true);
            dispose();
        });
        contentPane.add(btnRendimiento);
        
        btnSolicitudes = crearTab("Solicitudes", 80 + 540 + tabGap * 3, tabY, 180, tabH);
        btnSolicitudes.addActionListener(e -> {
            seleccionarTab(btnSolicitudes, "solicitudes");
            verSolicitudes solicitud = new verSolicitudes(usuario);
            solicitud.setVisible(true);
            dispose();
        });
        contentPane.add(btnSolicitudes);
        
        btnHorasExtras = crearTab("Horas Extras", 80, tabY + tabH + tabGap, 180, tabH);
        btnHorasExtras.addActionListener(e -> {
            seleccionarTab(btnHorasExtras, "horasextras");
            horasExtras extras = new horasExtras(usuario);
            extras.setVisible(true);
            dispose();
        });
        contentPane.add(btnHorasExtras);
        
        btnBonos = crearTab("Gestionar Bonos", 80 + 180 + tabGap, tabY + tabH + tabGap, 180, tabH);
        btnBonos.addActionListener(e -> {
            seleccionarTab(btnBonos, "bonos");
            GestionarBonos bono = new GestionarBonos(usuario);
            bono.setVisible(true);
            dispose();
        });
        contentPane.add(btnBonos);
        
        btnAsistencia = crearTab("Asistencia", 80 + 360 + tabGap * 2, tabY + tabH + tabGap, 180, tabH);
        btnAsistencia.addActionListener(e -> {
            seleccionarTab(btnAsistencia, "asistencia");
            GestionarAsistencia asistencia = new GestionarAsistencia(usuario);
            asistencia.setVisible(true);
            dispose();
        });
        contentPane.add(btnAsistencia);
        
        btnVentas = crearTab("Ver Ventas", 80 + 540 + tabGap * 3, tabY + tabH + tabGap, 180, tabH);
        btnVentas.addActionListener(e -> {
            seleccionarTab(btnVentas, "ventas");
            MenuVentas ventas = new MenuVentas(usuario);
            ventas.setVisible(true);
            dispose();
        });
        contentPane.add(btnVentas);
        
        btnClima = crearTab("Clima Laboral", 260, tabY + (tabH + tabGap) * 2, 180, tabH);
        btnClima.addActionListener(e -> {
            seleccionarTab(btnClima, "clima");
            climaLaboral comentario = new climaLaboral(usuario);
            comentario.setVisible(true);
            dispose();
        });
        contentPane.add(btnClima);
        
        panelContenido = new JPanel();
        panelContenido.setBounds(140, 260, 620, 220);
        panelContenido.setBackground(new Color(245, 245, 245));
        panelContenido.setLayout(null);
        contentPane.add(panelContenido);
        
        JButton btnSalir = new JButton("Cerrar Sesion");
        btnSalir.setBounds(792, 561, 110, 35);
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setBackground(new Color(180, 50, 50));
        btnSalir.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        btnSalir.setBorder(null);
        btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSalir.setFocusPainted(false);
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalir.setBackground(new Color(150, 30, 30));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalir.setBackground(new Color(180, 50, 50));
            }
        });
        btnSalir.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Cerrando sesion...");
            Login login = new Login();
            login.setVisible(true);
            dispose();
        });
        contentPane.add(btnSalir);
        
        seleccionarTab(btnEmpleados, "empleados");
        getContentPane().setLayout(null);
    }
    
    private JButton crearTab(String texto, int x, int y, int ancho, int alto) {
        JButton btn = new JButton(texto);

        btn.setBounds(x, y, ancho, alto);

        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(0, 91, 0));
        btn.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        btn.setBorder(null);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setFocusPainted(false);

        return btn;
    }
    
    private void seleccionarTab(JButton btnSeleccionado, String opcion) {
        JButton[] tabs = {btnEmpleados, btnProyectos, btnRendimiento, btnSolicitudes,
                          btnHorasExtras, btnBonos, btnAsistencia, btnVentas, btnClima};
        
        for (JButton tab : tabs) {
            tab.setBackground(new Color(0, 91, 0));
            tab.setForeground(Color.WHITE);
            tab.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        }
        
        btnSeleccionado.setBackground(new Color(28, 137, 16));
        btnSeleccionado.setForeground(Color.WHITE);
        btnSeleccionado.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        
        panelContenido.removeAll();
        panelContenido.repaint();
        panelContenido.revalidate();
        
        panelContenido.revalidate();
        panelContenido.repaint();
    }
}