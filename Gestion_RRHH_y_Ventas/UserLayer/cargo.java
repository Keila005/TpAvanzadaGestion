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
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Operativo op = co.buscarPorUsuario(usuario.getIdUsuario());
//
//		        if(op.getRol() == Roles.LIDER_PROYECTO) {
//
//		            MenuLider ml = new MenuLider(op);
//		            ml.setVisible(true);
//		            dispose();
//
//		        } else {
//
//		            JOptionPane.showMessageDialog(
//		                null,
//		                "Usted no posee el cargo de Líder de Proyecto"
//		            );
//		        }
//		    
//			}
//		});
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
