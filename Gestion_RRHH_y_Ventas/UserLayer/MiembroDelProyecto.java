package UserLayer;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LogicLayer.Usuario;

public class MiembroDelProyecto extends JFrame {
	private Usuario usuario;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiembroDelProyecto frame = new MiembroDelProyecto();
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
	public MiembroDelProyecto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Realice una accion");
		lblNewLabel.setBounds(118, 26, 191, 23);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Visualizar Kanban");
		btnNewButton.setBounds(29, 81, 183, 36);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			VisualizarKanban VisualizarKanban = new VisualizarKanban(usuario);
			VisualizarKanban.setVisible(true);
			dispose();
			}
	});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Evaluar Compañero");
		btnNewButton_1.setBounds(29, 139, 183, 36);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EvaluarCompaniero EvaluarCompaniero = new EvaluarCompaniero();
				EvaluarCompaniero.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Ver Reuniones"); //okk
		btnNewButton_2.setBounds(228, 81, 183, 36);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerReuniones VerReuniones = new VerReuniones();
				VerReuniones.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Volver");
		btnNewButton_3.setBounds(228, 139, 183, 36);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Cargo ventanaCargo = new Cargo(usuario);
		        ventanaCargo.setVisible(true);
		        dispose();
		    }
		});
		contentPane.add(btnNewButton_3);
		contentPane.setLayout(null);


	}


}
