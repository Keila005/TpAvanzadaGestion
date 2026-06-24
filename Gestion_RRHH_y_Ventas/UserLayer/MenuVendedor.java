package UserLayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LogicLayer.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MenuVendedor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MenuVendedor frame = new MenuVendedor();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public MenuVendedor(Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido vendedor: <dynamic>");
		lblNewLabel.setBounds(31, 50, 271, 21);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Stock");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(31, 116, 190, 51);
		contentPane.add(btnNewButton);
		
		JButton btnPerfilLaboral = new JButton("Perfil Laboral");
		btnPerfilLaboral.setBounds(31, 210, 190, 51);
		contentPane.add(btnPerfilLaboral);
		
		JButton btnVenta = new JButton("Venta");
		btnVenta.setBounds(269, 116, 190, 51);
		contentPane.add(btnVenta);
		
		JButton btnHistorialDeVentas = new JButton("Historial de Ventas");
		btnHistorialDeVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHistorialDeVentas.setBounds(269, 210, 190, 51);
		contentPane.add(btnHistorialDeVentas);
		
		JButton btnCerrarSession = new JButton("Cerrar Session");
		btnCerrarSession.setForeground(new Color(255, 0, 0));
		btnCerrarSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCerrarSession.setBounds(326, 45, 133, 36);
		contentPane.add(btnCerrarSession);

	}
}
