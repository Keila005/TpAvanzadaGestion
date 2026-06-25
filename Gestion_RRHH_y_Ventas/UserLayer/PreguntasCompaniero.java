package UserLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class PreguntasCompaniero extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreguntasCompaniero frame = new PreguntasCompaniero();
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
	public PreguntasCompaniero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Afirmativo");
		chckbxNewCheckBox.setBounds(82, 33, 102, 20);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel = new JLabel("Cumple sus tareas a tiempo?");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 416, 31);
		contentPane.add(lblNewLabel);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Negativo");
		chckbxNewCheckBox_1.setBounds(228, 33, 102, 20);
		contentPane.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Yes");
		chckbxNewCheckBox_2.setBounds(82, 78, 102, 20);
		contentPane.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("No");
		chckbxNewCheckBox_1_1.setBounds(228, 78, 102, 20);
		contentPane.add(chckbxNewCheckBox_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Asiste regularmente al trabajo grupal?");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 55, 416, 31);
		contentPane.add(lblNewLabel_1);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Asi merito");
		chckbxNewCheckBox_3.setBounds(82, 123, 102, 20);
		contentPane.add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_1_2 = new JCheckBox("Nel");
		chckbxNewCheckBox_1_2.setBounds(228, 123, 102, 20);
		contentPane.add(chckbxNewCheckBox_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("Apoya a sus compañeros si es necesario?");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 100, 416, 31);
		contentPane.add(lblNewLabel_2);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Ponele");
		chckbxNewCheckBox_4.setBounds(82, 168, 102, 20);
		contentPane.add(chckbxNewCheckBox_4);
		
		JCheckBox chckbxNewCheckBox_1_3 = new JCheckBox("Ni a gancho");
		chckbxNewCheckBox_1_3.setBounds(228, 168, 102, 20);
		contentPane.add(chckbxNewCheckBox_1_3);
		
		JLabel lblNewLabel_3 = new JLabel("Se comunica de forma clara?");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(33, 145, 348, 31);
		contentPane.add(lblNewLabel_3);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("De una");
		chckbxNewCheckBox_5.setBounds(82, 213, 102, 20);
		contentPane.add(chckbxNewCheckBox_5);
		
		JCheckBox chckbxNewCheckBox_1_4 = new JCheckBox("Ni ahi");
		chckbxNewCheckBox_1_4.setBounds(228, 213, 102, 20);
		contentPane.add(chckbxNewCheckBox_1_4);
		
		JLabel lblNewLabel_4 = new JLabel("Escucha y respeta las opiniones de otros?");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 190, 416, 31);
		contentPane.add(lblNewLabel_4);
		
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("aja");
		chckbxNewCheckBox_6.setBounds(82, 258, 102, 20);
		contentPane.add(chckbxNewCheckBox_6);
		
		JCheckBox chckbxNewCheckBox_1_5 = new JCheckBox("No papu");
		chckbxNewCheckBox_1_5.setBounds(228, 258, 102, 20);
		contentPane.add(chckbxNewCheckBox_1_5);
		
		JLabel lblNewLabel_5 = new JLabel("Muestra iniciativa en su trabajo?");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 235, 416, 31);
		contentPane.add(lblNewLabel_5);
		
		JCheckBox chckbxNewCheckBox_7 = new JCheckBox("siii!!!!!11");
		chckbxNewCheckBox_7.setBounds(82, 303, 102, 20);
		contentPane.add(chckbxNewCheckBox_7);
		
		JCheckBox chckbxNewCheckBox_1_6 = new JCheckBox("noo9oo");
		chckbxNewCheckBox_1_6.setBounds(228, 303, 102, 20);
		contentPane.add(chckbxNewCheckBox_1_6);
		
		JLabel lblNewLabel_6 = new JLabel("Se adapta a cambios en el proyecto?");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(43, 280, 338, 31);
		contentPane.add(lblNewLabel_6);
		
		JCheckBox chckbxNewCheckBox_8 = new JCheckBox("confirmo");
		chckbxNewCheckBox_8.setBounds(82, 348, 102, 20);
		contentPane.add(chckbxNewCheckBox_8);
		
		JCheckBox chckbxNewCheckBox_1_7 = new JCheckBox("niego rotundamente");
		chckbxNewCheckBox_1_7.setBounds(228, 348, 141, 20);
		contentPane.add(chckbxNewCheckBox_1_7);
		
		JLabel lblNewLabel_7 = new JLabel("Mantiene una actitud responsable?");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(10, 325, 416, 31);
		contentPane.add(lblNewLabel_7);
		
		JCheckBox chckbxNewCheckBox_9 = new JCheckBox("si papu");
		chckbxNewCheckBox_9.setBounds(82, 393, 102, 20);
		contentPane.add(chckbxNewCheckBox_9);
		
		JCheckBox chckbxNewCheckBox_1_8 = new JCheckBox("no papu x2");
		chckbxNewCheckBox_1_8.setBounds(228, 393, 102, 20);
		contentPane.add(chckbxNewCheckBox_1_8);
		
		JLabel lblNewLabel_8 = new JLabel("Cumple con su rol dentro del equipo?");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(10, 370, 416, 31);
		contentPane.add(lblNewLabel_8);
		
		JCheckBox chckbxNewCheckBox_10 = new JCheckBox("siiiiiiiiiiii");
		chckbxNewCheckBox_10.setBounds(82, 438, 102, 20);
		contentPane.add(chckbxNewCheckBox_10);
		
		JCheckBox chckbxNewCheckBox_1_9 = new JCheckBox("nooooooooooooo");
		chckbxNewCheckBox_1_9.setBounds(228, 438, 153, 20);
		contentPane.add(chckbxNewCheckBox_1_9);
		
		JLabel lblNewLabel_9 = new JLabel("Contribuye positivamente al resultado del proyecto?");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(10, 415, 416, 31);
		contentPane.add(lblNewLabel_9);
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.setBounds(280, 490, 102, 20);
		contentPane.add(btnNewButton);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(426, 490, 102, 20);
		contentPane.add(btnVolver);
		
		textField = new JTextField();
		textField.setBounds(435, 123, 215, 260);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Agregue un comentario:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(408, 78, 265, 31);
		contentPane.add(lblNewLabel_2_1);

	}
}
