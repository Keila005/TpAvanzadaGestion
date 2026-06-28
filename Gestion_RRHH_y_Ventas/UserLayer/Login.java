package UserLayer;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import DLL.ControllerUsuario;
import LogicLayer.Administrador;
import LogicLayer.Operativo;
import LogicLayer.Usuario;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Cursor;
import javax.swing.BorderFactory;
import javax.swing.border.LineBorder;

public class Login extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private JTextField inpMail;
    private JPasswordField inpPassword;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                    ControllerUsuario nuevo = new ControllerUsuario();
                    nuevo.mostrarUsuarios();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Login() {
        
        JPanel panelLateral = new JPanel();
        panelLateral.setBackground(EstilosGlobales.VERDE_PRINCIPAL);
        panelLateral.setBounds(0, 50, 380, EstilosGlobales.ALTO_VENTANA - 50);
        panelLateral.setLayout(null);
        contentPane.add(panelLateral);
        
        JLabel lblImagen = new JLabel("");
        lblImagen.setIcon(new ImageIcon(Login.class.getResource("/Img/rrhh.jpg")));
        lblImagen.setBounds(20, 80, 340, 340);
        panelLateral.add(lblImagen);
        
        JLabel lblKlbe = new JLabel("KLBE");
        lblKlbe.setForeground(EstilosGlobales.COLOR_BLANCO);
        lblKlbe.setFont(EstilosGlobales.FUENTE_TITULO);
        lblKlbe.setBounds(150, 20, 80, 30);
        panelLateral.add(lblKlbe);
        
        JLabel lblGestor = new JLabel("GESTOR EMPRESARIAL");
        lblGestor.setForeground(EstilosGlobales.COLOR_BLANCO);
        lblGestor.setFont(EstilosGlobales.FUENTE_SUBTITULO);
        lblGestor.setBounds(90, 50, 200, 25);
        panelLateral.add(lblGestor);
        
        JLabel lblSistema = new JLabel("Sistema de integracion empresaria");
        lblSistema.setForeground(new Color(200, 230, 200));
        lblSistema.setFont(EstilosGlobales.FUENTE_LABEL);
        lblSistema.setBounds(50, 440, 280, 25);
        panelLateral.add(lblSistema);
        
        JLabel lblDescripcion = new JLabel("RRHH - Proyectos - Ventas");
        lblDescripcion.setForeground(new Color(200, 230, 200));
        lblDescripcion.setFont(EstilosGlobales.FUENTE_LABEL);
        lblDescripcion.setBounds(120, 465, 200, 25);
        panelLateral.add(lblDescripcion);

        int formX = 420;
        
        JLabel lblTitulo = new JLabel("Bienvenido");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 28));
        lblTitulo.setBounds(formX, 80, 250, 35);
        contentPane.add(lblTitulo);
        
        JLabel lblSubtitulo = new JLabel("Ingrese sus credenciales");
        lblSubtitulo.setForeground(new Color(120, 120, 120));
        lblSubtitulo.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
        lblSubtitulo.setBounds(formX + 30, 120, 200, 25);
        contentPane.add(lblSubtitulo);

        JLabel lblMail = new JLabel("Correo");
        lblMail.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblMail.setForeground(new Color(0, 91, 0));
        lblMail.setBounds(formX, 170, 200, 25);
        contentPane.add(lblMail);

        inpMail = new JTextField();
        inpMail.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        inpMail.setBounds(formX, 198, 250, 35);
        inpMail.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(200, 200, 200), 1),
            BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(inpMail);
        inpMail.setColumns(10);

        JLabel lblPass = new JLabel("Contraseña");
        lblPass.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblPass.setForeground(new Color(0, 91, 0));
        lblPass.setBounds(formX, 260, 200, 25);
        contentPane.add(lblPass);

        inpPassword = new JPasswordField();
        inpPassword.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        inpPassword.setBounds(formX, 288, 250, 35);
        inpPassword.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(200, 200, 200), 1),
            BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(inpPassword);

        JButton btnLogin = new JButton("Ingresar");
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBackground(new Color(0, 91, 0));
        btnLogin.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
        btnLogin.setBounds(formX, 370, 250, 45);
        btnLogin.setBorder(null);
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogin.setFocusPainted(false);
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogin.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogin.setBackground(new Color(0, 91, 0));
            }
        });
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iniciarSesion();
            }
        });
        contentPane.add(btnLogin);

        inpMail.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    inpPassword.requestFocus();
                }
            }
        });

        inpPassword.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    iniciarSesion();
                }
            }
        });
        
        // BOTON CERRAR en navbar (ya existe en VentanaBase)
        // BOTON MINIMIZAR en navbar (ya existe en VentanaBase)
    }

    private void iniciarSesion() {
        String email = inpMail.getText();
        String password = new String(inpPassword.getPassword());

        Usuario usuarioLogueado = Usuario.Login(email, password);

        if (usuarioLogueado != null) {
            if (usuarioLogueado instanceof Administrador) {
                MenuAdministrador menuAdmin = new MenuAdministrador(usuarioLogueado);
                menuAdmin.setVisible(true);
                dispose();
            } else if (usuarioLogueado instanceof Operativo) {
                MenuOperativo menuOperativo = new MenuOperativo(usuarioLogueado);
                menuOperativo.setVisible(true);
                dispose();
            } else {
                MenuVendedor menuVendedor = new MenuVendedor(usuarioLogueado);
                menuVendedor.setVisible(true);
                dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto");
        }
    }
}