package UserLayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LogicLayer.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MenuVendedor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private Usuario usuario;


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
		this.usuario = usuario;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido vendedor: " + usuario.getNombre() );
		lblNewLabel.setBounds(31, 50, 271, 21);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Stock");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MenuStock stock =
						new MenuStock(usuario);

				stock.setVisible(true);

				dispose();
			}
		});
		btnNewButton.setBounds(31, 116, 190, 51);
		contentPane.add(btnNewButton);
		
		JButton btnPerfilLaboral = new JButton("Perfil Laboral");
		btnPerfilLaboral.setBounds(31, 210, 190, 51);
		contentPane.add(btnPerfilLaboral);
		
		JButton btnVenta = new JButton("Venta");
		btnVenta.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        AgregarVenta venta =
		                new AgregarVenta(usuario);

		        venta.setVisible(true);

		        dispose();
		    }
		});
		btnVenta.setBounds(269, 116, 190, 51);
		contentPane.add(btnVenta);
		
		JButton btnHistorialDeVentas = new JButton("Historial de Ventas");
		btnHistorialDeVentas.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        HistorialVentas historial =
		                new HistorialVentas(usuario);

		        historial.setVisible(true);

		        dispose();
		    }
		});
		btnHistorialDeVentas.setBounds(269, 210, 190, 51);
		contentPane.add(btnHistorialDeVentas);
		
		JButton btnSalir = new JButton("Cerrar Session");
		btnSalir.setForeground(new Color(255, 0, 0));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Saludos chau= new Saludos();
						chau.setVisible(true);
					dispose();
						 DLL.ControllerAsistencia asis = new DLL.ControllerAsistencia();
			           int idEmpleado = asis.getIdEmpleadoByUsuario(usuario.getIdUsuario());
			            if (idEmpleado != -1) {
			                asis.registrarSalida(idEmpleado);
			                JOptionPane.showMessageDialog(null, "Salida registrada. Hasta luego!");
			}
			}
		});
		btnSalir.setBounds(326, 45, 133, 36);
		contentPane.add(btnSalir);

	}
	
	
	
	
}


