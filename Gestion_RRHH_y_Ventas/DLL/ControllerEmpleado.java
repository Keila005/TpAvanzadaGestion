package DLL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import com.mysql.jdbc.Connection;
import LogicLayer.Empleado;


public class ControllerEmpleado {
	
	private static Connection con = Conexion.getInstance().getConnection();
	
	
	public LinkedList<Empleado> mostrarEmpleados() {

	    LinkedList<Empleado> empleados = new LinkedList<>();

	    try {

	        String sql =
	                "SELECT e.id_empleado, u.nombre, u.apellido, u.email, e.dni, e.sueldo_base " +
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

	            empleados.add(e);
	        }

	    } catch(Exception ex) {
	        ex.printStackTrace();
	    }

	    return empleados;
	}
}// FIN DE LA CLASE
