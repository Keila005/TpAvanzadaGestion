package DLL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.LinkedList;

import com.mysql.jdbc.Connection;

import LogicLayer.ComentarioAnonimo;
import LogicLayer.Empleado;
import LogicLayer.Equipo;


public class ControllerEquipo {
	private static Connection con = Conexion.getInstance().getConnection();
	
	public LinkedList<Equipo> mostrarEquipo() {

	    LinkedList<Equipo> equipo = new LinkedList<>();
	    try {
	    	  PreparedStatement stmt = con.prepareStatement
	    			  ("SELECT `id_equipo`,`nombre` FROM `equipo`");

		        ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	            	
	            	int id = rs.getInt("id_equipo");
	                String nombre = rs.getString("nombre");
 
	                equipo.add(new Equipo(id,nombre));
				}
		} catch (Exception e) {
			 e.printStackTrace();
		}
	    return equipo;
	}
}
