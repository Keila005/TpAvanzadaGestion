package DLL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import com.mysql.jdbc.Connection;
import LogicLayer.Empleado;
import LogicLayer.Vendedor;


public class ControllerEmpleado {
	
	private static Connection con = Conexion.getInstance().getConnection();
	
	public Vendedor buscarVendedorPorUsuario(int idUsuario) {

	    Vendedor vendedor = null;

	    try {

	        PreparedStatement stmt = con.prepareStatement(

	        		"SELECT e.id_empleado, " +
	        				"e.dni, " +
	        				"e.sueldo_base, " +
	        				"u.nombre, " +
	        				"u.apellido, " +
	        				"u.email, " +
	        				"v.ventas_totales " +
	        				"FROM empleado e " +
	        				"INNER JOIN usuario u " +
	        				"ON e.id_usuario = u.id_usuario " +
	        				"INNER JOIN vendedor v " +
	        				"ON e.id_empleado = v.id_empleado " +
	        				"WHERE e.id_usuario = ?"
	        );

	        stmt.setInt(1, idUsuario);

	        ResultSet rs = stmt.executeQuery();

	        if(rs.next()) {

	            vendedor = new Vendedor();

	            vendedor.setIdEmpleado(
	                    rs.getInt("id_empleado")
	            );

	            vendedor.setDni(
	                    rs.getInt("dni")
	            );

	            vendedor.setSueldoBase(
	                    rs.getDouble("sueldo_base")
	            );

	            vendedor.setVentasTotales(
	                    rs.getInt("ventas_totales")
	            );
	            
	            vendedor.setNombre(
	                    rs.getString("nombre")
	            );

	            vendedor.setApellido(
	                    rs.getString("apellido")
	            );

	            vendedor.setMail(
	                    rs.getString("email")
	            );
	        }

	        stmt.close();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return vendedor;
	}
	
	public LinkedList<Empleado> mostrarEmpleados() {

	    LinkedList<Empleado> empleados = new LinkedList<>();

	    try {

	        String sql =
	                "SELECT e.id_empleado, u.nombre, u.apellido, u.email, e.dni,e.perfil, e.sueldo_base " +
	                "FROM empleado e " +
	                "JOIN usuario u ON e.id_usuario = u.id_usuario";

	        PreparedStatement stmt = con.prepareStatement(sql);

	        ResultSet rs = stmt.executeQuery();

	        while(rs.next()) {

	            Empleado e =new Empleado();

	            e.setIdEmpleado(rs.getInt("id_empleado"));
	            e.setNombre(rs.getString("nombre"));
	            e.setApellido(rs.getString("apellido"));
	            e.setMail(rs.getString("email"));
	            e.setDni(rs.getInt("dni"));
	            e.setSueldoBase(rs.getDouble("sueldo_base"));
	            e.setPerfil(rs.getBytes("perfil"));
	            empleados.add(e);
	        }

	    } catch(Exception ex) {
	        ex.printStackTrace();
	    }

	    return empleados;
	    
	    
	    
	    
	    
	}
	
	
	
}// FIN DE LA CLASE
