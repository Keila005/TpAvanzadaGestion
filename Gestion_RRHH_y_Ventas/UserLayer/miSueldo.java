package UserLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class miSueldo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					miSueldo frame = new miSueldo();
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
	public miSueldo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUltimaLiquidacion = new JButton("Ultima liquidacion");
		btnUltimaLiquidacion.setBounds(10, 86, 185, 43);
		btnUltimaLiquidacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ultimaLiquidacion ultimaLiquidacion = new ultimaLiquidacion();
				ultimaLiquidacion.setVisible(true);
				dispose();
			}
			
		});
		btnUltimaLiquidacion.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUltimaLiquidacion.setBackground(UIManager.getColor("Button.background"));
//		btnNewButton.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//			ultimaLiquidacion ultimaLiquidacion = new ultimaLiquidacion();
//			ultimaLiquidacion.setVisible(true);
//			dispose();
//		}
//		});
		contentPane.add(btnUltimaLiquidacion);
		
		JButton btnNewButton_4 = new JButton("Volver");
		btnNewButton_4.setBounds(325, 208, 101, 31);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verInformacionPersonal verInformacionPersonal = new verInformacionPersonal();
				verInformacionPersonal.setVisible(true);
				dispose();
			}
			
		});
		contentPane.add(btnNewButton_4);
		
		JButton btnHistorialCompleto = new JButton("Historial completo");
		btnHistorialCompleto.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHistorialCompleto.setBackground(UIManager.getColor("Button.background"));
		btnHistorialCompleto.setBounds(241, 86, 185, 43);
		btnUltimaLiquidacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				historial historial = new historial();
				historial.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnHistorialCompleto);

	}

}
