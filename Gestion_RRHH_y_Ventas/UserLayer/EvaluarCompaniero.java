package UserLayer;

import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DLL.ControllerEvaluacion;
import LogicLayer.Operativo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluarCompaniero extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EvaluarCompaniero frame = new EvaluarCompaniero();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EvaluarCompaniero() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Elija su compañero:");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setBounds(115, 57, 209, 21);
		contentPane.add(lblNewLabel);

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(115, 88, 209, 20);
		contentPane.add(comboBox);

		ControllerEvaluacion ce = new ControllerEvaluacion();

		int idOperativoLog = 1; // temporal

		LinkedList<Operativo> integrantes =
				ce.mostrarIntegrantesEquipo(idOperativoLog);

		for (Operativo op : integrantes) {
			comboBox.addItem(op.getNombre() + " " + op.getApellido());
		}

		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.setBounds(115, 132, 101, 20);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Operativo seleccionado =
						integrantes.get(comboBox.getSelectedIndex());

				System.out.println("ID seleccionado: " + seleccionado.getIdOperativo());
				System.out.println("Nombre: " + seleccionado.getNombre());
				
				PreguntasCompaniero preguntas =
						new PreguntasCompaniero(seleccionado);

				preguntas.setVisible(true);
				dispose();
			}
		});

		contentPane.add(btnNewButton);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(223, 132, 101, 20);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MiembroDelProyecto menu = new MiembroDelProyecto();
				menu.setVisible(true);
				dispose();
			}
		});

		contentPane.add(btnCancelar);
	}
}