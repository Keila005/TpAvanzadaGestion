package UserLayer;

import javax.swing.JOptionPane;

import DLL.ControllerUsuario;
import LogicLayer.Usuario;

public class Main2 {
	public static void main(String[] args) {
		
		
		ControllerUsuario nuevo = new ControllerUsuario();
		
//		JOptionPane.showMessageDialog(null, nuevo.mostrarUsuarios());
		String[] acciones = { "Login", "Salir" };
	    int menu = 0;
	    
	    do {
	        menu = JOptionPane.showOptionDialog(null, "Bienvenido", null, 0, 0, null, acciones, acciones[0]);

	        switch (menu) {
	            case 0:// login
	                String mail = "";
	                while (mail.isEmpty()) {
	                	mail = JOptionPane.showInputDialog("Ingrese mail");
	                    if (mail.isEmpty()) {
	                        JOptionPane.showMessageDialog(null, "Incorrecto");
	                    }
	                }

	                String contrasenia = "";
	                while (contrasenia.isEmpty()) {
	                    contrasenia = JOptionPane.showInputDialog("Ingrese contraseña");
	                    if (contrasenia.isEmpty()) {
	                        JOptionPane.showMessageDialog(null, "Incorrecto");
	                    }
	                }

	                Usuario usuario= nuevo.login(mail, contrasenia);  
	                

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
	        }
	    } while (menu != 1);
	}
	
}
