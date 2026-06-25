package UserLayer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DLL.ControllerProducto;
import LogicLayer.Producto;
import LogicLayer.Usuario;
import javax.swing.JTextField;



public class AgregarProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Usuario usuario;
	private JTextField textNombre;
	private JTextField textPrecio;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	///				AgregarProducto frame = new AgregarProducto();
	//				frame.setVisible(true);
	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//		}
	//	});
	//}

	/**
	 * Create the frame.
	 */
	public AgregarProducto(
	        Usuario usuario) {
		this.usuario = usuario;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("AGREGAR PRODUCTO :>");
	    lblTitulo.setBounds(21, 10, 213, 20);
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
	    btnSalir.setBounds(304, 10, 109, 23);
	    contentPane.add(btnSalir);
	    
	    
	    JLabel lblNompreP = new JLabel("Nombre del Producto:");
	    lblNompreP.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblNompreP.setBounds(21, 63, 213, 27);
	    contentPane.add(lblNompreP);
	    
	    
	    
	    JLabel lblPrecioP = new JLabel("Precio del Producto:");
	    lblPrecioP.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblPrecioP.setBounds(21, 111, 213, 27);
	    contentPane.add(lblPrecioP);
	    
	    textNombre = new JTextField();
	    textNombre.setText((String) null);
	    textNombre.setColumns(10);
	    textNombre.setBounds(204, 65, 174, 27);
	    contentPane.add(textNombre);
	    
	    textPrecio = new JTextField();
	    textPrecio.setColumns(10);
	    textPrecio.setBounds(204, 116, 174, 27);
	    contentPane.add(textPrecio);
	    
	    JButton btnGuardarProducto = new JButton("Guardar Producto");
	    btnGuardarProducto.addActionListener(e -> {

	        try {

	            String nombre =
	                    textNombre.getText();
	            
	            if(textNombre.getText().trim().isEmpty()) {

	                JOptionPane.showMessageDialog(
	                        null,
	                        "Ingrese un nombre"
	                );

	                return;
	            }

	            double precio =
	                    Double.parseDouble(
	                            textPrecio.getText()
	                    );

	            Producto producto =
	                    new Producto(
	                            0,
	                            nombre,
	                            precio
	                    );

	            ControllerProducto cp =
	                    new ControllerProducto();

	            cp.agregarProducto(producto);

	            JOptionPane.showMessageDialog(
	                    null,
	                    "Producto agregado correctamente"
	            );

	            MenuStock menu =
	                    new MenuStock(usuario);

	            menu.setVisible(true);

	            dispose();

	        } catch(NumberFormatException ex) {

	            JOptionPane.showMessageDialog(
	                    null,
	                    "Ingrese un precio válido"
	            );
	        }
	    });
	    btnGuardarProducto.setForeground(new Color(0, 204, 0));
	    btnGuardarProducto.setBounds(49, 176, 140, 48);
	    contentPane.add(btnGuardarProducto);
	    
	    JButton btnCancelar = new JButton("cancelar");
	    btnCancelar.addActionListener(e -> {

	        MenuStock menu =
	                new MenuStock(usuario);

	        menu.setVisible(true);

	        dispose();
	    });
	    btnCancelar.setForeground(new Color(204, 0, 0));
	    btnCancelar.setBounds(220, 176, 140, 48);
	    contentPane.add(btnCancelar);

	}//fin de agregar producto

}


