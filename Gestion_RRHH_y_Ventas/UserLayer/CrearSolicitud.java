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
	JComboBox<String> comboDiaInicio = new JComboBox<>();
	JComboBox<String> comboMesInicio = new JComboBox<>();
	JComboBox<String> comboAnioInicio = new JComboBox<>();

	JComboBox<String> comboDiaFin = new JComboBox<>();
	JComboBox<String> comboMesFin = new JComboBox<>();
	JComboBox<String> comboAnioFin = new JComboBox<>();
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
		
		JLabel lblDiaInicio = new JLabel("Día de Inicio");
		lblDiaInicio.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDiaInicio.setBounds(200, 50, 120, 20);
		lblDiaInicio.setVisible(false);
		contentPane.add(lblDiaInicio);

		JLabel lblMesInicio = new JLabel("Mes de Inicio");
		lblMesInicio.setFont(new Font("Verdana", Font.BOLD, 12));
		lblMesInicio.setBounds(200, 115, 120, 20);
		lblMesInicio.setVisible(false);
		contentPane.add(lblMesInicio);

		JLabel lblAnioInicio = new JLabel("Año de Inicio");
		lblAnioInicio.setFont(new Font("Verdana", Font.BOLD, 12));
		lblAnioInicio.setBounds(200, 180, 120, 20);
		lblAnioInicio.setVisible(false);
		contentPane.add(lblAnioInicio);

		JLabel lblDiaFin = new JLabel("Día de Finalización");
		lblDiaFin.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDiaFin.setBounds(386, 50, 150, 20);
		lblDiaFin.setVisible(false);
		contentPane.add(lblDiaFin);

		JLabel lblMesFin = new JLabel("Mes de Finalización");
		lblMesFin.setFont(new Font("Verdana", Font.BOLD, 12));
		lblMesFin.setBounds(386, 115, 150, 20);
		lblMesFin.setVisible(false);
		contentPane.add(lblMesFin);

		JLabel lblAnioFin = new JLabel("Año de Finalización");
		lblAnioFin.setFont(new Font("Verdana", Font.BOLD, 12));
		lblAnioFin.setBounds(386, 180, 150, 20);
		lblAnioFin.setVisible(false);
		contentPane.add(lblAnioFin);
		
		JLabel lblInstitucion = new JLabel("Institución:");
		lblInstitucion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInstitucion.setBounds(200, 269, 115, 26);
		lblInstitucion.setVisible(false);
		contentPane.add(lblInstitucion);
		
		JLabel lblMateria = new JLabel("Materia:");
		lblMateria.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMateria.setBounds(391, 269, 115, 26);
		lblMateria.setVisible(false);
		contentPane.add(lblMateria);
		
		JLabel lblTipoEstudio = new JLabel("Tipo Estudio:");
		lblTipoEstudio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipoEstudio.setBounds(200, 269, 115, 26);
		lblTipoEstudio.setVisible(false);
		contentPane.add(lblTipoEstudio);
		
		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDireccion.setBounds(200, 269, 115, 26);
		lblDireccion.setVisible(false);
		contentPane.add(lblDireccion);
		
		JLabel lblOrganismo = new JLabel("Organismo:");
		lblOrganismo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOrganismo.setBounds(200, 269, 115, 26);
		lblOrganismo.setVisible(false); 
		contentPane.add(lblOrganismo);
		
		comboDiaInicio.setBounds(200, 75, 120, 25);
		comboDiaInicio.setVisible(false);
		contentPane.add(comboDiaInicio);

		comboMesInicio.setBounds(200, 140, 120, 25);
		comboMesInicio.setVisible(false);
		contentPane.add(comboMesInicio);

		comboAnioInicio.setBounds(200, 205, 120, 25);
		comboAnioInicio.setVisible(false);
		contentPane.add(comboAnioInicio);

		comboDiaFin.setBounds(386, 75, 120, 25);
		comboDiaFin.setVisible(false);
		contentPane.add(comboDiaFin);

		comboMesFin.setBounds(386, 140, 120, 25);
		comboMesFin.setVisible(false);
		contentPane.add(comboMesFin);

		comboAnioFin.setBounds(386, 205, 120, 25);
		comboAnioFin.setVisible(false);
		contentPane.add(comboAnioFin);
		
		textField_3 = new JTextField(); //Institución
		textField_3.setColumns(10);
		textField_3.setBounds(200, 308, 101, 18);
		textField_3.setVisible(false);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField(); //Materia
		textField_4.setColumns(10);
		textField_4.setBounds(391, 308, 101, 18);
		textField_4.setVisible(false);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField(); //Tipo de Estudio
		textField_5.setBounds(200, 308, 101, 18);
		textField_5.setVisible(false);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField(); //Dirección
		textField_6.setColumns(10);
		textField_6.setBounds(200, 308, 101, 18);
		textField_6.setVisible(false);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField(); //Organismo
		textField_7.setColumns(10);
		textField_7.setBounds(200, 308, 101, 18);
		textField_7.setVisible(false);
		contentPane.add(textField_7);
		
		for (int i = 1; i <= 31; i++) {

		    String valor = String.format("%02d", i);

		    comboDiaInicio.addItem(valor);
		    comboDiaFin.addItem(valor);
		}

		for (int i = 1; i <= 12; i++) {

		    String valor = String.format("%02d", i);

		    comboMesInicio.addItem(valor);
		    comboMesFin.addItem(valor);
		}

		for (int i = 2026; i <= 2035; i++) {

		    comboAnioInicio.addItem(String.valueOf(i));
		    comboAnioFin.addItem(String.valueOf(i));
		}
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblDiaInicio.setVisible(false);
				comboDiaInicio.setVisible(false);

				lblMesInicio.setVisible(false);
				comboMesInicio.setVisible(false);

				lblAnioInicio.setVisible(false);
				comboAnioInicio.setVisible(false);

				lblDiaFin.setVisible(false);
				comboDiaFin.setVisible(false);

				lblMesFin.setVisible(false);
				comboMesFin.setVisible(false);

				lblAnioFin.setVisible(false);
				comboAnioFin.setVisible(false);

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

					lblDiaInicio.setVisible(true);
					comboDiaInicio.setVisible(true);

					lblMesInicio.setVisible(true);
					comboMesInicio.setVisible(true);

					lblAnioInicio.setVisible(true);
					comboAnioInicio.setVisible(true);

					lblDiaFin.setVisible(true);
					comboDiaFin.setVisible(true);

					lblMesFin.setVisible(true);
					comboMesFin.setVisible(true);

					lblAnioFin.setVisible(true);
					comboAnioFin.setVisible(true);
					break;

				case 2:

					lblDiaInicio.setVisible(true);
					comboDiaInicio.setVisible(true);

					lblMesInicio.setVisible(true);
					comboMesInicio.setVisible(true);

					lblAnioInicio.setVisible(true);
					comboAnioInicio.setVisible(true);

					lblDiaFin.setVisible(true);
					comboDiaFin.setVisible(true);

					lblMesFin.setVisible(true);
					comboMesFin.setVisible(true);

					lblAnioFin.setVisible(true);
					comboAnioFin.setVisible(true);

					lblInstitucion.setVisible(true);
					textField_3.setVisible(true);

					lblMateria.setVisible(true);
					textField_4.setVisible(true);
					break;

				case 3:

					lblDiaInicio.setVisible(true);
					comboDiaInicio.setVisible(true);

					lblMesInicio.setVisible(true);
					comboMesInicio.setVisible(true);

					lblAnioInicio.setVisible(true);
					comboAnioInicio.setVisible(true);

					lblDiaFin.setVisible(true);
					comboDiaFin.setVisible(true);

					lblMesFin.setVisible(true);
					comboMesFin.setVisible(true);

					lblAnioFin.setVisible(true);
					comboAnioFin.setVisible(true);

					lblTipoEstudio.setVisible(true);
					textField_5.setVisible(true);
					break;

				case 4:

					lblDiaInicio.setVisible(true);
					comboDiaInicio.setVisible(true);

					lblMesInicio.setVisible(true);
					comboMesInicio.setVisible(true);

					lblAnioInicio.setVisible(true);
					comboAnioInicio.setVisible(true);

					lblDiaFin.setVisible(true);
					comboDiaFin.setVisible(true);

					lblMesFin.setVisible(true);
					comboMesFin.setVisible(true);

					lblAnioFin.setVisible(true);
					comboAnioFin.setVisible(true);
					break;

				case 5:

					lblDireccion.setVisible(true);
					textField_6.setVisible(true);

					lblDiaInicio.setVisible(true);
					comboDiaInicio.setVisible(true);

					lblMesInicio.setVisible(true);
					comboMesInicio.setVisible(true);

					lblAnioInicio.setVisible(true);
					comboAnioInicio.setVisible(true);

					lblDiaFin.setVisible(true);
					comboDiaFin.setVisible(true);

					lblMesFin.setVisible(true);
					comboMesFin.setVisible(true);

					lblAnioFin.setVisible(true);
					comboAnioFin.setVisible(true);
					break;

				case 6:

					lblOrganismo.setVisible(true);
					textField_7.setVisible(true);

					lblDiaInicio.setVisible(true);
					comboDiaInicio.setVisible(true);

					lblMesInicio.setVisible(true);
					comboMesInicio.setVisible(true);

					lblAnioInicio.setVisible(true);
					comboAnioInicio.setVisible(true);

					lblDiaFin.setVisible(true);
					comboDiaFin.setVisible(true);

					lblMesFin.setVisible(true);
					comboMesFin.setVisible(true);

					lblAnioFin.setVisible(true);
					comboAnioFin.setVisible(true);
					break;
				}
			}
		});
		
		

	}
}
