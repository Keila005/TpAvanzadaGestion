package UserLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;

public class SolicitarVacaciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SolicitarVacaciones frame = new SolicitarVacaciones();
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
	public SolicitarVacaciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDiaDeInicio = new JLabel("Dia de Inicio");
		lblDiaDeInicio.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDiaDeInicio.setBounds(201, 48, 152, 26);
		contentPane.add(lblDiaDeInicio);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(201, 84, 169, 26);
		contentPane.add(textField);
		
		JLabel lblTipo = new JLabel("Tipo de Solicitud");
		lblTipo.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTipo.setBounds(11, 48, 152, 26);
		contentPane.add(lblTipo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setBounds(10, 84, 163, 26);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(138, 215, 150));
		btnNewButton.setBounds(177, 314, 106, 40);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.setBackground(new Color(215, 138, 138));
		btnCancelar.setBounds(293, 314, 106, 40);
		contentPane.add(btnCancelar);
		
		JLabel lblAoDeInicio = new JLabel("Año de Inicio");
		lblAoDeInicio.setFont(new Font("Verdana", Font.BOLD, 12));
		lblAoDeInicio.setBounds(201, 213, 152, 26);
		contentPane.add(lblAoDeInicio);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(201, 249, 169, 26);
		contentPane.add(textField_1);
		
		JLabel lblSeleccioneFechaDe_1_1 = new JLabel("Mes de Inicio");
		lblSeleccioneFechaDe_1_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSeleccioneFechaDe_1_1.setBounds(201, 132, 152, 26);
		contentPane.add(lblSeleccioneFechaDe_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(201, 168, 169, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(410, 84, 169, 26);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(410, 168, 169, 26);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(410, 249, 169, 26);
		contentPane.add(textField_5);
		
		JLabel lblAoDeFinalizacion = new JLabel("Año de Finalizacion");
		lblAoDeFinalizacion.setFont(new Font("Verdana", Font.BOLD, 12));
		lblAoDeFinalizacion.setBounds(410, 213, 152, 26);
		contentPane.add(lblAoDeFinalizacion);
		
		JLabel lblSeleccioneFechaDe_1_1_1 = new JLabel("Mes de Finalizacion");
		lblSeleccioneFechaDe_1_1_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSeleccioneFechaDe_1_1_1.setBounds(410, 132, 152, 26);
		contentPane.add(lblSeleccioneFechaDe_1_1_1);
		
		JLabel lblDiaDeFinalizacion = new JLabel("Dia de Finalizacion");
		lblDiaDeFinalizacion.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDiaDeFinalizacion.setBounds(410, 48, 152, 26);
		contentPane.add(lblDiaDeFinalizacion);
		
		JLabel lblSolicitarPermisosO = new JLabel("Solicitar permisos o vacaciones");
		lblSolicitarPermisosO.setFont(new Font("Verdana", Font.BOLD, 18));
		lblSolicitarPermisosO.setBounds(131, 10, 335, 33);
		contentPane.add(lblSolicitarPermisosO);

	}

}
