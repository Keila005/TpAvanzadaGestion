package UserLayer;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DLL.ControllerProducto;
import DLL.ControllerStock;
import LogicLayer.Producto;
import LogicLayer.Stock;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;

public class MenuStock extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;

	private ControllerProducto controllerProducto =
	        new ControllerProducto();

	private ControllerStock controllerStock =
	        new ControllerStock();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuStock frame = new MenuStock();
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
	public MenuStock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	    contentPane.setLayout(null);
		
	    JLabel lblTitulo = new JLabel("MENU DE STOCK");
	    lblTitulo.setBounds(21, 0, 140, 29);
	    lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
	    contentPane.add(lblTitulo);
	
		
	    
	    model = new DefaultTableModel(
	    	    new String[] {
	    	        "ID",
	    	        "Nombre",
	    	        "Precio",
	    	        "Stock"
	    	    },
	    	    0
	    	);

	    	table = new JTable(model);

	    	JScrollPane scrollPane =
	    	        new JScrollPane(table);

	    	scrollPane.setBounds(
	    	        10,
	    	        28,
	    	        412,
	    	        119
	    	);

	    	contentPane.add(scrollPane);
	    	
	    	JButton btnSalir = new JButton("Cerrar Session");
	    	btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    	btnSalir.setForeground(Color.RED);
	    	btnSalir.setBounds(292, 0, 119, 27);
	    	contentPane.add(btnSalir);
	    	
	    	
	    	JButton btnActualizar =
	    	        new JButton("Editar producto");

	    	btnActualizar.addActionListener(e -> {

	    	    cargarTabla();
	    	});

	    	btnActualizar.setBounds(
	    	        20,
	    	        158,
	    	        120,
	    	        35
	    	);

	    	contentPane.add(btnActualizar);
	    	
	    	
	    	JButton btnAgregarProducto =
	    	        new JButton("Agregar Producto");

	    	btnAgregarProducto.addActionListener(e -> {

	    	    String nombre =
	    	            JOptionPane.showInputDialog(
	    	                    "Nombre"
	    	            );

	    	    if(nombre == null) {
	    	        return;
	    	    }

	    	    double precio =
	    	            Double.parseDouble(
	    	                JOptionPane.showInputDialog(
	    	                        "Precio"
	    	                )
	    	            );

	    	    Producto producto =
	    	            new Producto(
	    	                    0,
	    	                    nombre,
	    	                    precio
	    	            );

	    	    controllerProducto.agregarProducto(
	    	            producto
	    	    );

	    	    cargarTabla();
	    	});

	    	btnAgregarProducto.setBounds(
	    	        292,
	    	        158,
	    	        120,
	    	        35
	    	);

	    	contentPane.add(btnAgregarProducto);
	    	
	    	
	    	JButton btnAgregarStock =
	    	        new JButton("Agregar Stock");

	    	btnAgregarStock.addActionListener(e -> {

	    	    int fila =
	    	            table.getSelectedRow();

	    	    if(fila == -1) {

	    	        JOptionPane.showMessageDialog(
	    	                null,
	    	                "Seleccione un producto"
	    	        );

	    	        return;
	    	    }

	    	    int idProducto =
	    	            (int) model.getValueAt(
	    	                    fila,
	    	                    0
	    	            );

	    	    Producto producto =
	    	            controllerProducto.BuscarProducto();

	    	    int cantidad =
	    	            Integer.parseInt(
	    	                JOptionPane.showInputDialog(
	    	                        "Cantidad"
	    	                )
	    	            );

	    	    Stock stock =
	    	            new Stock(
	    	                    producto,
	    	                    cantidad,
	    	                    java.time.LocalDate.now(),
	    	                    "INGRESO"
	    	            );

	    	    controllerStock.registrarMovimiento(
	    	            stock
	    	    );

	    	    cargarTabla();
	    	});

	    	btnAgregarStock.setBounds(
	    	        272,
	    	        204,
	    	        150,
	    	        35
	    	);

	    	contentPane.add(btnAgregarStock);
	    	
	    	
	    	JButton btnEliminar =
	    	        new JButton("Eliminar producto");

	    	btnEliminar.addActionListener(e -> {

	    	    int fila =
	    	            table.getSelectedRow();

	    	    if(fila == -1) {

	    	        JOptionPane.showMessageDialog(
	    	                null,
	    	                "Seleccione un producto"
	    	        );

	    	        return;
	    	    }

	    	    int id =
	    	            (int) model.getValueAt(
	    	                    fila,
	    	                    0
	    	            );

	    	    Producto producto =
	    	            null;

	    	    for(Producto p :
	    	            controllerProducto.mostrarProductos()) {

	    	        if(p.getIdproducto() == id) {

	    	            producto = p;
	    	            break;
	    	        }
	    	    }

	    	    if(producto != null) {

	    	        controllerProducto.eliminarProducto(
	    	                producto
	    	        );

	    	        cargarTabla();
	    	    }
	    	});

	    	btnEliminar.setBounds(
	    	        162,
	    	        158,
	    	        120,
	    	        35
	    	);

	    	contentPane.add(btnEliminar);
	    	
	    	
	    	
	    
	    
	}//fin public menustock

	
	public void cargarTabla() {

	    model.setRowCount(0);

	    LinkedList<Producto> productos =
	            controllerProducto.mostrarProductos();

	    for(Producto p : productos) {

	        model.addRow(
	            new Object[] {

	                p.getIdproducto(),

	                p.getNombre(),

	                p.getPrecio(),

	                controllerStock.obtenerStockActual(
	                        p.getIdproducto()
	                )
	            }
	        );
	    }
	}
}
