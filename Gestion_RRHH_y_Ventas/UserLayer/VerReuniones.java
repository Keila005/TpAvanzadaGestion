package UserLayer;

<<<<<<< HEAD
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
=======
>>>>>>> d87fe51cd2e47fb57d041a167c5cef520bd3638d
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import DLL.ControllerProyecto;
import DLL.ControllerReunion;
import LogicLayer.Proyecto;
import LogicLayer.Reunion;
import LogicLayer.Usuario;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.Color;

<<<<<<< HEAD
import DLL.ControllerProyecto;
import DLL.ControllerReunion;
import LogicLayer.Proyecto;
import LogicLayer.Reunion;
import LogicLayer.Usuario;

public class VerReuniones extends JFrame {
	
	private Usuario usuario;
=======
public class VerReuniones extends VentanaBase {
>>>>>>> d87fe51cd2e47fb57d041a167c5cef520bd3638d

    private static final long serialVersionUID = 1L;

<<<<<<< HEAD
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public VerReuniones(Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(63, 151, 292, 21);
		contentPane.add(comboBox);
		ControllerReunion cr = new ControllerReunion();
		int idProyecto = 1; // temporal
		LinkedList<Reunion> reuniones =
		        cr.obtenerReunionesProyecto(idProyecto);
		for(Reunion r : reuniones) {
		    comboBox.addItem(r.getTitulo());
		}
		
		//PROYECTOS
		
		JComboBox<String> comboBox_1 = new JComboBox<>();
		comboBox_1.setBounds(63, 82, 292, 21);
		contentPane.add(comboBox_1);
		ControllerProyecto cp = new ControllerProyecto();
		int idOperativo = 2; // temporal
		LinkedList<Proyecto> proyectos =
		        cp.obtenerProyectosMiembro(idOperativo);
		for(Proyecto p : proyectos) {
		    comboBox_1.addItem(p.getNombre());
		}
		
		JLabel lblNewLabel = new JLabel("Elegir proyecto:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel.setBounds(135, 44, 153, 28);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(63, 182, 141, 28);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AsistenciaRegistrada AsistenciaRegistrada = new AsistenciaRegistrada();
				AsistenciaRegistrada.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MiembroDelProyecto MiembroDelProyecto = new MiembroDelProyecto(usuario);
				MiembroDelProyecto.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(214, 182, 141, 28);
		contentPane.add(btnNewButton_1);
		
		JLabel lblElegirReunin = new JLabel("Elegir reunión:");
		lblElegirReunin.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblElegirReunin.setBounds(135, 113, 153, 28);
		contentPane.add(lblElegirReunin);
=======
    public VerReuniones(Usuario usuario) {

        JLabel lblTitulo = new JLabel("Ver Reuniones");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 250, 30);
        contentPane.add(lblTitulo);
>>>>>>> d87fe51cd2e47fb57d041a167c5cef520bd3638d

        JLabel lblUsuario = new JLabel(usuario.getNombre() + " " + usuario.getApellido());
        lblUsuario.setForeground(new Color(120, 120, 120));
        lblUsuario.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        lblUsuario.setBounds(390, 90, 200, 20);
        contentPane.add(lblUsuario);

        JLabel lblProyecto = new JLabel("Elegir proyecto:");
        lblProyecto.setForeground(new Color(0, 91, 0));
        lblProyecto.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        lblProyecto.setBounds(200, 130, 150, 25);
        contentPane.add(lblProyecto);

        JComboBox<String> comboProyectos = new JComboBox<>();
        comboProyectos.setBackground(Color.WHITE);
        comboProyectos.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        comboProyectos.setBounds(360, 130, 250, 35);
        contentPane.add(comboProyectos);

        JLabel lblReunion = new JLabel("Elegir reunión:");
        lblReunion.setForeground(new Color(0, 91, 0));
        lblReunion.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        lblReunion.setBounds(200, 190, 150, 25);
        contentPane.add(lblReunion);

        JComboBox<String> comboReuniones = new JComboBox<>();
        comboReuniones.setBackground(Color.WHITE);
        comboReuniones.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        comboReuniones.setBounds(360, 190, 250, 35);
        contentPane.add(comboReuniones);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setForeground(Color.WHITE);
        btnAceptar.setBackground(new Color(0, 91, 0));
        btnAceptar.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnAceptar.setBounds(280, 270, 150, 45);
        btnAceptar.setBorder(null);
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.setFocusPainted(false);
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAceptar.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAceptar.setBackground(new Color(0, 91, 0));
            }
        });
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AsistenciaRegistrada asistencia = new AsistenciaRegistrada();
                asistencia.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnAceptar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBackground(new Color(180, 50, 50));
        btnCancelar.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        btnCancelar.setBounds(450, 270, 150, 45);
        btnCancelar.setBorder(null);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setFocusPainted(false);
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelar.setBackground(new Color(150, 30, 30));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelar.setBackground(new Color(180, 50, 50));
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MiembroDelProyecto miembro = new MiembroDelProyecto(usuario);
                miembro.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnCancelar);

        JButton btnVolver = crearBotonRojo("Volver", EstilosGlobales.ANCHO_VENTANA - 130, EstilosGlobales.ALTO_VENTANA - 55, 110, 35);
        btnVolver.addActionListener(e -> {
            MiembroDelProyecto miembro = new MiembroDelProyecto(usuario);
            miembro.setVisible(true);
            dispose();
        });
        contentPane.add(btnVolver);

        // Cargar proyectos
        ControllerProyecto cp = new ControllerProyecto();
        int idOperativo = 2;
        LinkedList<Proyecto> proyectos = cp.obtenerProyectosMiembro(idOperativo);
        for (Proyecto p : proyectos) {
            comboProyectos.addItem(p.getNombre());
        }

        // Cargar reuniones
        ControllerReunion cr = new ControllerReunion();
        int idProyecto = 1;
        LinkedList<Reunion> reuniones = cr.obtenerReunionesProyecto(idProyecto);
        for (Reunion r : reuniones) {
            comboReuniones.addItem(r.getTitulo());
        }

        seleccionarTabPorIndice(0);
    }
}