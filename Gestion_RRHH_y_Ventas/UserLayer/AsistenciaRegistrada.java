package UserLayer;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;

public class AsistenciaRegistrada extends VentanaBase {
	private static final long serialVersionUID = 1L;

	public AsistenciaRegistrada() {
		
		JLabel lblTitulo = new JLabel("Asistencia Registrada");
		lblTitulo.setForeground(new Color(0, 91, 0));
		lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 28));
		lblTitulo.setBounds(330, 120, 300, 35);
		contentPane.add(lblTitulo);
		
		JLabel lblSubtitulo = new JLabel("La asistencia ha sido registrada exitosamente");
		lblSubtitulo.setForeground(new Color(120, 120, 120));
		lblSubtitulo.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		lblSubtitulo.setBounds(310, 160, 350, 25);
		contentPane.add(lblSubtitulo);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setBackground(new Color(0, 91, 0));
		btnAceptar.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
		btnAceptar.setBounds(390, 230, 150, 45);
		btnAceptar.setBorder(null);
		btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnAceptar.setFocusPainted(false);
		btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnAceptar.setBackground(new Color(20, 110, 12));
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnAceptar.setBackground(new Color(0, 91, 0));
			}
		});
		btnAceptar.addActionListener(e -> {
			MiembroDelProyecto miembro = new MiembroDelProyecto(null);
			miembro.setVisible(true);
			dispose();
		});
		contentPane.add(btnAceptar);
	}
}