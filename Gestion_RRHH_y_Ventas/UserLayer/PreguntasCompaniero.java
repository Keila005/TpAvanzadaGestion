package UserLayer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import LogicLayer.Operativo;
import javax.swing.ButtonGroup;
import LogicLayer.Operativo;
import LogicLayer.Evaluacion360;
import DLL.ControllerEvaluacion;


public class PreguntasCompaniero extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private Operativo evaluado;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Operativo op = new Operativo();
					PreguntasCompaniero frame = new PreguntasCompaniero(op);					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PreguntasCompaniero(Operativo evaluado) {

	    this.evaluado = evaluado;

	    
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Afirmativo");
		chckbxNewCheckBox.setBounds(82, 33, 102, 20);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel = new JLabel("Cumple sus tareas a tiempo?");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 416, 31);
		contentPane.add(lblNewLabel);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Negativo");
		chckbxNewCheckBox_1.setBounds(228, 33, 102, 20);
		contentPane.add(chckbxNewCheckBox_1);
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					chckbxNewCheckBox_1.setSelected(false);
				}
			}
		});

		chckbxNewCheckBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_1.isSelected()) {
					chckbxNewCheckBox.setSelected(false);
				}
			}
		});
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Yes");
		chckbxNewCheckBox_2.setBounds(82, 78, 102, 20);
		contentPane.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("No");
		chckbxNewCheckBox_1_1.setBounds(228, 78, 102, 20);
		contentPane.add(chckbxNewCheckBox_1_1);
		chckbxNewCheckBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_2.isSelected()) {
					chckbxNewCheckBox_1_1.setSelected(false);
				}
			}
		});

		chckbxNewCheckBox_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_1_1.isSelected()) {
					chckbxNewCheckBox_2.setSelected(false);
				}
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Asiste regularmente al trabajo grupal?");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 55, 416, 31);
		contentPane.add(lblNewLabel_1);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Asi merito");
		chckbxNewCheckBox_3.setBounds(82, 123, 102, 20);
		
		contentPane.add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_1_2 = new JCheckBox("Nel");
		chckbxNewCheckBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_3.isSelected()) {
					chckbxNewCheckBox_1_2.setSelected(false);
				}
			}
		});

		chckbxNewCheckBox_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_1_2.isSelected()) {
					chckbxNewCheckBox_3.setSelected(false);
				}
			}
		});
		chckbxNewCheckBox_1_2.setBounds(228, 123, 102, 20);
		contentPane.add(chckbxNewCheckBox_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("Apoya a sus compañeros si es necesario?");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 100, 416, 31);
		contentPane.add(lblNewLabel_2);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Ponele");
		chckbxNewCheckBox_4.setBounds(82, 168, 102, 20);
		contentPane.add(chckbxNewCheckBox_4);
		
		JCheckBox chckbxNewCheckBox_1_3 = new JCheckBox("Ni a gancho");
		chckbxNewCheckBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_4.isSelected()) {
					chckbxNewCheckBox_1_3.setSelected(false);
				}
			}
		});

		chckbxNewCheckBox_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_1_3.isSelected()) {
					chckbxNewCheckBox_4.setSelected(false);
				}
			}
		});
		chckbxNewCheckBox_1_3.setBounds(228, 168, 102, 20);
		contentPane.add(chckbxNewCheckBox_1_3);
		
		JLabel lblNewLabel_3 = new JLabel("Se comunica de forma clara?");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(33, 145, 348, 31);
		contentPane.add(lblNewLabel_3);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("De una");
		chckbxNewCheckBox_5.setBounds(82, 213, 102, 20);
		contentPane.add(chckbxNewCheckBox_5);
		
		JCheckBox chckbxNewCheckBox_1_4 = new JCheckBox("Ni ahi");
		chckbxNewCheckBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_5.isSelected()) {
					chckbxNewCheckBox_1_4.setSelected(false);
				}
			}
		});

		chckbxNewCheckBox_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_1_4.isSelected()) {
					chckbxNewCheckBox_5.setSelected(false);
				}
			}
		});
		chckbxNewCheckBox_1_4.setBounds(228, 213, 102, 20);
		contentPane.add(chckbxNewCheckBox_1_4);
		
		JLabel lblNewLabel_4 = new JLabel("Escucha y respeta las opiniones de otros?");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 190, 416, 31);
		contentPane.add(lblNewLabel_4);
		
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("aja");
		chckbxNewCheckBox_6.setBounds(82, 258, 102, 20);
		contentPane.add(chckbxNewCheckBox_6);
		
		JCheckBox chckbxNewCheckBox_1_5 = new JCheckBox("No papu");
		chckbxNewCheckBox_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_6.isSelected()) {
					chckbxNewCheckBox_1_5.setSelected(false);
				}
			}
		});

		chckbxNewCheckBox_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_1_5.isSelected()) {
					chckbxNewCheckBox_6.setSelected(false);
				}
			}
		});
		chckbxNewCheckBox_1_5.setBounds(228, 258, 102, 20);
		contentPane.add(chckbxNewCheckBox_1_5);
		
		JLabel lblNewLabel_5 = new JLabel("Muestra iniciativa en su trabajo?");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 235, 416, 31);
		contentPane.add(lblNewLabel_5);
		
		JCheckBox chckbxNewCheckBox_7 = new JCheckBox("siii!!!!!11");
		chckbxNewCheckBox_7.setBounds(82, 303, 102, 20);
		contentPane.add(chckbxNewCheckBox_7);
		
		JCheckBox chckbxNewCheckBox_1_6 = new JCheckBox("noo9oo");
		chckbxNewCheckBox_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_7.isSelected()) {
					chckbxNewCheckBox_1_6.setSelected(false);
				}
			}
		});

		chckbxNewCheckBox_1_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_1_6.isSelected()) {
					chckbxNewCheckBox_7.setSelected(false);
				}
			}
		});
		chckbxNewCheckBox_1_6.setBounds(228, 303, 102, 20);
		contentPane.add(chckbxNewCheckBox_1_6);
		
		JLabel lblNewLabel_6 = new JLabel("Se adapta a cambios en el proyecto?");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(43, 280, 338, 31);
		contentPane.add(lblNewLabel_6);
		
		JCheckBox chckbxNewCheckBox_8 = new JCheckBox("confirmo");
		chckbxNewCheckBox_8.setBounds(82, 348, 102, 20);
		contentPane.add(chckbxNewCheckBox_8);
		
		JCheckBox chckbxNewCheckBox_1_7 = new JCheckBox("niego rotundamente");
		chckbxNewCheckBox_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_8.isSelected()) {
					chckbxNewCheckBox_1_7.setSelected(false);
				}
			}
		});

		chckbxNewCheckBox_1_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_1_7.isSelected()) {
					chckbxNewCheckBox_8.setSelected(false);
				}
			}
		});
		chckbxNewCheckBox_1_7.setBounds(228, 348, 141, 20);
		contentPane.add(chckbxNewCheckBox_1_7);
		
		JLabel lblNewLabel_7 = new JLabel("Mantiene una actitud responsable?");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(10, 325, 416, 31);
		contentPane.add(lblNewLabel_7);
		
		JCheckBox chckbxNewCheckBox_9 = new JCheckBox("si papu");
		chckbxNewCheckBox_9.setBounds(82, 393, 102, 20);
		contentPane.add(chckbxNewCheckBox_9);
		
		JCheckBox chckbxNewCheckBox_1_8 = new JCheckBox("no papu x2");
		chckbxNewCheckBox_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_9.isSelected()) {
					chckbxNewCheckBox_1_8.setSelected(false);
				}
			}
		});

		chckbxNewCheckBox_1_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_1_8.isSelected()) {
					chckbxNewCheckBox_9.setSelected(false);
				}
			}
		});
		chckbxNewCheckBox_1_8.setBounds(228, 393, 102, 20);
		contentPane.add(chckbxNewCheckBox_1_8);
		
		JLabel lblNewLabel_8 = new JLabel("Cumple con su rol dentro del equipo?");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(10, 370, 416, 31);
		contentPane.add(lblNewLabel_8);
		
		JCheckBox chckbxNewCheckBox_10 = new JCheckBox("siiiiiiiiiiii");
		chckbxNewCheckBox_10.setBounds(82, 438, 102, 20);
		contentPane.add(chckbxNewCheckBox_10);
		
		JCheckBox chckbxNewCheckBox_1_9 = new JCheckBox("nooooooooooooo");
		chckbxNewCheckBox_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_10.isSelected()) {
					chckbxNewCheckBox_1_9.setSelected(false);
				}
			}
		});

		chckbxNewCheckBox_1_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_1_9.isSelected()) {
					chckbxNewCheckBox_10.setSelected(false);
				}
			}
		});
		chckbxNewCheckBox_1_9.setBounds(228, 438, 153, 20);
		contentPane.add(chckbxNewCheckBox_1_9);
		
		JLabel lblNewLabel_9 = new JLabel("Contribuye positivamente al resultado del proyecto?");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(10, 415, 416, 31);
		contentPane.add(lblNewLabel_9);
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.setBounds(280, 490, 102, 20);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("=== BOTÓN CONTINUAR ===");
		        System.out.println("ID de evaluado ANTES: " + evaluado.getIdOperativo());
		        System.out.println("Nombre de evaluado ANTES: " + evaluado.getNombre());


				int[] respuestas = new int[10];

				respuestas[0] = chckbxNewCheckBox.isSelected() ? 1 : 0;
				respuestas[1] = chckbxNewCheckBox_2.isSelected() ? 1 : 0;
				respuestas[2] = chckbxNewCheckBox_3.isSelected() ? 1 : 0;
				respuestas[3] = chckbxNewCheckBox_4.isSelected() ? 1 : 0;
				respuestas[4] = chckbxNewCheckBox_5.isSelected() ? 1 : 0;
				respuestas[5] = chckbxNewCheckBox_6.isSelected() ? 1 : 0;
				respuestas[6] = chckbxNewCheckBox_7.isSelected() ? 1 : 0;
				respuestas[7] = chckbxNewCheckBox_8.isSelected() ? 1 : 0;
				respuestas[8] = chckbxNewCheckBox_9.isSelected() ? 1 : 0;
				respuestas[9] = chckbxNewCheckBox_10.isSelected() ? 1 : 0;

				String comentario = textField.getText();

				Operativo evaluador = new Operativo();
				evaluador.setIdOperativo(1);
				System.out.println("ID de evaluado DESPUÉS: " + evaluado.getIdOperativo());
		        


				Evaluacion360 eva =
						new Evaluacion360(
								evaluador,
								evaluado,
								respuestas,
								comentario);
				System.out.println("Evaluador: " + evaluador.getIdOperativo());
				System.out.println("Evaluado: " + evaluado.getIdOperativo());

				ControllerEvaluacion ce =
						new ControllerEvaluacion();

				ce.guardarEvaluacion(eva);

				ConfirmacionCompaniero confirmacion =
						new ConfirmacionCompaniero();

				confirmacion.setVisible(true);

				dispose();
				dispose();
			}
		});
		contentPane.add(btnNewButton);
		
		
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(426, 490, 102, 20);

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EvaluarCompaniero volver = new EvaluarCompaniero();

				volver.setVisible(true);

				dispose();
			}
		});

		contentPane.add(btnVolver);
		
		JLabel lblNewLabel_2_1 = new JLabel("Agregue un comentario:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(408, 78, 265, 31);
		contentPane.add(lblNewLabel_2_1);
		textField = new JTextField();
		textField.setBounds(408, 120, 200, 30);
		contentPane.add(textField);

	}
}
