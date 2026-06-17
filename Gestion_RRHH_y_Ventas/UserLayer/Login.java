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
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 560);

		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(null);
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		JLabel lblTitulo = new JLabel("Bienvenidos al sistema");
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 24));
		lblTitulo.setBounds(161, 29, 288, 55);
		panelPrincipal.add(lblTitulo);

		// MAIL
		JLabel lblMail = new JLabel("Mail:");
		lblMail.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMail.setBounds(88, 138, 70, 28);
		panelPrincipal.add(lblMail);

		inpMail = new JTextField();
		inpMail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		inpMail.setBounds(80, 176, 223, 33);
		panelPrincipal.add(inpMail);
		inpMail.setColumns(10);

		// CONTRASEÑA
		JLabel lblPass = new JLabel("Contraseña:");
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPass.setBounds(88, 236, 120, 28);
		panelPrincipal.add(lblPass);

		inpPassword = new JPasswordField();
		inpPassword.setBounds(80, 274, 223, 33);
		panelPrincipal.add(inpPassword);

		// IMAGEN
		JLabel lblImg = new JLabel("");
		lblImg.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblImg.setIcon(new ImageIcon(Login.class.getResource("/Img/tienda.png")));
		lblImg.setBounds(369, 148, 186, 168);
		panelPrincipal.add(lblImg);

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
			        	        
			        	 }else if(usuarioLogueado instanceof Operativo){
			        		 MenuOperativo menuOperativo= new MenuOperativo(usuarioLogueado);
			        		 menuOperativo.setVisible(true);
			        	        
			        	 }else {
			        		 MenuVendedor menuVendedor = new MenuVendedor(usuarioLogueado);
			        		 menuVendedor.setVisible(true);
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

		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBackground(new Color(255, 255, 128));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogin.setBounds(197, 371, 235, 41);
		panelPrincipal.add(btnLogin);
	}
}