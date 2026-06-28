package UserLayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.ActionListener;

public class VentanaBase extends JFrame {
    private static final long serialVersionUID = 1L;
    protected JPanel contentPane;
    protected JPanel navbar;
    protected JPanel tabContainer;
    protected JButton btnScrollLeft, btnScrollRight;
    protected int tabOffset = 0;
    protected int tabAncho = 160;
    protected int tabGap = 2;
    protected JButton tabSeleccionado = null;
    
    public VentanaBase() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setBounds(100, 100, EstilosGlobales.ANCHO_VENTANA, EstilosGlobales.ALTO_VENTANA);
        
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new LineBorder(new Color(0, 91, 0), 2));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        crearNavbar();
    }
    
    private void crearNavbar() {
        navbar = new JPanel();
        navbar.setBackground(new Color(0, 91, 0));
        navbar.setBounds(0, 0, EstilosGlobales.ANCHO_VENTANA, 50);
        navbar.setLayout(null);
        contentPane.add(navbar);
        
        JLabel lblLogo = new JLabel("KLBE");
        lblLogo.setForeground(Color.WHITE);
        lblLogo.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        lblLogo.setBounds(15, 12, 60, 25);
        navbar.add(lblLogo);
        
        tabContainer = new JPanel();
        tabContainer.setBackground(new Color(0, 91, 0));
        tabContainer.setLayout(null);
        tabContainer.setBounds(85, 5, EstilosGlobales.ANCHO_VENTANA - 200, 40);
        navbar.add(tabContainer);
        
        btnScrollLeft = new JButton("◄");
        btnScrollLeft.setForeground(Color.WHITE);
        btnScrollLeft.setBackground(new Color(0, 70, 0));
        btnScrollLeft.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnScrollLeft.setBounds(65, 10, 18, 30);
        btnScrollLeft.setBorder(null);
        btnScrollLeft.setFocusPainted(false);
        btnScrollLeft.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnScrollLeft.setVisible(false);
        btnScrollLeft.addActionListener(e -> scrollTabs(-1));
        navbar.add(btnScrollLeft);
        
        btnScrollRight = new JButton("►");
        btnScrollRight.setForeground(Color.WHITE);
        btnScrollRight.setBackground(new Color(0, 70, 0));
        btnScrollRight.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnScrollRight.setBounds(EstilosGlobales.ANCHO_VENTANA - 35, 10, 18, 30);
        btnScrollRight.setBorder(null);
        btnScrollRight.setFocusPainted(false);
        btnScrollRight.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnScrollRight.setVisible(false);
        btnScrollRight.addActionListener(e -> scrollTabs(1));
        navbar.add(btnScrollRight);
        
        JLabel lblCerrar = new JLabel("×");
        lblCerrar.setForeground(Color.WHITE);
        lblCerrar.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
        lblCerrar.setBounds(EstilosGlobales.ANCHO_VENTANA - 25, 10, 20, 30);
        lblCerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) { System.exit(0); }
            public void mouseEntered(java.awt.event.MouseEvent evt) { lblCerrar.setForeground(new Color(200, 50, 50)); }
            public void mouseExited(java.awt.event.MouseEvent evt) { lblCerrar.setForeground(Color.WHITE); }
        });
        navbar.add(lblCerrar);
        
        JLabel lblMinimizar = new JLabel("−");
        lblMinimizar.setForeground(Color.WHITE);
        lblMinimizar.setFont(new Font("Helvetica Neue", Font.PLAIN, 26));
        lblMinimizar.setBounds(EstilosGlobales.ANCHO_VENTANA - 55, 8, 20, 30);
        lblMinimizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) { setState(JFrame.ICONIFIED); }
            public void mouseEntered(java.awt.event.MouseEvent evt) { lblMinimizar.setForeground(new Color(200, 200, 200)); }
            public void mouseExited(java.awt.event.MouseEvent evt) { lblMinimizar.setForeground(Color.WHITE); }
        });
        navbar.add(lblMinimizar);
    }
    
    protected void agregarTab(String nombre, ActionListener accion) {
        int totalTabs = tabContainer.getComponentCount();
        int x = totalTabs * (tabAncho + tabGap);
        
        JButton tab = new JButton(nombre);
        tab.setForeground(Color.WHITE);
        tab.setBackground(new Color(0, 91, 0));
        tab.setFont(EstilosGlobales.FUENTE_TAB);
        tab.setBounds(x, 0, tabAncho, 38);
        tab.setBorder(null);
        tab.setFocusPainted(false);
        tab.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tab.addActionListener(accion);
        tab.addActionListener(e -> seleccionarTab(tab));
        tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (tab != tabSeleccionado) {
                    tab.setBackground(new Color(20, 100, 20));
                }
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (tab != tabSeleccionado) {
                    tab.setBackground(new Color(0, 91, 0));
                }
            }
        });
        tabContainer.add(tab);
        
        actualizarScroll();
    }
    
    protected void seleccionarTab(JButton tab) {
        if (tabSeleccionado != null) {
            tabSeleccionado.setBackground(new Color(0, 91, 0));
            tabSeleccionado.setFont(EstilosGlobales.FUENTE_TAB);
        }
        tab.setBackground(new Color(28, 137, 16));
        tab.setFont(EstilosGlobales.FUENTE_TAB_SELECCIONADA);
        tabSeleccionado = tab;
    }
    
    protected void seleccionarTabPorIndice(int indice) {
        if (indice >= 0 && indice < tabContainer.getComponentCount()) {
            JButton tab = (JButton) tabContainer.getComponent(indice);
            seleccionarTab(tab);
            tab.doClick();
        }
    }
    
    private void scrollTabs(int direccion) {
        int paso = 160;
        int maxScroll = Math.max(0, tabContainer.getPreferredSize().width - tabContainer.getWidth());
        tabOffset += direccion * paso;
        tabOffset = Math.max(0, Math.min(tabOffset, maxScroll));
        
        for (int i = 0; i < tabContainer.getComponentCount(); i++) {
            JButton tab = (JButton) tabContainer.getComponent(i);
            tab.setLocation(i * (tabAncho + tabGap) - tabOffset, 0);
        }
        actualizarScroll();
    }
    
    private void actualizarScroll() {
        int totalAncho = tabContainer.getComponentCount() * (tabAncho + tabGap);
        btnScrollLeft.setVisible(tabOffset > 0);
        btnScrollRight.setVisible(totalAncho > tabContainer.getWidth() && tabOffset < totalAncho - tabContainer.getWidth());
    }
    
    protected JButton crearBoton(String texto, int x, int y, int ancho, int alto) {
        JButton btn = new JButton(texto);
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(0, 91, 0));
        btn.setFont(EstilosGlobales.FUENTE_SUBTITULO);
        btn.setBounds(x, y, ancho, alto);
        btn.setBorder(null);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setFocusPainted(false);
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(0, 91, 0));
            }
        });
        return btn;
    }
    
    protected JButton crearBotonRojo(String texto, int x, int y, int ancho, int alto) {
        JButton btn = new JButton(texto);
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(180, 50, 50));
        btn.setFont(EstilosGlobales.FUENTE_LABEL);
        btn.setBounds(x, y, ancho, alto);
        btn.setBorder(null);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setFocusPainted(false);
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(150, 30, 30));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(180, 50, 50));
            }
        });
        return btn;
    }
    
    protected JLabel crearTitulo(String texto, int x, int y) {
        JLabel lbl = new JLabel(texto);
        lbl.setForeground(new Color(0, 91, 0));
        lbl.setFont(EstilosGlobales.FUENTE_TITULO);
        lbl.setBounds(x, y, 400, 30);
        return lbl;
    }
    
    protected JLabel crearSubtitulo(String texto, int x, int y) {
        JLabel lbl = new JLabel(texto);
        lbl.setForeground(new Color(120, 120, 120));
        lbl.setFont(EstilosGlobales.FUENTE_SUBTITULO);
        lbl.setBounds(x, y, 300, 20);
        return lbl;
    }
}