package UserLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import LogicLayer.Operativo;
import LogicLayer.Usuario;
import java.awt.Color;
import java.awt.Font;

public class VerInfoPersonal extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private Usuario usuario;
    private Operativo operativo;

    public VerInfoPersonal(Usuario usuario, Operativo operativo) {
        this.usuario = usuario;
        this.operativo = operativo;

<<<<<<< HEAD
	/**
	 * Create the frame.
	 */
	public VerInfoPersonal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ver informacion personal");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(119, 22, 214, 31);
		contentPane.add(lblNewLabel);
				
		JButton btnNewButton = new JButton("Mis datos");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MisDatos MisDatos = new MisDatos();
				MisDatos.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(28, 84, 187, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Rendimiento");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(225, 84, 187, 44);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rendimiento Rendimiento = new Rendimiento();
				Rendimiento.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Ver mi sueldo");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MiSueldo MiSueldo = new MiSueldo();
				MiSueldo.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(28, 138, 187, 44);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Ver ausencias");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBounds(225, 138, 187, 44);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			misAusencias misAusencias = new misAusencias();
			misAusencias.setVisible(true);
			dispose();
			}
		});
		contentPane.add(btnNewButton_3);
		
=======
        JLabel lblTitulo = new JLabel("Informacion Personal");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(330, 60, 300, 30);
        contentPane.add(lblTitulo);
>>>>>>> d87fe51cd2e47fb57d041a167c5cef520bd3638d

        JLabel lblUsuario = new JLabel(usuario.getNombre() + " " + usuario.getApellido());
        lblUsuario.setForeground(new Color(120, 120, 120));
        lblUsuario.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        lblUsuario.setBounds(390, 95, 200, 20);
        contentPane.add(lblUsuario);

        JLabel lblSeccion = new JLabel("Seleccione una opcion");
        lblSeccion.setForeground(new Color(0, 91, 0));
        lblSeccion.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
        lblSeccion.setBounds(350, 140, 250, 25);
        contentPane.add(lblSeccion);

        JButton btnMisDatos = crearBoton("Mis Datos", 280, 190, 180, 45);
        btnMisDatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MisDatos misDatos = new MisDatos(usuario, operativo);
                misDatos.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnMisDatos);

        JButton btnRendimiento = crearBoton("Rendimiento", 480, 190, 180, 45);
        btnRendimiento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Rendimiento rendimiento = new Rendimiento(operativo);
                rendimiento.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnRendimiento);

        JButton btnMiSueldo = crearBoton("Mi Sueldo", 280, 260, 180, 45);
        btnMiSueldo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MiSueldo miSueldo = new MiSueldo();
                miSueldo.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnMiSueldo);

        JButton btnAusencias = crearBoton("Ver Ausencias", 480, 260, 180, 45);
        btnAusencias.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Funcionalidad en desarrollo");
            }
        });
        contentPane.add(btnAusencias);

        JButton btnVolver = crearBotonRojo("Volver", EstilosGlobales.ANCHO_VENTANA - 130, EstilosGlobales.ALTO_VENTANA - 55, 110, 35);
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuOperativo menuOperativo = new MenuOperativo(usuario);
                menuOperativo.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnVolver);

        seleccionarTabPorIndice(0);
    }
}