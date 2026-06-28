package UserLayer;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import DLL.ControllerComentario;
import LogicLayer.ComentarioAnonimo;
import LogicLayer.Usuario;
import java.util.LinkedList;

public class climaLaboral extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private DefaultTableModel model;
    private JTable table;
    private ControllerComentario comentarioController;

    public climaLaboral(Usuario usuario) {

        JLabel lblTitulo = new JLabel("Clima Laboral");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 250, 30);
        contentPane.add(lblTitulo);

        model = new DefaultTableModel(new String[]{"N°", "Comentarios", "Fecha", "Sentimiento"}, 0);
        table = new JTable(model);
        table.setBackground(Color.WHITE);
        table.setForeground(new Color(50, 50, 50));
        table.setGridColor(new Color(200, 200, 200));
        table.setSelectionBackground(new Color(0, 91, 0));
        table.setSelectionForeground(Color.WHITE);
        table.setRowHeight(28);
        table.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        table.getTableHeader().setBackground(new Color(0, 91, 0));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setFont(new Font("Helvetica Neue", Font.BOLD, 13));

        cargarComentarios();
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(250);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(null);
        scrollPane.setBounds(80, 120, 762, 200);
        contentPane.add(scrollPane);

        JLabel lblReporte = new JLabel("Reporte de comentarios:");
        lblReporte.setForeground(new Color(0, 91, 0));
        lblReporte.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
        lblReporte.setBounds(80, 340, 200, 25);
        contentPane.add(lblReporte);

        JTextArea txtReporte = new JTextArea();
        txtReporte.setBackground(new Color(245, 245, 245));
        txtReporte.setForeground(new Color(50, 50, 50));
        txtReporte.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        txtReporte.setEditable(false);
        txtReporte.setLineWrap(true);
        txtReporte.setWrapStyleWord(true);
        txtReporte.setText(comentarioController.generarReporteClima());
        txtReporte.setBounds(80, 370, 500, 120);
        txtReporte.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));
        contentPane.add(txtReporte);

        JButton btnVolver = crearBotonRojo("Volver", EstilosGlobales.ANCHO_VENTANA - 130, EstilosGlobales.ALTO_VENTANA - 55, 110, 35);
        btnVolver.addActionListener(e -> {
            MenuAdministrador menuAdmin = new MenuAdministrador(usuario);
            menuAdmin.setVisible(true);
            dispose();
        });
        contentPane.add(btnVolver);

        seleccionarTabPorIndice(0);
    }

    private void cargarComentarios() {
        model.setRowCount(0);
        comentarioController = new ControllerComentario();
        LinkedList<ComentarioAnonimo> comentarios = comentarioController.verComentarios();
        for (ComentarioAnonimo c : comentarios) {
            model.addRow(new Object[]{c.getIdMensaje(), c.getContenido(), c.getFecha(), c.getSentimiento()});
        }
    }
}