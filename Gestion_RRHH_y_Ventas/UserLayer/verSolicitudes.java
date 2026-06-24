package UserLayer;

import java.awt.EventQueue;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DLL.ControllerSolicitud;
import LogicLayer.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class verSolicitudes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnAceptar;
	private JButton btnRechazar;

	
	public verSolicitudes(Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		 model = new DefaultTableModel(new String[]{"N°", "Tipo","Fecha de inicio",
	        		"Fecha de finalización","Estado"}, 0);
	        
	        table = new JTable(model);
	        table.getColumnModel().getColumn(0).setPreferredWidth(10);
	        table.getColumnModel().getColumn(1).setPreferredWidth(50);  
	        table.getColumnModel().getColumn(2).setPreferredWidth(30);  
	        table.getColumnModel().getColumn(4).setPreferredWidth(20);
	        contentPane.setLayout(null);
	        
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(23, 32, 533, 112);
	        contentPane.add(scrollPane);
	        
	        btnAceptar = new JButton("Aceptar");
	        btnAceptar.setBounds(117, 173, 120, 30);
	        contentPane.add(btnAceptar);

	        btnRechazar = new JButton("Rechazar");
	        btnRechazar.setBounds(280, 173, 120, 30);
	        contentPane.add(btnRechazar);
	        cargarSolicitudes("pendiente");
	        
	        JLabel lbSeleccioar = new JLabel("Solicitudes :");
	        lbSeleccioar.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        lbSeleccioar.setBounds(24, 10, 193, 12);
	        contentPane.add(lbSeleccioar);
	        
	        JButton btnVerAprobadas = new JButton("Ver aprobadas");
	        btnVerAprobadas.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		cargarSolicitudes("aprobada");
	        	}
	        });
	        btnVerAprobadas.setBounds(308, 240, 126, 30);
	        contentPane.add(btnVerAprobadas);
	        
	        JButton btnVerRechazadas = new JButton("Ver rechazadas");
	        btnVerRechazadas.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		cargarSolicitudes("rechazada");
	        	}
	        });
	        btnVerRechazadas.setBounds(443, 240, 126, 30);
	        contentPane.add(btnVerRechazadas);
	        
	        JButton btnVerPendientes = new JButton("Ver pendientes");
	        btnVerPendientes.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		cargarSolicitudes("pendiente");
	        	}
	        });
	        btnVerPendientes.setBounds(172, 240, 126, 30);
	        contentPane.add(btnVerPendientes);
	        
	        JButton btnNewButton = new JButton("<-Volver");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		MenuAdministrador menuAdmin=new MenuAdministrador(usuario);
	        		menuAdmin.setVisible(true);
	        		dispose();
	        	}
	        });
	        btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 13));
	        btnNewButton.setBounds(10, 250, 84, 20);
	        contentPane.add(btnNewButton);
	        
	        btnRechazar.addActionListener(e -> {

	            int fila = table.getSelectedRow();

	            if (fila != -1) {

	                int idSolicitud =
	                    Integer.parseInt(model.getValueAt(fila, 0).toString());

	                ControllerSolicitud cs = new ControllerSolicitud();
	                cs.actualizarEstado(idSolicitud, "rechazada");
	                cargarSolicitudes("pendiente");
	            }else {
	            	 JOptionPane.showMessageDialog(null,
	                         "Debe seleccionar un empleado.",
	                         "Aviso",
	                         JOptionPane.WARNING_MESSAGE);
	            }
	        });
	        btnAceptar.addActionListener(e -> {

	            int fila = table.getSelectedRow();

	            if (fila != -1) {

	                int idSolicitud =
	                    Integer.parseInt(model.getValueAt(fila, 0).toString());

	                ControllerSolicitud cs = new ControllerSolicitud();
	                cs.actualizarEstado(idSolicitud, "aceptada");

	                cargarSolicitudes("pendiente");
	            }else {
	            	 JOptionPane.showMessageDialog(null,
	                         "Debe seleccionar un empleado.",
	                         "Aviso",
	                         JOptionPane.WARNING_MESSAGE);
	            }
	        });

	}
	private void cargarSolicitudes(String estado) {

	    model.setRowCount(0);
	    if (estado.equals("pendiente")) {
	        btnAceptar.setVisible(true);
	        btnRechazar.setVisible(true);
	    } else {
	        btnAceptar.setVisible(false);
	        btnRechazar.setVisible(false);
	    }


	    ControllerSolicitud cs = new ControllerSolicitud();

	    try {

	        ResultSet rs = cs.getSolicitudesPorEstado(estado);

	        while (rs.next()) {

	            model.addRow(new Object[] {
	                rs.getInt("id_solicitud"),
	                rs.getString("tipo"),
	                rs.getString("fecha_inicio"),
	                rs.getString("fecha_fin"),
	                rs.getString("estado")
	            });
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
