package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.LinkedList;

import LogicLayer.Proyecto;

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
					 
		  "INSERT INTO `proyecto`(`nombre`,`descripcion`,`fecha_inicio`,"
		  + "`fecha_fin`,`id_lider`,`id_equipo`) "
		                		+ "VALUES(?,?,?,?,?,?)"
		            );
			 
			 stmt.setString(1, nombre);
			 stmt.setString(2, descripcion);
			 stmt.setDate(3, java.sql.Date.valueOf(inicio));
			 stmt.setDate(4, java.sql.Date.valueOf(fin));
			 stmt.setInt(5, idLider);
			 stmt.setInt(6, idEquipo);
			 
			 stmt.executeUpdate();

		} catch(Exception e) {
			 e.printStackTrace();
		}
		
	}
	
	public String obtenerProyectos() {

	    String mensaje = "PROYECTOS:\n";

	    try {

	        PreparedStatement stmt = con.prepareStatement(
	                "SELECT nombre FROM proyecto"
	        );

	        ResultSet rs = stmt.executeQuery();

	        while(rs.next()) {

	            mensaje += rs.getString("nombre") + "\n";
	        }

	    } catch(Exception e) {

	        e.printStackTrace();
	    }

	    return mensaje;
	}
	
//	public void asignarLider(
//	        int idProyecto,
//	        int nuevoLider) {
//
//	    try {
//
//	        PreparedStatement stmt = con.prepareStatement(
//
//	            "UPDATE proyecto "
//	            + "SET id_lider = ? "
//	            + "WHERE id_proyecto = ?"
//	        );
//
//	        stmt.setInt(1, nuevoLider);
//	        stmt.setInt(2, idProyecto);
//
//	        stmt.executeUpdate();
//
//	    } catch(Exception e) {
//	        e.printStackTrace();
//	    }
//	}
	
	public LinkedList<Proyecto> obtenerProyectosLider(int idLider) {

	    LinkedList<Proyecto> listaProyectos = new LinkedList<>();

	    try {

	        String sql =
	            "SELECT p.id_proyecto, p.nombre " +
	            "FROM proyecto p " +
	            "JOIN equipo e ON p.id_equipo = e.id_equipo " +
	            "WHERE e.id_lider = ?";

	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setInt(1, idLider);

	        ResultSet rs = stmt.executeQuery();

	        while(rs.next()) {

	            listaProyectos.add(
	                new Proyecto(
	                    rs.getInt("id_proyecto"),
	                    rs.getString("nombre")
	                )
	            );
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return listaProyectos;
		}
	public int obtenerProyectoMiembro(int idOperativo) {

	    int idProyecto = -1;

	    try {

	        String sql =
	            "SELECT p.id_proyecto " +
	            "FROM proyecto p " +
	            "JOIN equipo e ON p.id_equipo = e.id_equipo " +
	            "JOIN equipo_operativo eo ON eo.id_equipo = e.id_equipo " +
	            "WHERE eo.id_operativo = ?";

	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setInt(1, idOperativo);

	        ResultSet rs = stmt.executeQuery();

	        if(rs.next()) {
	            idProyecto = rs.getInt("id_proyecto");
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return idProyecto;
	}
	
}
