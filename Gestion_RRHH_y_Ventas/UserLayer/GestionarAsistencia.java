package UserLayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import LogicLayer.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionarAsistencia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnModif;
	private JButton btnActualizar;
	private JTextField txtEntrada;
	private JTextField txtSalida;
	private JComboBox<String> comboPresente;
	private int idSeleccionado = -1;
	private JButton btnNewButton_1;


	
	public GestionarAsistencia(Usuario usuario) {
		JOptionPane.showMessageDialog(null, "Para modificar la asistencia:\nSeleccionar empleado->"
				+ "Modificar asistencia->Editar los datos ->Actualizar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestión de asistencia:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(153, 10, 232, 29);
		contentPane.add(lblNewLabel);
		
		   model = new DefaultTableModel(new String[]{"N°", "Fecha","Empleado",
	        		"Hora Entrada","Hora Salida","Presente"}, 0);
	        
	        table = new JTable(model);
	        table.getColumnModel().getColumn(0).setPreferredWidth(10);
	        table.getColumnModel().getColumn(1).setPreferredWidth(30);  
	        table.getColumnModel().getColumn(2).setPreferredWidth(80);  
	        table.getColumnModel().getColumn(3).setPreferredWidth(40);
	        table.getColumnModel().getColumn(4).setPreferredWidth(40);
	        table.getColumnModel().getColumn(5).setPreferredWidth(20);
	        
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(10, 40, 499, 258);
	        contentPane.add(scrollPane);
	        cargarTabla();
	        btnModif = new JButton("Modificar Asistencia");
	        btnModif.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		modifDatosAntes();
	        		
	        	}
	        });
	        btnModif.setFont(new Font("Tahoma", Font.BOLD, 13));
	        btnModif.setBounds(105, 421, 183, 29);
	        contentPane.add(btnModif);
	        
	        btnActualizar = new JButton("Actualizar");
	        btnActualizar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		modificarAsistencia();
	        	}
	        });
	        btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
	        btnActualizar.setBounds(298, 421, 183, 29);
	        contentPane.add(btnActualizar);
	        
	        JLabel lblEntrada = new JLabel("Entrada:");
	        lblEntrada.setBounds(37, 317, 80, 25);
	        contentPane.add(lblEntrada);

	        txtEntrada = new JTextField();
	        txtEntrada.setBounds(117, 317, 120, 25);
	        contentPane.add(txtEntrada);

	        JLabel lblSalida = new JLabel("Salida:");
	        lblSalida.setBounds(257, 317, 80, 25);
	        contentPane.add(lblSalida);

	        txtSalida = new JTextField();
	        txtSalida.setBounds(317, 317, 120, 25);
	        contentPane.add(txtSalida);

	        JLabel lblPresente = new JLabel("Presente:");
	        lblPresente.setBounds(37, 357, 80, 25);
	        contentPane.add(lblPresente);

	        comboPresente = new JComboBox<>(new String[]{"1 - Presente", "0 - Ausente"});
	        comboPresente.setBounds(117, 357, 150, 25);
	        contentPane.add(comboPresente); 
	        
	        btnNewButton_1 = new JButton("<-Volver");
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		MenuAdministrador menuAdmin=new MenuAdministrador(usuario);
	        		menuAdmin.setVisible(true);
	        		dispose();
	        	}
	        });
	        btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
	        btnNewButton_1.setBounds(0, 426, 84, 20);
	        contentPane.add(btnNewButton_1);

	}
	public void cargarTabla() {

	    model.setRowCount(0);

	    DLL.ControllerAsistencia ca = new DLL.ControllerAsistencia();

	    try {

	        ResultSet rs = ca.getTodasAsistencias();

	        while(rs.next()) {

	            model.addRow(new Object[] {

	                rs.getInt("id_asistencia"),
	                rs.getString("fecha"),
	                rs.getString("nombre") + " " + rs.getString("apellido"),
	                rs.getString("hora_entrada"),
	                rs.getString("hora_salida"),
	                rs.getInt("presente") == 1 ? "SI" : "NO"
	            });
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	private void modifDatosAntes() {

	    int fila = table.getSelectedRow();

	    if (fila == -1) {
	    	JOptionPane.showMessageDialog(this,
	                "Seleccioná una asistencia primero");
	        return;
	    }

	    idSeleccionado = Integer.parseInt(model.getValueAt(fila, 0).toString());

	    txtEntrada.setText(model.getValueAt(fila, 3).toString());
	    txtSalida.setText(model.getValueAt(fila, 4).toString());

	    String presente = model.getValueAt(fila, 5).toString();
	    comboPresente.setSelectedIndex(presente.equals("SI") ? 0 : 1);

	}
	private void modificarAsistencia() {

	    if (idSeleccionado == -1) {
	    	JOptionPane.showMessageDialog(this, "Seleccione una asistencia");
	        return;
	    }

	    String entrada = txtEntrada.getText();
	    String salida = txtSalida.getText();

	    int presente = comboPresente.getSelectedIndex() == 0 ? 1 : 0;

	    DLL.ControllerAsistencia ca = new DLL.ControllerAsistencia();

	    ca.actualizarAsistencia(idSeleccionado, entrada, salida, presente);

	    cargarTabla();

	   JOptionPane.showMessageDialog(this, "Asistencia actualizada");
	}
}
