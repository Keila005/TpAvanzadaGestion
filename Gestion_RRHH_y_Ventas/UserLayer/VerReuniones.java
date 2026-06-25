package UserLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DLL.ControllerProyecto;
import DLL.ControllerReunion;
import LogicLayer.Proyecto;
import LogicLayer.Reunion;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

public class VerReuniones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerReuniones frame = new VerReuniones();
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
	public VerReuniones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
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
				MiembroDelProyecto MiembroDelProyecto = new MiembroDelProyecto();
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
		


	}
}
