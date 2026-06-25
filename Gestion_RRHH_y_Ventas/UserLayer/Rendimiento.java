package UserLayer;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DLL.ControllerEvaluacion;
import LogicLayer.Operativo;

public class Rendimiento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private Operativo usuario;

	public Rendimiento(Operativo usuario) {

		this.usuario = usuario;

		ControllerEvaluacion ce = new ControllerEvaluacion();

		double individual = usuario.calcularRendimientoIndividual();
		double grupal = ce.obtenerRendimientoGrupal(usuario.getIdOperativo());

		double finalRendimiento = 0;

		if (individual != 0 || grupal != 0) {
			finalRendimiento = usuario.calcularRendimientoFinal();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Mi Rendimiento");
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTitulo.setBounds(125, 10, 200, 25);
		contentPane.add(lblTitulo);

		JLabel lblIndividual = new JLabel(
				"Rendimiento Individual: " + individual + "%");
		lblIndividual.setFont(new Font("Verdana", Font.BOLD, 14));
		lblIndividual.setBounds(40, 55, 350, 25);
		contentPane.add(lblIndividual);

		JLabel lblGrupal = new JLabel(
				"Rendimiento Grupal: " + grupal + "%");
		lblGrupal.setFont(new Font("Verdana", Font.BOLD, 14));
		lblGrupal.setBounds(40, 90, 350, 25);
		contentPane.add(lblGrupal);

		JLabel lblFinal;

		if (individual == 0 && grupal == 0) {

			lblFinal = new JLabel(
					"Último rendimiento registrado: "
							+ usuario.getRendimiento() + "%");

		} else {

			lblFinal = new JLabel(
					"Rendimiento Final: "
							+ finalRendimiento + "%");
		}

		lblFinal.setFont(new Font("Verdana", Font.BOLD, 14));
		lblFinal.setBounds(40, 140, 350, 25);
		contentPane.add(lblFinal);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAceptar.setBounds(160, 210, 110, 35);

		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				verInformacionPersonal ventana =
						new verInformacionPersonal(usuario);

				ventana.setVisible(true);
				dispose();
			}
		});

		contentPane.add(btnAceptar);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Operativo op = new Operativo();

					Rendimiento frame =
							new Rendimiento(op);

					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}