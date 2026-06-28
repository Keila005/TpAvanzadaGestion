package UserLayer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;

public class VerInfoPersonal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VerInfoPersonal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ver informacion personal");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(119, 22, 214, 31);
		contentPane.add(lblNewLabel);
				
		JButton btnNewButton = new JButton("Mis datos");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MisDatos MisDatos = new MisDatos();
				MisDatos.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(28, 84, 187, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Rendimiento");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(225, 84, 187, 44);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rendimiento Rendimiento = new Rendimiento();
				Rendimiento.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Ver mi sueldo");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MiSueldo MiSueldo = new MiSueldo();
				MiSueldo.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(28, 138, 187, 44);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Ver ausencias");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBounds(225, 138, 187, 44);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			misAusencias misAusencias = new misAusencias();
			misAusencias.setVisible(true);
			dispose();
			}
		});
		contentPane.add(btnNewButton_3);
		


		JButton btnNewButton_4 = new JButton("Volver");
		btnNewButton_4.setBounds(325, 211, 101, 31);
		
		
		contentPane.add(btnNewButton_4);
		
	}
}
