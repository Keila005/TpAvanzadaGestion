package UserLayer;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LogicLayer.Usuario;

public class LiderDelProyecto extends JFrame {
	
	private Usuario usuario;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public LiderDelProyecto(Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Realice una accion");
		lblNewLabel.setBounds(125, 10, 191, 23);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Visualizar Kanban");
		btnNewButton.setBounds(62, 112, 147, 23);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			VisualizarKanban VisualizarKanban = new VisualizarKanban(usuario);
			VisualizarKanban.setVisible(true);
			dispose();
			}
	});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Crear tareas");
		btnNewButton_1.setBounds(226, 112, 147, 23);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearTarea CrearTarea = new CrearTarea(usuario);
				CrearTarea.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Registrar reunion");
		btnNewButton_2.setBounds(62, 145, 147, 23);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarReunion registrarReunion = new registrarReunion(usuario);
				registrarReunion.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Evaluar compañero");
		btnNewButton_3.setBounds(226, 145, 147, 23);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				dispose();
			}
		});
		contentPane.add(btnNewButton_3);

		
	}

}
