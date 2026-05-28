package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class ControllerProyecto {

	private static Connection con =
            Conexion.getInstance().getConnection();
	
	public void crearProyecto(
			String nombre,
			String descripcion,
			LocalDate inicio,
			LocalDate fin,
			int idLider,
			int idEquipo) {
		
		try {
			 PreparedStatement stmt = con.prepareStatement(

		                "INSERT INTO proyecto("
		                + "nombre,descripcion,fecha_inicio,"
		                + "fecha_fin,id_lider,id_equipo)"
		                + " VALUES(?,?,?,?,?,?)"
		            );
			 
			 stmt.setString(1, nombre);
			 stmt.setString(2, descripcion);
			 stmt.setDate(3, java.sql.Date.valueOf(inicio));
			 stmt.setDate(4, java.sql.Date.valueOf(fin));
			 stmt.setInt(5, idLider);
			 stmt.setInt(6, idEquipo);
			 

		} catch(Exception e) {
			 e.printStackTrace();
		}
		
	}
	
	public void asignarLider(
	        int idProyecto,
	        int nuevoLider) {

	    try {

	        PreparedStatement stmt = con.prepareStatement(

	            "UPDATE proyecto "
	            + "SET id_lider = ? "
	            + "WHERE id_proyecto = ?"
	        );

	        stmt.setInt(1, nuevoLider);
	        stmt.setInt(2, idProyecto);

	        stmt.executeUpdate();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
}
