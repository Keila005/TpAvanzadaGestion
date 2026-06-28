package UserLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import LogicLayer.Operativo;
import LogicLayer.Usuario;
import java.awt.Color;
import java.awt.Font;

public class Cargo extends VentanaBase {
    private Usuario usuario;
    private static final long serialVersionUID = 1L;

<<<<<<< HEAD
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Cargo(Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Seleccione su Rol");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(160, 10, 139, 40);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Lider del proyecto");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(30, 112, 186, 67);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LiderDelProyecto liderDeProyecto = new LiderDelProyecto(usuario);
				liderDeProyecto.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);

		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Miembro del proyecto");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(226, 112, 186, 67);
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        MiembroDelProyecto miembroDelProyecto = new MiembroDelProyecto(usuario);
		        miembroDelProyecto.setVisible(true);
		        dispose();
		    }
		});
		contentPane.add(btnNewButton_1);
		//hecha la conexion :D

		JButton btnNewButton_2 = new JButton("Volver");
		btnNewButton_2.setBounds(312, 208, 114, 34);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuOperativo MenuOperativo = new MenuOperativo(usuario);
				MenuOperativo.setVisible(true);
				dispose();
			}
			
		});
		
		contentPane.add(btnNewButton_2);
		
		Operativo operativo = (Operativo) usuario;

		btnNewButton.setVisible(false);
		btnNewButton_1.setVisible(false);

		switch (operativo.getRol()) {

		case LIDER_PROYECTO:
			lblNewLabel.setText("Rol: Líder del Proyecto");
			btnNewButton.setVisible(true);
			break;

		case MIEMBRO_PROYECTO:
			lblNewLabel.setText("Rol: Miembro del Proyecto");
			btnNewButton_1.setVisible(true);
			break;
		}

		
		
	}

}
=======
    public Cargo(Usuario usuario) {
        this.usuario = usuario;
        
        JLabel lblTitulo = new JLabel("Seleccione su Rol");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(260, 70, 400, 35);
        contentPane.add(lblTitulo);
        
        JButton btnLider = crearBoton("Lider del proyecto", 280, 160, 180, 55);
        btnLider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LiderDelProyecto liderDeProyecto = new LiderDelProyecto(usuario);
                liderDeProyecto.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnLider);
        
        JButton btnMiembro = crearBoton("Miembro del proyecto", 480, 160, 180, 55);
        btnMiembro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MiembroDelProyecto miembroDelProyecto = new MiembroDelProyecto(usuario);
                miembroDelProyecto.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnMiembro);
        
        JButton btnVolver = crearBotonRojo("Volver", EstilosGlobales.ANCHO_VENTANA - 130, EstilosGlobales.ALTO_VENTANA - 55, 110, 35);
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuOperativo menuOperativo = new MenuOperativo(usuario);
                menuOperativo.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnVolver);
        
        Operativo operativo = (Operativo) usuario;
        btnLider.setVisible(false);
        btnMiembro.setVisible(false);
        
        switch (operativo.getRol()) {
            case LIDER_PROYECTO:
                lblTitulo.setText("Rol: Lider del Proyecto");
                btnLider.setVisible(true);
                break;
            case MIEMBRO_PROYECTO:
                lblTitulo.setText("Rol: Miembro del Proyecto");
                btnMiembro.setVisible(true);
                break;
            default:
                break;
        }
    }
}
>>>>>>> d87fe51cd2e47fb57d041a167c5cef520bd3638d
