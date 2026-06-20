package UserLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class cargo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cargo frame = new cargo();
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
	public cargo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("lider del proyecto");
		btnNewButton.setBounds(60, 91, 136, 44);
		contentPane.add(btnNewButton);
		
		JButton btnMiembroDelProyecto = new JButton("miembro del proyecto");
		btnMiembroDelProyecto.setBounds(236, 91, 136, 44);
		contentPane.add(btnMiembroDelProyecto);
		
		JButton btnNewButton_2 = new JButton("Volver");
		btnNewButton_2.setBounds(312, 208, 114, 34);
		contentPane.add(btnNewButton_2);

	}

}
