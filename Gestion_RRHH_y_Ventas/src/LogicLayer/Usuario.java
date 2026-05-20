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
		return "Usuario: nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", contrasenia="
				+ contrasenia + "\n";
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public static Usuario Login() {
		String email = "";
        while (email.isEmpty()) {
        	email = JOptionPane.showInputDialog("Ingrese el nombre de usuario");
            if (email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Incorrecto");
            }
        }

        String contrasenia = "";
        while (contrasenia.isEmpty()) {
            contrasenia = JOptionPane.showInputDialog("Ingrese la contraseña");
            if (contrasenia.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Incorrecto");
            }
        }

        Usuario usuario = controller.login(email, contrasenia);
		return usuario;
	}
	
public static void Registrarse() {
		
		String nombre = Validador.ValidarString("Ingrese nombre");
			String mail=Validador.ValidarString("Ingrese mail");
		
//		String contrasenia	= Validador.ValidarString("Ingrese contraseña");
//		controller.agregarUsuario(new Empleado(
//				nombre,mail,"Empleado",Hashing.hash(contrasenia)));
		
	}
	
	public abstract void Menu();	
	
}
