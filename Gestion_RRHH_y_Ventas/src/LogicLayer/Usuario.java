package LogicLayer;

import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Usuario {
	private String nombre;
	private String apellido;
	private String mail;
	private String contrasenia;
	public double sueldo;
	public String rol;
	private static LinkedList<Actores> listusuarios;
	
	public Usuario(String nombre,String apellido, String mail, String contrasenia) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.contrasenia = contrasenia;
	}
	
	public static LinkedList<Actores> getListusuarios() {
        if (listusuarios == null) {
            listusuarios = new LinkedList<>();
            sobrecarga(); 
        }
        return listusuarios;
    }
	
	public static void setListusuarios(LinkedList<Actores> listusuarios) {
		Usuario.listusuarios = listusuarios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	
	@Override
	public String toString() {
		return "Usuario: nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", contrasenia="
				+ contrasenia + "\n";
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	//prueba 
	public static Usuario loginBD(String email, String pass) {
	    return DLL.ControllerUsuario.login(email, pass);
	}

	public static Usuario login(String mail, String contrasenia) {
	        for (Actores a : getListusuarios()) {
	            if (a.getUsuario().getMail().equalsIgnoreCase(mail) &&
	                a.getUsuario().getContrasenia().equals(contrasenia)) {
	                return a.getUsuario();
	            }
	        }
	        //SI se escribe bien el mail pero no la contra entonces existe la cuenta
	        boolean usuarioExiste = false;
		    for (Actores a : listusuarios) {
		        if (a.getUsuario().getMail().equalsIgnoreCase(mail)) {
		        	//pero la contra esta mal
		            usuarioExiste = true;
		            break; // sale del for
		        }
		    }

		    if (usuarioExiste) {
		        JOptionPane.showMessageDialog(null, "La contraseña es incorrecta","Incorrecto",JOptionPane.DEFAULT_OPTION,
		        		new ImageIcon(Usuario.class.getResource("/img/nohay.png")));
		    } else {
		        JOptionPane.showMessageDialog(null, "El usuario no pertenece a este sistema.\nPor favor, contactar con la empresa","No registrado",JOptionPane.DEFAULT_OPTION,
		        		new ImageIcon(Usuario.class.getResource("/img/nohay.png")));
		    }
	        return null;
	    }
	public void Menu(){};	
	
	public static void sobrecarga() {
	    
	    //ESTE ES EL ADMINISTRADOR
	    getListusuarios().add(new Actores(new Administrador("Admin","Perez","admin@mail.com","1234",1,"Area de gestion")));
	    
	    //ESTE ES EL EMPLEADO LIDER
	    Operativo juan = new Operativo("Juan", "Gomez", "empleadoLider@mail.com", "1234", 1234555, 1000, LocalDate.of(1999,12,30), 0, Roles.LIDER_PROYECTO, 0);
	    juan.setHorasExtra(8);
	    getListusuarios().add(new Actores(juan));
	    
	    //ESTE ES EL EMPLEADO MIEMBRO
	    getListusuarios().add(new Actores(new Operativo("Pedro", "Pablo", "empleadoMiembro@mail.com", "1234", 1234566, 500, LocalDate.of(2008,5,25), 0, Roles.MIEMBRO_PROYECTO, 0)));
	    
	    //ESTE ES EL EMPLEADO VENDEDOR
	    getListusuarios().add(new Actores(new Vendedor("Fulanito", "Lopez", "empleadoVendedor@mail.com", "1234", 45684332, 5000, LocalDate.of(2010,10,23), 0, 1000, 0)));
	}
}
