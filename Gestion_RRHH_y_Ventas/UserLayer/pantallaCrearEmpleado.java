package UserLayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import DLL.ControllerUsuario;
import DLL.Hashing;
import LogicLayer.Administrador;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class pantallaCrearEmpleado extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private JTextField inpName;
    private JTextField inpApellido;
    private JTextField inpEmail;
    private JPasswordField inpContra;
    private JTextField inpDni;
    private JTextField inpSueldo;
    private byte[] fotoPerfil;

    private static ControllerUsuario usuarioController = new ControllerUsuario();

    public pantallaCrearEmpleado(MenuGestionar menuGestionar, Administrador admin) {

        JLabel lblTitulo = new JLabel("Crear Empleado");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 50, 250, 30);
        contentPane.add(lblTitulo);

        JLabel lblName = new JLabel("Nombre:");
        lblName.setForeground(new Color(0, 91, 0));
        lblName.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblName.setBounds(80, 100, 100, 25);
        contentPane.add(lblName);

        inpName = new JTextField();
        inpName.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        inpName.setBounds(80, 125, 180, 35);
        inpName.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(inpName);
        inpName.setColumns(10);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setForeground(new Color(0, 91, 0));
        lblApellido.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblApellido.setBounds(280, 100, 100, 25);
        contentPane.add(lblApellido);

        inpApellido = new JTextField();
        inpApellido.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        inpApellido.setBounds(280, 125, 180, 35);
        inpApellido.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(inpApellido);
        inpApellido.setColumns(10);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setForeground(new Color(0, 91, 0));
        lblEmail.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblEmail.setBounds(80, 180, 100, 25);
        contentPane.add(lblEmail);

        inpEmail = new JTextField();
        inpEmail.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        inpEmail.setBounds(80, 205, 380, 35);
        inpEmail.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(inpEmail);
        inpEmail.setColumns(10);

        JLabel lblContra = new JLabel("Contraseña:");
        lblContra.setForeground(new Color(0, 91, 0));
        lblContra.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblContra.setBounds(80, 260, 100, 25);
        contentPane.add(lblContra);

        inpContra = new JPasswordField();
        inpContra.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        inpContra.setBounds(80, 285, 180, 35);
        inpContra.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(inpContra);

        JLabel lblDni = new JLabel("DNI:");
        lblDni.setForeground(new Color(0, 91, 0));
        lblDni.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblDni.setBounds(280, 260, 100, 25);
        contentPane.add(lblDni);

        inpDni = new JTextField();
        inpDni.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        inpDni.setBounds(280, 285, 180, 35);
        inpDni.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(inpDni);
        inpDni.setColumns(10);

        JLabel lblSueldo = new JLabel("Sueldo Base:");
        lblSueldo.setForeground(new Color(0, 91, 0));
        lblSueldo.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblSueldo.setBounds(80, 340, 100, 25);
        contentPane.add(lblSueldo);

        inpSueldo = new JTextField();
        inpSueldo.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        inpSueldo.setBounds(80, 365, 180, 35);
        inpSueldo.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(inpSueldo);
        inpSueldo.setColumns(10);

        JLabel lblRol = new JLabel("Rol:");
        lblRol.setForeground(new Color(0, 91, 0));
        lblRol.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblRol.setBounds(480, 100, 100, 25);
        contentPane.add(lblRol);

        JRadioButton rdbtnOperativo = new JRadioButton("Operativo");
        rdbtnOperativo.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        rdbtnOperativo.setForeground(new Color(0, 91, 0));
        rdbtnOperativo.setBackground(Color.WHITE);
        rdbtnOperativo.setBounds(480, 125, 120, 30);
        contentPane.add(rdbtnOperativo);

        JRadioButton rdbtnVendedor = new JRadioButton("Vendedor");
        rdbtnVendedor.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        rdbtnVendedor.setForeground(new Color(0, 91, 0));
        rdbtnVendedor.setBackground(Color.WHITE);
        rdbtnVendedor.setBounds(480, 160, 120, 30);
        contentPane.add(rdbtnVendedor);

        ButtonGroup grupoRol = new ButtonGroup();
        grupoRol.add(rdbtnOperativo);
        grupoRol.add(rdbtnVendedor);

        JRadioButton rdbtnLider = new JRadioButton("Lider");
        rdbtnLider.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        rdbtnLider.setForeground(new Color(0, 91, 0));
        rdbtnLider.setBackground(Color.WHITE);
        rdbtnLider.setBounds(620, 125, 100, 30);
        rdbtnLider.setVisible(false);
        contentPane.add(rdbtnLider);

        JRadioButton rdbtnMiembro = new JRadioButton("Miembro");
        rdbtnMiembro.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        rdbtnMiembro.setForeground(new Color(0, 91, 0));
        rdbtnMiembro.setBackground(Color.WHITE);
        rdbtnMiembro.setBounds(620, 160, 100, 30);
        rdbtnMiembro.setVisible(false);
        contentPane.add(rdbtnMiembro);

        ButtonGroup grupoOperativo = new ButtonGroup();
        grupoOperativo.add(rdbtnLider);
        grupoOperativo.add(rdbtnMiembro);

        rdbtnOperativo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnLider.setVisible(true);
                rdbtnMiembro.setVisible(true);
            }
        });

        rdbtnVendedor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnLider.setVisible(false);
                rdbtnMiembro.setVisible(false);
                grupoOperativo.clearSelection();
            }
        });

        JLabel lblFoto = new JLabel("Foto de Perfil:");
        lblFoto.setForeground(new Color(0, 91, 0));
        lblFoto.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblFoto.setBounds(480, 210, 150, 25);
        contentPane.add(lblFoto);

        JButton btnFoto = new JButton("Cargar Foto");
        btnFoto.setForeground(Color.WHITE);
        btnFoto.setBackground(new Color(0, 91, 0));
        btnFoto.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        btnFoto.setBounds(480, 240, 150, 35);
        btnFoto.setBorder(null);
        btnFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFoto.setFocusPainted(false);
        btnFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFoto.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFoto.setBackground(new Color(0, 91, 0));
            }
        });
        btnFoto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "Imagenes (JPG, PNG, JPEG)", "jpg", "jpeg", "png");
                chooser.setFileFilter(filter);
                int option = chooser.showOpenDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = chooser.getSelectedFile();
                    String nombreArchivo = selectedFile.getName().toLowerCase();
                    if (!(nombreArchivo.endsWith(".jpg") || nombreArchivo.endsWith(".jpeg") || nombreArchivo.endsWith(".png"))) {
                        JOptionPane.showMessageDialog(null, "Solo se permiten archivos JPG, JPEG o PNG.");
                        return;
                    }
                    try {
                        fotoPerfil = Files.readAllBytes(selectedFile.toPath());
                        JOptionPane.showMessageDialog(null, "Imagen cargada correctamente.");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al leer la imagen.");
                    }
                }
            }
        });
        contentPane.add(btnFoto);

        JButton btnCrear = new JButton("Crear Empleado");
        btnCrear.setForeground(Color.WHITE);
        btnCrear.setBackground(new Color(0, 91, 0));
        btnCrear.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
        btnCrear.setBounds(280, 440, 300, 50);
        btnCrear.setBorder(null);
        btnCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrear.setFocusPainted(false);
        btnCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrear.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrear.setBackground(new Color(0, 91, 0));
            }
        });
        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnOperativo.isSelected()) {
                    if (rdbtnLider.isSelected()) {
                        usuarioController.crearOperativo(
                                inpName.getText(),
                                inpApellido.getText(),
                                inpEmail.getText(),
                                Hashing.hash(new String(inpContra.getPassword())),
                                Integer.parseInt(inpDni.getText()),
                                Double.parseDouble(inpSueldo.getText()),
                                "Lider de Proyecto",
                                fotoPerfil);
                        menuGestionar.cargarTabla();
                        dispose();
                        JOptionPane.showMessageDialog(null, "Se creo correctamente el empleado Lider");
                    } else if (rdbtnMiembro.isSelected()) {
                        usuarioController.crearOperativo(
                                inpName.getText(),
                                inpApellido.getText(),
                                inpEmail.getText(),
                                Hashing.hash(new String(inpContra.getPassword())),
                                Integer.parseInt(inpDni.getText()),
                                Double.parseDouble(inpSueldo.getText()),
                                "Miembro de Proyecto",
                                fotoPerfil);
                        menuGestionar.cargarTabla();
                        JOptionPane.showMessageDialog(null, "Se creo correctamente el empleado miembro");
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Debes elegir Lider o Miembro");
                    }
                } else if (rdbtnVendedor.isSelected()) {
                    usuarioController.crearVendedor(
                            inpName.getText(),
                            inpApellido.getText(),
                            inpEmail.getText(),
                            Hashing.hash(new String(inpContra.getPassword())),
                            Integer.parseInt(inpDni.getText()),
                            Double.parseDouble(inpSueldo.getText()),
                            fotoPerfil);
                    menuGestionar.cargarTabla();
                    JOptionPane.showMessageDialog(null, "Se creo correctamente el empleado Vendedor");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Debe elegir un rol");
                }
            }
        });
        contentPane.add(btnCrear);

        JButton btnVolver = crearBotonRojo("Volver", EstilosGlobales.ANCHO_VENTANA - 130, EstilosGlobales.ALTO_VENTANA - 55, 110, 35);
        btnVolver.addActionListener(e -> {
            MenuGestionar gestion = new MenuGestionar(admin);
            gestion.setVisible(true);
            dispose();
        });
        contentPane.add(btnVolver);

        seleccionarTabPorIndice(0);
    }
}