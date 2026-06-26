package UserLayer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import LogicLayer.Administrador;
import LogicLayer.Operativo;
import LogicLayer.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;

import DLL.ControllerUsuario;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.SystemColor;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	private JTextField inpMail;
	private JPasswordField inpPassword;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					ControllerUsuario nuevo = new ControllerUsuario();
					 nuevo.mostrarUsuarios();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 922, 611);

		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(255, 255, 255));
		panelPrincipal.setBorder(null);
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		JLabel lblTitulo = new JLabel("Bienvenido al sistema");
		lblTitulo.setForeground(new Color(0, 128, 0));
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 24));
		lblTitulo.setBounds(73, 38, 288, 55);
		panelPrincipal.add(lblTitulo);

		// MAIL
		JLabel lblMail = new JLabel("Mail:");
		lblMail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMail.setBounds(73, 174, 70, 28);
		panelPrincipal.add(lblMail);

		inpMail = new JTextField();
		inpMail.setForeground(new Color(0, 0, 0));
		inpMail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		inpMail.setBounds(73, 227, 223, 33);
		panelPrincipal.add(inpMail);
		inpMail.setColumns(10);

		// CONTRASEÑA
		JLabel lblPass = new JLabel("Contraseña:");
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPass.setBounds(73, 286, 120, 28);
		panelPrincipal.add(lblPass);

		inpPassword = new JPasswordField();
		inpPassword.setForeground(new Color(0, 0, 0));
		inpPassword.setBounds(73, 319, 223, 33);
		panelPrincipal.add(inpPassword);

		// BOTÓN LOGIN
		JButton btnLogin = new JButton("Iniciar sesión");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				  String email = inpMail.getText();
			        String password = new String(inpPassword.getPassword());

			        Usuario usuarioLogueado = Usuario.Login(email, password);

			        if (usuarioLogueado != null) {
			        	 if (usuarioLogueado instanceof Administrador) {

			        	        MenuAdministrador menuAdmin = new MenuAdministrador(usuarioLogueado);
			        	        menuAdmin.setVisible(true);
			        	        dispose();
			        	        
			        	 }else if(usuarioLogueado instanceof Operativo){
			        		 MenuOperativo menuOperativo= new MenuOperativo(usuarioLogueado);
			        		 menuOperativo.setVisible(true);
			        		 dispose();
			        	        
			        	 }else {
			        		 MenuVendedor menuVendedor = new MenuVendedor(usuarioLogueado);
			        		 menuVendedor.setVisible(true);
			        		 dispose();
						}
//			            DLL.ControllerAsistencia asis = new DLL.ControllerAsistencia();
//			            int idEmpleado = asis.getIdEmpleadoByUsuario(usuarioLogueado.getIdUsuario());
//
//			            if (idEmpleado != -1) {
//			                asis.registrarSalida(idEmpleado);
//			                JOptionPane.showMessageDialog(null, "Salida registrada. Hasta luego!");
//			            }

			        } else {
			            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto");
			        }
			    }
		});

		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(28, 137, 16));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogin.setBounds(73, 414, 236, 41);
		panelPrincipal.add(btnLogin);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(28, 137, 16));
		panel.setBounds(406, 0, 501, 576);
		panelPrincipal.add(panel);
				panel.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Img/rrhh.jpg")));
				lblNewLabel.setBounds(85, 138, 343, 318);
				panel.add(lblNewLabel);
				
				JLabel lblKlbe = new JLabel("KLBE &");
				lblKlbe.setForeground(new Color(255, 255, 255));
				lblKlbe.setFont(new Font("Tahoma", Font.BOLD, 24));
				lblKlbe.setBounds(199, 26, 88, 45);
				panel.add(lblKlbe);
				
				JSeparator separator = new JSeparator();
				separator.setForeground(new Color(255, 255, 255));
				separator.setBackground(new Color(255, 255, 255));
				separator.setBounds(85, 114, 311, 2);
				panel.add(separator);
				
				JLabel lblGestorEmpresarial = new JLabel("GESTOR EMPRESARIAL");
				lblGestorEmpresarial.setForeground(Color.WHITE);
				lblGestorEmpresarial.setFont(new Font("Tahoma", Font.BOLD, 24));
				lblGestorEmpresarial.setBounds(88, 59, 311, 45);
				panel.add(lblGestorEmpresarial);
				
				JLabel lblNewLabel_2 = new JLabel("Sistema de integración empresaria");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblNewLabel_2.setForeground(new Color(248, 248, 255));
				lblNewLabel_2.setBounds(127, 466, 287, 63);
				panel.add(lblNewLabel_2);
				
				JLabel lblNewLabel_2_1 = new JLabel("Administración de Recursos Humanos, Proyectos Operativos y Ventas.");
				lblNewLabel_2_1.setForeground(new Color(248, 248, 255));
				lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblNewLabel_2_1.setBounds(25, 494, 491, 72);
				panel.add(lblNewLabel_2_1);
				
				JLabel lblNewLabel_1 = new JLabel("Ingrese con su cuenta de la empresa");
				lblNewLabel_1.setForeground(new Color(128, 128, 128));
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNewLabel_1.setBounds(73, 97, 236, 20);
				panelPrincipal.add(lblNewLabel_1);
	}
}