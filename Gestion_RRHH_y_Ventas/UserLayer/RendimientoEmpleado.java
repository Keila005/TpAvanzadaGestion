package UserLayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import DLL.ControllerRendimiento;

import LogicLayer.Operativo;
import LogicLayer.Usuario;
import LogicLayer.Vendedor;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class RendimientoEmpleado extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private DefaultTableModel model;
    private DefaultTableModel model2;
    private JTable table;
    private JTable table2;
    private JButton btnMejoresO;
    private JButton btnBajosO;
    private JButton btnMejoresV;
    private JButton btnBajosV;
    private JButton btnVerTodas;
    private JButton btnVerTodas_1;

    public RendimientoEmpleado(Usuario usuario) {

        JLabel lblTitulo = new JLabel("Rendimiento de Empleados");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(320, 50, 350, 30);
        contentPane.add(lblTitulo);

        model = new DefaultTableModel(new String[]{"ID", "Nombre", "Rendimiento"}, 0);
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

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(new LineBorder(new Color(0, 91, 0), 2));
        scrollPane.setBounds(80, 130, 350, 180);
        contentPane.add(scrollPane);
        cargarTablaOperativo();

        JLabel lblRankingOperativo = new JLabel("Ranking Operativo");
        lblRankingOperativo.setForeground(new Color(0, 91, 0));
        lblRankingOperativo.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
        lblRankingOperativo.setBounds(180, 100, 200, 25);
        contentPane.add(lblRankingOperativo);

        model2 = new DefaultTableModel(new String[]{"ID", "Nombre", "Cantidad de Ventas"}, 0);
        table2 = new JTable(model2);
        table2.setBackground(Color.WHITE);
        table2.setForeground(new Color(50, 50, 50));
        table2.setGridColor(new Color(200, 200, 200));
        table2.setSelectionBackground(new Color(0, 91, 0));
        table2.setSelectionForeground(Color.WHITE);
        table2.setRowHeight(28);
        table2.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        table2.getTableHeader().setBackground(new Color(0, 91, 0));
        table2.getTableHeader().setForeground(Color.WHITE);
        table2.getTableHeader().setFont(new Font("Helvetica Neue", Font.BOLD, 13));

        JScrollPane scrollPane1 = new JScrollPane(table2);
        scrollPane1.setBorder(new LineBorder(new Color(0, 91, 0), 2));
        scrollPane1.setBounds(480, 130, 350, 180);
        contentPane.add(scrollPane1);
        cargarTablaVendedor();

        JLabel lblRankingVendedor = new JLabel("Ranking Vendedor");
        lblRankingVendedor.setForeground(new Color(0, 91, 0));
        lblRankingVendedor.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
        lblRankingVendedor.setBounds(570, 100, 200, 25);
        contentPane.add(lblRankingVendedor);

        JSeparator linea = new JSeparator();
        linea.setOrientation(SwingConstants.VERTICAL);
        linea.setForeground(new Color(0, 91, 0, 50));
        linea.setBackground(new Color(0, 91, 0, 50));
        linea.setBounds(460, 100, 10, 220);
        contentPane.add(linea);

        JLabel lblMayor70 = new JLabel("Mayor al 70%");
        lblMayor70.setForeground(new Color(0, 91, 0));
        lblMayor70.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        lblMayor70.setBounds(90, 340, 100, 25);
        contentPane.add(lblMayor70);

        btnMejoresO = new JButton("Mejores");
        btnMejoresO.setForeground(Color.WHITE);
        btnMejoresO.setBackground(new Color(0, 91, 0));
        btnMejoresO.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        btnMejoresO.setBounds(80, 370, 120, 35);
        btnMejoresO.setBorder(null);
        btnMejoresO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMejoresO.setFocusPainted(false);
        btnMejoresO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMejoresO.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMejoresO.setBackground(new Color(0, 91, 0));
            }
        });
        btnMejoresO.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarOperativosMejorRendimiento();
            }
        });
        contentPane.add(btnMejoresO);

        JLabel lblMenor70 = new JLabel("Menor al 70%");
        lblMenor70.setForeground(new Color(0, 91, 0));
        lblMenor70.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        lblMenor70.setBounds(220, 340, 100, 25);
        contentPane.add(lblMenor70);

        btnBajosO = new JButton("Bajos");
        btnBajosO.setForeground(Color.WHITE);
        btnBajosO.setBackground(new Color(0, 91, 0));
        btnBajosO.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        btnBajosO.setBounds(210, 370, 120, 35);
        btnBajosO.setBorder(null);
        btnBajosO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBajosO.setFocusPainted(false);
        btnBajosO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBajosO.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBajosO.setBackground(new Color(0, 91, 0));
            }
        });
        btnBajosO.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarOperativosBajoRendimiento();
            }
        });
        contentPane.add(btnBajosO);

        btnVerTodas = new JButton("Ver todas");
        btnVerTodas.setForeground(Color.WHITE);
        btnVerTodas.setBackground(new Color(0, 91, 0));
        btnVerTodas.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        btnVerTodas.setBounds(145, 420, 120, 35);
        btnVerTodas.setBorder(null);
        btnVerTodas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerTodas.setFocusPainted(false);
        btnVerTodas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVerTodas.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVerTodas.setBackground(new Color(0, 91, 0));
            }
        });
        btnVerTodas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarTablaOperativo();
            }
        });
        contentPane.add(btnVerTodas);

        JLabel lblMayor20 = new JLabel("Mayor 20 ventas");
        lblMayor20.setForeground(new Color(0, 91, 0));
        lblMayor20.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        lblMayor20.setBounds(490, 340, 120, 25);
        contentPane.add(lblMayor20);

        btnMejoresV = new JButton("Mejores");
        btnMejoresV.setForeground(Color.WHITE);
        btnMejoresV.setBackground(new Color(0, 91, 0));
        btnMejoresV.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        btnMejoresV.setBounds(480, 370, 120, 35);
        btnMejoresV.setBorder(null);
        btnMejoresV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMejoresV.setFocusPainted(false);
        btnMejoresV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMejoresV.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMejoresV.setBackground(new Color(0, 91, 0));
            }
        });
        btnMejoresV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarMejorVenta();
            }
        });
        contentPane.add(btnMejoresV);

        JLabel lblMenor20 = new JLabel("Menor a 20 ventas");
        lblMenor20.setForeground(new Color(0, 91, 0));
        lblMenor20.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        lblMenor20.setBounds(620, 340, 130, 25);
        contentPane.add(lblMenor20);

        btnBajosV = new JButton("Bajos");
        btnBajosV.setForeground(Color.WHITE);
        btnBajosV.setBackground(new Color(0, 91, 0));
        btnBajosV.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        btnBajosV.setBounds(610, 370, 120, 35);
        btnBajosV.setBorder(null);
        btnBajosV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBajosV.setFocusPainted(false);
        btnBajosV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBajosV.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBajosV.setBackground(new Color(0, 91, 0));
            }
        });
        btnBajosV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarBajaVenta();
            }
        });
        contentPane.add(btnBajosV);

        btnVerTodas_1 = new JButton("Ver todas");
        btnVerTodas_1.setForeground(Color.WHITE);
        btnVerTodas_1.setBackground(new Color(0, 91, 0));
        btnVerTodas_1.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        btnVerTodas_1.setBounds(545, 420, 120, 35);
        btnVerTodas_1.setBorder(null);
        btnVerTodas_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerTodas_1.setFocusPainted(false);
        btnVerTodas_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVerTodas_1.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVerTodas_1.setBackground(new Color(0, 91, 0));
            }
        });
        btnVerTodas_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarTablaVendedor();
            }
        });
        contentPane.add(btnVerTodas_1);

        JButton btnVolver = crearBotonRojo("Volver", EstilosGlobales.ANCHO_VENTANA - 130, EstilosGlobales.ALTO_VENTANA - 55, 110, 35);
        btnVolver.addActionListener(e -> {
            MenuAdministrador menuAdmin = new MenuAdministrador(usuario);
            menuAdmin.setVisible(true);
            dispose();
        });
        contentPane.add(btnVolver);

        seleccionarTabPorIndice(0);
    }

    private void cargarTablaOperativo() {
        model.setRowCount(0);
        ControllerRendimiento rendimientoOperativo = new ControllerRendimiento();
        LinkedList<Operativo> operativos = rendimientoOperativo.getTodosOperativos();
        for (Operativo o : operativos) {
            String nombreCompleto = o.getNombre() + " " + o.getApellido();
            model.addRow(new Object[]{o.getIdEmpleado(), nombreCompleto, o.getRendimiento() + "%"});
        }
    }

    private void cargarTablaVendedor() {
        model2.setRowCount(0);
        ControllerRendimiento rendimientoVendedor = new ControllerRendimiento();
        LinkedList<Vendedor> vendedores = rendimientoVendedor.getTodosVendedores();
        for (Vendedor v : vendedores) {
            String nombreCompleto = v.getNombre() + " " + v.getApellido();
            model2.addRow(new Object[]{v.getIdEmpleado(), nombreCompleto, v.getVentasTotales()});
        }
    }

    private void cargarOperativosMejorRendimiento() {
        model.setRowCount(0);
        ControllerRendimiento cr = new ControllerRendimiento();
        LinkedList<Operativo> lista = cr.getTodosOperativos();
        for (Operativo o : lista) {
            if (o.getRendimiento() > 70) {
                model.addRow(new Object[]{o.getIdEmpleado(), o.getNombre() + " " + o.getApellido(), o.getRendimiento() + "%"});
            }
        }
    }

    private void cargarOperativosBajoRendimiento() {
        model.setRowCount(0);
        ControllerRendimiento cr = new ControllerRendimiento();
        LinkedList<Operativo> lista = cr.getTodosOperativos();
        for (Operativo o : lista) {
            if (o.getRendimiento() <= 70) {
                model.addRow(new Object[]{o.getIdEmpleado(), o.getNombre() + " " + o.getApellido(), o.getRendimiento() + "%"});
            }
        }
    }

    private void cargarMejorVenta() {
        model2.setRowCount(0);
        ControllerRendimiento rendimientoVendedor = new ControllerRendimiento();
        LinkedList<Vendedor> vendedores = rendimientoVendedor.getTodosVendedores();
        for (Vendedor v : vendedores) {
            String nombreCompleto = v.getNombre() + " " + v.getApellido();
            if (v.getVentasTotales() > 20) {
                model2.addRow(new Object[]{v.getIdEmpleado(), nombreCompleto, v.getVentasTotales()});
            }
        }
    }

    private void cargarBajaVenta() {
        model2.setRowCount(0);
        ControllerRendimiento rendimientoVendedor = new ControllerRendimiento();
        LinkedList<Vendedor> vendedores = rendimientoVendedor.getTodosVendedores();
        for (Vendedor v : vendedores) {
            String nombreCompleto = v.getNombre() + " " + v.getApellido();
            if (v.getVentasTotales() <= 20) {
                model2.addRow(new Object[]{v.getIdEmpleado(), nombreCompleto, v.getVentasTotales()});
            }
        }
    }
}