package UserLayer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DLL.ControllerTarea;
import LogicLayer.Tarea;
import LogicLayer.Usuario;

public class VisualizarKanban extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private Usuario usuario;

	private JComboBox<Tarea> comboTareas;

	private LinkedList<Tarea> tareasAsignadas;

	private ControllerTarea controllerTarea = new ControllerTarea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarKanban frame = new VisualizarKanban();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VisualizarKanban(Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 260);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("KANBAN");
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
		lblTitulo.setBounds(215, 10, 120, 30);
		contentPane.add(lblTitulo);

		JLabel lblTareas = new JLabel("Mis tareas:");
		lblTareas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTareas.setBounds(40, 60, 100, 20);
		contentPane.add(lblTareas);

		comboTareas = new JComboBox<>();
		comboTareas.setBounds(40, 90, 450, 30);
		contentPane.add(comboTareas);

		JButton btnTrabajar = new JButton("TRABAJAR");
		btnTrabajar.setBackground(new Color(65, 105, 225));
		btnTrabajar.setForeground(Color.WHITE);
		btnTrabajar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTrabajar.setBounds(190, 145, 140, 35);
		contentPane.add(btnTrabajar);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(410, 185, 100, 25);
		contentPane.add(btnVolver);

		cargarTareas();

		btnTrabajar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Tarea tarea = (Tarea) comboTareas.getSelectedItem();

				if (tarea == null) {
					JOptionPane.showMessageDialog(null, "Seleccione una tarea.");
					return;
				}

				tarea.trabajar();

				controllerTarea.trabajarTarea(tarea.getIdTarea());

				JOptionPane.showMessageDialog(null,
						"La tarea fue actualizada.");

				cargarTareas();
			}
		});

		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

			public void actionPerformed(ActionEvent e) {

				MiembroDelProyecto menu = new MiembroDelProyecto(usuario);
				menu.setVisible(true);
				dispose();
			}
		});
	}

	private void cargarTareas() {

		comboTareas.removeAllItems();

		tareasAsignadas =
				controllerTarea.obtenerTareasEmpleado(usuario.getIdUsuario());

		for (Tarea t : tareasAsignadas) {

			if (!"FINALIZADA".equalsIgnoreCase(t.getEstado())) {
				comboTareas.addItem(t);
			}
		}
		
	}

}
