package UserLayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;
import DLL.ControllerUsuario;
import LogicLayer.Administrador;
import LogicLayer.Empleado;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class EditarUsuario extends VentanaBase {

    private static final long serialVersionUID = 1L;
    private JTextField inpName;
    private JTextField inpApellido;
    private JTextField inpEmail;
    private JTextField inpDni;
    private JTextField inpSueldo;
    private static ControllerUsuario usuarioController = new ControllerUsuario();
    private JButton btnActualizar;
    private JButton btnActualizar_1;
    private byte[] fotoPerfil;
    private JLabel lblImg;

    public EditarUsuario(Empleado empleado, Administrador admin) {

        JLabel lblTitulo = new JLabel("Editar Usuario");
        lblTitulo.setForeground(new Color(0, 91, 0));
        lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        lblTitulo.setBounds(350, 60, 250, 30);
        contentPane.add(lblTitulo);

        // Columna izquierda
        JLabel lblName = new JLabel("Nombre:");
        lblName.setForeground(new Color(0, 91, 0));
        lblName.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblName.setBounds(80, 120, 100, 25);
        contentPane.add(lblName);

        inpName = new JTextField();
        inpName.setText(empleado.getNombre());
        inpName.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        inpName.setBackground(Color.WHITE);
        inpName.setBounds(80, 145, 200, 35);
        inpName.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(inpName);
        inpName.setColumns(10);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setForeground(new Color(0, 91, 0));
        lblApellido.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblApellido.setBounds(300, 120, 100, 25);
        contentPane.add(lblApellido);

        inpApellido = new JTextField();
        inpApellido.setText(empleado.getApellido());
        inpApellido.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        inpApellido.setBackground(Color.WHITE);
        inpApellido.setBounds(300, 145, 200, 35);
        inpApellido.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(inpApellido);
        inpApellido.setColumns(10);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setForeground(new Color(0, 91, 0));
        lblEmail.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblEmail.setBounds(80, 200, 100, 25);
        contentPane.add(lblEmail);

        inpEmail = new JTextField();
        inpEmail.setText(empleado.getMail());
        inpEmail.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        inpEmail.setBackground(Color.WHITE);
        inpEmail.setBounds(80, 225, 420, 35);
        inpEmail.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(inpEmail);
        inpEmail.setColumns(10);

        JLabel lblDni = new JLabel("DNI:");
        lblDni.setForeground(new Color(0, 91, 0));
        lblDni.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblDni.setBounds(80, 280, 100, 25);
        contentPane.add(lblDni);

        inpDni = new JTextField();
        inpDni.setText(String.valueOf(empleado.getDni()));
        inpDni.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        inpDni.setBackground(Color.WHITE);
        inpDni.setBounds(80, 305, 200, 35);
        inpDni.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(inpDni);
        inpDni.setColumns(10);

        JLabel lblSueldo = new JLabel("Sueldo Base:");
        lblSueldo.setForeground(new Color(0, 91, 0));
        lblSueldo.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblSueldo.setBounds(300, 280, 100, 25);
        contentPane.add(lblSueldo);

        inpSueldo = new JTextField();
        inpSueldo.setText(String.valueOf(empleado.getSueldoBase()));
        inpSueldo.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        inpSueldo.setBackground(Color.WHITE);
        inpSueldo.setBounds(300, 305, 200, 35);
        inpSueldo.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new Color(200, 200, 200), 1),
            javax.swing.BorderFactory.createEmptyBorder(5, 12, 5, 12)
        ));
        contentPane.add(inpSueldo);
        inpSueldo.setColumns(10);

        // Foto perfil
        JLabel lblFoto = new JLabel("Foto de Perfil:");
        lblFoto.setForeground(new Color(0, 91, 0));
        lblFoto.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        lblFoto.setBounds(560, 120, 150, 25);
        contentPane.add(lblFoto);

        lblImg = new JLabel("");
        lblImg.setBounds(560, 145, 150, 150);
        lblImg.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        ImageIcon icono = new ImageIcon(EditarUsuario.class.getResource("/Img/perfilLogo.png"));
        Image imagenEscalada = icono.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        lblImg.setIcon(new ImageIcon(imagenEscalada));
        contentPane.add(lblImg);

        btnActualizar = new JButton("Cargar Foto");
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setBackground(new Color(0, 91, 0));
        btnActualizar.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
        btnActualizar.setBounds(560, 305, 150, 35);
        btnActualizar.setBorder(null);
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.setFocusPainted(false);
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnActualizar.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnActualizar.setBackground(new Color(0, 91, 0));
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
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
                        ImageIcon icon = new ImageIcon(fotoPerfil);
                        Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                        lblImg.setIcon(new ImageIcon(img));
                        JOptionPane.showMessageDialog(null, "Imagen cargada correctamente.");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al leer la imagen.");
                    }
                }
            }
        });
        contentPane.add(btnActualizar);

        btnActualizar_1 = new JButton("Guardar Cambios");
        btnActualizar_1.setForeground(Color.WHITE);
        btnActualizar_1.setBackground(new Color(0, 91, 0));
        btnActualizar_1.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        btnActualizar_1.setBounds(280, 390, 220, 45);
        btnActualizar_1.setBorder(null);
        btnActualizar_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar_1.setFocusPainted(false);
        btnActualizar_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnActualizar_1.setBackground(new Color(20, 110, 12));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnActualizar_1.setBackground(new Color(0, 91, 0));
            }
        });
        btnActualizar_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    byte[] perfilFinal;
                    if (fotoPerfil != null) {
                        perfilFinal = fotoPerfil;
                    } else {
                        perfilFinal = empleado.getPerfil();
                    }
                    usuarioController.modificarEmpleado(
                            empleado.getIdEmpleado(), inpName.getText(), inpApellido.getText(),
                            inpEmail.getText(), Integer.parseInt(inpDni.getText()),
                            Double.parseDouble(inpSueldo.getText()), perfilFinal);
                    JOptionPane.showMessageDialog(null, "Se edito correctamente los datos");
                    MenuGestionar menugestion = new MenuGestionar(admin);
                    menugestion.setVisible(true);
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Verifique los datos ingresados");
                }
            }
        });
        contentPane.add(btnActualizar_1);

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