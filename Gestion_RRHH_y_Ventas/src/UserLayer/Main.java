package UserLayer;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import DLL.ControllerUsuario;
import DLL.Hashing;
import LogicLayer.Empleado;
import LogicLayer.Usuario;
import LogicLayer.Vendedor;

public class Main {
	public static void main(String[] args) {
		ControllerUsuario nuevo = new ControllerUsuario();
		String[] acciones = { "Login", "Salir" };
	    int menu = 0;
	    Usuario usuarioLogueado = null;
		 nuevo.mostrarUsuarios();
		 
		 //System.out.println(Hashing.hash("1234"));
	    do {
	    	menu = JOptionPane.showOptionDialog(null, "Bienvenidos al sistema de gestion de RRHH y Comerciales", null, 0, JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("../img/tienda.png")), acciones, acciones[0]);
	        switch (menu) {
	        
	            case 0:// login
	            	 Usuario usuario = Usuario.Login();
	            	 if(usuario != null) {
	            		    usuario.Menu();
	            		    usuarioLogueado = usuario;
	            		    
	            		} else {
	            		    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto");
	            		}
	                     
	                break;
	            case 1:
	                if (usuarioLogueado != null) {
	                    DLL.ControllerAsistencia asis = new DLL.ControllerAsistencia();
	                    int idEmpleado = asis.getIdEmpleadoByUsuario(usuarioLogueado.getIdUsuario());
	                    if (idEmpleado != -1) {
	                        asis.registrarSalida(idEmpleado);
	                        JOptionPane.showMessageDialog(null, "Salida registrada. Hasta luego!");
	                    }
	                }
	                menu = 1;
	                break;
	        }
	    } while (menu != 1);
	}
	
}
