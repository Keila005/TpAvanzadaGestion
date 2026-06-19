package UserLayer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import LogicLayer.Administrador;
import LogicLayer.Usuario;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MenuAdministrador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Usuario usuario;

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
		  this.usuario = usuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 672);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblbienvenida = new JLabel("Bienvenido administrador: "+ usuario.getNombre());
		lblbienvenida.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblbienvenida.setBounds(289, 25, 380, 28);
		contentPane.add(lblbienvenida);
		
		JButton btnEmpleados = new JButton("Gestionar empleados");
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
		btnSalir.setForeground(new Color(255, 0, 0));
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
		btnSalir.setBounds(719, 21, 151, 38);
		contentPane.add(btnSalir);
		
		JButton btnProyectos = new JButton("Registrar Proyectos");
		btnProyectos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnProyectos.setBounds(709, 171, 200, 38);
		contentPane.add(btnProyectos);
		
		JButton btnEstadisticas = new JButton("Ver estadisticas de rendimiento");
		btnEstadisticas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEstadisticas.setBounds(340, 171, 271, 38);
		contentPane.add(btnEstadisticas);
		
		JButton btnSolicitudes = new JButton("Solicitudes");
		btnSolicitudes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSolicitudes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSolicitudes.setBounds(289, 266, 200, 38);
		contentPane.add(btnSolicitudes);
		
		JButton btnHorasExtras = new JButton("Horas Extras");
		btnHorasExtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHorasExtras.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHorasExtras.setBounds(40, 266, 200, 38);
		contentPane.add(btnHorasExtras);
		
		JButton btnGestionarBonos = new JButton("Gestionar Bonos");
		btnGestionarBonos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGestionarBonos.setBounds(543, 266, 200, 38);
		contentPane.add(btnGestionarBonos);
		
		JButton btnAsistencia = new JButton("Asistencia");
		btnAsistencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAsistencia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAsistencia.setBounds(773, 266, 200, 38);
		contentPane.add(btnAsistencia);

	}

}
