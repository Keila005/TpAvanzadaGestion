package UserLayer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DLL.ControllerVenta;
import LogicLayer.Usuario;
import LogicLayer.Venta;

public class HistorialVentas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Usuario usuario;
	private JTable tablaHistorial;
	private DefaultTableModel modeloHistorial;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				HistorialVentas frame = new HistorialVentas();
	//				frame.setVisible(true);
	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public HistorialVentas(Usuario usuario) {
		this.usuario = usuario;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblTitulo = new JLabel("HISTORIAL DE VENTAS :>");

		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(21,0,214,22);

		contentPane.add(lblTitulo);
		
		
		modeloHistorial = new DefaultTableModel(

			    new String[]{

			        "ID Venta",
			        "Fecha",
			        "Total"

			    },

			    0
			);
		
		tablaHistorial = new JTable(modeloHistorial);

		JScrollPane scroll = new JScrollPane(tablaHistorial);

		scroll.setBounds(10,25,414,149);

		contentPane.add(scroll);
		
		
		JButton btnSalir = new JButton("volver a menu");
		btnSalir.addActionListener(e -> {

		    MenuStock menu = new MenuStock(usuario);

		    menu.setVisible(true);

		    dispose();
		});
		btnSalir.setForeground(Color.RED);
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalir.setBounds(234, 188, 127, 44);
		contentPane.add(btnSalir);
		
		JButton btnVerVenta = new JButton("Ver Venta");
		btnVerVenta.addActionListener(e -> {

		    int fila = tablaHistorial.getSelectedRow();

		    if(fila == -1) {

		        JOptionPane.showMessageDialog(
		                null,
		                "Seleccione una venta."
		        );

		        return;
		    }

		    int idVenta =
		            (int) modeloHistorial.getValueAt(fila, 0);

		    VerVenta ventana =
		            new VerVenta(idVenta, usuario);

		    ventana.setVisible(true);

		    dispose();

		});
		btnVerVenta.setForeground(new Color(0, 0, 0));
		btnVerVenta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVerVenta.setBounds(67, 188, 127, 44);
		contentPane.add(btnVerVenta);
		
		cargarTabla();

	}// fin de historial

	public void cargarTabla() {

		modeloHistorial.setRowCount(0);

	    ControllerVenta cv =
	            new ControllerVenta();

	    int idEmpleado =
	            ((LogicLayer.Vendedor)usuario)
	            .getIdEmpleado();

	    for(Venta v : cv.mostrarVentas(idEmpleado)) {

	    	modeloHistorial.addRow(

	            new Object[]{

	                v.getIdVenta(),
	                v.getFecha(),
	                v.getTotal()

	            }

	        );

	    }

	}
	
}
