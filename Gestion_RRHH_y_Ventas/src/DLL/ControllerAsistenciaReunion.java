package DLL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

public class ControllerAsistenciaReunion {

    private static Connection con =
            Conexion.getInstance().getConnection();

    // EL MIEMBRO MARCA ASISTENCIA

    public void registrarAsistencia(
            int idReunion,
            int idOperativo) {

        try {

            PreparedStatement stmt =
                    con.prepareStatement(

                    "INSERT INTO asistencia_reunion "
                    + "(id_reunion,id_operativo,presente) "
                    + "VALUES(?,?,0)"
            );

            stmt.setInt(1, idReunion);
            stmt.setInt(2, idOperativo);

            stmt.executeUpdate();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    // EL LIDER VE PENDIENTES

    public ResultSet obtenerPendientes(
            int idReunion) {

        try {

            PreparedStatement stmt =
                    con.prepareStatement(

                    "SELECT "
                    + "u.nombre, "
                    + "u.apellido, "
                    + "ar.id_operativo "
                    + "FROM asistencia_reunion ar "
                    + "INNER JOIN operativo o "
                    + "ON ar.id_operativo = o.id_operativo "
                    + "INNER JOIN empleado e "
                    + "ON o.id_empleado = e.id_empleado "
                    + "INNER JOIN usuario u "
                    + "ON e.id_usuario = u.id_usuario "
                    + "WHERE ar.id_reunion = ? "
                    + "AND ar.presente = 0"
            );

            stmt.setInt(1, idReunion);

            return stmt.executeQuery();

        } catch(Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    // EL LIDER APRUEBA

    public void validarAsistencia(
            int idReunion,
            int idOperativo) {

        try {

            PreparedStatement stmt =
                    con.prepareStatement(

                    "UPDATE asistencia_reunion "
                    + "SET presente = 1 "
                    + "WHERE id_reunion = ? "
                    + "AND id_operativo = ?"
            );

            stmt.setInt(1, idReunion);
            stmt.setInt(2, idOperativo);

            stmt.executeUpdate();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}