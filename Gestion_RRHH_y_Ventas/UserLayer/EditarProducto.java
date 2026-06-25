package UserLayer;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DLL.ControllerProducto;
import LogicLayer.Producto;
import LogicLayer.Usuario;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;

public class EditarProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private Producto producto;
	private Usuario usuario;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				EditarProducto frame = new EditarProducto();
	//				frame.setVisible(true);
	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//		}
	//	});
//	}

	/**
	 * Create the frame.
	 */
	public EditarProducto(Producto producto,
	        Usuario usuario) {
		this.producto = producto;
		this.usuario = usuario;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("EDITAR PRODUCTO :>");
	    lblTitulo.setBounds(27, 11, 196, 28);
	    lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
	    contentPane.add(lblTitulo);
	    
	    JButton btnSalir = new JButton("volver a menu");
	    btnSalir.addActionListener(e -> {

	        MenuStock menu = new MenuStock(usuario);

	        menu.setVisible(true);

	        dispose();
	    });
	    btnSalir.setForeground(Color.RED);
	    btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    btnSalir.setBounds(305, 1, 119, 27);
	    contentPane.add(btnSalir);
	    
	    txtNombre = new JTextField();
	    txtNombre.setText(producto.getNombre());
	    txtNombre.setBounds(220, 53, 174, 27);
	    contentPane.add(txtNombre);
	    txtNombre.setColumns(10);
	    
	    JLabel lblNewLabel = new JLabel("Nuevo Nombre del Producto:");
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblNewLabel.setBounds(10, 51, 213, 27);
	    contentPane.add(lblNewLabel);
	    
	    JLabel lblNewLabel_1 = new JLabel("Nuevo Precio del Producto:");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblNewLabel_1.setBounds(10, 103, 213, 27);
	    contentPane.add(lblNewLabel_1);
	    
	    txtPrecio = new JTextField();
	    txtPrecio.setText( String.valueOf(
                producto.getPrecio()) );
	    txtPrecio.setColumns(10);
	    txtPrecio.setBounds(220, 105, 174, 27);
	    contentPane.add(txtPrecio);
	    
	    JButton btnGuardar = new JButton("Guardar cambios");
	    btnGuardar.setForeground(new Color(102, 204, 0));
	    btnGuardar.addActionListener(e -> {

	        producto.setNombre(
	                txtNombre.getText()
	        );

	        producto.setPrecio(
	                Double.parseDouble(
	                        txtPrecio.getText()
	                )
	        );

	        ControllerProducto cp =
	                new ControllerProducto();

	        cp.modificarProducto(producto);

	        JOptionPane.showMessageDialog(
	                null,
	                "Producto modificado"
	        );
	        
	        MenuStock menu =
	                new MenuStock(usuario);

	        menu.setVisible(true);

	        dispose();
	    });
	    btnGuardar.setBounds(43, 175, 140, 48);
	    contentPane.add(btnGuardar);
	    
	    
	    JButton btnCancelarCambios = new JButton("cancelar cambios");
	    btnCancelarCambios.setForeground(new Color(204, 0, 0));
	    btnCancelarCambios.addActionListener(e -> {
	    	MenuStock menu =
	                new MenuStock(usuario);

	        menu.setVisible(true);
	        dispose();
	    });
	    btnCancelarCambios.setBounds(227, 175, 140, 48);
	    contentPane.add(btnCancelarCambios);
	    
	    
	    
		

	}//fin de editar producto
}


