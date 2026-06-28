package UserLayer;

import java.awt.EventQueue;
<<<<<<< HEAD
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
=======
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MiSueldo extends VentanaBase {

    private static final long serialVersionUID = 1L;

    public MiSueldo() {

        JLabel lblTitulo = new JLabel("Mi Sueldo");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 200, 30);
        contentPane.add(lblTitulo);

        JLabel lblSueldoBase = new JLabel("Sueldo Base: $1.500.000");
        lblSueldoBase.setForeground(new Color(0, 91, 0));
        lblSueldoBase.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        lblSueldoBase.setBounds(300, 130, 300, 35);
        contentPane.add(lblSueldoBase);

        JLabel lblBonos = new JLabel("Bonos: $150.000");
        lblBonos.setForeground(new Color(80, 80, 80));
        lblBonos.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        lblBonos.setBounds(300, 180, 300, 25);
        contentPane.add(lblBonos);

        JLabel lblHorasExtras = new JLabel("Horas Extras: $200.000");
        lblHorasExtras.setForeground(new Color(80, 80, 80));
        lblHorasExtras.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        lblHorasExtras.setBounds(300, 210, 300, 25);
        contentPane.add(lblHorasExtras);

        JLabel lblTotal = new JLabel("Total: $1.850.000");
        lblTotal.setForeground(new Color(0, 91, 0));
        lblTotal.setFont(new Font("Helvetica Neue", Font.BOLD, 22));
        lblTotal.setBounds(300, 260, 300, 35);
        contentPane.add(lblTotal);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setForeground(Color.WHITE);
        btnAceptar.setBackground(new Color(0, 91, 0));
        btnAceptar.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnAceptar.setBounds(350, 340, 150, 45);
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
            dispose();
        });
        contentPane.add(btnAceptar);

        JButton btnVolver = crearBotonRojo("Volver", EstilosGlobales.ANCHO_VENTANA - 130, EstilosGlobales.ALTO_VENTANA - 55, 110, 35);
        btnVolver.addActionListener(e -> {
            dispose();
        });
        contentPane.add(btnVolver);

        seleccionarTabPorIndice(0);
    }
}
>>>>>>> d87fe51cd2e47fb57d041a167c5cef520bd3638d
