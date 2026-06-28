package UserLayer;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import LogicLayer.Usuario;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Saludos extends VentanaBase {
    private static final long serialVersionUID = 1L;

    public Saludos() {
        JLabel lblTitulo = new JLabel("Hasta luego");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 32));
        lblTitulo.setBounds(370, 60, 250, 40);
        contentPane.add(lblTitulo);
        
        JLabel lblSubtitulo = new JLabel("Gracias por usar el sistema");
        lblSubtitulo.setForeground(new Color(120, 120, 120));
        lblSubtitulo.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        lblSubtitulo.setBounds(360, 110, 300, 25);
        contentPane.add(lblSubtitulo);

        JLabel lblGif = new JLabel("");
        lblGif.setIcon(new ImageIcon(Saludos.class.getResource("/Img/bye.gif")));
        lblGif.setBounds(350, 160, 200, 200);
        contentPane.add(lblGif);
        
        JButton btnLogin = crearBoton("Volver al Login", 380, 400, 160, 45);
        btnLogin.addActionListener(e -> {
            Login login = new Login();
            login.setVisible(true);
            dispose();
        });
        contentPane.add(btnLogin);

        seleccionarTabPorIndice(0);
    }
}