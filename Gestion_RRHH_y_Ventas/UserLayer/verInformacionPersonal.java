package UserLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class verInformacionPersonal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					verInformacionPersonal frame = new verInformacionPersonal();
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
	public verInformacionPersonal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Realice una accion");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setBounds(100, 10, 200, 51);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Visualizar Kanban");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(10, 81, 150, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Crear tareas");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(193, 82, 150, 44);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Registrar reunion");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(10, 135, 150, 44);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Evaluar compañero");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBounds(193, 135, 150, 44);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Volver");
		btnNewButton_4.setBounds(254, 233, 100, 25);
		contentPane.add(btnNewButton_4);

	}
}
