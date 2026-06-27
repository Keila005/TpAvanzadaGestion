package UserLayer;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LogicLayer.Usuario;
import LogicLayer.Operativo;

public class MisDatos extends JFrame {
	
	private Usuario usuario;
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
		lblMisDatos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMisDatos.setBounds(164, 10, 91, 22);
		contentPane.add(lblMisDatos);
		
		JLabel lblNewLabel_3 = new JLabel("ID: " + operativo.getIdUsuario());
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 84, 28, 17);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Rol: " + operativo.getRol());
		lblNewLabel_3_1.setToolTipText("");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(10, 111, 33, 17);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Rendimiento: " + operativo.getRendimiento() + "%");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1.setBounds(10, 138, 123, 17);
		contentPane.add(lblNewLabel_3_1_1);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(166, 228, 89, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Empleado: " + usuario.getNombre());
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 57, 80, 17);
		contentPane.add(lblNewLabel_1);

	}

}
