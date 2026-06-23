package LogicLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DLL.ControllerVenta;
import UserLayer.MenuAdministrador;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.LinkedList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuVentas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JLabel lblHistorialDeProductos;
	private JTable tableDetalles;
	private DefaultTableModel modelDetalles;
	private JButton btnMasVendido;
	private JButton btnMenosVendido;
	LinkedList<Producto> productosLista = new LinkedList<>();
	LinkedList<Object[]> detallesOriginales = new LinkedList<>();
	private JButton btnTodosProductos;
	private JButton btnNewButton;

	
	public MenuVentas(Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Historial de ventas:");
		lblNewLabel.setBounds(197, 10, 163, 21);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(lblNewLabel);
		
		 model = new DefaultTableModel(new String[]{"N°Venta","Fecha","Monto total","Vendedor"}, 0);
		  table = new JTable(model);
	        table.getColumnModel().getColumn(0).setPreferredWidth(10);
	        table.getColumnModel().getColumn(1).setPreferredWidth(50);  
	        table.getColumnModel().getColumn(2).setPreferredWidth(30);  
	        table.getColumnModel().getColumn(3).setPreferredWidth(20);
	        contentPane.setLayout(null);
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(20, 50, 550, 121);
	        contentPane.add(scrollPane);
	        cargarTablaVentas();
	        
	        lblHistorialDeProductos = new JLabel("Historial de productos:");
	        lblHistorialDeProductos.setFont(new Font("Tahoma", Font.BOLD, 17));
	        lblHistorialDeProductos.setBounds(180, 197, 215, 21);
	        contentPane.add(lblHistorialDeProductos);
	        
	        modelDetalles = new DefaultTableModel(new String[]{"ID Detalle","ID Venta","Producto","Cantidad","Subtotal"}, 0);
	        	tableDetalles = new JTable(modelDetalles);
		        tableDetalles.getColumnModel().getColumn(0).setPreferredWidth(10);
		        tableDetalles.getColumnModel().getColumn(1).setPreferredWidth(50);  
		        tableDetalles.getColumnModel().getColumn(2).setPreferredWidth(30);  
		        tableDetalles.getColumnModel().getColumn(3).setPreferredWidth(20);
		        contentPane.setLayout(null);
		        JScrollPane scrollPaneDetalles = new JScrollPane(tableDetalles);
		        scrollPaneDetalles.setBounds(20, 228, 550, 115);
		        contentPane.add(scrollPaneDetalles);
		        
		        btnMasVendido = new JButton("Más vendido");
		        btnMasVendido.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        	cargarMasVendidos();
		        	}
		        });
		        btnMasVendido.setFont(new Font("Tahoma", Font.BOLD, 15));
		        btnMasVendido.setBounds(210, 377, 163, 32);
		        contentPane.add(btnMasVendido);
		        
		        btnMenosVendido = new JButton("Menos vendido");
		        btnMenosVendido.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		cargarMenosVendidos();
		        	}
		        });
		        btnMenosVendido.setFont(new Font("Tahoma", Font.BOLD, 15));
		        btnMenosVendido.setBounds(387, 377, 163, 32);
		        contentPane.add(btnMenosVendido);
		        
		        btnTodosProductos = new JButton("Todos productos");
		        btnTodosProductos.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		cargarTablaDetalles();
		        	}
		        });
		        btnTodosProductos.setFont(new Font("Tahoma", Font.BOLD, 15));
		        btnTodosProductos.setBounds(37, 377, 163, 32);
		        contentPane.add(btnTodosProductos);
		        
		        btnNewButton = new JButton("<-Volver");
		        btnNewButton.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		MenuAdministrador menuAdmin= new MenuAdministrador(usuario);
		        		menuAdmin.setVisible(true);
		        		dispose();
		        
		        	}
		        });
		        btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 14));
		        btnNewButton.setBounds(20, 435, 113, 20);
		        contentPane.add(btnNewButton);
		        cargarTablaDetalles();
	}
	private void cargarTablaVentas() {
		ControllerVenta controlador= new ControllerVenta();
		LinkedList<Venta> ventas = controlador.mostrarVentas();

		for(Venta v : ventas) {

		    model.addRow(new Object[] {
		        v.getIdVenta(),
		        v.getFecha(),
		        v.getTotal(),
		        v.getNombreVendedor()
		    });
		}
	}
	private void cargarTablaDetalles() {

	    ControllerVenta controlador = new ControllerVenta();

	    try {
	        ResultSet rs = controlador.mostrarDetalleVentas();

	        modelDetalles.setRowCount(0);
	        detallesOriginales.clear();

	        while (rs.next()) {

	            Object[] fila = new Object[]{
	                rs.getInt("id_detalle"),
	                rs.getInt("id_venta"),
	                rs.getString("producto"),
	                rs.getInt("cantidad"),
	                rs.getDouble("subtotal")
	            };

	            detallesOriginales.add(fila);
	            modelDetalles.addRow(fila);
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	private void cargarMasVendidos() {

	    modelDetalles.setRowCount(0);

	    for (Object[] fila : detallesOriginales) {

	        int cantidad = (int) fila[3];

	        if (cantidad >= 3) {
	            modelDetalles.addRow(fila);
	        }
	    }
	}
	//MENOS VENDIDOS O SEA MENOR A 3
	private void cargarMenosVendidos() {

	    modelDetalles.setRowCount(0);

	    for (Object[] fila : detallesOriginales) {

	        int cantidad = (int) fila[3];

	        if (cantidad < 3) {
	            modelDetalles.addRow(fila);
	        }
	    }
	}
	

}
