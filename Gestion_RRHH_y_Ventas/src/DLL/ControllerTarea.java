package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	
	
	
	
	
}
