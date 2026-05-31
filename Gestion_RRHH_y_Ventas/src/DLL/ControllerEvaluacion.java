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

	        int idEquipo = -1;

	        // Buscar si es miembro
	        PreparedStatement stmtEquipo = con.prepareStatement(
	                "SELECT id_equipo " +
	                "FROM equipo_miembro " +
	                "WHERE id_operativo = ?");

	        stmtEquipo.setInt(1, idOperativoLog);

	        ResultSet rsEquipo = stmtEquipo.executeQuery();

	        if(rsEquipo.next()) {

	            idEquipo = rsEquipo.getInt("id_equipo");

	        } else {

	            // Buscar si es líder
	            PreparedStatement stmtLider = con.prepareStatement(
	                    "SELECT id_equipo " +
	                    "FROM equipo " +
	                    "WHERE id_lider = ?");

	            stmtLider.setInt(1, idOperativoLog);

	            ResultSet rsLider = stmtLider.executeQuery();

	            if(rsLider.next()) {

	                idEquipo = rsLider.getInt("id_equipo");
	            }
	        }

	        if(idEquipo == -1) {

	            return integrantes;
	        }

	        // Miembros del equipo
	        PreparedStatement stmt = con.prepareStatement(

	            "SELECT o.id_empleado, u.nombre, u.apellido " +
	            "FROM equipo_miembro em " +
	            "JOIN operativo o ON em.id_operativo = o.id_empleado " +
	            "JOIN empleado e ON o.id_empleado = e.id_empleado " +
	            "JOIN usuario u ON e.id_usuario = u.id_usuario " +
	            "WHERE em.id_equipo = ? " +
	            "AND o.id_empleado <> ?"

	        );

	        stmt.setInt(1, idEquipo);
	        stmt.setInt(2, idOperativoLog);

	        ResultSet rs = stmt.executeQuery();

	        while(rs.next()) {

	            Operativo op = new Operativo();

	            op.setIdOperativo(rs.getInt("id_empleado"));
	            op.setNombre(rs.getString("nombre"));
	            op.setApellido(rs.getString("apellido"));

	            integrantes.add(op);
	        }

	        // Agregar líder si no es el logueado
	        PreparedStatement stmtLider = con.prepareStatement(

	            "SELECT o.id_empleado, u.nombre, u.apellido " +
	            "FROM equipo eq " +
	            "JOIN operativo o ON eq.id_lider = o.id_empleado " +
	            "JOIN empleado e ON o.id_empleado = e.id_empleado " +
	            "JOIN usuario u ON e.id_usuario = u.id_usuario " +
	            "WHERE eq.id_equipo = ? " +
	            "AND o.id_empleado <> ?"

	        );

	        stmtLider.setInt(1, idEquipo);
	        stmtLider.setInt(2, idOperativoLog);

	        ResultSet rsLider = stmtLider.executeQuery();

	        while(rsLider.next()) {

	            Operativo op = new Operativo();

	            op.setIdOperativo(rsLider.getInt("id_empleado"));
	            op.setNombre(rsLider.getString("nombre"));
	            op.setApellido(rsLider.getString("apellido"));

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
