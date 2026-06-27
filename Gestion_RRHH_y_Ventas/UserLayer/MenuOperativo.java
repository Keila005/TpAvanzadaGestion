package UserLayer;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LogicLayer.Usuario;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class MenuOperativo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;



	public MenuOperativo(Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 848, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido operativo:"+ usuario.getNombre());
		lblNewLabel.setBounds(269, 10, 310, 51);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ver Informacion Personal");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(175, 146, 206, 57);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Crear Solicitud");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(433, 146, 206, 57);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Comentar");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(175, 235, 206, 57);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Cargo");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_3.setBounds(433, 235, 206, 57);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Salir");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_4.setBounds(350, 433, 119, 45);
		contentPane.add(btnNewButton_4);

	}

}
