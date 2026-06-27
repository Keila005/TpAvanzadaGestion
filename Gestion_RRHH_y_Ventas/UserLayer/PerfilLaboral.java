package UserLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import LogicLayer.Usuario;
import LogicLayer.Vendedor;
import DLL.ControllerEmpleado;
import DLL.ControllerVenta;


public class PerfilLaboral extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Usuario usuario;
	private JLabel lblNombre;
	private JLabel lblDni;
	private JLabel lblCorreo;
	private JLabel lblCargo;
	private JLabel lblSueldoBase;
	private JLabel lblVentas;
	private JLabel lblUltimaVenta;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PerfilLaboral frame = new PerfilLaboral();
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
	public PerfilLaboral(Usuario usuario) {
	    this.usuario = usuario;
	    
	   
	    ControllerEmpleado ce = new ControllerEmpleado();
	    Vendedor vendedor = ce.buscarVendedorPorUsuario(usuario.getIdUsuario());

	    ControllerVenta cv = new ControllerVenta();
	    String ultimaVenta = cv.obtenerUltimaVenta(vendedor.getIdEmpleado());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Perfil Laboral");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblTitulo.setBounds(122, 0, 187, 27);
		contentPane.add(lblTitulo);
		
		 lblNombre = new JLabel("Nombre:");
		 lblNombre.setText(
			        "Nombre: "
			        + vendedor.getNombre()
			        + " "
			        + vendedor.getApellido()
			);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(44, 47, 306, 17);
		contentPane.add(lblNombre);
		
		 lblDni = new JLabel("Dni:");
		 lblDni.setText(
			        "DNI: "
			        + vendedor.getDni()
			);
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDni.setBounds(44, 75, 306, 17);
		contentPane.add(lblDni);
		
		 lblCorreo = new JLabel("Correo:");
		 lblCorreo.setText(
			        "Correo: "
			        + vendedor.getMail()
			);

		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCorreo.setBounds(44, 103, 306, 17);
		contentPane.add(lblCorreo);
		
		 lblCargo = new JLabel("Cargo:");
		 lblCargo.setText(
			        "Cargo: Vendedor"
			);
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCargo.setBounds(44, 132, 306, 17);
		contentPane.add(lblCargo);
		
		 lblSueldoBase = new JLabel("Sueldo Base:");
		 lblSueldoBase.setText(
			        "Sueldo Base: $"
			        + vendedor.getSueldoBase()
			);
		lblSueldoBase.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSueldoBase.setBounds(44, 163, 306, 17);
		contentPane.add(lblSueldoBase);
		
		 lblVentas = new JLabel("Ventas:");
		 lblVentas.setText(
			        "Ventas realizadas: "
			        + vendedor.getVentasTotales()
			);
		lblVentas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVentas.setBounds(44, 202, 306, 17);
		contentPane.add(lblVentas);
		
			
		 lblUltimaVenta = new JLabel("Ultima Venta:");
		 lblUltimaVenta.setText(
			        "Última venta: "
			        + cv.obtenerUltimaVenta(
			                vendedor.getIdEmpleado()
			        )
			);
		lblUltimaVenta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUltimaVenta.setBounds(44, 237, 306, 17);
		contentPane.add(lblUltimaVenta);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(e -> {

		    MenuVendedor menu =
		            new MenuVendedor(usuario);

		    menu.setVisible(true);

		    dispose();

		});
		btnVolver.setBounds(122, 281, 144, 48);
		contentPane.add(btnVolver);

		cargarPerfil();
	}//fim
	
	private void cargarPerfil() {

	    lblNombre.setText(
	            "Nombre: " +
	            usuario.getNombre() +
	            " " +
	            usuario.getApellido()
	    );

	    lblCorreo.setText(
	            "Correo: " +
	            usuario.getMail()
	    );

	    lblCargo.setText(
	            "Cargo: Vendedor"
	    );

	    ControllerEmpleado ce =
	            new ControllerEmpleado();

	    Vendedor vendedor =
	            ce.buscarVendedorPorUsuario(
	                    usuario.getIdUsuario()
	            );

	    if(vendedor == null) {

	        return;
	    }
	    
	    if(vendedor != null) {

	        lblDni.setText(
	                "DNI: " +
	                vendedor.getDni()
	        );

	        lblSueldoBase.setText(
	                "Sueldo Base: $" +
	                vendedor.getSueldoBase()
	        );
	    }

	    ControllerVenta cv =
	            new ControllerVenta();

	   
	    		lblVentas.setText(
	    		        "Ventas realizadas: "
	    		        + vendedor.getVentasTotales()
	    		
	    );

	    lblUltimaVenta.setText(
	            "Última Venta: " +
	            cv.obtenerUltimaVenta(
	                    vendedor.getIdEmpleado()
	            )
	    );
	}
}
