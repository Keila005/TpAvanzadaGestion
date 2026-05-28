package UserLayer;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import DLL.ControllerUsuario;
import DLL.Hashing;
import LogicLayer.Usuario;

public class Main2 {
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
	                

	              //REGISTRAR       case 1: 
	            	
//	            	 String nombre =JOptionPane.showInputDialog("Ingrese nombre");
//	            	 String apellido =JOptionPane.showInputDialog("Ingrese apellido");
//	            	 String mail1 = "";
//	                 while (mail1.isEmpty()) {
//	                 	mail = JOptionPane.showInputDialog("Ingrese mail");
//	                     if (mail.isEmpty()) {
//	                         JOptionPane.showMessageDialog(null, "Incorrecto");
//	                     }
//	                 }
//
//	                 String contrasenia1 = "";
//	                 while (contrasenia1.isEmpty()) {
//	                     contrasenia = JOptionPane.showInputDialog("Ingrese contraseña");
//	                     if (contrasenia.isEmpty()) {
//	                         JOptionPane.showMessageDialog(null, "Incorrecto");
//	                     }
//	                 }
//	                
//	                 Usuario usuarioNuevo=new Usuario(nombre,apellido,mail1,contrasenia1);
//	                		 nuevo.agregarUsuario(usuarioNuevo); 
	                
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
