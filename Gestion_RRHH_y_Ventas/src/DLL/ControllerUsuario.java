package DLL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import com.mysql.jdbc.Connection;

import LogicLayer.Usuario;

public class ControllerUsuario {
	private static Connection con = Conexion.getInstance().getConnection();

	 public LinkedList<Usuario> mostrarUsuarios() {
	        LinkedList<Usuario> usuarios = new LinkedList<>();
	        try {
	            PreparedStatement stmt = con.prepareStatement("SELECT * FROM usuario");
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	                int id = rs.getInt("id_usuario");
	                String nombre = rs.getString("nombre");
	                String apellido = rs.getString("apellido");
	                String email = rs.getString("email");
	                String contrasenia = rs.getString("contrasenia");
	                
	                
	                usuarios.add(new Usuario(nombre,apellido,email,contrasenia));
	                
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return usuarios;
	    }
	 
	 public void agregarUsuario(Usuario usuario) {
	        try {
	            PreparedStatement statement = con.prepareStatement(
	            		"INSERT INTO `usuario`( `nombre`, `apellido`, `email`, `contrasenia`) VALUES (?,?,?,?)"
	                );
	            statement.setString(1, usuario.getNombre());
	            statement.setString(2,usuario.getApellido());
	            statement.setString(3, usuario.getMail());
	            statement.setString(4, usuario.getContrasenia());

	            int filas = statement.executeUpdate();
	            if (filas > 0) {
	                System.out.println("Usuario agregado correctamente.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 public Usuario login(String nombre, String password) {
	       Usuario usuario = null;
	        try {
	            PreparedStatement stmt = con.prepareStatement(
	                "SELECT * FROM usuario WHERE nombre = ? AND password = ?"
	            );
	            stmt.setString(1, nombre);
	            stmt.setString(2, password);

	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                int id = rs.getInt("id");
	                String email = rs.getString("email");
	                String tipo = rs.getString("tipo");

	             
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return usuario;
	    }
}
