package DLL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import com.mysql.jdbc.Connection;
import LogicLayer.Operativo;
import LogicLayer.Roles;

public class ControllerOperativo {
	private static Connection con = Conexion.getInstance().getConnection();
	
	
	 public LinkedList<Operativo> mostrarOperativos() {
		 
		 LinkedList<Operativo> miembrosOperativos = new LinkedList<>();
		 
		 try {

	          PreparedStatement stmt = con.prepareStatement
	        		  (" SELECT o.id_empleado,"
	        		  		+ "o.rol,"
	        		  		+ "o.rendimiento,"
	        		  		+ "u.nombre,"
	        		  		+ "u.apellido"
	        		  		+ "FROM operativo o"
	        		  		+ "INNER JOIN empleado e"
	        		  		+ "ON o.id_empleado = e.id_empleado"
	        		  		+ "INNER JOIN usuario u"
	        		  		+ "ON e.id_usuario = u.id_usuario");
	              ResultSet rs = stmt.executeQuery();

	              while(rs.next()) {
	            	  
	            	  int idEmpleado =rs.getInt("id_empleado");

	                  String rol =rs.getString("rol");

	                  int rendimiento =rs.getInt("rendimiento");

	                  String nombre =rs.getString("nombre");

	                  String apellido =rs.getString("apellido");

	            	  Roles tipoRol;
	            	  
	            	  if (rol.equalsIgnoreCase("Lider de Proyecto")) {
						 tipoRol= Roles.LIDER_PROYECTO;
					}else {
						 tipoRol= Roles.MIEMBRO_PROYECTO;
					}
	            	  Operativo op = new Operativo(idEmpleado,tipoRol,rendimiento);

	                  op.setNombre(nombre);
	                  op.setApellido(apellido);

	                  miembrosOperativos.add(op);
	              }
	          } catch(Exception e) {
	          }

	          return miembrosOperativos;
	      }
}
