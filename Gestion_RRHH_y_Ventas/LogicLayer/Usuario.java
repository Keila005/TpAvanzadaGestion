package LogicLayer;

import javax.swing.JOptionPane;
import DLL.ControllerUsuario;
import DLL.Hashing;


public abstract class Usuario {
	private  int idUsuario;
	private String nombre;
	private String apellido;
	private String mail;
	private String contrasenia;
	 private static ControllerUsuario controller = new ControllerUsuario();
	
	public Usuario(String nombre,String apellido, String mail, String contrasenia) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.contrasenia = contrasenia;
	}
	
	public  Usuario() {
		
	}
	

	public Usuario(int idUsuario, String nombre, String apellido, String mail, String contrasenia) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.contrasenia = contrasenia;
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
	
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "Usuario: nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail ;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public static Usuario Login(String email,String contrasenia) {
		  if (email == null || email.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "El mail no puede estar vacío");
		        return null;
		    }

		    if (contrasenia == null || contrasenia.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "La contraseña no puede estar vacía");
		        return null;
		    }

		    Usuario usuario = controller.login(email, contrasenia);
        
		return usuario;
	}
		
	public abstract void Menu();	
	
}
