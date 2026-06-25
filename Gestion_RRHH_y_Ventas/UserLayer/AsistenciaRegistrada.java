package UserLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
<<<<<<< HEAD

import LogicLayer.Usuario;

=======
>>>>>>> main
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AsistenciaRegistrada extends JFrame {
<<<<<<< HEAD
	
	private Usuario usuario;
=======
>>>>>>> main

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
<<<<<<< HEAD
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AsistenciaRegistrada frame = new AsistenciaRegistrada(usuario);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
=======
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AsistenciaRegistrada frame = new AsistenciaRegistrada();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
>>>>>>> main

	/**
	 * Create the frame.
	 */
<<<<<<< HEAD
	public AsistenciaRegistrada(Usuario usuario) {
		
		
=======
	public AsistenciaRegistrada() {
>>>>>>> main
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Asistencia registrada!!1!!");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel.setBounds(75, 70, 291, 53);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 18));
		btnNewButton.setBounds(137, 178, 166, 41);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
				MiembroDelProyecto MiembroDelProyecto = new MiembroDelProyecto(usuario);
=======
				MiembroDelProyecto MiembroDelProyecto = new MiembroDelProyecto();
>>>>>>> main
				MiembroDelProyecto.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton);

	}

}
