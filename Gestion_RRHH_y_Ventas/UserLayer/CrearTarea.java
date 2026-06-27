package UserLayer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DLL.ControllerOperativo;
import DLL.ControllerProyecto;
import DLL.ControllerTarea;
import DLL.ControllerUsuario;
import LogicLayer.Operativo;
import LogicLayer.Proyecto;
import LogicLayer.Usuario;

public class CrearTarea extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	private JComboBox<Proyecto> cmbProyecto;
	private JComboBox<Operativo> cmbEmpleado;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					CrearTarea frame = new CrearTarea(null);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public CrearTarea(Usuario Usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

		JLabel lblNewLabel = new JLabel("Nombre de la Tarea");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 13, 129, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(161, 13, 96, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDescripcion.setBounds(10, 41, 74, 16);
		contentPane.add(lblDescripcion);
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 39, 96, 18);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		
		JLabel lblSeleccioneElProyecto = new JLabel("Seleccione el proyecto");
		lblSeleccioneElProyecto.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSeleccioneElProyecto.setBounds(10, 74, 145, 16);
		contentPane.add(lblSeleccioneElProyecto);
		
		cmbProyecto = new JComboBox<>();
		cmbProyecto.setBounds(173, 73, 180, 22);
		contentPane.add(cmbProyecto);

		JLabel lblEmpleado = new JLabel("Asignar a");
		lblEmpleado.setFont(new Font("Verdana", Font.BOLD, 12));
		lblEmpleado.setBounds(6,111,67,16);
		contentPane.add(lblEmpleado);

		cmbEmpleado = new JComboBox<>();
		cmbEmpleado.setBounds(77,109,180,22);
		contentPane.add(cmbEmpleado);
		
		JLabel lblSeleccioneFechaDe = new JLabel("Seleccione fecha de inicio (AAAA-MM-DD)");
		lblSeleccioneFechaDe.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSeleccioneFechaDe.setBounds(10, 156, 271, 16);
		contentPane.add(lblSeleccioneFechaDe);
		
		textField_2 = new JTextField();
		textField_2.setBounds(291, 156, 96, 18);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		JLabel lblSeleccioneFechaDe_2 = new JLabel("Seleccione fecha de fin (AAAA-MM-DD)");
		lblSeleccioneFechaDe_2.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSeleccioneFechaDe_2.setBounds(10, 197, 255, 16);
		contentPane.add(lblSeleccioneFechaDe_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(275, 197, 96, 18);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		ControllerProyecto cp = new ControllerProyecto();

		LinkedList<Proyecto> proyectos = cp.obtenerProyectosTabla();

		for(Proyecto p : proyectos) {
			cmbProyecto.addItem(p);
		}

		ControllerOperativo co = new ControllerOperativo();

		LinkedList<Operativo> miembros = co.obtenerMiembrosProyecto();

		for(Operativo op : miembros) {
			cmbEmpleado.addItem(op);
		}

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(138,215,150));
		btnAceptar.setBounds(120,245,90,25);
		contentPane.add(btnAceptar);

		btnAceptar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Proyecto proyecto =
						(Proyecto)cmbProyecto.getSelectedItem();

				Operativo operativo =
						(Operativo)cmbEmpleado.getSelectedItem();

				ControllerTarea ct = new ControllerTarea();

				ct.crearTarea(

						textField.getText(),
						textField_1.getText(),
						proyecto.getIdProyecto(),
						operativo.getIdOperativo()

				);

				JOptionPane.showMessageDialog(null,
						"Tarea creada correctamente");

			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(215,138,138));
		btnCancelar.setBounds(225,245,90,25);
		contentPane.add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				LiderDelProyecto ventana =
						new LiderDelProyecto(Usuario);

				ventana.setVisible(true);
				dispose();

			}
		});

		
	}

}
