package DLL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import com.mysql.jdbc.Connection;

import LogicLayer.Operativo;
import LogicLayer.Roles;
import LogicLayer.Vendedor;

public class ControllerVendedor {
	
	private static Connection con = Conexion.getInstance().getConnection();
	
	
	public LinkedList<Vendedor> mostrarVendedor() {
		 
		 LinkedList<Vendedor> miembrosVendedor = new LinkedList<>();
		 
		 try {

	          PreparedStatement stmt = con.prepareStatement
	        		  (" SELECT v.id_empleado,"
	        		  		+ "v.comision,"
	        		  		+ "v.ventas_totales,"
	        		  		+ "u.nombre,"
	        		  		+ "u.apellido"
	        		  		+ "FROM vendedor v"
	        		  		+ "INNER JOIN empleado e"
	        		  		+ "ON v.id_empleado = e.id_empleado"
	        		  		+ "INNER JOIN usuario u"
	        		  		+ "ON e.id_usuario = u.id_usuario");
	              ResultSet rs = stmt.executeQuery();

	              while(rs.next()) {
	            	  
	            	  int idEmpleado =rs.getInt("id_empleado");

	                  Double comision =rs.getDouble("comision");

	                  int ventas_totales =rs.getInt("ventas_totales");

	                  String nombre =rs.getString("nombre");

	                  String apellido =rs.getString("apellido");

	  
	            	  
	            	 
	            	  Vendedor ven = new Vendedor(idEmpleado,comision,ventas_totales);

	                  ven.setNombre(nombre);
	                  ven.setApellido(apellido);

	                  miembrosVendedor.add(ven);
	              }
	          } catch(Exception e) {
	          }

	          return miembrosVendedor;
	      }
	

}//fin clase
