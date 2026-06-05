package DLL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import com.mysql.jdbc.Connection;
import LogicLayer.Operativo;
import LogicLayer.Roles;

public class ControllerOperativo {
	private static Connection con = Conexion.getInstance().getConnection();
	
	 public LinkedList<Operativo> obtenerLideres() {

		    LinkedList<Operativo> lideres = new LinkedList<>();

		    try {

		        String sql =
		                "SELECT o.id_empleado, o.rol, u.nombre, u.apellido " +
		                "FROM operativo o " +
		                "INNER JOIN empleado e ON o.id_empleado = e.id_empleado " +
		                "INNER JOIN usuario u ON e.id_usuario = u.id_usuario " +
		                "WHERE o.rol = 'Lider de Proyecto'";

		        PreparedStatement stmt = con.prepareStatement(sql);

		        ResultSet rs = stmt.executeQuery();

		        while(rs.next()) {

		            Operativo op = new Operativo();

		            op.setIdOperativo(rs.getInt("id_empleado"));
		            op.setNombre(rs.getString("nombre"));
		            op.setApellido(rs.getString("apellido"));

		            lideres.add(op);
		        }

		    } catch(Exception e) {
		        e.printStackTrace();
		    }

		    return lideres;
		}
	 
	 public LinkedList<Operativo> obtenerOperativosProyecto(int idProyecto){

		    LinkedList<Operativo> integrantes = new LinkedList<>();

		    try {

		        PreparedStatement stmt = con.prepareStatement(

		            "SELECT o.id_empleado, "
		          + "o.rol, "
		          + "o.rendimiento, "
		          + "u.nombre, "
		          + "u.apellido "
		          + "FROM proyecto p "
		          + "INNER JOIN equipo_miembro em "
		          + "ON p.id_equipo = em.id_equipo "
		          + "INNER JOIN operativo o "
		          + "ON em.id_operativo = o.id_empleado "
		          + "INNER JOIN empleado e "
		          + "ON o.id_empleado = e.id_empleado "
		          + "INNER JOIN usuario u "
		          + "ON e.id_usuario = u.id_usuario "
		          + "WHERE p.id_proyecto = ?"

		        );

		        stmt.setInt(1, idProyecto);

		        ResultSet rs = stmt.executeQuery();

		        while(rs.next()) {

		            int idEmpleado = rs.getInt("id_empleado");

		            String rol = rs.getString("rol");

		            int rendimiento = rs.getInt("rendimiento");

		            String nombre = rs.getString("nombre");

		            String apellido = rs.getString("apellido");

		            Roles tipoRol;

		            if(rol.equalsIgnoreCase("Lider de Proyecto")) {

		                tipoRol = Roles.LIDER_PROYECTO;

		            } else {

		                tipoRol = Roles.MIEMBRO_PROYECTO;
		            }

		            Operativo op =
		                    new Operativo(
		                            idEmpleado,
		                            tipoRol,
		                            rendimiento
		                    );

		            op.setNombre(nombre);
		            op.setApellido(apellido);

		            integrantes.add(op);
		        }

		    } catch(Exception e) {

		        e.printStackTrace();
		    }

		    return integrantes;
		}
}
