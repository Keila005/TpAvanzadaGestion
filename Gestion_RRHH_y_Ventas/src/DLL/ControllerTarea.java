package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ControllerTarea {
	private static Connection con =
            Conexion.getInstance().getConnection();
	
	public void crearTarea(
			String nombre,
			String descripcion,
			int idProyecto,
			int idEmpleado) {
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(
					
					"INSERT INTO tarea("
					+ "nombre,descripcion,estado,progreso,"
					+ "id_proyecto,id_empleado)"
					+ "VALUES (?,?,?,?,?,?)");
			
			stmt.setString(1, nombre);
			stmt.setString(2, descripcion);
			stmt.setString(3, "Pendiente");
			stmt.setInt(4, 0);
			stmt.setInt(5, idProyecto);
			stmt.setInt(6, idEmpleado);
			
			stmt.executeUpdate();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String mostrarKanban(int idProyecto) {

	    String tablero = "";

	    try {

	        PreparedStatement stmt = con.prepareStatement(

	            "SELECT * FROM tarea "
	            + "WHERE id_proyecto = ?"
	        );

	        stmt.setInt(1, idProyecto);

	        ResultSet rs = stmt.executeQuery();

	        while(rs.next()) {

	            tablero +=
	                    "TAREA: "
	                    + rs.getString("descripcion")

	                    + "\nESTADO: "
	                    + rs.getString("estado")

	                    + "\nPROGRESO: "
	                    + rs.getInt("progreso")
	                    + "%\n\n";
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return tablero;
	}
	
	public String tareasEmpleado(int idEmpleado) {

	    String tareas = "";

	    try {

	        PreparedStatement stmt = con.prepareStatement(

	            "SELECT * FROM tarea "
	            + "WHERE id_empleado = ?"
	        );

	        stmt.setInt(1, idEmpleado);

	        ResultSet rs = stmt.executeQuery();

	        while(rs.next()) {

	            tareas +=
	                    rs.getString("descripcion")

	                    + " | "

	                    + rs.getString("estado")

	                    + "\n";
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return tareas;
	}
	
	public void trabajarTarea(int idTarea) {

		try {

			PreparedStatement stmt = con.prepareStatement(

					"UPDATE tarea "
					+ "SET progreso = progreso + 33, "
					+ "estado = 'EN PROCESO' "
					+ "WHERE id_tarea = ?"
			);

			stmt.setInt(1, idTarea);

			stmt.executeUpdate();

		} catch(Exception e) {

			e.printStackTrace();
		}
	}
	
	public void completarTarea(int idTarea) {

		try {

			PreparedStatement stmt = con.prepareStatement(

					"UPDATE tarea "
					+ "SET estado = 'FINALIZADA', "
					+ "progreso = 100 "
					+ "WHERE id_tarea = ?"
			);

			stmt.setInt(1, idTarea);

			stmt.executeUpdate();

		} catch(Exception e) {

			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
}

//fin de controller
