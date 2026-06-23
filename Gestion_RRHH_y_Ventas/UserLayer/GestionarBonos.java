package UserLayer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import DLL.ControllerBono;
import DLL.ControllerEmpleado;
import LogicLayer.Empleado;
import LogicLayer.Usuario;

public class GestionarBonos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JLabel lblNewLabel;
	private JLabel lblAgregarHorasExtras;
	private JLabel lblNewLabel_1;
	private JComboBox<Empleado> comboBox;
	private JLabel lblNewLabel_2;
	private JTextField inpMotivo;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField inpMonto;
	private JButton btnNewButton_2;


	public GestionarBonos(Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		 model = new DefaultTableModel(new String[]{"N°","Empleado","Fecha","Monto","Motivo"}, 0);
		  table = new JTable(model);
	        table.getColumnModel().getColumn(0).setPreferredWidth(10);
	        table.getColumnModel().getColumn(1).setPreferredWidth(50);  
	        table.getColumnModel().getColumn(2).setPreferredWidth(30);  
	        table.getColumnModel().getColumn(3).setPreferredWidth(20);
	        table.getColumnModel().getColumn(4).setPreferredWidth(50);
	        contentPane.setLayout(null);
	        
	        
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(20, 37, 523, 155);
	        contentPane.add(scrollPane);
	        
	        lblNewLabel = new JLabel("Bonos :");
	        lblNewLabel.setBounds(30, 10, 157, 12);
	        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
	        contentPane.add(lblNewLabel);
	        
	        lblAgregarHorasExtras = new JLabel("Agregar Bonos:");
	        lblAgregarHorasExtras.setBounds(166, 206, 201, 19);
	        lblAgregarHorasExtras.setFont(new Font("Tahoma", Font.BOLD, 15));
	        contentPane.add(lblAgregarHorasExtras);
	        cargarTablaBonos();
	        lblNewLabel_1 = new JLabel("Empleado:");
	        lblNewLabel_1.setBounds(89, 240, 85, 19);
	        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        contentPane.add(lblNewLabel_1);
	        
	        comboBox = new JComboBox<Empleado>();
	        comboBox.setBounds(89, 269, 120, 20);
	        contentPane.add(comboBox);   
	        cargarMenuDesplegable();
	        
	        JLabel lblNewLabel_1_1 = new JLabel("Monto:");
	        lblNewLabel_1_1.setBounds(276, 240, 128, 19);
	        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        contentPane.add(lblNewLabel_1_1);
	        
	        lblNewLabel_2 = new JLabel("Motivo");
	        lblNewLabel_2.setBounds(89, 310, 85, 19);
	        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        contentPane.add(lblNewLabel_2);
	        
	        inpMotivo = new JTextField();
	        inpMotivo.setBounds(89, 339, 201, 19);
	        contentPane.add(inpMotivo);
	        inpMotivo.setColumns(10);
	        
	        btnNewButton = new JButton("Agregar");
	        btnNewButton.setBounds(216, 395, 137, 31);
	        btnNewButton.addActionListener(e -> {
	            Empleado emp = (Empleado) comboBox.getSelectedItem();
	            if(emp == null) {
	                return;
	            }
	            String motivo = inpMotivo.getText();
	            Double monto=Double.parseDouble(inpMonto.getText());
	            ControllerBono cont = new ControllerBono();
	            cont.registrarBono(emp.getIdEmpleado(),monto, motivo);

	            cargarTablaBonos();

	            inpMotivo.setText("");
	            inpMonto.setText("");
	          
	        });
	        
	        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
	        contentPane.add(btnNewButton);
	        
	        btnNewButton_1 = new JButton("<-Volver");
	        btnNewButton_1.setBounds(10, 458, 95, 20);
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		MenuAdministrador menuAdmin= new MenuAdministrador(usuario);
	        		menuAdmin.setVisible(true);
	        		dispose();
	        	}
	        });
	        btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
	        contentPane.add(btnNewButton_1);
	        
	        inpMonto = new JTextField();
	        inpMonto.setBounds(276, 271, 96, 18);
	        contentPane.add(inpMonto);
	        inpMonto.setColumns(10);
	        
	        btnNewButton_2 = new JButton("<-Volver");
	        btnNewButton_2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		MenuAdministrador menuAdmin= new MenuAdministrador(usuario);
	        		menuAdmin.setVisible(true);
	        		dispose();
	        	}
	        });
	        btnNewButton_2.setFont(new Font("Tahoma", Font.ITALIC, 13));
	        btnNewButton_2.setBounds(10, 409, 84, 20);
	        contentPane.add(btnNewButton_2);
	       
	}
	private void cargarMenuDesplegable() {
		
		ControllerEmpleado contEmpleado = new ControllerEmpleado();
	    LinkedList<Empleado> empleados = contEmpleado.mostrarEmpleados();
			
		    comboBox.removeAllItems();
		    for (Empleado e : empleados) {
		        comboBox.addItem(e);
		    }
		}
	private void cargarTablaBonos() {

	    model.setRowCount(0);
	    ControllerBono cont = new ControllerBono();
	    try {

	        ResultSet rs = cont.getBonos();
	        while(rs.next()) {
	            model.addRow(new Object[] {
	                rs.getInt("id_bono"),
	                rs.getString("nombre") + " " + rs.getString("apellido"),
	                rs.getDate("fecha"),
	                rs.getDouble("monto"),
	                rs.getString("motivo")
	            });

	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	

}
