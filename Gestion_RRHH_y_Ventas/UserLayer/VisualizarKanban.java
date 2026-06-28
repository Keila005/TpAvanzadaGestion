package UserLayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import DLL.ControllerTarea;
import LogicLayer.Operativo;
import LogicLayer.Tarea;
import LogicLayer.Usuario;

public class VisualizarKanban extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private Usuario usuario;
    private JComboBox<Tarea> comboTareas;
    private LinkedList<Tarea> tareasAsignadas;
    private ControllerTarea controllerTarea = new ControllerTarea();

    public VisualizarKanban(Usuario usuario) {
        this.usuario = usuario;

        JLabel lblTitulo = new JLabel("Kanban");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 200, 30);
        contentPane.add(lblTitulo);

        JLabel lblUsuario = new JLabel(usuario.getNombre() + " " + usuario.getApellido());
        lblUsuario.setForeground(new Color(120, 120, 120));
        lblUsuario.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        lblUsuario.setBounds(390, 90, 200, 20);
        contentPane.add(lblUsuario);

        JLabel lblTareas = new JLabel("Mis tareas:");
        lblTareas.setForeground(new Color(0, 91, 0));
        lblTareas.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        lblTareas.setBounds(200, 130, 120, 25);
        contentPane.add(lblTareas);

        comboTareas = new JComboBox<>();
        comboTareas.setBackground(Color.WHITE);
        comboTareas.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        comboTareas.setBounds(330, 130, 300, 35);
        contentPane.add(comboTareas);

        JButton btnTrabajar = new JButton("Trabajar");
        btnTrabajar.setForeground(Color.WHITE);
        btnTrabajar.setBackground(new Color(0, 91, 0));
        btnTrabajar.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnTrabajar.setBounds(280, 210, 180, 45);
        btnTrabajar.setBorder(null);
        btnTrabajar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTrabajar.setFocusPainted(false);
        btnTrabajar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTrabajar.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTrabajar.setBackground(new Color(0, 91, 0));
            }
        });
        btnTrabajar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Tarea tarea = (Tarea) comboTareas.getSelectedItem();
                if (tarea == null) {
                    JOptionPane.showMessageDialog(null, "Seleccione una tarea.");
                    return;
                }
                tarea.trabajar();
                controllerTarea.trabajarTarea(tarea.getIdTarea());
                JOptionPane.showMessageDialog(null, "La tarea fue actualizada.");
                cargarTareas();
            }
        });
        contentPane.add(btnTrabajar);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setBackground(new Color(0, 91, 0));
        btnVolver.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnVolver.setBounds(500, 210, 150, 45);
        btnVolver.setBorder(null);
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.setFocusPainted(false);
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVolver.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVolver.setBackground(new Color(0, 91, 0));
            }
        });
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Operativo operativo = (Operativo) usuario;
                if (operativo.getRol() == LogicLayer.Roles.LIDER_PROYECTO) {
                    LiderDelProyecto lider = new LiderDelProyecto(usuario);
                    lider.setVisible(true);
                } else {
                    MiembroDelProyecto miembro = new MiembroDelProyecto(usuario);
                    miembro.setVisible(true);
                }
                dispose();
            }
        });
        contentPane.add(btnVolver);

        if (usuario != null) {
            cargarTareas();
        }

        seleccionarTabPorIndice(0);
    }

    private void cargarTareas() {
        comboTareas.removeAllItems();
        Operativo op = (Operativo) usuario;
        tareasAsignadas = controllerTarea.obtenerTareasEmpleado(op.getIdOperativo());
        for (Tarea t : tareasAsignadas) {
            if (!t.getEstado().equalsIgnoreCase("FINALIZADA")) {
                comboTareas.addItem(t);
            }
        }
    }
}