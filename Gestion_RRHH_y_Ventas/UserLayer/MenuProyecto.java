package UserLayer;

import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

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
import java.awt.Color;

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
	private JPanel panel;
		private final Color VERDE = new Color(28, 137, 16);
		private final Color VERDE_OSCURO = new Color(20, 110, 12);
		private final Color FONDO = new Color(245, 245, 245);
		private final Color PANEL_VERDE = new Color(28, 137, 16);

		public MenuProyecto(Usuario usuario) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 730, 586);

			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			contentPane.setBackground(new Color(232, 243, 226));
			setContentPane(contentPane);

			JLabel lblNewLabel = new JLabel("Proyectos creados: ");
			lblNewLabel.setForeground(VERDE_OSCURO);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setBounds(32, 10, 147, 30);
			contentPane.add(lblNewLabel);

			model = new DefaultTableModel(new String[]{"N°", "Nombre","Descripción",
				"Inicio:", "Finalización:","Líder","Equipo"}, 0);

			table = new JTable(model);

			table.setRowHeight(22);
			table.setGridColor(VERDE);
			table.setSelectionBackground(VERDE);
			table.setSelectionForeground(Color.WHITE);

			JTableHeader header = table.getTableHeader();
			header.setBackground(VERDE);
			header.setForeground(Color.WHITE);
			header.setFont(new Font("Tahoma", Font.BOLD, 12));

			table.getColumnModel().getColumn(0).setPreferredWidth(20);
			table.getColumnModel().getColumn(1).setPreferredWidth(250);
			table.getColumnModel().getColumn(2).setPreferredWidth(250);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(4).setPreferredWidth(100);
			table.getColumnModel().getColumn(5).setPreferredWidth(100);
			table.getColumnModel().getColumn(6).setPreferredWidth(100);

			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(10, 50, 706, 162);
			contentPane.add(scrollPane);

			JLabel lblName = new JLabel("Nombre del proyecto:");
			lblName.setForeground(Color.WHITE);
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblName.setBounds(121, 244, 147, 17);
			contentPane.add(lblName);

			iptName = new JTextField();
			iptName.setBounds(121, 271, 147, 21);
			contentPane.add(iptName);

			JLabel lblDescripcin = new JLabel("Descripción:");
			lblDescripcin.setForeground(Color.WHITE);
			lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblDescripcin.setBounds(121, 302, 147, 17);
			contentPane.add(lblDescripcin);

			textField = new JTextField();
			textField.setBounds(121, 326, 230, 48);
			contentPane.add(textField);

			comboLider = new JComboBox<>();
			comboLider.setBounds(426, 270, 127, 23);
			contentPane.add(comboLider);

			comboEquipo = new JComboBox<>();
			comboEquipo.setBounds(426, 342, 127, 25);
			contentPane.add(comboEquipo);

			cargarMenuDesplegable();
			cargarProyectos();

			lblAsignacinDeLder = new JLabel("Asignación de líder:");
			lblAsignacinDeLder.setForeground(Color.WHITE);
			lblAsignacinDeLder.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAsignacinDeLder.setBounds(426, 243, 147, 17);
			contentPane.add(lblAsignacinDeLder);

			lblAsignacinDeEquipo = new JLabel("Asignación de equipo:");
			lblAsignacinDeEquipo.setForeground(Color.WHITE);
			lblAsignacinDeEquipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAsignacinDeEquipo.setBounds(426, 306, 147, 17);
			contentPane.add(lblAsignacinDeEquipo);

			btnCrear = new JButton("Crear");
			btnCrear.setBackground(new Color(89, 142, 89));
			btnCrear.setForeground(Color.WHITE);
			btnCrear.setFont(new Font("Tahoma", Font.BOLD, 17));
			btnCrear.addActionListener(e -> {
				crearProyecto();
				cargarProyectos();
			});
			btnCrear.setBounds(306, 476, 119, 30);
			contentPane.add(btnCrear);

			dateInicio = new JDateChooser();
			dateInicio.setBounds(121, 411, 150, 25);
			contentPane.add(dateInicio);

			dateFin = new JDateChooser();
			dateFin.setBounds(426, 411, 150, 25);
			contentPane.add(dateFin);

			lblFechaDeInicio = new JLabel("Fecha de inicio:");
			lblFechaDeInicio.setForeground(Color.WHITE);
			lblFechaDeInicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblFechaDeInicio.setBounds(121, 384, 147, 17);
			contentPane.add(lblFechaDeInicio);

			lblFechaDeFinalizacin = new JLabel("Fecha de finalización:");
			lblFechaDeFinalizacin.setForeground(Color.WHITE);
			lblFechaDeFinalizacin.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblFechaDeFinalizacin.setBounds(426, 382, 147, 17);
			contentPane.add(lblFechaDeFinalizacin);

			dateInicio.setMinSelectableDate(new Date());

			btnNewButton = new JButton("<-Volver");
			btnNewButton.setBackground(new Color(255, 0, 0));
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnNewButton.addActionListener(e -> {
				MenuAdministrador menuAdmin=new MenuAdministrador(usuario);
				menuAdmin.setVisible(true);
				dispose();
			});
			btnNewButton.setBounds(10, 519, 119, 20);
			contentPane.add(btnNewButton);

			panel = new JPanel();
			panel.setBackground(new Color(167, 228, 191));
			panel.setBounds(-15, 211, 751, 338);
			contentPane.add(panel);
			
						lblCrearProyecto = new JLabel("Crear Proyecto:");
						panel.add(lblCrearProyecto);
						lblCrearProyecto.setForeground(Color.WHITE);
						lblCrearProyecto.setFont(new Font("Tahoma", Font.BOLD, 14));

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
