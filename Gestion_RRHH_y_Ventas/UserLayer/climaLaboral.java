package UserLayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DLL.ControllerComentario;
import LogicLayer.ComentarioAnonimo;
import LogicLayer.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.LinkedList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class climaLaboral extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private  DefaultTableModel model;
	private JTable table;
	private JLabel lblNewLabel_1;
	private ControllerComentario comentarioController;
	private JButton btnNewButton;
	
	/**
	 * Create the frame.
	 */
	public climaLaboral(Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Clima Laboral :");
		lblNewLabel.setBounds(206, 28, 142, 21);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(lblNewLabel);
		
		  model = new DefaultTableModel(new String[]{"N°", "Comentarios","Fecha",
	        		"Sentimiento"}, 0);
	        
	         table = new JTable(model);
	         cargarComentarios();
	         table.getColumnModel().getColumn(0).setPreferredWidth(25);  
	         table.getColumnModel().getColumn(1).setPreferredWidth(250);  
	         table.getColumnModel().getColumn(2).setPreferredWidth(80);   
	         table.getColumnModel().getColumn(3).setPreferredWidth(100);
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(10, 59, 480, 159);
	        contentPane.add(scrollPane);
	        
	        lblNewLabel_1 = new JLabel("Reporte de comentarios:");
	        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	        lblNewLabel_1.setBounds(132, 228, 227, 21);
	        contentPane.add(lblNewLabel_1);
	        
	        JTextArea txtReporte = new JTextArea();
	        txtReporte.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        txtReporte.setEditable(false);
	        txtReporte.setLineWrap(true);
	        txtReporte.setWrapStyleWord(true);

	        txtReporte.setText(comentarioController.generarReporteClima());

	        txtReporte.setBounds(132, 260, 245, 111);
	        contentPane.add(txtReporte);
	        
	        btnNewButton = new JButton("<-Volver");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		MenuAdministrador menuAdmin= new MenuAdministrador(usuario);
	        		menuAdmin.setVisible(true);
	        		dispose();
	        	}
	        });
	        btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 13));
	        btnNewButton.setBounds(0, 341, 95, 20);
	        contentPane.add(btnNewButton);

	}
	private void cargarComentarios() {
		 model.setRowCount(0);

		  comentarioController = new ControllerComentario();
		 LinkedList<ComentarioAnonimo> comentarios = comentarioController.verComentarios();

	    for (ComentarioAnonimo c : comentarios) {

	        model.addRow(new Object[]{
	           c.getIdMensaje(),
	           c.getContenido(),
	           c.getFecha(),
	           c.getSentimiento()
	        });
	    }
	}

}
