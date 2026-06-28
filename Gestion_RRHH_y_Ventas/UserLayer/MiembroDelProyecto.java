package UserLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import LogicLayer.Usuario;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;

public class MiembroDelProyecto extends VentanaBase {
    private static final long serialVersionUID = 1L;
    private Usuario usuario;

    public MiembroDelProyecto(Usuario usuario) {
        this.usuario = usuario;

        JLabel lblTitulo = new JLabel("Panel Miembro");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 250, 30);
        contentPane.add(lblTitulo);

        JLabel lblUsuario = new JLabel(usuario.getNombre() + " " + usuario.getApellido());
        lblUsuario.setForeground(new Color(120, 120, 120));
        lblUsuario.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        lblUsuario.setBounds(390, 90, 200, 20);
        contentPane.add(lblUsuario);

        JPanel linea = new JPanel();
        linea.setBackground(new Color(0, 91, 0, 50));
        linea.setBounds(250, 130, 422, 1);
        contentPane.add(linea);

        JButton btnKanban = crearBoton("Visualizar Kanban", 280, 180, 180, 50);
        btnKanban.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VisualizarKanban VisualizarKanban = new VisualizarKanban(usuario);
                VisualizarKanban.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnKanban);

        JButton btnEvaluar = crearBoton("Evaluar Compañero", 480, 180, 180, 50);
        btnEvaluar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EvaluarCompaniero EvaluarCompaniero = new EvaluarCompaniero();
                EvaluarCompaniero.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnEvaluar);

        JButton btnReuniones = crearBoton("Ver Reuniones", 280, 250, 180, 50);
        btnReuniones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VerReuniones VerReuniones = new VerReuniones();
                VerReuniones.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnReuniones);

        JButton btnVolver = crearBotonRojo("Volver", EstilosGlobales.ANCHO_VENTANA - 130, EstilosGlobales.ALTO_VENTANA - 55, 110, 35);
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cargo cargo = new Cargo(usuario);
                cargo.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnVolver);

        seleccionarTabPorIndice(0);
    }
}