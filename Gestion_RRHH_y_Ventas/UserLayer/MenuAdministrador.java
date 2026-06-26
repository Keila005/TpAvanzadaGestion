package UserLayer;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import LogicLayer.Administrador;
import LogicLayer.MenuVentas;
import LogicLayer.Usuario;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MenuAdministrador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MenuAdministrador frame = new MenuAdministrador();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public MenuAdministrador(Usuario usuario) {
		Administrador admin = (Administrador) usuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblbienvenida = new JLabel("Bienvenido administrador: "+ usuario.getNombre());
		lblbienvenida.setForeground(new Color(0, 100, 0));
		lblbienvenida.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblbienvenida.setBounds(173, 16, 380, 28);
		contentPane.add(lblbienvenida);
		
		JButton btnEmpleados = new JButton("Gestionar empleados");
		btnEmpleados.setForeground(new Color(255, 255, 255));
		btnEmpleados.setBackground(new Color(27, 94, 32));
		btnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGestionar menugestion=new MenuGestionar(admin);
				menugestion.setVisible(true);
				dispose();
			}
		});
		btnEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEmpleados.setBounds(40, 171, 200, 38);
		contentPane.add(btnEmpleados);
		
		JButton btnSalir = new JButton("Cerrar sesión");
		btnSalir.setBackground(new Color(255, 0, 0));
		btnSalir.setForeground(new Color(255, 250, 250));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Saludos chau= new Saludos();
				chau.setVisible(true);
				dispose();
				 DLL.ControllerAsistencia asis = new DLL.ControllerAsistencia();
	            int idEmpleado = asis.getIdEmpleadoByUsuario(usuario.getIdUsuario());
	            if (idEmpleado != -1) {
	                asis.registrarSalida(idEmpleado);
	                JOptionPane.showMessageDialog(null, "Salida registrada. Hasta luego!");
	            }
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSalir.setBounds(603, 6, 151, 38);
		contentPane.add(btnSalir);
		
		JButton btnProyectos = new JButton("Registrar Proyectos");
		btnProyectos.setForeground(new Color(255, 255, 255));
		btnProyectos.setBackground(new Color(27, 94, 32));
		btnProyectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuProyecto menuProyecto=new MenuProyecto(usuario);
				menuProyecto.setVisible(true);
				dispose();
			}
		});
		btnProyectos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnProyectos.setBounds(264, 315, 200, 38);
		contentPane.add(btnProyectos);
		
		JButton btnEstadisticas = new JButton("Rendimiento empleado");
		btnEstadisticas.setForeground(new Color(255, 255, 255));
		btnEstadisticas.setBackground(new Color(27, 94, 32));
		btnEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RendimientoEmpleado rendimientoEmpleado= new RendimientoEmpleado(usuario);
				rendimientoEmpleado.setVisible(true);
				dispose();
			}
		});
		btnEstadisticas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEstadisticas.setBounds(264, 171, 200, 38);
		contentPane.add(btnEstadisticas);
		
		JButton btnSolicitudes = new JButton("Solicitudes");
		btnSolicitudes.setForeground(new Color(255, 255, 255));
		btnSolicitudes.setBackground(new Color(27, 94, 32));
		btnSolicitudes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verSolicitudes solicitud=new verSolicitudes(usuario);
				solicitud.setVisible(true);
				dispose();
			}
		});
		btnSolicitudes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSolicitudes.setBounds(264, 245, 200, 38);
		contentPane.add(btnSolicitudes);
		
		JButton btnHorasExtras = new JButton("Horas Extras");
		btnHorasExtras.setForeground(new Color(255, 255, 255));
		btnHorasExtras.setBackground(new Color(27, 94, 32));
		btnHorasExtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				horasExtras extras= new horasExtras(usuario);
				extras.setVisible(true);
				dispose();
			}
		});
		btnHorasExtras.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHorasExtras.setBounds(40, 245, 200, 38);
		contentPane.add(btnHorasExtras);
		
		JButton btnGestionarBonos = new JButton("Gestionar Bonos");
		btnGestionarBonos.setForeground(new Color(255, 255, 255));
		btnGestionarBonos.setBackground(new Color(27, 94, 32));
		btnGestionarBonos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionarBonos bono= new GestionarBonos(usuario);
				bono.setVisible(true);
				dispose();
			}
		});
		btnGestionarBonos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGestionarBonos.setBounds(497, 245, 200, 38);
		contentPane.add(btnGestionarBonos);
		
		JButton btnAsistencia = new JButton("Asistencia");
		btnAsistencia.setForeground(new Color(255, 255, 255));
		btnAsistencia.setBackground(new Color(27, 94, 32));
		btnAsistencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionarAsistencia asistencia=new GestionarAsistencia(usuario);
				asistencia.setVisible(true);
				dispose();
			}
		});
		btnAsistencia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAsistencia.setBounds(497, 315, 200, 38);
		contentPane.add(btnAsistencia);
		
		JButton btnRendimientoProductos = new JButton("Ver ventas");
		btnRendimientoProductos.setForeground(new Color(255, 255, 255));
		btnRendimientoProductos.setBackground(new Color(27, 94, 32));
		btnRendimientoProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuVentas ventas= new MenuVentas(usuario);
				ventas.setVisible(true);
				dispose();
			}
		});
		btnRendimientoProductos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRendimientoProductos.setBounds(497, 171, 200, 38);
		contentPane.add(btnRendimientoProductos);
		
		JButton btnProyectos_1 = new JButton("Clima laboral");
		btnProyectos_1.setForeground(new Color(255, 255, 255));
		btnProyectos_1.setBackground(new Color(27, 94, 32));
		btnProyectos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				climaLaboral comentario= new climaLaboral(usuario);
				comentario.setVisible(true);
				dispose();
			}
		});
		btnProyectos_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnProyectos_1.setBounds(40, 315, 200, 38);
		contentPane.add(btnProyectos_1);
		
		JLabel lblNewLabel = new JLabel("Desde este panel podrá gestionar empleados, proyectos, estadísticas y supervisar el funcionamiento general de la empresa.");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel.setBounds(28, 68, 712, 49);
		contentPane.add(lblNewLabel);
		
		JPanel panelFondo = new JPanel();
		panelFondo.setBackground(new Color(218, 218, 218));
		panelFondo.setBounds(0, 153, 764, 292);
		contentPane.add(panelFondo);

	}

}
