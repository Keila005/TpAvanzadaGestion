package DLL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import com.mysql.jdbc.Connection;

import LogicLayer.Evaluacion360;
import LogicLayer.Operativo;
import LogicLayer.Usuario;

public class ControllerEvaluacion {
	private static Connection con = Conexion.getInstance().getConnection();
	
	
	 public LinkedList<Operativo> mostrarIntegrantesEquipo(int idOperativoLog) {
		 
		 LinkedList<Operativo> integrantes = new LinkedList<>();
		 
		 try {

	          PreparedStatement stmt = con.prepareStatement(
	        		  
	        		  // consultar los id del operativo
	        		  "SELECT o.id_empleado, u.nombre, u.apellido"
	        		  + "FROM equipo_miembro em"
	        		  + "JOIN operativo o ON em.id_operativo = o.id_empleado"
	        		  + "JOIN empleado e ON o.id_empleado = e.id_empleado"
	        		  + "JOIN usuario u ON e.id_usuario = u.id_usuario"
	        		  + "WHERE em.id_equipo = (SELECT id_equipo FROM equipo_miembro"
	        		  + " WHERE id_operativo = ?)"
	        		  + "AND o.id_empleado <> ?" +

	                  "UNION " +

	                  //Y que el LIDER
	                  // tambien buscar el idLider sea igual al de tab equipo
	                  "SELECT DISTINCT o.id_empleado, u.nombre, u.apellido " +
	                  "FROM equipo eq " +

	                  "JOIN operativo o ON eq.id_lider = o.id_empleado " +
	                  "JOIN empleado e ON o.id_empleado = e.id_empleado " +
	                  "JOIN usuario u ON e.id_usuario = u.id_usuario " +

	                  "WHERE eq.id_equipo = (SELECT id_equipo FROM equipo_miembro " +
	                      "WHERE id_operativo = ? " +
	                  ") AND o.id_empleado <> ? "

	              );

	              stmt.setInt(1, idOperativoLog);
	              stmt.setInt(2, idOperativoLog);
	              stmt.setInt(3, idOperativoLog);
	              stmt.setInt(4, idOperativoLog);

	              ResultSet rs = stmt.executeQuery();

	              while(rs.next()) {
	            	  int idEmpleado=rs.getInt("id_empleado");
	            	  String nombre= rs.getString("nombre");
	            	  String apellido= rs.getString("apellido");

	                  Operativo op =new Operativo();
	                  op.setIdOperativo(idEmpleado);
	                  op.setNombre(nombre);
	                  op.setApellido(apellido);
	                  integrantes.add(op);
	              }


	          } catch(Exception e) {
	              e.printStackTrace();
	          }

	          return integrantes;
	      }
	public void guardarEvaluacion(Evaluacion360 eva) {

	    try {

	        PreparedStatement stmt = con.prepareStatement(
	            "INSERT INTO evaluacion_360 (puntaje, comentario, id_evaluador, id_evaluado) " +
	            "VALUES (?, ?, ?, ?)"
	        );

	        stmt.setInt(1, eva.getPuntajeTotal());
	        stmt.setString(2,eva.getComentario());
	        stmt.setInt(3, eva.getEvaluador().getIdOperativo());
	        stmt.setInt(4, eva.getEvaluado().getIdOperativo());

	        stmt.executeUpdate();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	 

	 }
