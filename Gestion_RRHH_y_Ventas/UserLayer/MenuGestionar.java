package UserLayer;

import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DLL.ControllerEmpleado;
import LogicLayer.Administrador;
import LogicLayer.Empleado;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuGestionar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	 private DefaultTableModel model;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MenuGestionar frame = new MenuGestionar();
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
	public MenuGestionar(Administrador admin) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		 JLabel lblSeleccionado = new JLabel("Seleccionando a:");
	        lblSeleccionado.setBounds(10, 10, 760, 20);
	        contentPane.add(lblSeleccionado);
	        //si lo adapto, primero cambio las columnas -> depende de cada tabla 
	        
	        //defino el nombre qeu va a tener cada columna
	       model = new DefaultTableModel(new String[]{"ID", "Nombre","Apellido",
	        		"Email"}, 0);
	        
	        table = new JTable(model);
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(10, 40, 691, 200);
	        contentPane.add(scrollPane);
	        cargarTabla(); 
	        //botones
	        JButton btnAgregar = new JButton("Agregar");
	        btnAgregar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		admin.crearEmpleado();
	        		cargarTabla();
	        	}
	        });
	        btnAgregar.setBounds(10, 270, 150, 40);
	        contentPane.add(btnAgregar);

	        JButton btnEditar = new JButton("Editar");
	        btnEditar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		admin.modificarEmpleado();
	        		cargarTabla();
	        	}
	        });
	        btnEditar.setBounds(170, 270, 150, 40);
	        contentPane.add(btnEditar);

	        JButton btnEliminar = new JButton("Eliminar");
	        btnEliminar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		admin.eliminarEmpleado();
	        		cargarTabla();
	        	}
	        });
	        btnEliminar.setBounds(330, 270, 150, 40);
	        contentPane.add(btnEliminar);
	 
	        JLabel lblNewLabel = new JLabel("filtro");
	        lblNewLabel.setBounds(668, 270, 46, 14);
	        contentPane.add(lblNewLabel);
	        
	        JButton btnVolverAtrs = new JButton("Volver atrás");
	        btnVolverAtrs.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		MenuAdministrador menuAdmin= new MenuAdministrador(admin);
	        		menuAdmin.setVisible(true);
	        	}
	        });
	        btnVolverAtrs.setBounds(488, 270, 150, 40);
	        contentPane.add(btnVolverAtrs);
	        
	          

	}
	private void cargarTabla() {

	    model.setRowCount(0);

	    ControllerEmpleado contEmpleado = new ControllerEmpleado();
	    LinkedList<Empleado> empleados = contEmpleado.mostrarEmpleados();

	    for (Empleado e : empleados) {

	        model.addRow(new Object[]{
	            e.getIdEmpleado(),
	            e.getNombre(),
	            e.getApellido(),
	            e.getMail()
	        });
	    }
	}
}
