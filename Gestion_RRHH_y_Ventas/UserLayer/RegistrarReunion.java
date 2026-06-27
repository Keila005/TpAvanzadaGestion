package UserLayer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DLL.ControllerProyecto;
import LogicLayer.Proyecto;
import LogicLayer.Usuario;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class RegistrarReunion extends JFrame {

	private Usuario usuario;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public RegistrarReunion(Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//---------------- NOMBRE ----------------

		JLabel lblNombre = new JLabel("Nombre de la reunión");
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNombre.setBounds(50, 10, 140, 16);
		contentPane.add(lblNombre);

		textField = new JTextField();
		textField.setBounds(50, 36, 140, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		

		//---------------- PROYECTO ----------------

		JLabel lblProyecto = new JLabel("Seleccione el proyecto");
		lblProyecto.setFont(new Font("Verdana", Font.BOLD, 12));
		lblProyecto.setBounds(271, 10, 145, 16);
		contentPane.add(lblProyecto);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(271, 35, 145, 20);
		contentPane.add(comboBox);

		//---------------- DESCRIPCIÓN ----------------

		JLabel lblDescripcion = new JLabel("Descripción");
		lblDescripcion.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDescripcion.setBounds(74, 118, 74, 16);
		contentPane.add(lblDescripcion);

		textField_1 = new JTextField();
		textField_1.setBounds(50, 144, 145, 18);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		//---------------- FECHA ----------------

		JLabel lblFecha = new JLabel("Fecha (AAAA-MM-DD)");
		lblFecha.setFont(new Font("Verdana", Font.BOLD, 12));
		lblFecha.setBounds(271, 118, 146, 16);
		contentPane.add(lblFecha);

		textField_2 = new JTextField();
		textField_2.setBounds(271, 144, 145, 18);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		//---------------- BOTONES ----------------

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(138, 215, 150));
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAceptar.setBounds(95, 217, 106, 40);
		contentPane.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(215, 138, 138));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.setBounds(211, 217, 106, 40);
		contentPane.add(btnCancelar);

		//---------------- CARGAR PROYECTOS ----------------

		ControllerProyecto cp = new ControllerProyecto();
		LinkedList<Proyecto> proyectos = cp.obtenerProyectosTabla();

		for (Proyecto p : proyectos) {
			comboBox.addItem(p);
		}
	}
}
