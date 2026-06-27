package UserLayer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Comentar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Comentar frame = new Comentar();
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
	public Comentar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblComentarios = new JLabel("Caja de comentarios");
		lblComentarios.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblComentarios.setBounds(126, 10, 190, 33);
		contentPane.add(lblComentarios);
		
		JLabel lblEscribaUnComentario = new JLabel("Escriba un comentario sobre el clima laboral");
		lblEscribaUnComentario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEscribaUnComentario.setBounds(78, 75, 315, 26);
		contentPane.add(lblEscribaUnComentario);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 111, 438, 26);
		contentPane.add(textField);
		
		JLabel lblSentimiento = new JLabel("Sentimiento");
		lblSentimiento.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSentimiento.setBounds(168, 146, 108, 26);
		contentPane.add(lblSentimiento);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Positivo");
		comboBox.addItem("Negativo");
		comboBox.addItem("Neutro");
		comboBox.setBounds(140, 182, 163, 26);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(138, 215, 150));
		btnNewButton.setBounds(106, 243, 106, 40);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.setBackground(new Color(215, 138, 138));
		btnCancelar.setBounds(222, 243, 106, 40);
		contentPane.add(btnCancelar);
		
		textField = new JTextField();
		textField.setBounds(36, 111, 398, 25);
		contentPane.add(textField);
		textField.setColumns(10);

		
	}
}
