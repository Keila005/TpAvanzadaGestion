package UserLayer;

import java.awt.Color;
import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

<<<<<<< Updated upstream
import LogicLayer.Tarea;
import DLL.ControllerTarea;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
	private ArrayList<Tarea> tareasAsignadas;
	private Tarea tareaSeleccionada;
	private ControllerTarea tareaController;
=======
import DLL.ControllerTarea;
import LogicLayer.Tarea;
import LogicLayer.Usuario;

public class visualizarKanban extends JFrame {

    private static final long serialVersionUID = 1L;
>>>>>>> Stashed changes

    private JPanel contentPane;

<<<<<<< Updated upstream
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
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setBounds(28, 87, 163, 21);
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
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(28, 134, 163, 21);
		contentPane.add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setBounds(154, 46, 204, 31);
		contentPane.add(comboBox);
		
		JLabel lblSeleccioneElProyecto = new JLabel("Seleccione una tarea");
		lblSeleccioneElProyecto.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSeleccioneElProyecto.setBounds(188, 10, 152, 26);
		contentPane.add(lblSeleccioneElProyecto);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(246, 87, 163, 21);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(246, 134, 163, 21);
		contentPane.add(textField_3);
		
		JButton btnTrabajar = new JButton("TRABAJAR");
		btnTrabajar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTrabajar.setBackground(new Color(65, 105, 225));
		btnTrabajar.setBounds(188, 165, 106, 40);
		
		btnTrabajar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        if (tareaSeleccionada == null) return;

		        tareaSeleccionada.trabajar();
		        tareaController.trabajarTarea(tareaSeleccionada.getIdTarea());

		        textField_2.setText(String.valueOf(tareaSeleccionada.getSesionesTrabajo()));
		    }
		});
		
		contentPane.add(btnTrabajar);
=======
    private Usuario usuario;
>>>>>>> Stashed changes

    private JComboBox<Tarea> comboTareas;

    private LinkedList<Tarea> tareasAsignadas;

    private ControllerTarea controllerTarea = new ControllerTarea();

    public visualizarKanban(Usuario usuario) {

        this.usuario = usuario;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 250);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("MIS TAREAS");
        lblTitulo.setFont(new Font("Verdana", Font.BOLD, 16));
        lblTitulo.setBounds(180, 20, 113, 30);
        contentPane.add(lblTitulo);

        comboTareas = new JComboBox<>();
        comboTareas.setBounds(54, 66, 380, 30);
        contentPane.add(comboTareas);

        JButton btnTrabajar = new JButton("TRABAJAR");
        btnTrabajar.setBackground(new Color(65, 105, 225));
        btnTrabajar.setBounds(170, 140, 140, 35);
        contentPane.add(btnTrabajar);

        cargarTareas(usuario.getIdUsuario());

        btnTrabajar.addActionListener(e -> {

            Tarea tarea = (Tarea) comboTareas.getSelectedItem();

            if (tarea == null) {
                JOptionPane.showMessageDialog(null,
                        "Seleccione una tarea");
                return;
            }

            controllerTarea.trabajarTarea(tarea.getIdTarea());

            JOptionPane.showMessageDialog(null,
                    "Tarea actualizada");

            cargarTareas(usuario.getIdUsuario());
        });
    }

    private void cargarTareas(int idEmpleado) {

        comboTareas.removeAllItems();

        tareasAsignadas =
                controllerTarea.obtenerTareasEmpleado(idEmpleado);

        for (Tarea t : tareasAsignadas) {

            comboTareas.addItem(t);
        }
    }
}