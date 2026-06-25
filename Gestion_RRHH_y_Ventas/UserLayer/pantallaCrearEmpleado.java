package UserLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DLL.ControllerUsuario;
import DLL.Hashing;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class pantallaCrearEmpleado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpName;
	private JTextField inpApellido;
	private JTextField inpEmail;
	private JPasswordField inpContra;
	private JTextField inpDni;
	private JTextField inpSueldo;
<<<<<<< HEAD
=======
	private byte[] fotoPerfil;
	
>>>>>>> 582830926404ebf67bea2dc0c367ff7a4b1f7785
	 private static ControllerUsuario usuarioController = new ControllerUsuario();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantallaCrearEmpleado frame = new pantallaCrearEmpleado();
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
	public pantallaCrearEmpleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnCrearOperativo = new JRadioButton("Crear operativo");
		rdbtnCrearOperativo.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnCrearOperativo.setBounds(46, 247, 167, 20);
		contentPane.add(rdbtnCrearOperativo);
		
		JRadioButton rdbtnCrearVendedor = new JRadioButton("Crear vendedor");
		rdbtnCrearVendedor.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnCrearVendedor.setBounds(46, 332, 167, 20);
		contentPane.add(rdbtnCrearVendedor);
		
		//agrupar btn para elegir una opcion
		ButtonGroup grupoRol = new ButtonGroup();
		grupoRol.add(rdbtnCrearOperativo);
		grupoRol.add(rdbtnCrearVendedor);
		
		// si se elige operativo se elige que tipo cumplir:
		JRadioButton rdbtnLider = new JRadioButton("Líder");
		rdbtnLider.setFont(new Font("Tahoma", Font.ITALIC, 16));
		rdbtnLider.setBounds(101, 276, 100, 20);
		rdbtnLider.setVisible(false);
		contentPane.add(rdbtnLider);

		JRadioButton rdbtnMiembro = new JRadioButton("Miembro");
		rdbtnMiembro.setFont(new Font("Tahoma", Font.ITALIC, 16));
		rdbtnMiembro.setBounds(101, 298, 100, 20);
		rdbtnMiembro.setVisible(false);
		contentPane.add(rdbtnMiembro);
		
		ButtonGroup grupoOperativo = new ButtonGroup();
		grupoOperativo.add(rdbtnLider);
		grupoOperativo.add(rdbtnMiembro);
		
		//si se elige operatico aparece la lista y sino desaparece
				rdbtnCrearOperativo.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        rdbtnLider.setVisible(true);
				        rdbtnMiembro.setVisible(true);
				    }
				});

				rdbtnCrearVendedor.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        rdbtnLider.setVisible(false);
				        rdbtnMiembro.setVisible(false);

				        // Desmarca líder y miembro si estaban seleccionados
				        grupoOperativo.clearSelection();
				    }
				});
		
		inpName = new JTextField();
		inpName.setFont(new Font("Tahoma", Font.ITALIC, 13));
		inpName.setBounds(46, 79, 133, 25);
		contentPane.add(inpName);
		inpName.setColumns(10);
		
		JLabel lblName = new JLabel("Nombre:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblName.setBounds(46, 49, 152, 20);
		contentPane.add(lblName);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblApellido.setBounds(247, 49, 152, 20);
		contentPane.add(lblApellido);
		
		inpApellido = new JTextField();
		inpApellido.setFont(new Font("Tahoma", Font.ITALIC, 13));
		inpApellido.setColumns(10);
		inpApellido.setBounds(247, 79, 133, 25);
		contentPane.add(inpApellido);
		
		JLabel lblEmail = new JLabel("Crea un email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEmail.setBounds(46, 130, 152, 20);
		contentPane.add(lblEmail);
		
		inpEmail = new JTextField();
		inpEmail.setFont(new Font("Tahoma", Font.ITALIC, 13));
		inpEmail.setColumns(10);
		inpEmail.setBounds(46, 160, 266, 25);
		contentPane.add(inpEmail);
		
		JLabel lblElegirRol = new JLabel("Elegir rol:");
		lblElegirRol.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblElegirRol.setBounds(46, 211, 152, 20);
		contentPane.add(lblElegirRol);
		
		inpContra = new JPasswordField();
		inpContra.setBounds(471, 161, 191, 25);
		contentPane.add(inpContra);
		
		JLabel lblDni = new JLabel("Dni:");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDni.setBounds(471, 49, 152, 20);
		contentPane.add(lblDni);
		
		inpDni = new JTextField();
		inpDni.setFont(new Font("Tahoma", Font.ITALIC, 13));
		inpDni.setColumns(10);
		inpDni.setBounds(471, 79, 133, 25);
		contentPane.add(inpDni);
		
		JLabel lblCrearContrasea = new JLabel("Crear contraseña:");
		lblCrearContrasea.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCrearContrasea.setBounds(471, 130, 152, 20);
		contentPane.add(lblCrearContrasea);
		
		JLabel lblSueldoI = new JLabel("Sueldo inicial:");
		lblSueldoI.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSueldoI.setBounds(471, 211, 152, 20);
		contentPane.add(lblSueldoI);
		
		inpSueldo = new JTextField();
		inpSueldo.setFont(new Font("Tahoma", Font.ITALIC, 13));
		inpSueldo.setColumns(10);
		inpSueldo.setBounds(471, 246, 121, 25);
		contentPane.add(inpSueldo);
		
		JButton btnNewButton = new JButton("Crear Empleado");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  if (rdbtnCrearOperativo.isSelected()) {

			            if (rdbtnLider.isSelected()) {
			            	usuarioController.crearOperativo(
			            			inpName.getText(),
			            			inpApellido.getText(),
			            			inpEmail.getText(),
			            			Hashing.hash(new String(inpContra.getPassword())),
			            			Integer.parseInt(inpDni.getText()),
			            			Double.parseDouble(inpSueldo.getText()),
<<<<<<< HEAD
			            			"Lider de Proyecto");
=======
			            			"Lider de Proyecto",
			            			fotoPerfil
			            			);
			            	menuGestionar.cargarTabla();
>>>>>>> 582830926404ebf67bea2dc0c367ff7a4b1f7785
			            	dispose();
			            	JOptionPane.showMessageDialog(null, "Se creo correctamente el empleado Lider");

			            } else if (rdbtnMiembro.isSelected()) {
			            	usuarioController.crearOperativo(
			            			inpName.getText(),
			            			inpApellido.getText(),
			            			inpEmail.getText(),
			            			Hashing.hash(new String(inpContra.getPassword())),
			            			Integer.parseInt(inpDni.getText()),
			            			Double.parseDouble(inpSueldo.getText()),
<<<<<<< HEAD
			            			"Miembro de Proyecto");
=======
			            			"Miembro de Proyecto",
			            			fotoPerfil);
			            	menuGestionar.cargarTabla();
			            	JOptionPane.showMessageDialog(null, "Se creo correctamente el empleado miembro");
>>>>>>> 582830926404ebf67bea2dc0c367ff7a4b1f7785
			            	dispose();
			            	JOptionPane.showMessageDialog(null, "Se creo correctamente el empleado Miembro");
				     	                
			            } else {
			                JOptionPane.showMessageDialog(null,
			                        "Debes elegir Líder o Miembro");
			            }

			        } else if (rdbtnCrearVendedor.isSelected()) {
			        	 usuarioController.crearVendedor(
			     	                inpName.getText(),
			     	               inpApellido.getText(),
			     	              inpEmail.getText(),
			     	             Hashing.hash(new String(inpContra.getPassword())),
			     	            Integer.parseInt(inpDni.getText()),
<<<<<<< HEAD
		            			Double.parseDouble(inpSueldo.getText()));
=======

		            			Double.parseDouble(inpSueldo.getText()),
		            			fotoPerfil);
			        	 menuGestionar.cargarTabla();
			        	 JOptionPane.showMessageDialog(null, "Se creo correctamente el empleado Vendedor");

>>>>>>> 582830926404ebf67bea2dc0c367ff7a4b1f7785
			        	 dispose();
			        	 JOptionPane.showMessageDialog(null, "Se creo correctamente el empleado Vendedor");



			        } else {
			            JOptionPane.showMessageDialog(null,
			                    "Debe elegir un rol");
			        }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(208, 418, 370, 45);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Agregar foto de perfil:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(471, 297, 240, 20);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Foto de perfil...");
		btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnNewButton_1.setBounds(471, 334, 167, 33);
		contentPane.add(btnNewButton_1);

	}
}
