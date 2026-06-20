package UserLayer;

import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DLL.ControllerEmpleado;
import DLL.ControllerUsuario;
import LogicLayer.Administrador;
import LogicLayer.Empleado;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class MenuGestionar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private Empleado empleadoSeleccionado; 
	private JTextField textField;
	
	public MenuGestionar(Administrador admin) {
		ControllerUsuario usuarioController = new ControllerUsuario();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		 JLabel lblSeleccionado = new JLabel();
	        lblSeleccionado.setBounds(10, 10, 760, 20);
	        contentPane.add(lblSeleccionado);
	        //si lo adapto, primero cambio las columnas -> depende de cada tabla 
	        
	        //defino el nombre qeu va a tener cada columna
	       model = new DefaultTableModel(new String[]{"ID", "Nombre","Apellido",
	        		"Email","Dni","Sueldo"}, 0);
	        
	        table = new JTable(model);
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(10, 40, 572, 202);
	        contentPane.add(scrollPane);
	        cargarTabla(); 
	        
	        // Acción al seleccionar fila
	        table.getSelectionModel().addListSelectionListener(e -> {
	            if (!e.getValueIsAdjusting()) {
	           
	                int row = table.getSelectedRow();
	                if (row != -1) {
	                	empleadoSeleccionado = new Empleado(
	                		    (String) model.getValueAt(row, 1),
	                		    (String) model.getValueAt(row, 2),
	                		    (String) model.getValueAt(row, 3), 
	                		    "",                               
	                		    (int) model.getValueAt(row, 0),    
	                		    (int) model.getValueAt(row, 4),    
	                		    (double) model.getValueAt(row, 5)  
	                		);
	                	 lblSeleccionado.setText(
	                		        "Seleccionado a: ID=" + empleadoSeleccionado.getIdEmpleado()
	                		        + ", Nombre=" + empleadoSeleccionado.getNombre()
	                		        + ", Apellido=" + empleadoSeleccionado.getApellido()
	                		        + ", Email=" + empleadoSeleccionado.getMail()
	                		    );
	                    
	                }
	            }
	        });
	        //botones
	        JButton btnAgregar = new JButton("Agregar +");
	        btnAgregar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		pantallaCrearEmpleado crearEmpleado= new pantallaCrearEmpleado();
	        		crearEmpleado.setVisible(true);
	        		cargarTabla();
	        	}
	        });
	        btnAgregar.setBounds(10, 272, 150, 40);
	        contentPane.add(btnAgregar);

	        JButton btnEditar = new JButton("Editar");
	        //seleccionnar fila y poder editar
	        btnEditar.addActionListener(e -> {
	        	cargarTabla();
	            if (empleadoSeleccionado != null) {
	             
	            	EditarUsuario selectEditar =new EditarUsuario(empleadoSeleccionado,admin);
	            	selectEditar.setVisible(true);
	            	dispose();
	            	
	            } else {
	                JOptionPane.showMessageDialog(null, "Seleccione un empleado",
							"Eliminar", JOptionPane.DEFAULT_OPTION,
							new ImageIcon(MenuGestionar.class.getResource("/img/nohay.png")));
	            }
	        });
	        btnEditar.setBounds(170, 272, 150, 40);
	        contentPane.add(btnEditar);

	        JButton btnEliminar = new JButton("Eliminar");
	        btnEliminar.setBounds(330, 272, 150, 40);
	        contentPane.add(btnEliminar);
	    
	        btnEliminar.addActionListener(e -> {
	            if (empleadoSeleccionado != null) {
	                int confirm = JOptionPane.showConfirmDialog(null, "¿Eliminar a " + empleadoSeleccionado.getNombre() + "?", 
	                		"Confirmar", JOptionPane.YES_NO_OPTION);
	                if (confirm == JOptionPane.YES_OPTION) {
	                  usuarioController.eliminarEmpleado(empleadoSeleccionado.getIdEmpleado());
	                  cargarTabla();
	                  JOptionPane.showMessageDialog(null, "Borrado correctamente :)",
								"Eliminar", JOptionPane.DEFAULT_OPTION,
								new ImageIcon(MenuGestionar.class.getResource("/img/correcto.png")));

	                }
	            } else {
	            	JOptionPane.showMessageDialog(null, "Seleccione un empleado",
							"Seleccion", JOptionPane.DEFAULT_OPTION,
							new ImageIcon(MenuGestionar.class.getResource("/img/nohay.png")));
	            }
	        });
	    
	 
	        JLabel lblNewLabel = new JLabel("Filtro:");
	        lblNewLabel.setBounds(32, 366, 46, 14);
	        contentPane.add(lblNewLabel);
	        
	        JButton btnVolverAtrs = new JButton("Volver atrás");
	        btnVolverAtrs.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		MenuAdministrador menuAdmin= new MenuAdministrador(admin);
	        		menuAdmin.setVisible(true);
	        		dispose();
	        	}
	        });
	        btnVolverAtrs.setBounds(488, 272, 150, 40);
	        contentPane.add(btnVolverAtrs);
	        
	        JLabel lblImg = new JLabel("");
	        lblImg.setBounds(606, 112, 122, 113);
	        contentPane.add(lblImg);
	        
	        textField = new JTextField();
	        textField.setBackground(new Color(192, 192, 192));
	        textField.setBounds(20, 389, 96, 18);
	        contentPane.add(textField);
	        textField.setColumns(10);
	        
	        JButton btnNewButton = new JButton("Buscar");
	        btnNewButton.setBackground(new Color(255, 128, 0));
	        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
	        btnNewButton.setBounds(126, 386, 75, 20);
	        contentPane.add(btnNewButton);
	        
	        JLabel lblNewLabel_1 = new JLabel("Perfil:");
	        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        lblNewLabel_1.setBounds(626, 74, 54, 20);
	        contentPane.add(lblNewLabel_1);
	        
	          

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
	            e.getMail(),
	            e.getDni(),
	            e.getSueldoBase()
	        });
	    }
	}
}
