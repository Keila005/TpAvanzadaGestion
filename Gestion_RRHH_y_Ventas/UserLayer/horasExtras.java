package UserLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DLL.ControllerAsistencia;
import DLL.ControllerEmpleado;
import DLL.ControllerEquipo;
import DLL.ControllerOperativo;
import LogicLayer.Empleado;
import LogicLayer.Equipo;
import LogicLayer.Operativo;
import LogicLayer.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class horasExtras extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JLabel lblNewLabel;
	private JLabel lblAgregarHorasExtras;
	private JLabel lblNewLabel_1;
	private JComboBox<Empleado> comboBox;
	private JLabel lblNewLabel_2;
	private JTextField textField;
	private JButton btnNewButton;
	private JSpinner spinner;
	private JButton btnNewButton_1;
	
	public horasExtras(Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		 model = new DefaultTableModel(new String[]{"N°", "Nombre","Horas",
	        		"Valor * Hora","Motivo"}, 0);
		  table = new JTable(model);
	        table.getColumnModel().getColumn(0).setPreferredWidth(10);
	        table.getColumnModel().getColumn(1).setPreferredWidth(30);  
	        table.getColumnModel().getColumn(2).setPreferredWidth(30);  
	        table.getColumnModel().getColumn(3).setPreferredWidth(90);
	        table.getColumnModel().getColumn(4).setPreferredWidth(40);
	        contentPane.setLayout(null);
	        
	        
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(20, 37, 523, 155);
	        contentPane.add(scrollPane);
	        cargarTablaExtras();
	        
	        lblNewLabel = new JLabel("Horas extras :");
	        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
	        lblNewLabel.setBounds(30, 10, 157, 12);
	        contentPane.add(lblNewLabel);
	        
	        lblAgregarHorasExtras = new JLabel("Agregar horas extras :");
	        lblAgregarHorasExtras.setFont(new Font("Tahoma", Font.BOLD, 15));
	        lblAgregarHorasExtras.setBounds(20, 209, 201, 19);
	        contentPane.add(lblAgregarHorasExtras);
	        
	        lblNewLabel_1 = new JLabel("Empleado:");
	        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lblNewLabel_1.setBounds(20, 248, 85, 19);
	        contentPane.add(lblNewLabel_1);
	        
	         comboBox = new JComboBox<Empleado>();
	        comboBox.setBounds(20, 277, 120, 20);
	        contentPane.add(comboBox);
	        cargarMenuDesplegable();
	        
	        
	        JLabel lblNewLabel_1_1 = new JLabel("Cantidad de horas:");
	        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lblNewLabel_1_1.setBounds(207, 253, 128, 19);
	        contentPane.add(lblNewLabel_1_1);
	        
	        spinner = new JSpinner();
	        spinner.setBounds(217, 278, 118, 20);
	        contentPane.add(spinner);
	        
	        lblNewLabel_2 = new JLabel("Motivo");
	        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lblNewLabel_2.setBounds(20, 322, 85, 19);
	        contentPane.add(lblNewLabel_2);
	        
	        textField = new JTextField();
	        textField.setBounds(20, 351, 201, 19);
	        contentPane.add(textField);
	        textField.setColumns(10);
	        
	        btnNewButton = new JButton("Agregar");
	        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
	        btnNewButton.setBounds(216, 395, 137, 31);
	        contentPane.add(btnNewButton);
	        
	        btnNewButton_1 = new JButton("<-Volver");
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		MenuAdministrador menuAdmin= new MenuAdministrador(usuario);
	        		menuAdmin.setVisible(true);
	        		dispose();
	        	}
	        });
	        btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
	        btnNewButton_1.setBounds(10, 458, 95, 20);
	        contentPane.add(btnNewButton_1);
	        btnNewButton.addActionListener(e -> {
	            Empleado emp = (Empleado) comboBox.getSelectedItem();
	            if(emp == null) {
	                return;
	            }

	            int horas = (Integer) spinner.getValue();
	            String motivo = textField.getText();
	            ControllerAsistencia cont = new ControllerAsistencia();

	            cont.registrarHorasExtra(emp.getIdEmpleado(),horas,motivo);

	            cargarTablaExtras();

	            textField.setText("");
	            spinner.setValue(0);

	        });
	        

	}
	private void cargarMenuDesplegable() {
	
	ControllerEmpleado contEmpleado = new ControllerEmpleado();
    LinkedList<Empleado> empleados = contEmpleado.mostrarEmpleados();
		
	    comboBox.removeAllItems();
	    for (Empleado e : empleados) {
	        comboBox.addItem(e);
	    }
	}
	private void cargarTablaExtras() {

	    model.setRowCount(0);
	    ControllerAsistencia cont = new ControllerAsistencia();

	    try {

	        ResultSet rs = cont.getHorasExtras();

	        while(rs.next()) {

	            model.addRow(new Object[] {
	                rs.getInt("id_hora_extra"),
	                rs.getString("nombre") + " " + rs.getString("apellido"),
	                rs.getInt("horas"),
	                rs.getDouble("valor_hora"),
	                rs.getString("motivo")
	            });

	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
}
