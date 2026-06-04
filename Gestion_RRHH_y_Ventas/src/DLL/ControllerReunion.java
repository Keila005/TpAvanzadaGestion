package DLL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.LinkedList;

import com.mysql.jdbc.Connection;

import LogicLayer.Reunion;

public class ControllerReunion {
	 private static Connection con = Conexion.getInstance().getConnection();

	    public void crearReunion(String titulo, LocalDate fechaReunion,int idProyecto) {

	    	  try {

	              PreparedStatement stmt =
	                      con.prepareStatement(

	                      "INSERT INTO reunion "
	                      + "(titulo,fecha,id_proyecto) "
	                      + "VALUES (?,?,?)"
	              );

	              stmt.setString(1, titulo);
	              stmt.setDate(2, java.sql.Date.valueOf(fechaReunion));
	              stmt.setInt(3, idProyecto);

	              stmt.executeUpdate();

	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public LinkedList<Reunion> obtenerReunionesProyecto(int idProyecto){

	        LinkedList<Reunion> reuniones = new LinkedList<>();

	        try {

	            PreparedStatement stmt = con.prepareStatement(
	                "SELECT * FROM reunion WHERE id_proyecto = ? ORDER BY fechaReunion"
	            );

	            stmt.setInt(1, idProyecto);

	            ResultSet rs = stmt.executeQuery();

	            while(rs.next()){

	                Reunion r = new Reunion(
	                    rs.getInt("id_reunion"),
	                    rs.getString("titulo"),
	                    rs.getDate("fechaReunion").toLocalDate(),
	                    rs.getInt("id_proyecto")
	                );

	                reuniones.add(r);
	            }

	        } catch(Exception e){
	            e.printStackTrace();
	        }

	        return reuniones;
	    }
}
