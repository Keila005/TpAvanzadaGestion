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