package UserLayer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import DLL.Conexion;
import LogicLayer.Usuario;

public class Main {
public static void main(String[] args) {
// hola estoy probando q onda
	Conexion.getInstance();
	
	String []menu= {"Login","Salir"};
	int opcion;
	do {
		opcion = JOptionPane.showOptionDialog(null, "Bienvenidos al sistema de gestion de RRHH y Comerciales", null, 0, JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("../img/tienda.png")), menu, menu[0]);
		switch(opcion) {
		case 0:
			String mail = JOptionPane.showInputDialog("Ingrese su mail");
			String contrasenia = JOptionPane.showInputDialog("Ingrese su contraseña");
			Usuario user=Usuario.login(mail, contrasenia);
			if (user==null) {
				 JOptionPane.showMessageDialog(null, "Volviendo al menú principal...","Cargando",
						 JOptionPane.DEFAULT_OPTION,new ImageIcon(Main.class.getResource("/img/cargando.gif")));
	                break; 
			}else {	
				user.Menu();
			}
			break;
		}
	} while (opcion!=1);
}
}
