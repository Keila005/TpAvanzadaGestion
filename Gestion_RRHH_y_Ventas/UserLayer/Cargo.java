package UserLayer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DLL.ControllerOperativo;
import LogicLayer.Operativo;
import LogicLayer.Usuario;

import java.awt.Font;
import javax.swing.JLabel;

public class Cargo extends JFrame {
	private Usuario usuario;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Cargo(Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Seleccione su Rol");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(160, 10, 139, 40);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Lider del proyecto");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(30, 112, 186, 67);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LiderDelProyecto liderDeProyecto = new LiderDelProyecto(usuario);
				liderDeProyecto.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);

		contentPane.add(btnNewButton);
//
//		JButton btnNewButton_1 = new JButton("Miembro del proyecto");
//		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		btnNewButton_1.setBounds(226, 112, 186, 67);
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				MiembroDelProyecto MiembroDelProyecto = new MiembroDelProyecto ();
//				MiembroDelProyecto.setVisible(true);
//				dispose();
//			}
//		});
//		
//		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Volver");
		btnNewButton_2.setBounds(312, 208, 114, 34);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuOperativo MenuOperativo = new MenuOperativo(usuario);
				MenuOperativo.setVisible(true);
				dispose();
			}
			
		});
		
		contentPane.add(btnNewButton_2);
		
		Operativo operativo = (Operativo) usuario;

		btnNewButton.setVisible(false);
//		btnNewButton_1.setVisible(false);

		switch (operativo.getRol()) {

		case LIDER_PROYECTO:
			lblNewLabel.setText("Rol: Líder del Proyecto");
			btnNewButton.setVisible(true);
			break;

		case MIEMBRO_PROYECTO:
			lblNewLabel.setText("Rol: Miembro del Proyecto");
//			btnNewButton_1.setVisible(true);
			break;
		}

		
		
	}

}
