package UserLayer;

import LogicLayer.Usuario;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class LiderDelProyecto extends VentanaBase {
	
	private static final long serialVersionUID = 1L;

	public LiderDelProyecto(Usuario usuario) {
		
		JLabel lblTitulo = new JLabel("Panel Lider");
		lblTitulo.setForeground(new Color(0, 91, 0));
		lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
		lblTitulo.setBounds(350, 60, 250, 30);
		contentPane.add(lblTitulo);
		
		JLabel lblUsuario = new JLabel(usuario.getNombre() + " " + usuario.getApellido());
		lblUsuario.setForeground(new Color(120, 120, 120));
		lblUsuario.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblUsuario.setBounds(390, 95, 200, 25);
		contentPane.add(lblUsuario);
		
		JPanel linea = new JPanel();
		linea.setBackground(new Color(0, 91, 0, 50));
		linea.setBounds(250, 130, 422, 1);
		contentPane.add(linea);

		JButton btnKanban = crearBoton("Visualizar Kanban", 280, 170, 180, 50);
		btnKanban.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizarKanban visualizarKanban = new VisualizarKanban(usuario);
				visualizarKanban.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnKanban);
		
		JButton btnTareas = crearBoton("Crear tareas", 480, 170, 180, 50);
		btnTareas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearTarea crearTarea = new CrearTarea(usuario);
				crearTarea.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnTareas);
		
		JButton btnReunion = crearBoton("Registrar reunion", 280, 240, 180, 50);
		btnReunion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarReunion registrarReunion = new RegistrarReunion(usuario);
				registrarReunion.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnReunion);
		
		JButton btnEvaluar = crearBoton("Evaluar compañero", 480, 240, 180, 50);
		btnEvaluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EvaluarCompaniero evaluar = new EvaluarCompaniero();
				evaluar.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnEvaluar);
		
		JButton btnVolver = crearBotonRojo("Volver", EstilosGlobales.ANCHO_VENTANA - 130, EstilosGlobales.ALTO_VENTANA - 55, 110, 35);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cargo cargo = new Cargo(usuario);
				cargo.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnVolver);
		
		JButton btnCerrarSesion = crearBotonRojo("Cerrar Sesion", EstilosGlobales.ANCHO_VENTANA - 140, EstilosGlobales.ALTO_VENTANA - 55, 120, 35);
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Cerrando sesion...");
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnCerrarSesion);
		
		seleccionarTabPorIndice(0);
	}
}