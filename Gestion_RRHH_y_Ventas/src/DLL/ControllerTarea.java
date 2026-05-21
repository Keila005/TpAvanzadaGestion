package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ControllerTarea {
	private static Connection con =
            Conexion.getInstance().getConnection();
	
	public void crearTarea(
			String descripcion,
			int idProyecto,
			int idEmpleado) {
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(
					
					"INSERT INT tarea("
					+ "descripcion,estado,progreso"
					+ "id_proyecto,id_empleado"
					+ "VALUES (?,?,?,?,?");
			
			stmt.setString(1, descripcion);
			stmt.setString(2, "Pendiente");
			stmt.setInt(3, 0);
			stmt.setInt(4, idProyecto);
			stmt.setInt(5, idEmpleado);
			
			stmt.executeUpdate();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
