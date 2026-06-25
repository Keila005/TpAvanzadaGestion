package UserLayer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DLL.ControllerRendimiento;
import LogicLayer.Operativo;
import LogicLayer.Usuario;
import LogicLayer.Vendedor;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RendimientoEmpleado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel model;
	private DefaultTableModel model2;
	private JTable table;
	private JTable table2;
	private JLabel lblNewLabel;
	private JLabel lblRankingVendedor;
	private JButton btnMejoresO;
	private JButton btnBajosO;
	private JButton btnMejoresV;
	private JButton btnBajosV;
	private JButton btnVerTodas;
	private JButton btnVerTodas_1;

	/**
	 * Launch the application.
	 */
	
	public RendimientoEmpleado(Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		model = new DefaultTableModel(new String[]{"ID", "Nombre completo",
        		"Rendimiento"}, 0);
        contentPane.setLayout(null);
        
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 73, 304, 153);
        contentPane.add(scrollPane);
        cargarTablaOperativo(); 
        
        lblNewLabel = new JLabel("Ranking operativo:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel.setBounds(36, 32, 196, 21);
        contentPane.add(lblNewLabel);
        
        JSeparator linea = new JSeparator();
        linea.setBackground(new Color(0, 0, 0));
        linea.setOrientation(SwingConstants.VERTICAL);
        linea.setBounds(341, 32, 18, 418); // x, y, ancho, alto
        contentPane.add(linea);
        
        lblRankingVendedor = new JLabel("Ranking vendedor:");
        lblRankingVendedor.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblRankingVendedor.setBounds(421, 39, 196, 21);
        contentPane.add(lblRankingVendedor);
        
         model2 = new DefaultTableModel(new String[]{"ID", "Nombre completo",
		"Cantidad de Ventas"}, 0);

			 table2 = new JTable(model2);
			JScrollPane scrollPane1 = new JScrollPane(table2);
			scrollPane1.setBounds(358, 73, 304, 153);
			contentPane.add(scrollPane1);
			
			btnMejoresO = new JButton("Mejores");
			btnMejoresO.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarOperativosMejorRendimiento();
				}
			});
			btnMejoresO.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnMejoresO.setBounds(36, 272, 114, 29);
			contentPane.add(btnMejoresO);
			
			btnBajosO = new JButton("Bajos");
			btnBajosO.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarOperativosBajoRendimiento();
				}
			});
			btnBajosO.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnBajosO.setBounds(178, 272, 114, 29);
			contentPane.add(btnBajosO);
			
			btnMejoresV = new JButton("Mejores");
			btnMejoresV.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnMejoresV.setBounds(398, 272, 114, 29);
			contentPane.add(btnMejoresV);
			
			btnBajosV = new JButton("Bajos");
			btnBajosV.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnBajosV.setBounds(548, 272, 114, 29);
			contentPane.add(btnBajosV);
			
			btnVerTodas = new JButton("Ver todas");
			btnVerTodas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarTablaOperativo();
				}
			});
			btnVerTodas.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnVerTodas.setBounds(104, 330, 114, 29);
			contentPane.add(btnVerTodas);
			
			btnVerTodas_1 = new JButton("Ver todas");
			btnVerTodas_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnVerTodas_1.setBounds(473, 330, 114, 29);
			contentPane.add(btnVerTodas_1);
			
			JButton btnNewButton = new JButton("<-Volver");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MenuAdministrador menuAdmin= new MenuAdministrador(usuario);
					menuAdmin.setVisible(true);
					dispose();
				}
			});
			btnNewButton.setBounds(10, 455, 84, 20);
			contentPane.add(btnNewButton);
			cargarTablaVendedor();
			        
	}

	private void cargarTablaOperativo() {

	    model.setRowCount(0);

	    ControllerRendimiento rendimientoOperativo = new ControllerRendimiento();
	    LinkedList<Operativo> operativos = rendimientoOperativo.getTodosOperativos();

	    for (Operativo o : operativos) {
	    	String nombreCompleto = o.getNombre()+" "+ o.getApellido();
	        model.addRow(new Object[]{
	          o.getIdEmpleado(),
	          nombreCompleto,
	          o.getRendimiento()+" %"
	          
	        });
	    }
	}
	//tabla vendedor
	private void cargarTablaVendedor() {

	    model2.setRowCount(0);

	    ControllerRendimiento rendimientoVendedor = new ControllerRendimiento();
	    LinkedList<Vendedor> vendedores = rendimientoVendedor.getTodosVendedores();

	    for (Vendedor v : vendedores) {
	    	String nombreCompleto = v.getNombre()+" "+ v.getApellido();
	        model2.addRow(new Object[]{
	          v.getIdEmpleado(),
	          nombreCompleto,
	          v.getVentasTotales()
	        });
	    }
	}
	// alto rendimiento mayor a 70% operativo
	private void cargarOperativosMejorRendimiento() {

	    model.setRowCount(0);

	    ControllerRendimiento cr = new ControllerRendimiento();
	    LinkedList<Operativo> lista = cr.getTodosOperativos();

	    for (Operativo o : lista) {

	        if (o.getRendimiento() > 70) {

	            model.addRow(new Object[]{
	                o.getIdEmpleado(),
	                o.getNombre() + " " + o.getApellido(),
	                o.getRendimiento() + "%"
	            });
	        }
	    }
	}
	//cargar rendimiento bajo menor a 70%
	private void cargarOperativosBajoRendimiento() {

	    model.setRowCount(0);

	    ControllerRendimiento cr = new ControllerRendimiento();
	    LinkedList<Operativo> lista = cr.getTodosOperativos();

	    for (Operativo o : lista) {

	        if (o.getRendimiento() <= 70) {

	            model.addRow(new Object[]{
	                o.getIdEmpleado(),
	                o.getNombre() + " " + o.getApellido(),
	                o.getRendimiento() + "%"
	            });
	        }
	    }
	}
}
