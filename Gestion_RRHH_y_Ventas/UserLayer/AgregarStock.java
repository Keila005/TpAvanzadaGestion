package UserLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DLL.ControllerStock;
import LogicLayer.Producto;
import LogicLayer.Stock;
import LogicLayer.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.time.LocalDate;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;

public class AgregarStock extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Producto producto;
	private Usuario usuario;
	private JTextField textCantidad;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				AgregarStock frame = new AgregarStock();
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
	public AgregarStock(Producto producto,
	        Usuario usuario) {
		this.producto = producto;
		this.usuario = usuario;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAgregarStock = new JLabel("AGREGAR STOCK :>");
		lblAgregarStock.setBounds(26, 11, 204, 20);
		lblAgregarStock.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblAgregarStock);
		
		JButton btnSalir = new JButton("volver a menu");
		btnSalir.addActionListener(e -> {

		    MenuStock menu = new MenuStock(usuario);

		    menu.setVisible(true);

		    dispose();
		});
		btnSalir.setForeground(Color.RED);
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalir.setBounds(294, 8, 109, 23);
		contentPane.add(btnSalir);
		
		JLabel lblNombrePS = new JLabel(
			    "Agregar stock a: " + producto.getNombre()
			);
		lblNombrePS.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNombrePS.setBounds(72, 56, 271, 21);
		contentPane.add(lblNombrePS);
		
		JLabel lblCantidadAAgregar = new JLabel("Cantidad a Agregar:");
		lblCantidadAAgregar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCantidadAAgregar.setBounds(39, 106, 213, 27);
		contentPane.add(lblCantidadAAgregar);
		
		textCantidad = new JTextField();
		textCantidad.setColumns(10);
		textCantidad.setBounds(210, 108, 174, 27);
		contentPane.add(textCantidad);
		
		JButton btnAgregarStock = new JButton("Agregar Stock");
		btnAgregarStock.addActionListener(e -> {

		    try {

		        int cantidad =
		                Integer.parseInt(
		                        textCantidad.getText()
		                );

		        Stock stock =
		                new Stock(
		                        producto,
		                        cantidad,
		                        LocalDate.now(),
		                        "INGRESO"
		                );

		        ControllerStock controller =
		                new ControllerStock();

		        controller.registrarMovimiento(stock);

		        JOptionPane.showMessageDialog(
		                null,
		                "Stock agregado correctamente"
		        );

		        MenuStock menu =
		                new MenuStock(usuario);

		        menu.setVisible(true);

		        dispose();

		    } catch(NumberFormatException ex) {

		        JOptionPane.showMessageDialog(
		                null,
		                "Ingrese una cantidad válida"
		        );
		    }
		});
		btnAgregarStock.setForeground(new Color(0, 204, 0));
		btnAgregarStock.setBounds(57, 168, 140, 48);
		contentPane.add(btnAgregarStock);
		
		JButton btnCancelar = new JButton("cancelar");
		btnCancelar.addActionListener(e -> {

		    MenuStock menu = new MenuStock(usuario);

		    menu.setVisible(true);

		    dispose();
		});
		btnCancelar.setForeground(new Color(204, 0, 0));
		btnCancelar.setBounds(234, 168, 140, 48);
		contentPane.add(btnCancelar);

	}

}
