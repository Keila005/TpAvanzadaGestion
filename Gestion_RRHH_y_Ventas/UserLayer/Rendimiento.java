package UserLayer;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LogicLayer.Operativo;

public class Rendimiento extends JFrame {
	private Operativo operativo;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rendimiento frame = new Rendimiento();
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
	public Rendimiento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel_3 = new JLabel("Rendimiento Individual: " + operativo.getRendimiento() + "%");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_3.setBounds(76, 55, 318, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Rendimiento Grupal: " + operativo.getRendimientoGrupal() + "%");
		lblNewLabel_3_1.setToolTipText("");
		lblNewLabel_3_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(76, 89, 266, 22);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Rendimiento Final: " + "%");
		lblNewLabel_3_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_3_1_1.setBounds(76, 155, 266, 23);
		contentPane.add(lblNewLabel_3_1_1);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(147, 218, 95, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblMiRendimiento = new JLabel("Mi Rendimiento");
		lblMiRendimiento.setFont(new Font("Verdana", Font.BOLD, 18));
		lblMiRendimiento.setBounds(130, 10, 180, 23);
		contentPane.add(lblMiRendimiento);


	}

}
