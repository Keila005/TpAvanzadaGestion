package UserLayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
	private JPanel inputContra;
	private JTextField inpMail;
	private JPasswordField inputMail;
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
		inputContra = new JPanel();
		inputContra.setBorder(null);
		setContentPane(inputContra);
		inputContra.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenidos al sistema");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(161, 29, 288, 55);
		inputContra.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mail:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(88, 138, 70, 28);
		inputContra.add(lblNewLabel_1);
		
		inpMail = new JTextField();
		inpMail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		inpMail.setBounds(80, 274, 223, 33);
		inputContra.add(inpMail);
		inpMail.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contraseña:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(88, 236, 112, 28);
		inputContra.add(lblNewLabel_1_1);
		
		inputMail = new JPasswordField();
		inputMail.setBounds(80, 176, 223, 33);
		inputContra.add(inputMail);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/Img/tienda.png")));
		lblNewLabel_2.setBounds(369, 148, 186, 168);
		inputContra.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Iniciar sesión");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//codigo del login btn Iniciar sesion
				 Usuario usuarioLogueado = null;
				 Usuario usuario = Usuario.Login();
            	 if(usuario != null) {
            		    usuario.Menu();
            		    usuarioLogueado = usuario;
            		    
            		} else {
            		    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto");
            		}
            	 
            	 if (usuarioLogueado != null) {
	                    DLL.ControllerAsistencia asis = new DLL.ControllerAsistencia();
	                    int idEmpleado = asis.getIdEmpleadoByUsuario(usuarioLogueado.getIdUsuario());
	                    if (idEmpleado != -1) {
	                        asis.registrarSalida(idEmpleado);
	                        JOptionPane.showMessageDialog(null, "Salida registrada. Hasta luego!");
	                    }
	                }
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(197, 371, 235, 41);
		inputContra.add(btnNewButton);

	}
}
