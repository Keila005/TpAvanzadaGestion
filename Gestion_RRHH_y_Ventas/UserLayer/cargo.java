package UserLayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LogicLayer.Operativo;
import LogicLayer.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cargo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public cargo(Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("lider del proyecto");
		btnNewButton.setBounds(60, 91, 136, 44);
<<<<<<< HEAD
<<<<<<< Updated upstream
=======
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				liderDeProyecto liderDeProyecto = new liderDeProyecto();
				liderDeProyecto.setVisible(true);
				dispose(); 
			}
		});
		
>>>>>>> main
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("miembro del proyecto");
		btnNewButton_1.setBounds(236, 91, 136, 44);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MiembroDelProyecto MiembroDelProyecto = new MiembroDelProyecto ();
				MiembroDelProyecto.setVisible(true);
				dispose(); 
			}
		});
		
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Volver");
		btnNewButton_2.setBounds(312, 208, 114, 34);
<<<<<<< HEAD
=======
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				liderDeProyecto liderDeProyecto =
				        new liderDeProyecto(usuario);
				liderDeProyecto.setVisible(true);
				dispose(); 
			}
		});
		
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("miembro del proyecto");
		btnNewButton_1.setBounds(236, 91, 136, 44);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MiembroDelProyecto MiembroDelProyecto =
				        new MiembroDelProyecto(usuario);
				MiembroDelProyecto.setVisible(true);
				dispose(); 
			}
		});
		
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Volver");
		btnNewButton_2.setBounds(312, 208, 114, 34);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verInformacionPersonal verInformacionPersonal = new verInformacionPersonal(usuario);
=======
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verInformacionPersonal verInformacionPersonal = new verInformacionPersonal();
>>>>>>> main
				verInformacionPersonal.setVisible(true);
				dispose();
			}
			
		});
		
<<<<<<< HEAD
>>>>>>> Stashed changes
=======
>>>>>>> main
		contentPane.add(btnNewButton_2);

	}
//	btnNewButton.addActionListener(new ActionListener() {
//	public void actionPerformed(ActionEvent e) {
//		Operativo op = co.buscarPorUsuario(usuario.getIdUsuario());
//
//        if(op.getRol() == Roles.LIDER_PROYECTO) {
//
//            MenuLider ml = new MenuLider(op);
//            ml.setVisible(true);
//            dispose();
//
//        } else {
//
//            JOptionPane.showMessageDialog(
//                null,
//                "Usted no posee el cargo de Líder de Proyecto"
//            );
//        }
//    
//	}
//});
}
