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
import javax.swing.JFormattedTextField;

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
		setBounds(100, 100, 472, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblComentarios = new JLabel("Caja de comentarios");
		lblComentarios.setFont(new Font("Verdana", Font.BOLD, 18));
		lblComentarios.setBounds(104, 10, 224, 33);
		contentPane.add(lblComentarios);
		
		JLabel lblEscribaUnComentario = new JLabel("Escriba un comentario sobre el clima laboral");
		lblEscribaUnComentario.setFont(new Font("Verdana", Font.BOLD, 16));
		lblEscribaUnComentario.setBounds(26, 75, 408, 26);
		contentPane.add(lblEscribaUnComentario);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 111, 438, 26);
		contentPane.add(textField);
		
		JLabel lblSentimiento = new JLabel("Sentimiento");
		lblSentimiento.setFont(new Font("Verdana", Font.BOLD, 16));
		lblSentimiento.setBounds(168, 146, 108, 26);
		contentPane.add(lblSentimiento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
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

	}

}
