package UserLayer;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import DLL.ControllerUsuario;
import LogicLayer.Administrador;
import LogicLayer.Empleado;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpName;
	private JTextField inpApellido;
	private JTextField inpEmail;
	private JTextField inpDni;
	private JTextField inpSueldo;
	 private static ControllerUsuario usuarioController = new ControllerUsuario();
	 private JLabel lblActualizarFotoPerfil;
	 private JButton btnActualizar;
	 private JButton btnActualizar_1;

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
	public EditarUsuario(Empleado empleado,Administrador admin) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 541);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		inpName = new JTextField();
		inpName.setText(empleado.getNombre());
		inpName.setBackground(new Color(255, 255, 128));
		inpName.setFont(new Font("Tahoma", Font.ITALIC, 13));
		inpName.setBounds(46, 79, 133, 25);
		contentPane.add(inpName);
		inpName.setColumns(10);
		
		JLabel lblName = new JLabel("Editar Nombre:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblName.setBounds(46, 49, 152, 20);
		contentPane.add(lblName);
		
		JLabel lblApellido = new JLabel("Editar Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblApellido.setBounds(247, 49, 152, 20);
		contentPane.add(lblApellido);
		
		inpApellido = new JTextField();
		inpApellido.setText(empleado.getApellido());
		inpApellido.setBackground(new Color(255, 255, 128));
		inpApellido.setFont(new Font("Tahoma", Font.ITALIC, 13));
		inpApellido.setColumns(10);
		inpApellido.setBounds(247, 79, 133, 25);
		contentPane.add(inpApellido);
		
		JLabel lblEmail = new JLabel("Editar email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEmail.setBounds(46, 130, 152, 20);
		contentPane.add(lblEmail);
		
		inpEmail = new JTextField();
		inpEmail.setText(empleado.getMail());
		inpEmail.setBackground(new Color(255, 255, 128));
		inpEmail.setFont(new Font("Tahoma", Font.ITALIC, 13));
		inpEmail.setColumns(10);
		inpEmail.setBounds(46, 160, 266, 25);
		contentPane.add(inpEmail);
		
		JLabel lblDni = new JLabel("Editar Dni:");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDni.setBounds(46, 211, 152, 20);
		contentPane.add(lblDni);
		
		inpDni = new JTextField();
		inpDni.setText(String.valueOf(empleado.getDni()));
		inpDni.setBackground(new Color(255, 255, 128));
		inpDni.setFont(new Font("Tahoma", Font.ITALIC, 13));
		inpDni.setColumns(10);
		inpDni.setBounds(46, 241, 133, 25);
		contentPane.add(inpDni);
		
		JLabel lblSueldoI = new JLabel("Editar Sueldo:");
		lblSueldoI.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSueldoI.setBounds(307, 211, 152, 20);
		contentPane.add(lblSueldoI);
		
		inpSueldo = new JTextField();
		inpSueldo.setText(String.valueOf(empleado.getSueldoBase()));
		inpSueldo.setBackground(new Color(255, 255, 128));
		inpSueldo.setFont(new Font("Tahoma", Font.ITALIC, 13));
		inpSueldo.setColumns(10);
		inpSueldo.setBounds(317, 241, 121, 25);
		contentPane.add(inpSueldo);
		
		lblActualizarFotoPerfil = new JLabel("Foto perfil:");
		lblActualizarFotoPerfil.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblActualizarFotoPerfil.setBounds(484, 130, 192, 20);
		contentPane.add(lblActualizarFotoPerfil);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBackground(new Color(128, 128, 128));
		btnActualizar.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnActualizar.setBounds(484, 174, 133, 30);
		contentPane.add(btnActualizar);
		
		btnActualizar_1 = new JButton("Editar");
		btnActualizar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				usuarioController.modificarEmpleado(
						empleado.getIdEmpleado(),inpName.getText(),inpApellido.getText(),
						inpEmail.getText(),Integer.parseInt(inpDni.getText()),
						Double.parseDouble(inpSueldo.getText()));
				JOptionPane.showMessageDialog(null, "Se edito correctamente los datos✨");
				dispose();
				MenuGestionar menugestion= new MenuGestionar(admin);
				menugestion.setVisible(true);
			}
		});
		btnActualizar_1.setBackground(new Color(189, 200, 183));
		btnActualizar_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnActualizar_1.setBounds(201, 366, 214, 30);
		contentPane.add(btnActualizar_1);
		
	}
}
