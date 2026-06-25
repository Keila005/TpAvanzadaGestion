package UserLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LogicLayer.Usuario;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MenuOperativo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public MenuOperativo(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido Operativo:"+usuario.getNombre());
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel.setBounds(30, 10, 377, 44);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ver informacion personal");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(172, 238, 123));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//<<<<<<< HEAD

				verInformacionPersonal ventana = new verInformacionPersonal();
				ventana.setVisible(true);

				dispose(); // cierra el menú actual
//=======
				
//>>>>>>> 56f6bfa5f6cb089ef789a11247c6dde1e8fea425
			}
		});
		btnNewButton.setBounds(10, 64, 200, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Solicitudes");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(10, 129, 214, 44);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			SolicitarVacaciones SolicitarVacaciones = new SolicitarVacaciones();
			SolicitarVacaciones.setVisible(true); 
				dispose();
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Comentar");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comentar comentario= new Comentar();
				comentario.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(249, 129, 177, 44);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Cargo");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargo cargo = new cargo();
				cargo.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBounds(226, 64, 200, 44);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Salir");
		btnNewButton_4.setBounds(325, 211, 101, 31);
		contentPane.add(btnNewButton_4);

	}
}
