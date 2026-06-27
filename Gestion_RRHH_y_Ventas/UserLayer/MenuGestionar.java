package UserLayer;

import java.util.LinkedList;
import java.util.stream.Collectors;

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
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.table.JTableHeader;

public class MenuGestionar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private Empleado empleadoSeleccionado; 
	private JTextField inpFiltro;
	private JLabel lblImg;
	private static ControllerEmpleado contEmpleado;

	// COLOREs
	private final Color VERDE_PRINCIPAL = new Color(28, 137, 16);
	private final Color VERDE_OSCURO = new Color(20, 110, 12);
	private final Color VERDE_CLARO = new Color(200, 255, 200);

	public MenuGestionar(Administrador admin) {
		ControllerUsuario usuarioController = new ControllerUsuario();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(245, 245, 245));
		setContentPane(contentPane);

		JLabel lblSeleccionado = new JLabel();
		lblSeleccionado.setBounds(10, 10, 760, 20);
		contentPane.add(lblSeleccionado);

		model = new DefaultTableModel(new String[]{"ID", "Nombre","Apellido",
			"Email","Dni","Sueldo"}, 0);

		table = new JTable(model);

	
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		table.setGridColor(VERDE_PRINCIPAL);
		table.setSelectionBackground(VERDE_PRINCIPAL);
		table.setSelectionForeground(Color.WHITE);
		table.setRowHeight(22);

		JTableHeader header = table.getTableHeader();
		header.setBackground(VERDE_PRINCIPAL);
		header.setForeground(Color.WHITE);
		header.setFont(new Font("Tahoma", Font.BOLD, 12));


		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);  
		table.getColumnModel().getColumn(2).setPreferredWidth(30);  
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setPreferredWidth(40);
		table.getColumnModel().getColumn(5).setPreferredWidth(40);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 40, 572, 202);
		contentPane.add(scrollPane);

		cargarTabla(); 

		table.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				int row = table.getSelectedRow();
				if (row != -1) {
					int id = (int) model.getValueAt(row, 0);

					for (Empleado emp : contEmpleado.mostrarEmpleados()) {
						if (emp.getIdEmpleado() == id) {
							empleadoSeleccionado = emp;
							mostrarImagen(emp.getPerfil());
							break;
						}
					}

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

		
		JButton btnAgregar = new JButton("Agregar +");
		btnAgregar.setBackground(VERDE_PRINCIPAL);
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 12));

		btnAgregar.addActionListener(e -> {
			pantallaCrearEmpleado crearEmpleado= new pantallaCrearEmpleado(MenuGestionar.this);
			crearEmpleado.setVisible(true);
			cargarTabla();
		});
		btnAgregar.setBounds(10, 272, 150, 40);
		contentPane.add(btnAgregar);

		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBackground(new Color(34, 160, 20));
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 12));

		btnEditar.addActionListener(e -> {
			cargarTabla();
			if (empleadoSeleccionado != null) {
				EditarUsuario selectEditar = new EditarUsuario(empleadoSeleccionado, admin);
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
		btnEliminar.setBackground(new Color(180, 30, 30));
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEliminar.setBounds(330, 272, 150, 40);
		contentPane.add(btnEliminar);

		btnEliminar.addActionListener(e -> {
			if (empleadoSeleccionado != null) {
				int confirm = JOptionPane.showConfirmDialog(null, 
					"¿Eliminar a " + empleadoSeleccionado.getNombre() + "?", 
					"Confirmar", JOptionPane.YES_NO_OPTION);

				if (confirm == JOptionPane.YES_OPTION) {
					usuarioController.eliminarEmpleado(empleadoSeleccionado.getIdEmpleado());
					cargarTabla();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Seleccione un empleado");
			}
		});

		JLabel lblNewLabel = new JLabel("Filtro:");
		lblNewLabel.setBounds(32, 366, 46, 14);
		contentPane.add(lblNewLabel);

		JButton btnVolverAtrs = new JButton("Volver atrás");
		btnVolverAtrs.setBackground(VERDE_OSCURO);
		btnVolverAtrs.setForeground(Color.WHITE);
		btnVolverAtrs.setFont(new Font("Tahoma", Font.BOLD, 12));

		btnVolverAtrs.addActionListener(e -> {
			MenuAdministrador menuAdmin= new MenuAdministrador(admin);
			menuAdmin.setVisible(true);
			dispose();
		});
		btnVolverAtrs.setBounds(488, 272, 150, 40);
		contentPane.add(btnVolverAtrs);

		lblImg = new JLabel("");
		lblImg.setBounds(592, 81, 158, 161);
		contentPane.add(lblImg);

		inpFiltro = new JTextField();
		inpFiltro.setBackground(new Color(230, 255, 230));
		inpFiltro.setBounds(20, 389, 96, 18);
		contentPane.add(inpFiltro);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(VERDE_PRINCIPAL);
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 13));

		btnBuscar.addActionListener(e -> {
			cargarTablaFiltradaStream(inpFiltro.getText());
		});
		btnBuscar.setBounds(126, 386, 96, 20);
		contentPane.add(btnBuscar);

		JLabel lblNewLabel_1 = new JLabel("Perfil:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(628, 40, 54, 20);
		contentPane.add(lblNewLabel_1);
		
		JPanel panelFondoTabla = new JPanel();
		panelFondoTabla.setBounds(0, 10, 770, 252);
		panelFondoTabla.setBackground(VERDE_CLARO);
		contentPane.add(panelFondoTabla);
	}


	public void cargarTabla() {
		model.setRowCount(0);
		contEmpleado = new ControllerEmpleado();
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

	private void cargarTablaFiltradaStream(String filtro) {
		LinkedList<Empleado> filtradasPorLetra = contEmpleado.mostrarEmpleados().stream()
			.filter(empleado ->
				(empleado.getNombre() != null &&
				 empleado.getNombre().toLowerCase().contains(filtro.toLowerCase()))
				||
				(empleado.getApellido() != null &&
				 empleado.getApellido().toLowerCase().contains(filtro.toLowerCase()))
				||
				(empleado.getMail() != null &&
				 empleado.getMail().toLowerCase().contains(filtro.toLowerCase())))
			.collect(Collectors.toCollection(LinkedList::new));

		model.setRowCount(0);

		for (Empleado e : filtradasPorLetra) {
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

	private void mostrarImagen(byte[] imagenBytes) {
		if (imagenBytes != null && imagenBytes.length > 0) {
			ImageIcon icon = new ImageIcon(imagenBytes);
			Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			lblImg.setIcon(new ImageIcon(img));
		} else {
			lblImg.setIcon(null);
			lblImg.setText("Sin imagen");
		}
	}
}