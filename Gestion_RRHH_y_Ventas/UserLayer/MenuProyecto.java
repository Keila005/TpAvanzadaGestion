package UserLayer;

import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import DLL.ControllerEquipo;
import DLL.ControllerOperativo;
import DLL.ControllerProyecto;
import LogicLayer.Equipo;
import LogicLayer.Operativo;
import LogicLayer.Proyecto;
import LogicLayer.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuProyecto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JLabel lblCrearProyecto;
	private JTextField iptName;
	private JTextField textField;
	private JComboBox<String> comboLider;
	private JComboBox<String> comboEquipo;
	private JLabel lblAsignacinDeLder;
	private JLabel lblAsignacinDeEquipo;
	private static LinkedList<Operativo> lideres;
	private static LinkedList<Equipo> equipos ;
	private static ControllerProyecto proyectoController= new ControllerProyecto() ;
	private JButton btnCrear;
	private JDateChooser dateInicio;
	private JDateChooser dateFin;
	private JLabel lblFechaDeInicio;
	private JLabel lblFechaDeFinalizacin;
	private JButton btnNewButton;
	

	/**
	 * Create the frame.
	 */
	public MenuProyecto(Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Proyectos creados: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(32, 10, 147, 30);
		contentPane.add(lblNewLabel);
		
		  model = new DefaultTableModel(new String[]{"N°", "Nombre","Descripción",
  		"Inicio:", "Finalización:","Líder","Equipo"}, 0);
  
   table = new JTable(model);
   table.getColumnModel().getColumn(0).setPreferredWidth(20);  
   table.getColumnModel().getColumn(1).setPreferredWidth(100);  
   table.getColumnModel().getColumn(2).setPreferredWidth(250);   
   table.getColumnModel().getColumn(3).setPreferredWidth(100);
   table.getColumnModel().getColumn(4).setPreferredWidth(100);
   table.getColumnModel().getColumn(5).setPreferredWidth(90);
   table.getColumnModel().getColumn(6).setPreferredWidth(90);
  JScrollPane scrollPane = new JScrollPane(table);
  scrollPane.setBounds(10, 59, 607, 123);
  contentPane.add(scrollPane);
  
  lblCrearProyecto = new JLabel("Crear Proyecto:");
  lblCrearProyecto.setFont(new Font("Tahoma", Font.BOLD, 14));
  lblCrearProyecto.setBounds(190, 201, 147, 30);
  contentPane.add(lblCrearProyecto);
  
  JLabel lblName = new JLabel("Nombre del proyecto:");
  lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
  lblName.setBounds(22, 242, 147, 17);
  contentPane.add(lblName);
  
  iptName = new JTextField();
  iptName.setBounds(22, 269, 147, 21);
  contentPane.add(iptName);
  iptName.setColumns(10);
  
  JLabel lblDescripcin = new JLabel("Descripción:");
  lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 14));
  lblDescripcin.setBounds(22, 300, 147, 17);
  contentPane.add(lblDescripcin);
  
  textField = new JTextField();
  textField.setColumns(10);
  textField.setBounds(22, 324, 230, 48);
  contentPane.add(textField);
	//LIDER
	comboLider = new JComboBox<>();
	comboLider.setBounds(327, 268, 127, 23);
	contentPane.add(comboLider);
	
	//EQUIPO
	comboEquipo = new JComboBox<>();
	comboEquipo.setBounds(327, 340, 127, 25);
	contentPane.add(comboEquipo);
	cargarMenuDesplegable();
	cargarProyectos();
	
	
	lblAsignacinDeLder = new JLabel("Asignación de líder:");
	lblAsignacinDeLder.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblAsignacinDeLder.setBounds(327, 241, 147, 17);
	contentPane.add(lblAsignacinDeLder);
	lblAsignacinDeEquipo = new JLabel("Asignación de equipo:");
	lblAsignacinDeEquipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblAsignacinDeEquipo.setBounds(327, 304, 147, 17);
	contentPane.add(lblAsignacinDeEquipo);
	btnCrear = new JButton("Crear");
	btnCrear.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		crearProyecto();
		cargarProyectos();
		}
	});
	btnCrear.setFont(new Font("Tahoma", Font.BOLD, 17));
	btnCrear.setBounds(231, 478, 119, 30);
	contentPane.add(btnCrear);
	dateInicio = new JDateChooser();
	dateInicio.setBounds(22, 409, 150, 25);
	contentPane.add(dateInicio);
	
	dateFin = new JDateChooser();
	dateFin.setBounds(327, 409, 150, 25);
	contentPane.add(dateFin);
	
	lblFechaDeInicio = new JLabel("Fecha de inicio:");
	lblFechaDeInicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblFechaDeInicio.setBounds(22, 382, 147, 17);
	contentPane.add(lblFechaDeInicio);
	
	lblFechaDeFinalizacin = new JLabel("Fecha de finalización:");
	lblFechaDeFinalizacin.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblFechaDeFinalizacin.setBounds(327, 382, 147, 17);
	contentPane.add(lblFechaDeFinalizacin);
	
	dateInicio.setMinSelectableDate(new Date());
	
	btnNewButton = new JButton("<-Volver");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			MenuAdministrador menuAdmin=new MenuAdministrador(usuario);
			menuAdmin.setVisible(true);
			dispose();
		}
	});
	btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 13));
	btnNewButton.setBounds(10, 519, 84, 20);
	contentPane.add(btnNewButton);
	
	dateInicio.addPropertyChangeListener("date", e -> {
	    Date inicio = dateInicio.getDate();
	    if (inicio != null) {
	        dateFin.setMinSelectableDate(inicio);
	    }
	});

	}
	
	private void cargarMenuDesplegable() {
		
		ControllerOperativo operativoController=new ControllerOperativo();
	     lideres = operativoController.obtenerLideres();

	    comboLider.removeAllItems();
	    for (Operativo op : lideres) {
	        comboLider.addItem(op.getNombre() + " " + op.getApellido());
	    }

	    ControllerEquipo equipoController = new ControllerEquipo();
	    equipos = equipoController.mostrarEquipo();

	    comboEquipo.removeAllItems();
	    for (Equipo eq : equipos) {
	        comboEquipo.addItem(eq.getNombre());
	    }
	}
	
	public void crearProyecto() {
		Date inicioDate = dateInicio.getDate();
		Date finDate = dateFin.getDate();
		
		java.sql.Date inicioSQL = new java.sql.Date(inicioDate.getTime());
		java.sql.Date finSQL = new java.sql.Date(finDate.getTime());

		if (inicioDate == null || finDate == null) {
		    JOptionPane.showMessageDialog(null, "Selecciona las fechas");
		    return;
		}

		
	    String nombre = iptName.getText();
	    String descripcion = textField.getText();

	    String seleccionadoLider = (String) comboLider.getSelectedItem();
	    String seleccionadoEquipo = (String) comboEquipo.getSelectedItem();

	    int idLider = -1;
	    for (Operativo op : lideres) {
	        String nombreCompleto = op.getNombre() + " " + op.getApellido();
	        if (nombreCompleto.equals(seleccionadoLider)) {
	            idLider = op.getIdOperativo();
	            break;
	        }
	    }

	    int idEquipo = -1;
	    for (Equipo eq : equipos) {
	        if (eq.getNombre().equals(seleccionadoEquipo)) {
	            idEquipo = eq.getId_equipo();
	            break;
	        }
	    }

	    proyectoController.crearProyecto(nombre,descripcion,inicioSQL,finSQL,idLider,idEquipo
	    );

	    JOptionPane.showMessageDialog(null, "Proyecto creado correctamente");
	}
	private void cargarProyectos() {
		 model.setRowCount(0);

		 LinkedList<Proyecto> proyectos =proyectoController.obtenerProyectosTabla();

	    for (Proyecto c : proyectos) {

	        model.addRow(new Object[]{
	          c.getIdProyecto(),
	          c.getNombre(),
	          c.getDescripcion(),
	          c.getFechaInicio(),
	          c.getFechaFin(),
	          c.getLider(),
	          c.getEquipo()
	        });
	    }
	}
}
