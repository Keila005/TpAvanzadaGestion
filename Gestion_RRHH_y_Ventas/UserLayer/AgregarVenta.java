package UserLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DLL.ControllerProducto;
import DLL.ControllerStock;
import DLL.ControllerVenta;
import LogicLayer.Producto;
import LogicLayer.Usuario;
import LogicLayer.Venta;
import LogicLayer.detalle_venta;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;

public class AgregarVenta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCantida;
	private Venta venta;
	private Usuario usuario;
	private JTable tablaProductos;
	private JTable tablaDetalle;

	private DefaultTableModel modeloProductos;
	private DefaultTableModel modeloDetalle;
	
	private JLabel lblTotal;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				AgregarVenta frame = new AgregarVenta();
	//				frame.setVisible(true);
	//			} catch (Exception e) {
		//			e.printStackTrace();
		//		}
	//		}
	//	});
//	}

	/**
	 * Create the frame.
	 */
	public AgregarVenta( Usuario usuario) {
		this.venta = new Venta();
		this.usuario = usuario;
		
		venta.setIdVendedor(
		        ((LogicLayer.Vendedor) usuario).getIdEmpleado()
		);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		modeloProductos = new DefaultTableModel(
		    	    new String[] {
		    	        "ID",
		    	        "Nombre",
		    	        "Precio",
		    	        "Stock"
		    	    },
		    	    0
		    	);
		
		tablaProductos = new JTable(modeloProductos);
		
		JScrollPane scrollPane = new JScrollPane(tablaProductos);
		scrollPane.setBounds(28, 76, 509, 183);
		contentPane.add(scrollPane);
		
		JLabel lblTitulo = new JLabel("AGREGAR NUEVA VENTA :>");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setBounds(28, 11, 355, 29);
		contentPane.add(lblTitulo);
		
		JButton btnCancelarVenta = new JButton("cancelar venta");
		btnCancelarVenta.addActionListener(e -> {

		    MenuStock menu = new MenuStock(usuario);

		    menu.setVisible(true);

		    dispose();
		});
		btnCancelarVenta.setForeground(Color.RED);
		btnCancelarVenta.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancelarVenta.setBounds(588, 11, 186, 34);
		contentPane.add(btnCancelarVenta);
		
		JLabel lblIndicador = new JLabel("Seleccione Producto");
		lblIndicador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIndicador.setBounds(28, 51, 167, 14);
		contentPane.add(lblIndicador);
		
		JLabel lblNewLabel = new JLabel("Ingrese Cantidad:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(38, 270, 145, 26);
		contentPane.add(lblNewLabel);

		textCantida = new JTextField();
		textCantida.setBounds(193, 270, 106, 26);
		contentPane.add(textCantida);
		textCantida.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar a la Venta");
		btnAgregar.addActionListener(e -> {

		    int fila = tablaProductos.getSelectedRow();

		    if(fila == -1) {
		        JOptionPane.showMessageDialog(null,
		                "Seleccione un producto");
		        return;
		    }

		    try {

		        int cantidad =
		                Integer.parseInt(
		                        textCantida.getText()
		                );

		        if(cantidad <= 0) {
		            JOptionPane.showMessageDialog(
		                    null,
		                    "Ingrese una cantidad válida");
		            return;
		        }

		        int idProducto =
		                (int) modeloProductos.getValueAt(fila, 0);

		        ControllerProducto cp =
		                new ControllerProducto();

		        Producto producto =
		                cp.buscarProductoPorId(idProducto);

		        ControllerStock cs =
		                new ControllerStock();

		        if(!cs.hayStock(idProducto, cantidad)) {
		            JOptionPane.showMessageDialog(
		                    null,
		                    "No hay stock suficiente");
		            return;
		        }

		        detalle_venta detalle =
		                new detalle_venta(
		                        producto,
		                        cantidad
		                );

		        venta.agregarDetalle(detalle);
		        
		        int stockActual =
		                (int) modeloProductos.getValueAt(
		                        fila,
		                        3
		                );

		        modeloProductos.setValueAt(
		                stockActual - cantidad,
		                fila,
		                3
		        );

		        modeloDetalle.addRow(new Object[] {

		                producto.getNombre(),
		                cantidad,
		                producto.getPrecio(),
		                detalle.getSubtotal()

		        });

		        actualizarTotal();

		        
		        textCantida.setText("");
		        
		        tablaProductos.clearSelection();

		    } catch(NumberFormatException ex) {

		        JOptionPane.showMessageDialog(
		                null,
		                "Ingrese un número válido");
		    }
		});
		btnAgregar.setForeground(new Color(102, 204, 0));
		btnAgregar.setBounds(392, 266, 145, 38);
		contentPane.add(btnAgregar);
		
		modeloDetalle = new DefaultTableModel(
	    	    new String[] {
	    	        "Producto",
	    	        "Cantidad",
	    	        "Precio Unitario",
	    	        "SubTotal"
	    	    },
	    	    0
	    	);
		tablaDetalle = new JTable(modeloDetalle);
		
		JScrollPane scrollPane_1 = new JScrollPane(tablaDetalle);
		scrollPane_1.setBounds(28, 364, 729, 183);
		contentPane.add(scrollPane_1);
		
		
		JLabel lblTextoDetalle = new JLabel("Detalle de Venta:");
		lblTextoDetalle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTextoDetalle.setBounds(31, 332, 198, 21);
		contentPane.add(lblTextoDetalle);
		
		lblTotal = new JLabel("Total: $0");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblTotal.setBounds(28, 558, 201, 34);
		contentPane.add(lblTotal);
		
		JButton btnNewButton = new JButton("Finalizar Compra");
		btnNewButton.addActionListener(e -> {

		    if(venta.getDetalles().isEmpty()) {

		        JOptionPane.showMessageDialog(
		                null,
		                "No hay productos en la venta."
		        );

		        return;
		    }

		    ControllerVenta cv =
		            new ControllerVenta();

		    cv.generarVenta(venta);

		    JOptionPane.showMessageDialog(
		            null,
		            "Venta registrada correctamente."
		    );
		    
		    MenuVendedor menu =
		            new MenuVendedor(usuario);

		    menu.setVisible(true);

		    dispose();
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(102, 204, 0));
		btnNewButton.setBounds(134, 609, 186, 57);
		contentPane.add(btnNewButton);
		
		JButton btnCancelarCompra = new JButton("Cancelar Compra");
		btnCancelarCompra.addActionListener(e -> {

		    MenuVendedor menu = new MenuVendedor(usuario);

		    menu.setVisible(true);

		    dispose();
		});
		btnCancelarCompra.setForeground(new Color(255, 0, 0));
		btnCancelarCompra.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancelarCompra.setBounds(416, 609, 186, 57);
		contentPane.add(btnCancelarCompra);
		
		cargarTablaProductos();

	}// fin de agregar venta 
	
	private void cargarTablaProductos() {

	    modeloProductos.setRowCount(0);

	    ControllerProducto cp = new ControllerProducto();
	    ControllerStock cs = new ControllerStock();

	    for(Producto p : cp.mostrarProductos()) {

	        modeloProductos.addRow(new Object[] {

	            p.getIdproducto(),

	            p.getNombre(),

	            p.getPrecio(),

	            cs.obtenerStockActual(
	                    p.getIdproducto()
	            )

	        });

	    }

	}
	
	
	private void actualizarTotal() {

	    lblTotal.setText(
	            "Total: $" + venta.calcularTotal()
	    );
	}
}




