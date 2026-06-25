package UserLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class historial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					historial frame = new historial();
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
	public historial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Historial de Sueldos");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setBounds(110, 10, 219, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("1. " + "ID: " + "user ID");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_1.setBounds(22, 58, 404, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Base: $");
		lblNewLabel_1_2_1.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_1_2_1.setBounds(70, 89, 356, 23);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Total: $");
		lblNewLabel_1_2_1_1.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_1_2_1_1.setBounds(70, 122, 356, 23);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("2. ID: user ID");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(22, 166, 404, 23);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Base: $");
		lblNewLabel_1_2_1_2.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_1_2_1_2.setBounds(70, 197, 356, 23);
		contentPane.add(lblNewLabel_1_2_1_2);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Total: $");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_1_2_1_1_1.setBounds(70, 230, 356, 23);
		contentPane.add(lblNewLabel_1_2_1_1_1);

	}

}
