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
import LogicLayer.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;

public class MenuStock extends JFrame {

	private static final long serialVersionUID = 1L;
	private Usuario usuario;
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
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
				//try {
					//MenuStock frame = new MenuStock();
					//frame.setVisible(true);
			//	} catch (Exception e) {
				//	e.printStackTrace();
		//		}
			//}
	//	});
//	}

	/**
	 * Create the frame.
	 */
	public MenuStock(Usuario usuario) {
		this.usuario = usuario;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
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
	    	        464,
	    	        119
	    	);

	    	contentPane.add(scrollPane);
	    	
	    	JButton btnSalir = new JButton("volver a menu");
	    	btnSalir.addActionListener(e -> {

	    	    MenuVendedor menu =
	    	            new MenuVendedor(usuario);

	    	    menu.setVisible(true);

	    	    dispose();
	    	});
	    	
	    	btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    	btnSalir.setForeground(Color.RED);
	    	btnSalir.setBounds(355, 2, 119, 27);
	    	contentPane.add(btnSalir);
	    	
	    	
	    	JButton btnActualizar =
	    	        new JButton("Editar producto");

	    	btnActualizar.addActionListener(e -> {

	    	    int fila = table.getSelectedRow();

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
	    	            controllerProducto.buscarProductoPorId(id);

	    	    if(producto != null) {

	    	        EditarProducto editar =
	    	                new EditarProducto(
	    	                        producto,
	    	                        usuario
	    	                );

	    	        editar.setVisible(true);

	    	        dispose();
	    	    }
	    	});

	    	btnActualizar.setBounds(
	    	        26,
	    	        158,
	    	        135,
	    	        35
	    	);

	    	contentPane.add(btnActualizar);
	    	
	    	
	    	JButton btnAgregarProducto =
	    	        new JButton("Agregar Producto");

	    	btnAgregarProducto.addActionListener(e -> {

	    	    AgregarProducto agregar =
	    	            new AgregarProducto(usuario);

	    	    agregar.setVisible(true);

	    	    dispose();
	    	});

	    	btnAgregarProducto.setBounds(
	    	        325,
	    	        158,
	    	        135,
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
	    	            controllerProducto.buscarProductoPorId(
	    	                    idProducto
	    	            );

	    	    if(producto != null) {

	    	        AgregarStock agregar =
	    	                new AgregarStock(
	    	                        producto,
	    	                        usuario
	    	                );

	    	        agregar.setVisible(true);

	    	        dispose();
	    	    }
	    	    
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
	    	            controllerProducto.buscarProductoPorId(id);

	    	    if(producto != null) {

	    	    	int opcion = JOptionPane.showConfirmDialog(
	    	    	        null,
	    	    	        "¿Está seguro que desea eliminar el producto?",
	    	    	        "Confirmar eliminación",
	    	    	        JOptionPane.YES_NO_OPTION
	    	    	);

	    	    	if(opcion == JOptionPane.YES_OPTION) {

	    	    	    controllerProducto.eliminarProducto(producto);

	    	    	    cargarTabla();
	    	    	}
	    	    }
	    	});

	    	btnEliminar.setBounds(
	    	        180,
	    	        158,
	    	        130,
	    	        35
	    	);

	    	contentPane.add(btnEliminar);
	    	
	    	
	    	cargarTabla();
	    
	    
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
