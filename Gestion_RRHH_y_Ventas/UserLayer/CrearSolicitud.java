package UserLayer;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class CrearSolicitud extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearSolicitud frame = new CrearSolicitud();
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
	public CrearSolicitud() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSolicitarPermisosO = new JLabel("Crear Solicitud");
		lblSolicitarPermisosO.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSolicitarPermisosO.setBounds(188, 10, 147, 33);
		contentPane.add(lblSolicitarPermisosO);

		
		JLabel lblTipo = new JLabel("Tipo de Solicitud");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipo.setBounds(11, 48, 101, 26);
		contentPane.add(lblTipo);
		
		
		
		JComboBox <String> comboBox = new JComboBox<String>();
		comboBox.addItem("Seleccione Tipo");
		comboBox.addItem("Vacaciones");
		comboBox.addItem("Día de Estudio");
		comboBox.addItem("Estudios Medicos");
		comboBox.addItem("Licencia por Maternidad");
		comboBox.addItem("Mudanza");
		comboBox.addItem("Trámites Personales");
		comboBox.setBounds(11, 86, 136, 26);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Desde:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(212, 86, 115, 26);
		lblNewLabel.setVisible(false);
		contentPane.add(lblNewLabel);
		
		JLabel lblHasta = new JLabel("Hasta:");
		lblHasta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHasta.setBounds(363, 86, 115, 26);
		contentPane.add(lblHasta);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFecha.setBounds(10, 157, 115, 26);
		contentPane.add(lblFecha);
		
		JLabel lblInstitucion = new JLabel("Institución:");
		lblInstitucion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInstitucion.setBounds(135, 157, 115, 26);
		lblInstitucion.setVisible(false);
		contentPane.add(lblInstitucion);
		
		JLabel lblMateria = new JLabel("Materia:");
		lblMateria.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMateria.setBounds(260, 157, 115, 26);
		lblMateria.setVisible(false);
		contentPane.add(lblMateria);
		
		JLabel lblTipoEstudio = new JLabel("Tipo Estudio:");
		lblTipoEstudio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipoEstudio.setBounds(135, 157, 115, 26);
		lblTipoEstudio.setVisible(false);
		contentPane.add(lblTipoEstudio);
		
		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDireccion.setBounds(135, 157, 115, 26);
		lblDireccion.setVisible(false);
		contentPane.add(lblDireccion);
		
		JLabel lblOrganismo = new JLabel("Organismo:");
		lblOrganismo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOrganismo.setBounds(135, 157, 115, 26);
		lblOrganismo.setVisible(false); 
		contentPane.add(lblOrganismo);
		
		textField = new JTextField(); // Desde
		textField.setBounds(212, 122, 123, 18);
		textField.setVisible(false);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(); //Hasta
		textField_1.setColumns(10);
		textField_1.setBounds(363, 122, 123, 18);
		lblHasta.setVisible(false);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField(); //Fecha
		textField_2.setColumns(10);
		textField_2.setBounds(11, 196, 101, 18);
		lblFecha.setVisible(false);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField(); //Institución
		textField_3.setColumns(10);
		textField_3.setBounds(135, 196, 101, 18);
		lblInstitucion.setVisible(false);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField(); //Materia
		textField_4.setColumns(10);
		textField_4.setBounds(260, 196, 101, 18);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField(); //Tipo de Estudio
		textField_5.setBounds(135, 196, 101, 18);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField(); //Dirección
		textField_6.setColumns(10);
		textField_6.setBounds(135, 196, 101, 18);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField(); //Organismo
		textField_7.setColumns(10);
		textField_7.setBounds(135, 196, 101, 18);
		contentPane.add(textField_7);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblNewLabel.setVisible(false);
				textField.setVisible(false);

				lblHasta.setVisible(false);
				textField_1.setVisible(false);

				lblFecha.setVisible(false);
				textField_2.setVisible(false);

				lblInstitucion.setVisible(false);
				textField_3.setVisible(false);

				lblMateria.setVisible(false);
				textField_4.setVisible(false);

				lblTipoEstudio.setVisible(false);
				textField_5.setVisible(false);

				lblDireccion.setVisible(false);
				textField_6.setVisible(false);

				lblOrganismo.setVisible(false);
				textField_7.setVisible(false);

				switch (comboBox.getSelectedIndex()) {

				case 0:
					
					break;

				case 1:

					lblNewLabel.setVisible(true);
					textField.setVisible(true);

					lblHasta.setVisible(true);
					textField_1.setVisible(true);
					break;

				case 2:

					lblFecha.setVisible(true);
					textField_2.setVisible(true);

					lblInstitucion.setVisible(true);
					textField_3.setVisible(true);

					lblMateria.setVisible(true);
					textField_4.setVisible(true);
					break;

				case 3:

					lblFecha.setVisible(true);
					textField_2.setVisible(true);

					lblTipoEstudio.setVisible(true);
					textField_5.setVisible(true);
					break;

				case 4:

					lblNewLabel.setVisible(true);
					textField.setVisible(true);

					lblHasta.setVisible(true);
					textField_1.setVisible(true);
					break;

				case 5:

					lblDireccion.setVisible(true);
					textField_6.setVisible(true);

					lblFecha.setVisible(true);
					textField_2.setVisible(true);
					break;

				case 6:

					lblOrganismo.setVisible(true);
					textField_7.setVisible(true);

					lblFecha.setVisible(true);
					textField_2.setVisible(true);
					break;
				}
			}
		});
		
		

	}
}
