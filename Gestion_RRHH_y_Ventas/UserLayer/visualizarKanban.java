package UserLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JList;
import javax.swing.JProgressBar;

public class visualizarKanban extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					visualizarKanban frame = new visualizarKanban();
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
	public visualizarKanban() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre de la Tarea");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel.setBounds(28, 10, 129, 26);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setBounds(28, 46, 163, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBackground(new Color(138, 215, 150));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(139, 228, 106, 40);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(215, 138, 138));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.setBounds(255, 228, 106, 40);
		contentPane.add(btnCancelar);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDescripcion.setBounds(28, 77, 129, 26);
		contentPane.add(lblDescripcion);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(28, 113, 163, 21);
		contentPane.add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setBounds(28, 180, 163, 20);
		contentPane.add(comboBox);
		
		JLabel lblSeleccioneElProyecto = new JLabel("Seleccione el proyecto");
		lblSeleccioneElProyecto.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSeleccioneElProyecto.setBounds(28, 144, 152, 26);
		contentPane.add(lblSeleccioneElProyecto);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(246, 46, 163, 21);
		contentPane.add(textField_2);
		
		JLabel lblSeleccioneFechaDe = new JLabel("Seleccione fecha de inicio (AAAA-MM-DD)");
		lblSeleccioneFechaDe.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSeleccioneFechaDe.setBounds(219, 10, 277, 26);
		contentPane.add(lblSeleccioneFechaDe);
		
		JLabel lblSeleccioneFechaDe_2 = new JLabel("Seleccione fecha de fin (AAAA-MM-DD)");
		lblSeleccioneFechaDe_2.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSeleccioneFechaDe_2.setBounds(219, 77, 262, 26);
		contentPane.add(lblSeleccioneFechaDe_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(246, 113, 163, 21);
		contentPane.add(textField_3);

	}
}
