package UserLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DLL.ControllerVenta;
import LogicLayer.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;

public class VerVenta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int idVenta;
	private JTable table;
	private DefaultTableModel modelo;
	private JLabel lblFecha;
	private JLabel lblVendedor;
	private JLabel lblTotal;
	private Usuario usuario;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				VerVenta frame = new VerVenta();
	//				frame.setVisible(true);
	//			} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
	/**
	 * Create the frame.
	 */
	public VerVenta(int idVenta, Usuario usuario) {
		this.idVenta = idVenta;
		this.usuario = usuario;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Venta N°" + idVenta);
		lblTitulo.setBounds(150, 0, 122, 20);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblTitulo);
		
		
		modelo = new DefaultTableModel(

		        new String[]{

		            "Producto",
		            "Cantidad",
		            "Subtotal"

		        },

		        0
		);

		table = new JTable(modelo);
		
		JScrollPane scroll =
		        new JScrollPane(table);

		scroll.setBounds(10,97,414,124);

		contentPane.add(scroll);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblFecha.setBounds(40, 34, 210, 20);
		contentPane.add(lblFecha);
		
		lblVendedor = new JLabel("Vendedor:");
		lblVendedor.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblVendedor.setBounds(40, 66, 210, 20);
		contentPane.add(lblVendedor);
		
		lblTotal = new JLabel("Total: $0");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblTotal.setBounds(130, 227, 174, 20);
		contentPane.add(lblTotal);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(e -> {

		    HistorialVentas historial =
		            new HistorialVentas(usuario);

		    historial.setVisible(true);

		    dispose();

		});
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnVolver.setBounds(150, 274, 133, 25);
		contentPane.add(btnVolver);

		
		
		cargarVenta();
	}// fin
	
	private void cargarVenta() {

	    ControllerVenta cv =
	            new ControllerVenta();

	    cv.cargarDetalleVenta(
	            idVenta,
	            modelo,
	            lblFecha,
	            lblVendedor,
	            lblTotal
	    );
	}
	
}
