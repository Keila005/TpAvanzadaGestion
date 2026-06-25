package UserLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import java.awt.Color;

public class ultimaLiquidacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ultimaLiquidacion frame = new ultimaLiquidacion();
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
	public ultimaLiquidacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Liquidacion de sueldo");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setBounds(52, 10, 224, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Empleado: ");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_1.setBounds(24, 43, 302, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Sueldo Base: $");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_3.setBounds(34, 120, 135, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("DNI: ");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(24, 73, 302, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(107, 304, 95, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3_1 = new JLabel("Bonos: $");
		lblNewLabel_3_1.setToolTipText("");
		lblNewLabel_3_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(34, 154, 266, 22);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Horas Extra: $");
		lblNewLabel_3_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_3_1_1.setBounds(34, 186, 266, 23);
		contentPane.add(lblNewLabel_3_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(UIManager.getColor("Button.focus"));
		separator.setBounds(10, 219, 316, 20);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(10, 103, 316, 20);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_2 = new JLabel("TOTAL: $");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_2.setBounds(34, 249, 266, 35);
		contentPane.add(lblNewLabel_2);

	}
}
