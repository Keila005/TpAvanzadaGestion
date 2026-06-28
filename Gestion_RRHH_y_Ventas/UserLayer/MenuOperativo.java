package UserLayer;

import LogicLayer.Usuario;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class MenuOperativo extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private JPanel panelContenido;

    public MenuOperativo(Usuario usuario) {
        
        JLabel lblTitulo = new JLabel("Panel Operativo");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 250, 30);
        contentPane.add(lblTitulo);
        
        JLabel lblUsuario = new JLabel(usuario.getNombre() + " " + usuario.getApellido());
        lblUsuario.setForeground(new Color(120, 120, 120));
        lblUsuario.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        lblUsuario.setBounds(390, 90, 200, 20);
        contentPane.add(lblUsuario);

        // BOTON 1 - Ver Informacion Personal (NO cierra MenuOperativo)
        JButton btnInfoPersonal = crearBoton("Ver Informacion Personal", 200, 170, 220, 50);
        btnInfoPersonal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VerInfoPersonal verInfo = new VerInfoPersonal(usuario, (LogicLayer.Operativo) usuario);
                verInfo.setVisible(true);
            }
        });
        contentPane.add(btnInfoPersonal);


	public MenuOperativo(Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 848, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido operativo:"+ usuario.getNombre());
		lblNewLabel.setBounds(269, 10, 310, 51);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ver Informacion Personal");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(175, 146, 206, 57);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerInfoPersonal VerInfoPersonal = new VerInfoPersonal();
				VerInfoPersonal.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Crear Solicitud");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(433, 146, 206, 57);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearSolicitud CrearSolicitud = new CrearSolicitud();
				CrearSolicitud.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Comentar");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(175, 235, 206, 57);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comentar Comentar = new Comentar();
				Comentar.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Cargo");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_3.setBounds(433, 235, 206, 57);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cargo Cargo = new Cargo(usuario);
				Cargo.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Salir");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_4.setBounds(350, 433, 119, 45);
		contentPane.add(btnNewButton_4);
        JButton btnCrearSolicitud = crearBoton("Crear Solicitud", 450, 170, 220, 50);
        btnCrearSolicitud.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CrearSolicitud crearSolicitud = new CrearSolicitud();
                crearSolicitud.setVisible(true);
            }
        });
        contentPane.add(btnCrearSolicitud);

        JButton btnComentar = crearBoton("Comentar", 200, 250, 220, 50);
        btnComentar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Comentar comentar = new Comentar(usuario);
                comentar.setVisible(true);
            }
        });
        contentPane.add(btnComentar);

        // BOTON 4 - Cargo (CIERRA MenuOperativo porque abre Cargo)
        JButton btnCargo = crearBoton("Cargo", 450, 250, 220, 50);
        btnCargo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cargo cargo = new Cargo(usuario);
                cargo.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnCargo);

        // BOTON 5 - Salir (CIERRA MenuOperativo y vuelve al Login)
        JButton btnSalir = crearBotonRojo("Salir", EstilosGlobales.ANCHO_VENTANA - 120, EstilosGlobales.ALTO_VENTANA - 50, 100, 35);
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Cerrando sesion...");
                Login login = new Login();
                login.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnSalir);

        seleccionarTabPorIndice(0);
    }
}