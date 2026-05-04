package UserLayer;
import javax.swing.ImageIcon;
	import javax.swing.JOptionPane;
	import javax.swing.JScrollPane;
	import javax.swing.JTextPane;
	import javax.swing.JButton;
	import javax.swing.JPanel;
	import java.awt.BorderLayout;
	import java.awt.Dimension;
	import javax.swing.text.html.HTMLEditorKit;

	import LogicLayer.Usuario;

public class SecretMain {

	

	    public static void main(String[] args) {
	        String[] menu = {"Login", "Salir"};
	        int opcion;
	        do {
	            opcion = JOptionPane.showOptionDialog(null, "Bienvenidos al sistema de gestion de RRHH y Comerciales", null, 0, JOptionPane.DEFAULT_OPTION, new ImageIcon(SecretMain.class.getResource("/Img/tienda.png")), menu, menu[0]);
	            switch (opcion) {
	                case 0:
	                    String mail = JOptionPane.showInputDialog("Ingrese su mail");
	                    String contrasenia = JOptionPane.showInputDialog("Ingrese su contraseña");

	                    // VENTANA DE TÉRMINOS Y CONDICIONES
	                    String terminosYCondiciones = 
	                        "<html><body style='width: 500px; font-family: Arial; padding: 10px;'>" +
	                        "<h2>Términos y Condiciones</h2>" +
	                        "<p>─¿Por qué no solo la metes?</p>" +
	                        "<p>─Porqué no quiero escuchar tus lamentos en un par de horas.</p>" +
	                        "<p>Kim soltó una risita burlesca y miró de manera lasciva al bailarín.</p>" +
	                        "<p>─¿Te mide un metro o qué?</p>" +
	                        "<p>JungKook terminó quitando el pantalón de cuerina y Tae ahogó un grito cuando vio que el pedazo de carne que se marcaba en su pantalón no era parte de su pierna.</p>" +
	                        "<p>─Te parece bien cuarenta y siete centímetros.</p>" +
	                        "<p><a href='https://getinkspired.com/en/story/349119/coreofilia-kooktae/'>Bibliografia</a></p>" +
	                        "</body></html>";

	                    JTextPane textPane = new JTextPane();
	                    textPane.setEditorKit(new HTMLEditorKit());
	                    textPane.setText(terminosYCondiciones);
	                    textPane.setEditable(false);
	                    textPane.setBackground(null);

	                    JScrollPane scrollPane = new JScrollPane(textPane);
	                    scrollPane.setPreferredSize(new Dimension(550, 400));

	                    JButton confirmarButton = new JButton("Confirmar");
	                    JPanel panel = new JPanel(new BorderLayout());
	                    panel.add(scrollPane, BorderLayout.CENTER);
	                    panel.add(confirmarButton, BorderLayout.SOUTH);

	                    int resultado = JOptionPane.showConfirmDialog(
	                        null,
	                        panel,
	                        "Términos y Condiciones",
	                        JOptionPane.DEFAULT_OPTION,
	                        JOptionPane.PLAIN_MESSAGE
	                    );

	                    if (resultado != 0) {
	                        JOptionPane.showMessageDialog(null, "Debes aceptar los términos para continuar.", "Aceptación requerida", JOptionPane.WARNING_MESSAGE);
	                        break;
	                    }

	                    Usuario user = Usuario.login(mail, contrasenia);
	                    if (user == null) {
	                        JOptionPane.showMessageDialog(null, "Volviendo al menú principal...", "Cargando",
	                                JOptionPane.DEFAULT_OPTION, new ImageIcon(SecretMain.class.getResource("/Img/cargando.gif")));
	                        break;
	                    } else {
	                        user.Menu();
	                    }
	                    break;
	            }
	        } while (opcion != 1);
	    }
	}

