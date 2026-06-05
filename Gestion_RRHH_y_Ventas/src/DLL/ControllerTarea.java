package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import LogicLayer.Tarea;

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

		String pendientes = "";
		String proceso = "";
		String finalizadas = "";

	    try {

	        PreparedStatement stmt = con.prepareStatement(

	            "SELECT * FROM tarea "
	            + "WHERE id_proyecto = ?"
	        );

	        stmt.setInt(1, idProyecto);

	        ResultSet rs = stmt.executeQuery();

	        while(rs.next()) {

	            String tarea =
	                    rs.getString("nombre")
	                    + " - "
	                    + rs.getString("descripcion")
	                    + " ("
	                    + rs.getInt("progreso")
	                    + "%)\n";

	            String estado = rs.getString("estado");

	            if(estado.equalsIgnoreCase("Pendiente")) {

	                pendientes += tarea;

	            }

	            else if(estado.equalsIgnoreCase("EN PROCESO")) {

	                proceso += tarea;

	            }

	            else if(estado.equalsIgnoreCase("FINALIZADA")) {

	                finalizadas += tarea;
	            }
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return
	            "=== PENDIENTES ===\n"
	            + pendientes

	            + "\n=== EN PROCESO ===\n"
	            + proceso

	            + "\n=== FINALIZADAS ===\n"
	            + finalizadas;
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
	
	
	public LinkedList<Tarea> obtenerTareasEmpleado(int idEmpleado){

	    LinkedList<Tarea> lista = new LinkedList<>();

	    try {

	        PreparedStatement stmt = con.prepareStatement(
	            "SELECT * FROM tarea WHERE id_empleado = ?");

	        stmt.setInt(1, idEmpleado);

	        ResultSet rs = stmt.executeQuery();

	        while(rs.next()){

	            Tarea t = new Tarea();

	            t.setIdTarea(rs.getInt("id_tarea"));
	            t.setNombre(rs.getString("nombre"));
	            t.setDescripcion(rs.getString("descripcion"));
	            t.setEstado(rs.getString("estado"));

	            lista.add(t);
	        }

	    } catch(Exception e){
	        e.printStackTrace();
	    }

	    return lista;
	}
	
	
	
	
	
}//fin de controller
