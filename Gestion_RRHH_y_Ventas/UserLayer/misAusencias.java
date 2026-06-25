package UserLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LogicLayer.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class misAusencias extends JFrame {

	private Usuario usuario;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					misAusencias frame = new misAusencias();
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
	public misAusencias() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mis Ausencias");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setBounds(120, 20, 153, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Fecha: ");
		lblNewLabel_1_2_1.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_1_2_1.setBounds(38, 72, 356, 23);
		contentPane.add(lblNewLabel_1_2_1);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(142, 184, 131, 39);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verInformacionPersonal verInformacionPersonal = new verInformacionPersonal(usuario);
				verInformacionPersonal.setVisible(true);
				dispose();
			}
			
		});
		contentPane.add(btnNewButton);

	}

}
