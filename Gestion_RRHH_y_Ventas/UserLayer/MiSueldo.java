package UserLayer;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import LogicLayer.Empleado;

public class MiSueldo extends JFrame {
	
	private Empleado Empleado;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JPanel panelContenido;

    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiSueldo frame = new MiSueldo();
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
	public MiSueldo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUltimaLiquidacion = new JButton("Ultima liquidacion");
		btnUltimaLiquidacion.setBounds(70, 10, 177, 44);
		btnUltimaLiquidacion.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUltimaLiquidacion.setBackground(UIManager.getColor("Button.background"));

		contentPane.add(btnUltimaLiquidacion);
		
		JButton btnHistorialCompleto = new JButton("Historial completo");
		btnHistorialCompleto.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHistorialCompleto.setBackground(UIManager.getColor("Button.background"));
		btnHistorialCompleto.setBounds(283, 10, 177, 44);
		contentPane.add(btnHistorialCompleto);
		
		panelContenido = new JPanel();
		panelContenido.setLayout(null);
		panelContenido.setBounds(70, 70, 390, 200);
		contentPane.add(panelContenido);
		
		btnUltimaLiquidacion.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        panelContenido.removeAll();

		        JLabel lblEmpleado = new JLabel("Empleado: " + Empleado.getNombre() + " " + Empleado.getApellido());
		        lblEmpleado.setBounds(20,20,300,20);
		        panelContenido.add(lblEmpleado);

		        JLabel lblBase = new JLabel("Sueldo Base: $" + Empleado.getSueldoBase());
		        lblBase.setBounds(20,60,300,20);
		        panelContenido.add(lblBase);

		        JLabel lblTotal = new JLabel("TOTAL: $" + Empleado.getSueldoBase());
		        lblTotal.setBounds(20,100,300,20);
		        panelContenido.add(lblTotal);

		        panelContenido.repaint();
		        panelContenido.revalidate();
		    }
		});
		
		btnHistorialCompleto.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        panelContenido.removeAll();

		        JLabel l1 = new JLabel("1. Liquidación");
		        l1.setBounds(20,20,300,20);
		        panelContenido.add(l1);

		        JLabel l2 = new JLabel("Base: $" + Empleado.getSueldoBase());
		        l2.setBounds(40,45,300,20);
		        panelContenido.add(l2);

		        JLabel l3 = new JLabel("Total: $" + Empleado.getSueldoBase());
		        l3.setBounds(40,70,300,20);
		        panelContenido.add(l3);

		        JLabel l4 = new JLabel("2. Liquidación");
		        l4.setBounds(20,110,300,20);
		        panelContenido.add(l4);

		        JLabel l5 = new JLabel("Base: $" + Empleado.getSueldoBase());
		        l5.setBounds(40,135,300,20);
		        panelContenido.add(l5);

		        JLabel l6 = new JLabel("Total: $" + Empleado.getSueldoBase());
		        l6.setBounds(40,160,300,20);
		        panelContenido.add(l6);

		        panelContenido.repaint();
		        panelContenido.revalidate();
		    }
		});
		
		
		
		JButton btnNewButton_4 = new JButton("Volver");
		btnNewButton_4.setBounds(437, 330, 89, 23);
		contentPane.add(btnNewButton_4);


	}

}
