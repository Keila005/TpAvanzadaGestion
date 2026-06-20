package UserLayer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class registrarReunion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarReunion frame = new registrarReunion();
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
	public registrarReunion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre de la reunion");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel.setBounds(28, 22, 169, 26);
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
		lblDescripcion.setBounds(28, 106, 129, 26);
		contentPane.add(lblDescripcion);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(28, 113, 163, 21);
		contentPane.add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setBounds(254, 58, 163, 26);
		contentPane.add(comboBox);
		
		JLabel lblSeleccioneElProyecto = new JLabel("Seleccione el proyecto");
		lblSeleccioneElProyecto.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSeleccioneElProyecto.setBounds(255, 22, 152, 26);
		contentPane.add(lblSeleccioneElProyecto);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(246, 46, 163, 21);
		contentPane.add(textField_2);
		
		JLabel lblSeleccioneFechaDe = new JLabel("Fecha (AAAA-MM-DD)");
		lblSeleccioneFechaDe.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSeleccioneFechaDe.setBounds(255, 106, 152, 26);
		contentPane.add(lblSeleccioneFechaDe);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(246, 113, 163, 21);
		contentPane.add(textField_3);
		
		textField = new JTextField();
		textField.setBounds(28, 46, 163, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(28, 113, 169, 18);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(219, 113, 277, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(219, 41, 277, 26);
		contentPane.add(textField_3);
		
		textField = new JTextField();
		textField.setBounds(28, 58, 169, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(28, 142, 169, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(255, 142, 169, 26);
		contentPane.add(textField_2);

	}

}
