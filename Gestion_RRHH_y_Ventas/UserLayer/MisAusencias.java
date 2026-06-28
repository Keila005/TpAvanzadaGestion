package UserLayer;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.sql.ResultSet;
import DLL.ControllerAsistencia;
import LogicLayer.Usuario;

public class MisAusencias extends VentanaBase {


	private static final long serialVersionUID = 1L;

	public MisAusencias(Usuario usuario) {

		JLabel lblTitulo = new JLabel("Mis Ausencias");
		lblTitulo.setForeground(new Color(0, 91, 0));
		lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
		lblTitulo.setBounds(330, 60, 250, 30);
		contentPane.add(lblTitulo);

		

//		JLabel lblFecha2 = new JLabel("• 03/04/2026 - Ausencia");
//		lblFecha2.setForeground(new Color(80, 80, 80));
//		lblFecha2.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
//		lblFecha2.setBounds(250, 180, 350, 25);
//		contentPane.add(lblFecha2);
//
//		JLabel lblFecha3 = new JLabel("• 18/02/2026 - Ausencia");
//		lblFecha3.setForeground(new Color(80, 80, 80));
//		lblFecha3.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
//		lblFecha3.setBounds(250, 220, 350, 25);
//		contentPane.add(lblFecha3);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setBackground(new Color(0, 91, 0));
		btnAceptar.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
		btnAceptar.setBounds(350, 330, 150, 45);
		btnAceptar.setBorder(null);
		btnAceptar.setFocusPainted(false);
		btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnAceptar.setBackground(new Color(20, 110, 12));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnAceptar.setBackground(new Color(0, 91, 0));
			}
		});

		btnAceptar.addActionListener(e -> dispose());

		contentPane.add(btnAceptar);

		ControllerAsistencia asis = new ControllerAsistencia();

		int idEmpleado = asis.getIdEmpleadoByUsuario(usuario.getIdUsuario());

		try {

		    ResultSet rs = asis.getAusenciasPorEmpleado(idEmpleado);

		    int y = 140;
		    boolean tieneAusencias = false;
		    while(rs.next()){

		        tieneAusencias = true;

		        JLabel lblFecha = new JLabel("• " + rs.getString("fecha") + " - Ausencia");
		        lblFecha.setForeground(new Color(80,80,80));
		        lblFecha.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
		        lblFecha.setBounds(250,y,350,25);
		        contentPane.add(lblFecha);
		        y += 35;
		    }
		    if(!tieneAusencias){
		        JLabel lbl = new JLabel("No posee ausencias registradas.");
		        lbl.setForeground(new Color(80,80,80));
		        lbl.setFont(new Font("Helvetica Neue", Font.PLAIN,18));
		        lbl.setBounds(250,140,350,25);

		        contentPane.add(lbl);
		    }

		}catch(Exception e){
		    e.printStackTrace();
		}
		
		JButton btnVolver = crearBotonRojo(
				"Volver",
				EstilosGlobales.ANCHO_VENTANA - 130,
				EstilosGlobales.ALTO_VENTANA - 55,
				110,
				35);

		btnVolver.addActionListener(e -> dispose());

		contentPane.add(btnVolver);

		seleccionarTabPorIndice(0);
	}

}
