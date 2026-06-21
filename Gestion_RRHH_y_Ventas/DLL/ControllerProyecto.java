package DLL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import LogicLayer.Proyecto;

public class ControllerProyecto {

	private static Connection con =
            Conexion.getInstance().getConnection();
	
	public void crearProyecto(
			String nombre,
			String descripcion,
			Date inicio,
			Date fin,
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
			 stmt.setDate(3, inicio);
			 stmt.setDate(4,fin);
			 stmt.setInt(5, idLider);
			 stmt.setInt(6, idEquipo);
			 
			 stmt.executeUpdate();

		} catch(Exception e) {
			 e.printStackTrace();
		}
		
	}
	//forma vieja de obtener proyectos
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
	// forma nueva y completa para la tabla
	public LinkedList<Proyecto> obtenerProyectosTabla() {

	    LinkedList<Proyecto> lista = new LinkedList<>();

	    try {

	        String sql =
	        		"SELECT p.id_proyecto, p.nombre, p.descripcion, " +
	        			    "p.fecha_inicio, p.fecha_fin, " +
	        			    "CONCAT(u.nombre, ' ', u.apellido) AS lider, " +
	        			    "e.nombre AS equipo " +
	        			    "FROM proyecto p " +
	        			    "JOIN operativo o ON p.id_lider = o.id_empleado " +
	        			    "JOIN empleado em ON o.id_empleado = em.id_empleado " +
	        			    "JOIN usuario u ON em.id_usuario = u.id_usuario " +
	        			    "JOIN equipo e ON p.id_equipo = e.id_equipo";

	        PreparedStatement stmt = con.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            Proyecto p = new Proyecto(
	            		rs.getInt("id_proyecto"),
		                rs.getString("nombre"),
		                rs.getString("descripcion"),
		                rs.getDate("fecha_inicio"),
		                rs.getDate("fecha_fin"),
		                rs.getString("lider"),
		                rs.getString("equipo")
	            );

	            lista.add(p);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return lista;
	}
	
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
	
	public LinkedList<Proyecto> obtenerProyectosMiembro(int idOperativo) {

	    LinkedList<Proyecto> proyectos = new LinkedList<>();

	    try {

	        PreparedStatement stmt = con.prepareStatement(

	            "SELECT DISTINCT p.id_proyecto, p.nombre " +
	            "FROM proyecto p " +
	            "JOIN equipo_miembro em ON p.id_equipo = em.id_equipo " +
	            "WHERE em.id_operativo = ?"
	        );

	        stmt.setInt(1, idOperativo);

	        ResultSet rs = stmt.executeQuery();

	        while(rs.next()) {

	            proyectos.add(
	                new Proyecto(
	                    rs.getInt("id_proyecto"),
	                    rs.getString("nombre")
	                )
	            );
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return proyectos;
	}
	
	
}
