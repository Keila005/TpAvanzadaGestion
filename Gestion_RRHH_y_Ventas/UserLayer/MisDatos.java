package UserLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class MisDatos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MisDatos frame = new MisDatos();
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
	public MisDatos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMisDatos = new JLabel("Mis Datos");
		lblMisDatos.setFont(new Font("Verdana", Font.BOLD, 18));
		lblMisDatos.setBounds(148, 10, 111, 23);
		contentPane.add(lblMisDatos);
		
		JLabel lblNewLabel_3 = new JLabel("ID: ");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_3.setBounds(31, 79, 267, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Rol: ");
		lblNewLabel_3_1.setToolTipText("");
		lblNewLabel_3_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(31, 113, 267, 22);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Rendimiento: " + " " + "%");
		lblNewLabel_3_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_3_1_1.setBounds(31, 145, 267, 23);
		contentPane.add(lblNewLabel_3_1_1);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(162, 193, 95, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Empleado: ");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_1.setBounds(31, 49, 302, 20);
		contentPane.add(lblNewLabel_1);

	}

}
