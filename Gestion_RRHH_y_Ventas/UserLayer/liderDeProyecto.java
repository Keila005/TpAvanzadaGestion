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
<<<<<<< HEAD

public class liderDeProyecto extends JFrame {
	
	private Usuario usuario;

=======

public class liderDeProyecto extends JFrame {

>>>>>>> main
	private Usuario usuario;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
<<<<<<< HEAD
<<<<<<< Updated upstream
	
=======
=======
>>>>>>> main
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					liderDeProyecto frame = new liderDeProyecto();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
<<<<<<< HEAD
>>>>>>> Stashed changes
=======
>>>>>>> main

	/**
	 * Create the frame.
	 */
	public liderDeProyecto(Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Realice una accion");
		lblNewLabel.setBounds(118, 26, 191, 23);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Visualizar Kanban");
		btnNewButton.setBounds(29, 81, 183, 36);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			visualizarKanban visualizarKanban = new visualizarKanban(usuario);
			visualizarKanban.setVisible(true);
			dispose();
			}
	});
		

		JButton btnNewButton_1 = new JButton("Crear Tareas");
		btnNewButton_1.setBounds(228, 139, 183, 36);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearTarea crearTarea = new crearTarea();
				crearTarea.setVisible(true);
				dispose(); 
			}
		});
		contentPane.add(btnNewButton_1);
		

		JButton btnNewButton_2 = new JButton("Registrar Reuniones");
		btnNewButton_2.setBounds(228, 81, 183, 36);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarReunion registrarReunion = new registrarReunion();
				registrarReunion.setVisible(true);
				dispose(); 
			}
		});
		contentPane.add(btnNewButton_2);
		
		
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Evaluar Compañero");
		btnNewButton_3.setBounds(29, 139, 183, 36);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EvaluarCompaniero EvaluarCompaniero = new EvaluarCompaniero(usuario);
				EvaluarCompaniero.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Volver");
<<<<<<< HEAD
<<<<<<< Updated upstream
		btnNewButton_4.setBounds(758, 11, 61, 21);
=======
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
<<<<<<< Updated upstream
				cargo cargo = new cargo(usuario);
				cargo.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBounds(249, 229, 183, 36);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			cargo cargo = new cargo(null);
=======
			cargo cargo = new cargo(usuario);
>>>>>>> Stashed changes
=======
		btnNewButton_4.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnNewButton_4.setBounds(248, 217, 107, 36);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
			cargo cargo = new cargo(usuario);
=======
			cargo cargo = new cargo(null);
>>>>>>> 582830926404ebf67bea2dc0c367ff7a4b1f7785
>>>>>>> main
			cargo.setVisible(true);
				dispose();
			}
		});
<<<<<<< HEAD
>>>>>>> Stashed changes
=======
		
>>>>>>> main
		contentPane.add(btnNewButton_4);

	}
}
